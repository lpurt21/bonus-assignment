import com.scheme.interpreter.SchemeInterpreter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArithmeticOperationsTests {
    SchemeInterpreter interpreter;

    @BeforeEach
    void setUpBeforeClass(){
        this.interpreter = new SchemeInterpreter();
    }
    @Test
    public void testAddition() {
        String expression = "(+ 3 5)";
        Object result = interpreter.interpret(expression);
        assertEquals(8, result);
    }

    @Test
    public void testSubtraction() {
        String expression = "(- 10 3)";
        Object result = interpreter.interpret(expression);
        assertEquals(7, result);
    }

    @Test
    public void testMultiplication() {
        String expression = "(* 4 2)";
        Object result = interpreter.interpret(expression);
        assertEquals(8, result);
    }

    @Test
    public void testDivision() {
        String expression = "(/ 10 2)";
        Object result = interpreter.interpret(expression);
        assertEquals(5, result);
    }

    @Test
    public void testGreaterThan() {
        String expression = "(> 5 3)";
        Object result = interpreter.interpret(expression);
        assertEquals(true, result);
    }

    @Test
    public void testLessThan() {
        String expression = "(< 3 5)";
        Object result = interpreter.interpret(expression);
        assertEquals(true, result);
    }

    @Test
    public void testInvalidExpression() {
        String expression = "(+ 1 'string')";

        assertThrows(RuntimeException.class, () -> interpreter.interpret(expression));
    }

    @Test
    public void testAdditionTwo() {
        String expression = "(+ 1 2 3 4)";
        Object result = interpreter.interpret(expression);
        assertEquals(10, result);
    }

    @Test
    public void testSubtractionTwo() {
        String expression = "(- 10 3 2)";
        Object result = interpreter.interpret(expression);
        assertEquals(5, result);
    }

    @Test
    public void testMultiplicationTwo() {
        String expression = "(* 2 3 4)";
        Object result = interpreter.interpret(expression);
        assertEquals(24, result);
    }

    @Test
    public void testDivisionTwo() {
        String expression = "(/ 8 2 2)";
        Object result = interpreter.interpret(expression);
        assertEquals(2, result);
    }

    @Test
    public void testGreaterThanTwo() {
        String expression = "(> 5 2)";
        Object result = interpreter.interpret(expression);
        assertEquals(true, result);
    }

    @Test
    public void testLessThanTwo() {
        String expression = "(< 5 2)";
        Object result = interpreter.interpret(expression);
        assertEquals(false, result);
    }

    @Test
    public void testDivideOnZero() {
        String expression = "(/ 10 0)";

        assertThrows(RuntimeException.class, () -> interpreter.interpret(expression));
    }

}
