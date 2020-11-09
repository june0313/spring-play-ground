package playground.modernjava.concurrency;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDirSize extends RecursiveTask<Long> {
    private final Path path;

    public ForkJoinDirSize(Path path) {
        this.path = path;
    }

    @Override
    protected Long compute() {

        // 디렉터리일 경우 하위 작업으로 분리
        if (Files.isDirectory(path)) {
            try {
                return Files.list(path)
                        .map(ForkJoinDirSize::new)
                        .peek(ForkJoinTask::fork)
                        .map(ForkJoinTask::join)
                        .mapToLong(Long::longValue)
                        .sum();
            } catch (IOException e) {
                System.out.println("Error : " + e.getMessage());
            }
        } else {
            // 파일일 경우 크기 리턴
            try {
                return Files.size(path);
            } catch (IOException e) {
                System.out.println("Error : " + e.getMessage());
            }
        }

        return 0L;
    }

    public static void main(String[] args) {
        Path rootPath = Paths.get("/Users/wayne");
        ForkJoinPool pool = new ForkJoinPool(10);
        System.out.println("병렬 처리 크기 : " + pool.getParallelism());
        Instant start = Instant.now();
        System.out.println("합계 : " + pool.invoke(new ForkJoinDirSize(rootPath)) / 1024 / 1024 + "mb");
        Instant end = Instant.now();
        long elapsed = ChronoUnit.MILLIS.between(start, end);
        System.out.println("소요 시간 : " + elapsed + "ms");
    }
}
