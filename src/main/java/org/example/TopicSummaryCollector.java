package org.example;

/**
 * TopicSummaryCollector class
 * A fully custom collector that gathers all topic strings into a set,
 * sorts them, and joins them with " | ".
 */

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;


/**
 * A custom collector that:
 * - gathers unique topic names into a set
 * - sorts them
 * - joins them into a single string separated by " | "
 */

public class TopicSummaryCollector  implements Collector<String, Set<String>, String>{
}
