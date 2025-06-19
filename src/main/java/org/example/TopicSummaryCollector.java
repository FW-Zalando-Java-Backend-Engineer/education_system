package org.example;

/**
 * TopicSummaryCollector class
 * A fully custom collector that gathers all topic strings into a set,
 * sorts them, and joins them with " | ".
 */

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/**
 * A custom collector that:
 * - gathers unique topic names into a set
 * - sorts them
 * - joins them into a single string separated by " | "
 */

public class TopicSummaryCollector  implements Collector<String, Set<String>, String>{

    /**
     * Supplier provides an empty mutable container — a HashSet in this case.
     */
    @Override
    public Supplier<Set<String>> supplier() {
        return HashSet::new;
    }

    /**
     * Accumulator adds each element (a topic) into the set.
     */
    @Override
    public BiConsumer<Set<String>, String> accumulator() {
        return Set::add;
    }


    /**
     * Combiner merges two sets during parallel stream processing.
     */
    @Override
    public BinaryOperator<Set<String>> combiner() {
        return (firstSet, secondSet) ->{
            firstSet.addAll(secondSet);
            return firstSet;
        };
    }

    /**
     * Finisher converts the final Set<String> to a formatted String.
     */
    @Override
    public Function<Set<String>, String> finisher() {
        return combinedValue -> combinedValue.stream()
                                            .sorted()
                                            .collect(Collectors.joining(" | "));
    }

    /**
     * No special characteristics needed; return empty set.
     */
    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.noneOf(Characteristics.class);
    }
}
