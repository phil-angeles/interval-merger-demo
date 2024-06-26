package src.main.java.intervalmerger.runner;

import src.main.java.intervalmerger.interfaces.IntervalMerger;
import src.main.java.intervalmerger.services.IntervalMergerImpl;
import src.main.java.intervalmerger.util.PerformanceTracker;

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

        // Instanziere den PerformanceTracker für die Messung der Laufzeit sowie
        // zur Messung des Speicherverbrauchs
        PerformanceTracker tracker = new PerformanceTracker();

        // Laufzeitmessung starten
        tracker.start();

        // Instanziere den IntervalMerger
        IntervalMerger merger = new IntervalMergerImpl();

        // Führe das Mergen der Intervalle durch
        List<IntervalMergerImpl.Interval> mergedIntervals = merger.merge(intervals);

        // Messung beenden
        tracker.stop();

        // Input Intervalle (aus der Aufgabe):
        System.out.println("Input Intervals:");
        for (IntervalMergerImpl.Interval interval : intervals) {
            System.out.println(interval);
        }

        // Printe das Ergebnis auf die Konsole (alternativ könnte man natürlich noch eine GUI hinzufügen).
        System.out.println("Merged Intervals:");
        for (IntervalMergerImpl.Interval interval : mergedIntervals) {
            System.out.println(interval);
        }

        // Ergebnisse der Laufzeitauswertung sowie Speicherverbrauch ausgeben
        System.out.println("Laufzeit: " + tracker.getElapsedTimeMillis() + " ms");
        System.out.println("Speicherverbrauch: " + tracker.getUsedMemoryBytes() + " Bytes");

        // Optimierte Merge Methode für große Eingaben (Big Data)
        /*
            Eine Möglichkeit, die Effizienz bei großen Eingaben zu verbessern, ist die Verwendung einer
            effizienteren Datenstruktur für die Speicherung und Verarbeitung der Intervalle.
            Eine solche Struktur könnten Bäume (z.B. siehe meine verwendete TreeMap) oder Heap-basierte Datenstrukturen sein, die schnelle
            Einfügungs- und Suchoperationen ermöglichen.
            Für diese Demo im Rahmen des Interviews werde ich jedoch bei einer einfachen Liste bleiben,
            aber die Art und Weise, wie wir sie verarbeiten, optimieren (Stichwort Sortierung).
            Ich optimiere den Algorithmus, indem ich die Liste der Intervalle zuerst sortiere und dann
            in einem Durchgang merge. Das Sortieren ermöglicht es, überlappende Intervalle effizient zu
            identifizieren und zu mergen, da alle potenziell überlappenden Intervalle nebeneinander liegen.
         */
        List<IntervalMergerImpl.Interval> mergedIntervalsBigData = merger.mergeOptimizedForBigDataInput(intervals);

        System.out.println("AddOn: Merged Intervals Big Data Method mithilfe einer Baumstruktur (TreeMap):");
        for (IntervalMergerImpl.Interval interval : mergedIntervalsBigData) {
            System.out.println(interval);
        }
    }
}
