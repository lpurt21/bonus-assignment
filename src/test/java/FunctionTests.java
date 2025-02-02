import com.scheme.expression.types.ListExpression;
import com.scheme.interpreter.SchemeInterpreter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionTests {
    SchemeInterpreter interpreter;


    @BeforeEach
    void setUp() {
        this.interpreter =  new SchemeInterpreter();
    }
    @Test
    public void testMap() {
        String expression = "(map (lambda (x) (* x x)) '(1 2 3 4))";
        Object result = interpreter.interpret(expression);
        List<?> resultList = ((ListExpression) result).getExpressions();

        assertEquals(4, resultList.size());
    }

    @Test
    public void testApply() {
        String expression = "(apply + '(1 2 3))";
        Object result = interpreter.interpret(expression);
        assertEquals(6, result);
    }

    @Test
    public void testEval() {
        String expression = "(eval '(+ 2 3))";
        Object result = interpreter.interpret(expression);
        assertEquals(5, result);
    }

    @Test
    public void testLambdaFunction() {
        String expression = "(define square (lambda (x) (* x x)))";
        interpreter.interpret(expression);

        String callExpression = "(square 4)";
        Object result = interpreter.interpret(callExpression);
        assertEquals(16, result);
    }

    @Test
    public void testFactorialRecursive() {
        String expression = "(define factorial (lambda (n) (if (equal? n 0) 1 (* n (factorial (- n 1))))))";
        interpreter.interpret(expression);

        String callExpression = "(factorial 5)";
        Object result = interpreter.interpret(callExpression);
        assertEquals(120, result);
    }

    @Test
    public void testFactorialBaseCase() {
        String expression = "(define factorial (lambda (n) (if (equal? n 0) 1 (* n (factorial (- n 1))))))";
        interpreter.interpret(expression);

        String callExpression = "(factorial 0)";
        Object result = interpreter.interpret(callExpression);
        assertEquals(1, result);
    }


    @Test
    public void testEmptyList() {
        String expression = "(null? '())";
        Object result = interpreter.interpret(expression);
        assertEquals(true, result);
    }

    @Test
    public void testEmptyAppend() {
        String expression = "(append '() '())";
        Object result = interpreter.interpret(expression);
        assertEquals("()", result.toString());
    }

    @Test
    public void testEmptyExpression() {
        String expression = "'()";
        Object result = interpreter.interpret(expression);
        assertEquals("()", result.toString());
    }


}
