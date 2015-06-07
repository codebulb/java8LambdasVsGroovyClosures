package ch.codebulb.java8lambdasvsgroovy

import org.junit.After
import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

class RangeTest extends BaseJavaVsGroovyTest {
    int RANGE_START = 0
    int RANGE_END_INCLUSIVE = 3

    @Before
    public void setUp() {
        RangeTestsJava.RANGE_START = RANGE_START
        RangeTestsGroovy.RANGE_START = RANGE_START
        
        RangeTestsJava.RANGE_END_INCLUSIVE = RANGE_END_INCLUSIVE
        RangeTestsGroovy.RANGE_END_INCLUSIVE = RANGE_END_INCLUSIVE
    }
    
    @Test
    public void testCollectRange() {
        assertMethodCallEquals(
            [0, 1, 2, 3],
            "collectRange"
        )
    }
    
    @Override
    protected Class getJavaClassUnderTest() {
        return RangeTestsJava
    }
    
    @Override
    protected Class getGroovyClassUnderTest() {
        return RangeTestsGroovy
    }
}
