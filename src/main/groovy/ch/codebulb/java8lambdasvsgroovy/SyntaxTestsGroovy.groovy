package ch.codebulb.java8lambdasvsgroovy

import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic

@CompileStatic
class SyntaxTestsGroovy {
    protected static List<String> INPUT_LIST;
    protected static Map<String, String> INPUT_MAP;
    
    public static List<String> collect() {
        return INPUT_LIST.collect {String myVar -> myVar.toUpperCase()}
    }
    
    public static List<String> collectDynamic() {
        return INPUT_LIST.collect {myVar -> myVar.toUpperCase()}
    }
    
    @CompileDynamic
    public static List<String> collectTypeInference() {
        // since Groovy >= 2.3
        return collectDynamic()
    }
    
    public static List<String> collectImplicitParameter() {
        return INPUT_LIST.collect {it.toUpperCase()}
    }
    
    public static String injectMultiParameter() {
        /*
         * We use "inject" for this test as Lambda's "map" doesn't support collecting key, value
         * as two separate parameters
         */
        return INPUT_LIST.inject("") { result, it -> result + it }
    }
    
    public static List<String> collectNoParameter() {
        return INPUT_LIST.collect {"default"}
    }
    
    public static List<String> collectMultiStatement() {
        return INPUT_LIST.collect {String ret = it.toUpperCase(); ret}
    }
    
    public static List<String> collectWithMethodReference() {
        throw new UnsupportedOperationException("Calling closures with method references does not work the same way as in Java."
                + "Even though you can reference a method with the .& operator in Groovy, its call such as closure(method) is interpreted as" 
                + "closure {method(it)}, not closure {it.method}. Thus use the default syntax instead.");
    }
    
}

