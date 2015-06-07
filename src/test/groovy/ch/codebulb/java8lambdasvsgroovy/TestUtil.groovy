package ch.codebulb.java8lambdasvsgroovy

/**
 * A helper class providing static test util methods.
 */
class TestUtil {
    private TestUtil() {}
    
    /**
     * Checks whether all closures provided, when executed, match the expected result provided.
     */
    protected static assertEquals(Object expected, Closure... methodCalls) {
        assert 1 == [expected, *methodCalls*.call()].unique().size()
    }
    
    /**
     * Checks whether all closures provided, when executed, yield UnsupportedOperationExceptions.
     */
    protected static assertUoException(Closure... closures) {
        closures.each {
            try {
                it()
                fail("Expected exception has not been thrown.")
            } catch(UnsupportedOperationException ex) {}
        }
    }
}

