package playground.modernjava.datetime;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;

public class CustomTemporalAdjusters {
    private static final int GIFT_AUTO_CANCEL_DAYS = 7;
    private static final int GIFT_CARD_AUTO_CANCEL_DAYS = 93;

    public static TemporalAdjuster giftRemindExpireDate(int days) {
        return temporal -> temporal.plus(GIFT_AUTO_CANCEL_DAYS - days, ChronoUnit.DAYS);
    }

    public static TemporalAdjuster giftCardRemindExpireDate(int days) {
        return temporal -> temporal.plus(GIFT_CARD_AUTO_CANCEL_DAYS - days, ChronoUnit.DAYS);
    }
}
