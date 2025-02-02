import com.scheme.expression.types.ListExpression;
import com.scheme.interpreter.SchemeInterpreter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListManipulationsTests {
    SchemeInterpreter interpreter;


    @BeforeEach
    void setUp() {
        this.interpreter = new SchemeInterpreter();
    }

    @Test
    public void testCar() {
        String expression = "(car '(1 2 3))";
        Object result = interpreter.interpret(expression);
        assertEquals(1, result);
    }

    @Test
    public void testCdr() {
        String expression = "(cdr '(1 2 3))";
        Object result = interpreter.interpret(expression);

        List<?> resultList = ((ListExpression) result).getExpressions();

        assertEquals(2, resultList.size());
    }

    @Test
    public void testCombinedCarCdr(){
        String expression = "(car (cdr '(1 2 3)))";
        Object result = interpreter.interpret(expression);

        assertEquals(2, result);
    }

    @Test
    public void testCons() {
        String expression = "(cons 1 '(2 3))";
        Object result = interpreter.interpret(expression);
        List<?> resultList = ((ListExpression) result).getExpressions();

        assertEquals(3, resultList.size());
    }

    @Test
    public void testAppend() {
        String expression = "(append '(1 2) '(3 4))";
        Object result = interpreter.interpret(expression);
        List<?> resultList = ((ListExpression) result).getExpressions();

        assertEquals(4, resultList.size());
    }

    @Test
    public void testLength() {
        String expression = "(length '(1 2 3))";
        Object result = interpreter.interpret(expression);
        assertEquals(3, result);
    }

    @Test
    public void testNull() {
        String expression = "(null? '())";
        Object result = interpreter.interpret(expression);
        assertEquals(true, result);
    }

    @Test
    public void testEqual() {
        String expression = "(equal? 3 3)";
        Object result = interpreter.interpret(expression);
        assertEquals(true, result);
    }

    @Test
    public void testNestedLists() {
        String expression = "(define nested (lambda (x) (cons x (cons 2 (cons 3 '())))))";
        interpreter.interpret(expression);

        String callExpression = "(nested 1)";
        Object result = interpreter.interpret(callExpression);
        assertEquals("(1 2 3)", result.toString());
    }

}
