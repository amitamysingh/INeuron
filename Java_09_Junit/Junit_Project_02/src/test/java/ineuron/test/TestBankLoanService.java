package ineuron.test;

import ineuron.services.BankLoanService;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TestBankLoanServiceClass")
@TestMethodOrder(value=MethodOrderer.OrderAnnotation.class)
public class TestBankLoanService {

    private static BankLoanService bankLoanService;

    @BeforeAll
    public static void setUp(){
        System.out.println("TestBankLoanService.setUp()");
        bankLoanService = new BankLoanService();
    }

    @DisplayName("TestingWithSmallNumbers")
    @Test
    @Order(1)
    public void testcalculateSimpleIntrestWithSmallNumbers(){
        System.out.println("TestBankLoanService.testcalculateSimpleIntrestWithSmallNumbers()");
        float actualOutput = bankLoanService.calculateSimpleIntrest(100000, 2, 12);

        //Following will throw error and not failure
        //float actualOutput = bankLoanService.calculateSimpleIntrest(0000, 2, 12);
        float expectedOutput = 24000.0f;
        float delta=actualOutput-expectedOutput;

        //Method checking for test-case and generating the output
        assertEquals(expectedOutput,actualOutput);


    }

    @DisplayName("Testing with Big Numbers")
    @Disabled
    @Test
    @Order(2)
    public void testcalculateSimpleIntrestWithBigNumbers(){
        System.out.println("TestBankLoanService.testcalculateSimpleIntrestWithBigNumbers()");

        float actualOutput = bankLoanService.calculateSimpleIntrest(10000000, 2, 12);
        float expectedOutput = 2400000.35f;
        float delta=actualOutput-expectedOutput;

        //Method checking for test-case and generating the output
        assertEquals(expectedOutput,actualOutput, 0.5f, "Results are not matching");
    }

    @DisplayName("Testing with Invalid inputs")
    @Test
    @Order(3)
    public void testcalculateSimpleIntrestWithInvalidInput(){
        System.out.println("TestBankLoanService.testcalculateSimpleIntrestWithInvalidInput()");

        assertThrows(IllegalArgumentException.class, ()-> bankLoanService.calculateSimpleIntrest(0,0,0));

    }

    @DisplayName("Testing with Time Interval")
    @Disabled
    @Test
    @Order(4)
    public void testcalculateSimpleIntrestWithinTimeInterval(){
        System.out.println("TestBankLoanService.testcalculateSimpleIntrestWithTimeInterval()");

        assertTimeout(Duration.ofMillis(20000), ()-> bankLoanService.calculateSimpleIntrest(10000,2,12));

    }

    @AfterAll
    public static void cleanUp(){
        System.out.println("TestBankLoanService.cleanUp()");
        bankLoanService = null;
    }

}
