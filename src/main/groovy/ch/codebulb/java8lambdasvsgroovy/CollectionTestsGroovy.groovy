package ch.codebulb.java8lambdasvsgroovy

import groovy.transform.CompileStatic

@CompileStatic
class CollectionTestsGroovy {
    protected static List<String> INPUT_LIST
    protected static Map<String, String> INPUT_MAP;
    protected static List<String> INPUT_LIST_NESTED;
    protected static List<String> OUTPUT_LIST
    protected static Map<String, String> OUTPUT_MAP
    
    public static List<String> each() {
        INPUT_LIST.each {OUTPUT_LIST << it.toUpperCase()}
        return OUTPUT_LIST;
    }
    
    public static Map<String, String> eachWithIndex() {
        INPUT_LIST.eachWithIndex {it, i ->
            OUTPUT_MAP[i.toString()] = it.toUpperCase()
        }
        return OUTPUT_MAP;
    }
    
    public static List<String> collect() {
        return INPUT_LIST.collect {it.toUpperCase()}
    }
    
    public static List<String> spreadDot() {
        return INPUT_LIST*.toUpperCase()
    }
    
    public static Map<String, String> collectEntries() {
        return INPUT_LIST.collectEntries {[(it): it.toUpperCase()]}
    }
    
    public static List<String> collectMap() {
        return INPUT_MAP.collect { key, value -> key + "=" + value }
    }
    
    public static String inject() {
        return INPUT_LIST.inject("") { result, it -> result + it }
    }
    
    public static Map<Boolean, List<String>> groupBy() {
        return INPUT_LIST.groupBy {it == "c"}
    }
    
    public static Map<Boolean, List<String>> partitioningBy() {
        return groupBy()
    }
    
    public static List<String> findAll() {
        // Note that without "as List", return type would be Collection
        return INPUT_LIST.findAll {it == "c"} as List
    }
    
    public static String find() {
        return INPUT_LIST.find {it == "c"}
    }
    
    public static List<String> sortReverse() {
        /*
         * Note that sort breaks type inference for the closure parameter!
         * This is a known bug: https://issues.apache.org/jira/browse/GROOVY-7061
         */
        return INPUT_LIST.sort(false){(it as String).charAt(0)}.reverse(false)
    }
    
    public static String max() {
        return INPUT_LIST.max { it.charAt(0) }
    }
    
    public static boolean every() {
        return INPUT_LIST.every {it in String}
    }
    
    public static boolean any() {
        return INPUT_LIST.any {it == "c"}
    }
    
    public static boolean none() {
        // Note that "none" is not directly supported
        return !INPUT_LIST.any {it == "d"}
    }
    
    public static List<String> flatten() {
        return INPUT_LIST_NESTED.flatten()
    }
    
    public static String join() {
        return INPUT_LIST.join(", ")
    }
}

