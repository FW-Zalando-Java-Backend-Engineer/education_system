package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for TopicSummaryCollector.
 */
public class TopicSummaryCollectorTest {

    /**
     * Test that the collector correctly gathers, sorts, and formats topics.
     */
    @Test
    public void testTopicSummaryCollector() {
        List<String> topics = List.of("OOP", "Streams", "Collections", "Streams", "Lambdas");

        String result = topics.stream()
                .collect(new TopicSummaryCollector());

        // Duplicates removed, sorted alphabetically, joined with " | "
        String expected = "Collections | Lambdas | OOP | Streams";
        assertEquals(expected, result);
    }

    /**
     * Test that an empty stream returns an empty string.
     */
    @Test
    public void testEmptyTopicList() {
        List<String> empty = List.of();

        String result = empty.stream()
                .collect(new TopicSummaryCollector());

        assertEquals("", result);
    }

    /**
     * Test combining results from parallel streams.
     */
    @Test
    public void testParallelStreamCollector() {
        List<String> topics = List.of("Concurrency", "Threads", "Streams", "Streams");

        String result = topics.parallelStream()
                .collect(new TopicSummaryCollector());

        // Should still be correct and deterministic
        String expected = "Concurrency | Streams | Threads";
        assertEquals(expected, result);
    }
}
