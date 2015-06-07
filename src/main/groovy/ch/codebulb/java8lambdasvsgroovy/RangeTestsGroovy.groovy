package ch.codebulb.java8lambdasvsgroovy

import groovy.transform.CompileStatic

@CompileStatic
class RangeTestsGroovy {
    protected static int RANGE_START;
    protected static int RANGE_END_INCLUSIVE;
    
    public static List<Integer> collectRange() {
        return (RANGE_START..RANGE_END_INCLUSIVE).collect()
    }
}
