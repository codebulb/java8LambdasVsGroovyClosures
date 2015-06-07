package ch.codebulb.java8lambdasvsgroovy;

import java.util.function.Function;

public class CustomFunctionTestsJava {
    protected static int INPUT_VALUE;
    protected static String INPUT_STRING;
    
    public static int calculateWithFunction() {
        /*
         * Note that x is inferred of type Integer. Setting it to int would not compile.
         * Rather, you'd have to implement one of the primitive interfaces
         */
        Function<Integer, Integer> function = x -> x*2;
        return useFunction(function, INPUT_VALUE);
    }
    
    private static int useFunction(Function<Integer, Integer> function, int inputValue) {
        return function.apply(inputValue);
    }
    
    public static char calculateWithMethodReference() {
        Function<Integer, Character> function = INPUT_STRING::charAt;
        return function.apply(0);
    }
}
