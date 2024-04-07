import java.util.ArrayList;
import java.util.List;

/**
 * Der IntervalMergerRunner dient als Hauptklasse für die Ausführung des IntervalMerger.
 * Diese Klasse wird genutzt um eine Liste von Intervallen zu mergen und das Ergebnis auf die Konsole zu printen.
 */
public class IntervalMergerRunner {

    /**
     * Die main Methode erstellt eine Liste von Intervallen, führt dann das Mergen dieser Intervalle durch
     * und printet das Ergebnis auf die Konsole.
     *
     * @param args Nicht verwendet.
     */
    public static void main(String[] args) {
        // Erstelle eine Liste von Intervallen, die gemerged werden sollen
        List<IntervalMergerImpl.Interval> intervals = new ArrayList<>();
        intervals.add(new IntervalMergerImpl.Interval(25, 30));
        intervals.add(new IntervalMergerImpl.Interval(2, 19));
        intervals.add(new IntervalMergerImpl.Interval(14, 23));
        intervals.add(new IntervalMergerImpl.Interval(4, 8));

        // Instanziere den IntervalMerger
        IntervalMerger merger = new IntervalMergerImpl();

        // Führe das Mergen der Intervalle durch
        List<IntervalMergerImpl.Interval> mergedIntervals = merger.merge(intervals);

        // Printe das Ergebnis auf die Konsole (alternativ könnte man natürlich noch eine GUI hinzufügen).
        System.out.println("Merged Intervals:");
        for (IntervalMergerImpl.Interval interval : mergedIntervals) {
            System.out.println(interval);
        }
    }
}