package nl.patrickkik.worldclock;

import org.junit.Test;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static nl.patrickkik.worldclock.Term.ACHT;
import static nl.patrickkik.worldclock.Term.DRIE;
import static nl.patrickkik.worldclock.Term.EEN;
import static nl.patrickkik.worldclock.Term.HALF;
import static nl.patrickkik.worldclock.Term.HET;
import static nl.patrickkik.worldclock.Term.IS;
import static nl.patrickkik.worldclock.Term.KWART;
import static nl.patrickkik.worldclock.Term.NEGEN;
import static nl.patrickkik.worldclock.Term.OVER;
import static nl.patrickkik.worldclock.Term.TIEN;
import static nl.patrickkik.worldclock.Term.TIEN_MINUTEN;
import static nl.patrickkik.worldclock.Term.TWAALF;
import static nl.patrickkik.worldclock.Term.TWEE;
import static nl.patrickkik.worldclock.Term.UUR;
import static nl.patrickkik.worldclock.Term.VIER;
import static nl.patrickkik.worldclock.Term.VIJF_MINUTEN;
import static nl.patrickkik.worldclock.Term.VOOR;
import static nl.patrickkik.worldclock.Term.ZES;
import static org.junit.Assert.assertEquals;

public class TermTest {

    @Test
    public void test00() throws Exception {
        LocalTime localTime = LocalTime.of(1, 0);
        List<Term> visibleTerms = Arrays.asList(HET, IS, EEN, UUR);
        for (Term term : Term.values()) {
            assertEquals(visibleTerms.contains(term), term.isVisible(localTime));
        }
    }

    @Test
    public void test05() throws Exception {
        LocalTime localTime = LocalTime.of(2, 5);
        List<Term> visibleTerms = Arrays.asList(HET, IS, VIJF_MINUTEN, OVER, TWEE);
        for (Term term : Term.values()) {
            assertEquals(visibleTerms.contains(term), term.isVisible(localTime));
        }
    }

    @Test
    public void test10() throws Exception {
        LocalTime localTime = LocalTime.of(3, 10);
        List<Term> visibleTerms = Arrays.asList(HET, IS, TIEN_MINUTEN, OVER, DRIE);
        for (Term term : Term.values()) {
            assertEquals(visibleTerms.contains(term), term.isVisible(localTime));
        }
    }

    @Test
    public void test15() throws Exception {
        LocalTime localTime = LocalTime.of(4, 15);
        List<Term> visibleTerms = Arrays.asList(HET, IS, KWART, OVER, VIER);
        for (Term term : Term.values()) {
            assertEquals(visibleTerms.contains(term), term.isVisible(localTime));
        }
    }

    @Test
    public void test20() throws Exception {
        LocalTime localTime = LocalTime.of(5, 20);
        List<Term> visibleTerms = Arrays.asList(HET, IS, TIEN_MINUTEN, VOOR, HALF, ZES);
        for (Term term : Term.values()) {
            assertEquals(visibleTerms.contains(term), term.isVisible(localTime));
        }
    }

    @Test
    public void test25() throws Exception {
        LocalTime localTime = LocalTime.of(7, 25);
        List<Term> visibleTerms = Arrays.asList(HET, IS, VIJF_MINUTEN, VOOR, HALF, ACHT);
        for (Term term : Term.values()) {
            assertEquals(term.toString(), visibleTerms.contains(term), term.isVisible(localTime));
        }
    }

    @Test
    public void test30() throws Exception {
        LocalTime localTime = LocalTime.of(9, 30);
        List<Term> visibleTerms = Arrays.asList(HET, IS, HALF, TIEN);
        for (Term term : Term.values()) {
            assertEquals(visibleTerms.contains(term), term.isVisible(localTime));
        }
    }

    @Test
    public void test35() throws Exception {
        LocalTime localTime = LocalTime.of(12, 35);
        List<Term> visibleTerms = Arrays.asList(HET, IS, VIJF_MINUTEN, OVER, HALF, EEN);
        for (Term term : Term.values()) {
            assertEquals(visibleTerms.contains(term), term.isVisible(localTime));
        }
    }

    @Test
    public void test40() throws Exception {
        LocalTime localTime = LocalTime.of(14, 40);
        List<Term> visibleTerms = Arrays.asList(HET, IS, TIEN_MINUTEN, OVER, HALF, DRIE);
        for (Term term : Term.values()) {
            assertEquals(visibleTerms.contains(term), term.isVisible(localTime));
        }
    }

    @Test
    public void test45() throws Exception {
        LocalTime localTime = LocalTime.of(17, 45);
        List<Term> visibleTerms = Arrays.asList(HET, IS, KWART, VOOR, ZES);
        for (Term term : Term.values()) {
            assertEquals(visibleTerms.contains(term), term.isVisible(localTime));
        }
    }

    @Test
    public void test50() throws Exception {
        LocalTime localTime = LocalTime.of(20, 50);
        List<Term> visibleTerms = Arrays.asList(HET, IS, TIEN_MINUTEN, VOOR, NEGEN);
        for (Term term : Term.values()) {
            assertEquals(visibleTerms.contains(term), term.isVisible(localTime));
        }
    }

    @Test
    public void test55() throws Exception {
        LocalTime localTime = LocalTime.of(23, 55);
        List<Term> visibleTerms = Arrays.asList(HET, IS, VIJF_MINUTEN, VOOR, TWAALF);
        for (Term term : Term.values()) {
            assertEquals(visibleTerms.contains(term), term.isVisible(localTime));
        }
    }
}