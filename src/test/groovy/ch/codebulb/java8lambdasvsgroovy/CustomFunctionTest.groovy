package ch.codebulb.java8lambdasvsgroovy

import org.junit.After
import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

class CustomFunctionTest extends BaseJavaVsGroovyTest {
    int INPUT_VALUE = 1
    String INPUT_STRING = "a"

    @Before
    public void setUp() {
        CustomFunctionTestsJava.INPUT_VALUE = INPUT_VALUE
        CustomFunctionTestsGroovy.INPUT_VALUE = INPUT_VALUE
        
        CustomFunctionTestsJava.INPUT_STRING = INPUT_STRING
        CustomFunctionTestsGroovy.INPUT_STRING = INPUT_STRING
    }
    
    @Test
    public void testCalculateWithFunction() {
        assertMethodCallEquals(
            2,
            "calculateWithFunction"
        )
    }
    
    @Test
    public void testCalculateWithMethodReference() {
        assertMethodCallEquals(
            'a',
            "calculateWithMethodReference"
        )
    }
    
    @Override
    protected Class getJavaClassUnderTest() {
        return CustomFunctionTestsJava
    }
    
    @Override
    protected Class getGroovyClassUnderTest() {
        return CustomFunctionTestsGroovy
    }
}
