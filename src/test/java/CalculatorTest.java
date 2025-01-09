package src.test.java;

// Test Class: CalculatorTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void testAdd() {
        // 준비 (Arrange)
        src.main.java.Calculator calculator = new src.main.java.Calculator();
        int a = 5;
        int b = 3;

        // 실행 (Act)
        int result = calculator.add(a, b);

        // 검증 (Assert)
        assertEquals(8, result); // 기대 값은 8
    }
}

