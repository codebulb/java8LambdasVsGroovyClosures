package ch.codebulb.java8lambdasvsgroovy

import org.junit.After
import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import static TestUtil.*

class CollectionTest extends BaseJavaVsGroovyTest {
    List INPUT_LIST = ["a", "b", "c"].asImmutable()
    Map INPUT_MAP = ["0": "a", "1": "b", "2": "c"].asImmutable()
    List OUTPUT_LIST = []
    Map OUTPUT_MAP = [:]

    @Before
    public void setUp() {
        CollectionTestsJava.INPUT_LIST = INPUT_LIST
        CollectionTestsGroovy.INPUT_LIST = INPUT_LIST
        
        CollectionTestsJava.INPUT_MAP = INPUT_MAP
        CollectionTestsGroovy.INPUT_MAP = INPUT_MAP
        
        CollectionTestsJava.OUTPUT_LIST = OUTPUT_LIST.clone()
        CollectionTestsGroovy.OUTPUT_LIST = OUTPUT_LIST.clone()
        
        CollectionTestsJava.OUTPUT_MAP = OUTPUT_MAP.clone()
        CollectionTestsGroovy.OUTPUT_MAP = OUTPUT_MAP.clone()
        
        CollectionTestsJava.INPUT_LIST_NESTED = [INPUT_LIST, INPUT_LIST]
        CollectionTestsGroovy.INPUT_LIST_NESTED = [INPUT_LIST, INPUT_LIST]
    }
    
    @Test
    public void testEach() {
        assertMethodCallEquals(
            ["A", "B", "C"],
            "each"
        )
    }
    
    @Test
    public void testEachWithIndex() {
        assertEquals(
            ["0": "A", "1": "B", "2": "C"],
            CollectionTestsGroovy.&eachWithIndex
        )
        
        assertUoException(
            CollectionTestsJava.&eachWithIndex
        )
    }
    
    @Test
    public void testCollect() {
        assertMethodCallEquals(
            ["A", "B", "C"],
            "collect",
            CollectionTestsGroovy.&spreadDot
        )
    }
    
    @Test
    public void testCollectEntries() {
        assertMethodCallEquals(
            [a: "A", b: "B", c: "C"],
            "collectEntries"
        )
    }
    
    @Test
    public void testCollectMap() {
        assertMethodCallEquals(
            ["0=a", "1=b", "2=c"],
            "collectMap"
        )
    }
    
    @Test
    public void testInject() {
        assertMethodCallEquals(
            "abc",
            "inject"
        )
    }
    
    @Test
    public void testSpreadDot() {
        assertUoException(
            CollectionTestsJava.&spreadDot,
        )
    }
    
    @Test
    public void testGroupBy() {
        assertMethodCallEquals(
            [(true): ["c"], (false): ["a", "b"]],
            "groupBy",
            CollectionTestsJava.&partitioningBy
        )
    }
    
    @Test
    public void testFindAll() {
        assertMethodCallEquals(
            ["c"],
            "findAll"
        )
    }
    
    @Test
    public void testFind() {
        assertMethodCallEquals(
            "c",
            "find"
        )
    }
    
    @Test
    public void testSort() {
        assertMethodCallEquals(
            ["c", "b", "a"],
            "sortReverse"
        )
    }
    
        
    @Test
    public void testMax() {
        assertMethodCallEquals(
            "c",
            "max"
        )
    }
    
    @Test
    public void testEvery() {
        assertMethodCallEquals(
            true,
            "every"
        )
    }
    
    @Test
    public void testAny() {
        assertMethodCallEquals(
            true,
            "any"
        )
    }
    
    @Test
    public void testNone() {
        assertMethodCallEquals(
            true,
            "none"
        )
    }
    
    @Test
    public void testFlatten() {
        assertMethodCallEquals(
            ["a", "b", "c", "a", "b", "c"],
            "flatten"
        )
    }
    
    @Test
    public void testJoin() {
        assertMethodCallEquals(
            "a, b, c",
            "join"
        )
    }
    
    @Override
    protected Class getJavaClassUnderTest() {
        return CollectionTestsJava
    }
    
    @Override
    protected Class getGroovyClassUnderTest() {
        return CollectionTestsGroovy
    }
}
