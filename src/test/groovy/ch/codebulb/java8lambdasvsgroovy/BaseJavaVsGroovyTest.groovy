package ch.codebulb.java8lambdasvsgroovy

/**
 * A common base class for all Java 8 lambda vs. Groovy closures tests which provides a DRY way
 * to run tests against java and groovy classes under test.
 */
abstract class BaseJavaVsGroovyTest {
    /**
     * Checks whether the static method with the method name provided, when called on both the java class under test
     * and the groovy class under test, matches the expected result as well as the result of executing the 
     * additional closures provided optionally.
     */
    protected assertMethodCallEquals(Object expected, String methodName, Closure... additionalChecks) {
        TestUtil.assertEquals(expected, 
            getJavaClassUnderTest().&"$methodName",
            getGroovyClassUnderTest().&"$methodName",
            *additionalChecks
        )
    }
    
    protected abstract Class getJavaClassUnderTest();
    protected abstract Class getGroovyClassUnderTest();
}
