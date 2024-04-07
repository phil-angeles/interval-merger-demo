import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Diese IntervalMerger Implementierung definiert zunächst eine Interval-Klasse,
 * die ein Intervall mit einem Start- und Endwert darstellt.
 * Die Klasse implementiert das Comparable-Interface, um die Intervalle basierend auf ihren Startwerten
 * sortieren zu können. Die merge-Methode sortiert dann die Eingabeintervalle und durchläuft sie,
 * um überlappende Intervalle zu mergen und das Ergebnis in einer Liste zurückzugeben.
 * Der IntervalMergerImpl implementiert das Interface IntervalMerger.
 **/
public class IntervalMergerImpl implements IntervalMerger{
    static class Interval implements Comparable<Interval> {
        //Definiere Start und Ende der Interval Variablen
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval other) {
            return this.start - other.start;
        }

        @Override
        public String toString() {
            //Logging
            return "[" + this.start + "," + this.end + "]";
        }
    }

    @Override
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        // Sortiere die Intervalle basierend auf ihren Startwerten
        Collections.sort(intervals);

        List<Interval> mergedIntervals = new ArrayList<>();
        Interval current = intervals.getFirst();

        for (int i = 1; i < intervals.size(); i++) {
            Interval next = intervals.get(i);

            if (current.end >= next.start) { // Überprüfe auf Überlappung
                // Merge Intervalle, indem das Ende des aktuellen Intervalls aktualisiert wird
                current.end = Math.max(current.end, next.end);
            } else {
                // Füge das aktuelle Intervall zur Liste hinzu und setze das nächste als aktuelles Intervall
                mergedIntervals.add(current);
                current = next;
            }
        }

        // Füge das letzte Intervall zur Liste hinzu
        mergedIntervals.add(current);

        return mergedIntervals;
    }
}
