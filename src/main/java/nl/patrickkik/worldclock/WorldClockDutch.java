package nl.patrickkik.worldclock;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorldClockDutch {

    public static void main(String[] args) {
        List<String> lines = new WorldClockDutch().dump(LocalTime.now());
        lines.forEach(System.out::println);

        System.out.println(new WorldClockDutch().visibleTerms(LocalTime.now()));

    }

    public List<Term> visibleTerms(LocalTime time) {
        time = time.with(t -> {
            LocalTime lt = (LocalTime) t;
            return LocalTime.of(lt.getHour(), lt.getMinute() / 5 * 5);
        });

        final List<Term> visibleTerms = new ArrayList<>(6);
        for (Term term : Term.values()) {
            if (term.isVisible(time)) {
                visibleTerms.add(term);
            }
        }
        return visibleTerms;
    }

    public List<String> dump(LocalTime time) {
        time = time.with(t -> {
            LocalTime lt = (LocalTime) t;
            return LocalTime.of(lt.getHour(), lt.getMinute() / 5 * 5);
        });

        final Random random = new Random();
        final char[][] matrix = new char[8][12];
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 12; col++) {
                matrix[row][col] = (char) (random.nextInt(26) + 'a');
            }
        }

        for (Term term : Term.values()) {
            for (int col = term.getCol(); col < term.getCol() + term.getText().length(); col++) {
                final String text = term.isVisible(time) ? term.getText().toUpperCase() : term.getText().toLowerCase();
                matrix[term.getRow()][col] = text.charAt(col - term.getCol());
            }
        }

        final List<String> dump = new ArrayList<>(8);
        for (int row = 0; row < 8; row++) {
            dump.add(new String(matrix[row]));
        }

        return dump;
    }
}
