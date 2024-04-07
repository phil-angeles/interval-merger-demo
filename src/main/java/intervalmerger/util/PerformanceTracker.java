package src.main.java.intervalmerger.util;

public class PerformanceTracker {
    private long startTime;
    private long endTime;
    private long beforeUsedMem;
    private long afterUsedMem;

    /**
     * Startet die Messung von Laufzeit und Speichernutzung.
     */
    public void start() {
        // Aufruf des Garbage Collectors (GC) um eine saubere Basis für die Speichermessung zu haben
        System.gc();

        // Laufzeitmessung starten
        startTime = System.nanoTime();

        // Speichernutzung vor der Operation messen
        beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    /**
     * Beendet die Messung von Laufzeit und Speichernutzung.
     */
    public void stop() {
        // Aufruf des Garbage Collectors (GC) um eine saubere Basis für die Speichermessung zu haben
        System.gc();

        // Speichernutzung nach der Operation messen
        afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // Laufzeitmessung beenden
        endTime = System.nanoTime();
    }

    /**
     * Gibt die gemessene Laufzeit in Millisekunden zurück.
     * @return Laufzeit in Millisekunden.
     */
    public long getElapsedTimeMillis() {
        return (endTime - startTime) / 1_000_000;
    }

    /**
     * Gibt die Differenz der Speichernutzung in Bytes zurück.
     * @return Differenz der Speichernutzung in Bytes.
     */
    public long getUsedMemoryBytes() {
        return afterUsedMem - beforeUsedMem;
    }
}

