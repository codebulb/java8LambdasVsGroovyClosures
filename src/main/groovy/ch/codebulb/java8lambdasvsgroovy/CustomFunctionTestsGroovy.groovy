package ch.codebulb.java8lambdasvsgroovy

import groovy.transform.CompileStatic
import java.util.function.IntFunction

@CompileStatic
class CustomFunctionTestsGroovy {
    protected static int INPUT_VALUE;
    protected static String INPUT_STRING;
    
    public static int calculateWithFunction() {
        Closure<Integer> function = {int x -> x*2};
        return useFunction(function, INPUT_VALUE);
    }
    
    private static int useFunction(Closure<Integer> function, int inputValue) {
        return function(inputValue);
    }
    
    public static char calculateWithMethodReference() {
        Closure<Character> function = INPUT_STRING.&charAt;
        // Note that we must explicitly unbox the return value
        return function(0) as char;
    }
}
