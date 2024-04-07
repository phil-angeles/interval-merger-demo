package src.main.java.intervalmerger.services;

import src.main.java.intervalmerger.interfaces.IntervalMerger;

import java.util.*;

/**
 * Diese Implementierung definiert zunächst eine Interval-Klasse,
 * die ein Intervall mit einem Start- und Endwert darstellt.
 * Die Klasse implementiert das Comparable-Interface, um die Intervalle basierend auf ihren Startwerten
 * sortieren zu können. Die merge-Methode sortiert dann die Eingabeintervalle und durchläuft sie,
 * um überlappende Intervalle zu mergen und das Ergebnis in einer Liste zurückzugeben.
 * Der IntervalMergerImpl implementiert das Interface IntervalMerger.
 **/
public class IntervalMergerImpl implements IntervalMerger {
    public static class Interval implements Comparable<Interval> {
        //Definiere Start und Ende der Interval Variablen
        int start;
        int end;

        public Interval(int start, int end) {
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

    @Override
    public List<Interval> mergeOptimizedForBigDataInput(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        // Ich verwende eine TreeMap, um die Endpunkte der Intervalle effizient zu verwalten
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Einfügen aller Intervalle in die TreeMap, dabei werden überlappende Intervalle direkt gemerged
        for (Interval interval : intervals) {
            Map.Entry<Integer, Integer> floorEntry = map.floorEntry(interval.start);
            if (floorEntry != null && floorEntry.getValue() >= interval.start) {
                // Überlappendes Intervall gefunden, aktualisiere das existierende Intervall
                if (floorEntry.getValue() < interval.end) {
                    map.put(floorEntry.getKey(), interval.end);
                }
            } else {
                // Kein überlappendes Intervall, füge das neue Intervall hinzu
                map.put(interval.start, interval.end);
            }
        }

        // Konvertiere die TreeMap zurück in eine Liste von Intervallen
        List<Interval> mergedIntervals = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            mergedIntervals.add(new Interval(entry.getKey(), entry.getValue()));
        }

        return mergedIntervals;
    }
}
