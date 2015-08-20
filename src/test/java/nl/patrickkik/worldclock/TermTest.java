package nl.patrickkik.worldclock;

import org.junit.Test;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static nl.patrickkik.worldclock.Term.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TermTest {

    @Test
    public void test00() {
        LocalTime localTime = LocalTime.of(1, 0);
        List<Term> visibleTerms = Arrays.asList(HET, IS, EEN, UUR);
        for (Term term : Term.values()) {
            assertEquals(visibleTerms.contains(term), term.isVisible(localTime));
        }
    }

    @Test
    public void test05() {
        LocalTime localTime = LocalTime.of(2, 5);
        List<Term> visibleTerms = Arrays.asList(HET, IS, VIJF_MINUTEN, OVER, TWEE);
        for (Term term : Term.values()) {
            assertEquals(visibleTerms.contains(term), term.isVisible(localTime));
        }
    }

    @Test
    public void test10() {
        LocalTime localTime = LocalTime.of(3, 10);
        List<Term> visibleTerms = Arrays.asList(HET, IS, TIEN_MINUTEN, OVER, DRIE);
        for (Term term : Term.values()) {
            assertEquals(visibleTerms.contains(term), term.isVisible(localTime));
        }
    }

    @Test
    public void test15() {
        LocalTime localTime = LocalTime.of(4, 15);
        List<Term> visibleTerms = Arrays.asList(HET, IS, KWART, OVER, VIER);
        for (Term term : Term.values()) {
            assertEquals(visibleTerms.contains(term), term.isVisible(localTime));
        }
    }

    @Test
    public void test20() {
        LocalTime localTime = LocalTime.of(5, 20);
        List<Term> visibleTerms = Arrays.asList(HET, IS, TIEN_MINUTEN, VOOR, HALF, ZES);
        for (Term term : Term.values()) {
            assertEquals(visibleTerms.contains(term), term.isVisible(localTime));
        }
    }

    @Test
    public void test25() {
        LocalTime localTime = LocalTime.of(7, 25);
        List<Term> visibleTerms = Arrays.asList(HET, IS, VIJF_MINUTEN, VOOR, HALF, ACHT);
        for (Term term : Term.values()) {
            assertEquals(term.toString(), visibleTerms.contains(term), term.isVisible(localTime));
        }
    }

    @Test
    public void test30() {
        LocalTime localTime = LocalTime.of(9, 30);
        List<Term> visibleTerms = Arrays.asList(HET, IS, HALF, TIEN);
        for (Term term : Term.values()) {
            assertEquals(visibleTerms.contains(term), term.isVisible(localTime));
        }
    }

    @Test
    public void test35() {
        LocalTime localTime = LocalTime.of(12, 35);
        List<Term> visibleTerms = Arrays.asList(HET, IS, VIJF_MINUTEN, OVER, HALF, EEN);
        for (Term term : Term.values()) {
            assertEquals(visibleTerms.contains(term), term.isVisible(localTime));
        }
    }

    @Test
    public void test40() {
        LocalTime localTime = LocalTime.of(14, 40);
        List<Term> visibleTerms = Arrays.asList(HET, IS, TIEN_MINUTEN, OVER, HALF, DRIE);
        for (Term term : Term.values()) {
            assertEquals(visibleTerms.contains(term), term.isVisible(localTime));
        }
    }

    @Test
    public void test45() {
        LocalTime localTime = LocalTime.of(17, 45);
        List<Term> visibleTerms = Arrays.asList(HET, IS, KWART, VOOR, ZES);
        for (Term term : Term.values()) {
            assertEquals(visibleTerms.contains(term), term.isVisible(localTime));
        }
    }

    @Test
    public void test50() {
        LocalTime localTime = LocalTime.of(20, 50);
        List<Term> visibleTerms = Arrays.asList(HET, IS, TIEN_MINUTEN, VOOR, NEGEN);
        for (Term term : Term.values()) {
            assertEquals(visibleTerms.contains(term), term.isVisible(localTime));
        }
    }

    @Test
    public void test55() {
        LocalTime localTime = LocalTime.of(23, 55);
        List<Term> visibleTerms = Arrays.asList(HET, IS, VIJF_MINUTEN, VOOR, TWAALF);
        for (Term term : Term.values()) {
            assertEquals(visibleTerms.contains(term), term.isVisible(localTime));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoValidTime() {
        Term.ACHT.isVisible(LocalTime.of(18, 18));
    }

    @Test
    public void testNoOverlap() {
        Term[] terms = Term.values();
        for (int i = 1; i < terms.length; i++) {
            for (int j = 0; j < i; j++) {
                if (terms[i].getRow() == terms[j].getRow()) {
                    if (terms[i].getCol() < terms[j].getCol() + terms[j].getText().length()) {
                        fail(String.format("%s overlaps with %s", terms[i], terms[j]));
                    }
                }
            }
        }
    }

    @Test
    public void testBoundingBox() {
        final int width = 12;
        final int height = 8;
        for (Term term : Term.values()) {
            if (term.getRow() < 0 || term.getCol() < 0
                    || term.getRow() > height - 1
                    || term.getCol() + term.getText().length() > width) {
                fail(String.format("%s does not fit in the bounding box", term));
            }
        }
    }
}