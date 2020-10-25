package playground.clean.software.monostate;

public class MonoState {
    private static int itsX = 0;

    public MonoState() {

    }

    public void setX(int x) {
        itsX = x;
    }

    public int getX() {
        return itsX;
    }
}
