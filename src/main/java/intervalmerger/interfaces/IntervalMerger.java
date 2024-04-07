package src.main.java.intervalmerger.interfaces;

import src.main.java.intervalmerger.services.IntervalMergerImpl;

import java.util.List;

/**
 * Das Interface definiert eine Methode merge, die eine Liste von Interval-Objekten entgegennimmt
 * und eine Liste von gemergten Interval-Objekten zurückgibt.
 * Das Interval-Objekt selbst ist eine einfache Klasse mit Start- und Endwerten,
 * die das Intervall repräsentieren.
 */
public interface IntervalMerger {
    /**
     * Merge (Zusammenführung) einer Liste von überlappenden Intervallen zu einer Liste von nicht-überlappenden Intervallen.
     * Jedes Intervall wird durch ein Start- und End-Integer-Paar repräsentiert. Die Methode durchläuft die Liste,
     * um überlappende Intervalle zu finden und zu mergen. Das Ergebnis ist eine Liste von Intervallen, bei denen
     * kein Intervall mit einem anderen überlappt.
     *
     * @param intervals Die Liste von Intervallen, die gemergt werden soll. Jedes Intervall ist ein Objekt
     *                  der Klasse Interval, die Start- und Endwerte speichert. Die Liste darf nicht null sein,
     *                  kann aber leer sein.
     * @return Eine neue Liste von nicht-überlappenden Intervallen
     *         Wenn die Eingabeliste leer oder nur ein Element enthält, wird diese direkt zurückgegeben.
     * @throws IllegalArgumentException wenn die Eingabeliste null ist, um eine NullPointer-Exception zu vermeiden.
     */
    List<IntervalMergerImpl.Interval> merge(List<IntervalMergerImpl.Interval> intervals);

    /**
     * Merge (Zusammenführung) einer Liste von überlappenden Intervallen zu einer Liste von nicht-überlappenden Intervallen.
     * Jedes Intervall wird durch ein Start- und End-Integer-Paar repräsentiert.
     * Die Methode benutzt eine TreeMap die widerrum eine interne Sortierung hat.
     * Anschließend durchläuft sie die sortierte Liste, um
     * überlappende Intervalle zu finden und zu mergen. Das Ergebnis ist eine Liste von Intervallen, bei denen
     * kein Intervall mit einem anderen überlappt.
     *
     * @param intervals Die Liste von Intervallen, die gemergt werden soll. Jedes Intervall ist ein Objekt
     *                  der Klasse Interval, die Start- und Endwerte speichert. Die Liste darf nicht null sein,
     *                  kann aber leer sein.
     * @return Eine neue Liste von nicht-überlappenden Intervallen, sortiert nach ihren Startwerten.
     *         Wenn die Eingabeliste leer oder nur ein Element enthält, wird diese direkt zurückgegeben.
     * @throws IllegalArgumentException wenn die Eingabeliste null ist, um eine NullPointer-Exception zu vermeiden.
     */
    List<IntervalMergerImpl.Interval> mergeOptimizedForBigDataInput(List<IntervalMergerImpl.Interval> intervals);
}
