package src.main.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import src.main.java.intervalmerger.interfaces.IntervalMerger;
import src.main.java.intervalmerger.services.IntervalMergerImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IntervalMergerTest {

    @Test
    @DisplayName("Test merging of overlapping intervals")
    void testMergingOverlappingIntervals() {
        List<IntervalMergerImpl.Interval> intervals = Arrays.asList(
                new IntervalMergerImpl.Interval(1, 3),
                new IntervalMergerImpl.Interval(2, 4),
                new IntervalMergerImpl.Interval(5, 7),
                new IntervalMergerImpl.Interval(6, 8)
        );

        IntervalMerger merger = new IntervalMergerImpl();
        List<IntervalMergerImpl.Interval> mergedIntervals = merger.merge(intervals);

        assertAll("Should merge overlapping intervals",
                () -> assertEquals(2, mergedIntervals.size(), "Expected merged list size to be 2"),
                () -> assertEquals(new IntervalMergerImpl.Interval(1, 4).toString(), mergedIntervals.getFirst().toString(), "First interval should be merged to [1,4]"),
                () -> assertEquals(new IntervalMergerImpl.Interval(5, 8).toString(), mergedIntervals.get(1).toString(), "Second interval should be merged to [5,8]")
        );
    }

    @Test
    @DisplayName("Test merging of non-overlapping intervals")
    void testMergingNonOverlappingIntervals() {
        List<IntervalMergerImpl.Interval> intervals = Arrays.asList(
                new IntervalMergerImpl.Interval(1, 2),
                new IntervalMergerImpl.Interval(3, 4)
        );

        IntervalMerger merger = new IntervalMergerImpl();
        List<IntervalMergerImpl.Interval> mergedIntervals = merger.merge(intervals);

        assertEquals(2, mergedIntervals.size(), "Non-overlapping intervals should not be merged");
    }

    @Test
    @DisplayName("Test merging of already merged intervals")
    void testMergingAlreadyMergedIntervals() {
        List<IntervalMergerImpl.Interval> intervals = Arrays.asList(
                new IntervalMergerImpl.Interval(1, 10)
        );

        IntervalMerger merger = new IntervalMergerImpl();
        List<IntervalMergerImpl.Interval> mergedIntervals = merger.merge(intervals);

        assertEquals(1, mergedIntervals.size(), "Already merged interval should remain unchanged");
        assertTrue(new IntervalMergerImpl.Interval(1, 10).compareTo(mergedIntervals.getFirst()) == 0);
    }

    @Test
    @DisplayName("Test merging of an empty list")
    void testMergingEmptyList() {
        List<IntervalMergerImpl.Interval> intervals = Arrays.asList();

        IntervalMerger merger = new IntervalMergerImpl();
        List<IntervalMergerImpl.Interval> mergedIntervals = merger.merge(intervals);

        assertTrue(mergedIntervals.isEmpty(), "Merging an empty list should result in an empty list");
    }
}

