package ch.codebulb.java8lambdasvsgroovy;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionTestsJava {
    protected static List<String> INPUT_LIST;
    protected static Map<String, String> INPUT_MAP;
    protected static List<List<String>> INPUT_LIST_NESTED;
    protected static List<String> OUTPUT_LIST;
    protected static Map<String, String> OUTPUT_MAP;
    
    public static List<String> each() {
        INPUT_LIST.stream().forEach(it -> OUTPUT_LIST.add(it.toUpperCase()));
        return OUTPUT_LIST;
    }
    
    public static List<String> eachWithIndex() {
        throw new UnsupportedOperationException("The Java 8 streams API lacks the feature of getting the index of a stream element. "
                + "see http://stackoverflow.com/a/18552071/1399395 for workarounds.");
    }
    
    public static List<String> collect() {
        return INPUT_LIST.stream().map(it -> it.toUpperCase()).collect(Collectors.toList());
    }
    
    public static List<String> spreadDot() {
        throw new UnsupportedOperationException("Java does not support the spread dot operator. "
                + "Use collect() instead.");
    }
    
    public static Map<String, String> collectEntries() {
        return INPUT_LIST.stream().collect(Collectors.toMap(it -> it, it -> it.toUpperCase()));
    }
    
    public static List<String> collectMap() {
        return INPUT_MAP.entrySet().stream().map(it -> it.getKey() + "=" + it.getValue()).collect(Collectors.toList());
    }
    
    public static String inject() {
        return INPUT_LIST.stream().reduce("", ((result, it) -> result + it));
    }
    
    public static Map<Boolean, List<String>> groupBy() {
        return INPUT_LIST.stream().collect(Collectors.groupingBy(it -> it.equals("c")));
    }
    
    public static Map<Boolean, List<String>> partitioningBy() {
        // "partitioningBy" is just as "groupyingby" for boolean group clauses
        return INPUT_LIST.stream().collect(Collectors.partitioningBy(it -> it.equals("c")));
    }
    
    public static List<String> findAll() {
        return INPUT_LIST.stream().filter(it -> it.equals("c")).collect(Collectors.toList());
    }
    
    public static String find() {
        return INPUT_LIST.stream().filter(it -> it.equals("c")).findFirst().get();
    }
    
    public static List<String> sortReverse() {
        /* 
         * Note that using Comparator chaining breaks type inference!
         * Therefore, we use a workaround here: http://stackoverflow.com/a/25192182/1399395
         */
        return INPUT_LIST.stream().sorted(Comparator.comparing(it -> it.charAt(0), Comparator.reverseOrder())).collect(Collectors.toList());
    }
    
    public static String max() {
        return INPUT_LIST.stream().collect(Collectors.maxBy(Comparator.comparing(it -> it.charAt(0)))).get();
    }
    
    public static boolean every() {
        return INPUT_LIST.stream().allMatch(it -> it.getClass() == String.class);
    }
    
    public static boolean any() {
        return INPUT_LIST.stream().anyMatch(it -> it.equals("c"));
    }
    
    public static boolean none() {
        return INPUT_LIST.stream().noneMatch(it -> it.equals("d"));
    }
    
    public static List<String> flatten() {
        return INPUT_LIST_NESTED.stream().flatMap(Collection::stream).collect(Collectors.toList());
    }
    
    public static String join() {
        return INPUT_LIST.stream().collect(Collectors.joining(", "));
    }
}
