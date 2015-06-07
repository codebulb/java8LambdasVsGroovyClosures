package ch.codebulb.java8lambdasvsgroovy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RangeTestsJava {
    protected static int RANGE_START;
    protected static int RANGE_END_INCLUSIVE;
    
    public static List<Integer> collectRange() {
        return IntStream.rangeClosed(RANGE_START, RANGE_END_INCLUSIVE).boxed().collect(Collectors.toList());
    }
}
