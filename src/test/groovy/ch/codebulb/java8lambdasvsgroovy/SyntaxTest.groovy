package ch.codebulb.java8lambdasvsgroovy

import org.junit.Before
import org.junit.Test
import static org.junit.Assert.fail

class SyntaxTest extends BaseJavaVsGroovyTest {
    List INPUT_LIST = ["a", "b", "c"].asImmutable()
    
    @Before
    public void setUp() {
        SyntaxTestsJava.INPUT_LIST = INPUT_LIST
        SyntaxTestsGroovy.INPUT_LIST = INPUT_LIST
    }
    
    @Test
    public void test() {
        assertMethodCallEquals(
            ["A", "B", "C"], // the actual expected result
            "collect",
            SyntaxTestsJava.&collectTypeInference,
            SyntaxTestsJava.&collectMultiStatement,
            SyntaxTestsJava.&collectMultiStatementTypeInference,
            SyntaxTestsJava.&collectWithMethodReference,
            
            SyntaxTestsGroovy.&collectDynamic,
            SyntaxTestsGroovy.&collectTypeInference,
            SyntaxTestsGroovy.&collectImplicitParameter,
            SyntaxTestsGroovy.&collectMultiStatement,
        )
        
        assertMethodCallEquals(
            ["default"] * INPUT_LIST.size(),
            "collectNoParameter",
        )
        
        assertMethodCallEquals(
            "abc",
            "injectMultiParameter",
        )
        
        TestUtil.assertUoException(
            SyntaxTestsJava.&collectDynamic,
            SyntaxTestsJava.&collectImplicitParameter,
            
            SyntaxTestsGroovy.&collectWithMethodReference,
        )
    }
    
    @Override
    protected Class getJavaClassUnderTest() {
        return SyntaxTestsJava
    }
    
    @Override
    protected Class getGroovyClassUnderTest() {
        return SyntaxTestsGroovy
    }
}
