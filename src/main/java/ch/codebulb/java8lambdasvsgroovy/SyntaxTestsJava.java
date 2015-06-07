package ch.codebulb.java8lambdasvsgroovy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SyntaxTestsJava {
    protected static List<String> INPUT_LIST;
    protected static Map<String, String> INPUT_MAP;
    
    public static List<String> collect() {
        // Mind the argument list brackets!
        return INPUT_LIST.stream().map((String it) -> it.toUpperCase())
                .collect(Collectors.toList());
    }
    
    public static List<String> collectDynamic() {
        throw new UnsupportedOperationException("Due its static nature, Java does not support dynamic parameters. "
                + "Use type inference instead.");
    }
    
    public static List<String> collectTypeInference() {
        return INPUT_LIST.stream().map(it -> it.toUpperCase())
                .collect(Collectors.toList());
    }
    
    public static List<String> collectImplicitParameter() {
        throw new UnsupportedOperationException("Java lambdas do not support an implicit parameter.");
    }
    
    public static String injectMultiParameter() {
        /*
         * We use "inject" for this test as Lambda's "map" doesn't support collecting key, value
         * as two separate parameters
         */
        // Mind the brackets around the type-inferenced parameters!
        return INPUT_LIST.stream().reduce("", ((result, it) -> result + it));
    }
    
    public static List<String> collectNoParameter() {
        /*
         * Note that not all stream methods do support actual empty parameter lists.
         * e.g. "map" does not. Thus we have to provide a parameter which is left unused
         * (the IDE does even moan about that).
         */
        return INPUT_LIST.stream().map(it -> "default")
                .collect(Collectors.toList());
    }
    
    public static List<String> collectMultiStatement() {
        // Mind the brackets, the return keyword and the conclusive semicolon!
        return INPUT_LIST.stream().map((String it) -> {String ret = it.toUpperCase(); return ret;})
                .collect(Collectors.toList());
    }
    
    public static List<String> collectMultiStatementTypeInference() {
        // Mind the brackets, the return keyword and the conclusive semicolon!
        return INPUT_LIST.stream().map(it -> {String ret = it.toUpperCase(); return ret;})
                .collect(Collectors.toList());
    }
    
    public static List<String> collectWithMethodReference() {
        // Note that method references cannot be chained
        return INPUT_LIST.stream().map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
