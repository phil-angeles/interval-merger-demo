import java.util.List;

/**
 * Das Interface definiert eine Methode merge, die eine Liste von Interval-Objekten entgegennimmt
 * und eine Liste von gemergten Interval-Objekten zurückgibt.
 * Das Interval-Objekt selbst ist eine einfache Klasse mit Start- und Endwerten,
 * die das Intervall repräsentieren.
 */
public interface IntervalMerger {
    List<IntervalMergerImpl.Interval> merge(List<IntervalMergerImpl.Interval> intervals);
}
