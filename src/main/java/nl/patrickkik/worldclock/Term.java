package nl.patrickkik.worldclock;

import java.time.LocalTime;
import java.util.function.Predicate;

//   012345678901
// 0 Het Is Vijf
// 1 Tien  Kwart
// 2 Over   Voor
// 3 Half EenTwee
// 4 DrieVierVijf
// 5 ZesZevenAcht
// 6 NegenTienElf
// 7 Twaalf  Uur
public enum Term {

    HET(0, 0, "HET", time -> true),
    IS(0, 4, "IS", time -> true),

    VIJF_MINUTEN(0, 7, "VIJF", time -> time.getMinute() == 5 || time.getMinute() == 25 || time.getMinute() == 35 || time.getMinute() == 55),
    TIEN_MINUTEN(1, 0, "TIEN", time -> time.getMinute() == 10 || time.getMinute() == 20 || time.getMinute() == 40 || time.getMinute() == 50),
    KWART(1, 6, "KWART", time -> time.getMinute() == 15 || time.getMinute() == 45),

    OVER(2, 0, "OVER", time -> time.getMinute() > 0 && time.getMinute() <= 15 || time.getMinute() >= 35 && time.getMinute() <= 40),
    VOOR(2, 7, "VOOR", time -> time.getMinute() >= 20 && time.getMinute() <= 25 || time.getMinute() >= 45),

    HALF(3, 0, "HALF", time -> time.getMinute() >= 20 && time.getMinute() <= 40),

    EEN(3, 5, "EEN", time -> time.getHour() % 12 == 0 && time.getMinute() >= 20 || time.getHour() % 12 == 1 && time.getMinute() <= 15),
    TWEE(3, 8, "TWEE", time -> time.getHour() % 12 == 1 && time.getMinute() >= 20 || time.getHour() % 12 == 2 && time.getMinute() <= 15),
    DRIE(4, 0, "DRIE", time -> time.getHour() % 12 == 2 && time.getMinute() >= 20 || time.getHour() % 12 == 3 && time.getMinute() <= 15),
    VIER(4, 4, "VIER", time -> time.getHour() % 12 == 3 && time.getMinute() >= 20 || time.getHour() % 12 == 4 && time.getMinute() <= 15),
    VIJF(4, 8, "VIJF", time -> time.getHour() % 12 == 4 && time.getMinute() >= 20 || time.getHour() % 12 == 5 && time.getMinute() <= 15),
    ZES(5, 0, "ZES", time -> time.getHour() % 12 == 5 && time.getMinute() >= 20 || time.getHour() % 12 == 6 && time.getMinute() <= 15),
    ZEVEN(5, 3, "ZEVEN", time -> time.getHour() % 12 == 6 && time.getMinute() >= 20 || time.getHour() % 12 == 7 && time.getMinute() <= 15),
    ACHT(5, 8, "ACHT", time -> time.getHour() % 12 == 7 && time.getMinute() >= 20 || time.getHour() % 12 == 8 && time.getMinute() <= 15),
    NEGEN(6, 0, "NEGEN", time -> time.getHour() % 12 == 8 && time.getMinute() >= 20 || time.getHour() % 12 == 9 && time.getMinute() <= 15),
    TIEN(6, 5, "TIEN", time -> time.getHour() % 12 == 9 && time.getMinute() >= 20 || time.getHour() % 12 == 10 && time.getMinute() <= 15),
    ELF(6, 9, "ELF", time -> time.getHour() % 12 == 10 && time.getMinute() >= 20 || time.getHour() % 12 == 11 && time.getMinute() <= 15),
    TWAALF(7, 0, "TWAALF", time -> time.getHour() % 12 == 11 && time.getMinute() >= 20 || time.getHour() % 12 == 0 && time.getMinute() <= 15),

    UUR(7, 8, "UUR", time -> time.getMinute() == 0);

    private final int row;
    private final int col;
    private String text;
    private Predicate<LocalTime> visibilityPredicate;

    Term(int row, int col, String text, Predicate<LocalTime> visibilityPredicate) {
        this.row = row;
        this.col = col;
        this.text = text;
        this.visibilityPredicate = visibilityPredicate;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String getText() {
        return text;
    }

    public boolean isVisible(LocalTime time) {
        if (time.getMinute() % 5 > 0) {
            throw new IllegalArgumentException("Minute must end with 0 or 5.");
        }
        return visibilityPredicate.test(time);
    }
}
