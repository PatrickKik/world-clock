package nl.patrickkik.worldclock;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorldClockDutch {

    public static void main(String[] args) {
        final WorldClockDutch worldClockDutch = new WorldClockDutch();
        final LocalTime now = LocalTime.now();

        System.out.println(worldClockDutch.visibleTerms(now));
        System.out.println();
        worldClockDutch.dump(now).forEach(System.out::println);
    }

    public List<Term> visibleTerms(final LocalTime time) {
        final LocalTime timeRounded = time.with(t -> {
            LocalTime lt = (LocalTime) t;
            return LocalTime.of(lt.getHour(), lt.getMinute() / 5 * 5);
        });

        return Stream.of(Term.values())
                .filter(term -> term.isVisible(timeRounded))
                .collect(Collectors.toList());
    }

    private List<String> dump(LocalTime time) {
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
