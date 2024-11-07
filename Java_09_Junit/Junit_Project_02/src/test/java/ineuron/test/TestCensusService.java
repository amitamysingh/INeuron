package ineuron.test;

import ineuron.services.CensusService;
import org.junit.After;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.NullString;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCensusService {

    private static CensusService censusService;

    @BeforeAll
    public static void setUpOnce(){
        censusService = new CensusService();
    }

    @Test
    @DisplayName("Testing Data Export")
    @RepeatedTest(value = 10, name="execution of {displayName}-{currentRepetition}/{totalRepetitions}")
    @Disabled
    public void testExportData(){


        System.out.println("TestCensusService.testExportData()");
        assertEquals("Data exported", censusService.exportData());
    }

    @ParameterizedTest
    @ValueSource(ints = {10,21,24,15,7,8,12,35})
    @Disabled
    public void testIsOdd(int data){
        System.out.println("TestCensusService.testIsOdd():: "+data);
        boolean result = censusService.isOdd(data);
        assertTrue(result);

    }

    @ParameterizedTest
    @ValueSource(strings = {"sachin", "kohli", "dhoni"})
    @Disabled
    public void testSayHello(String name){
        System.out.println("TestCensusService.testSayHello():: "+name);
        String actualOutput= censusService.sayHello(name);
        String expectedOutput = "Hello : "+name;
        assertEquals(expectedOutput, actualOutput);
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testIsEmpty(String data){
        assertTrue(censusService.isEmpty(data));
    }

    @AfterAll
    public static void cleanUpOnce(){
        censusService=null;
    }
}
