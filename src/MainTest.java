import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    // Тесты для FizzBuzz
    @Test
    public void testFizzBuzz() {
        assertEquals("fizz", Main.fizzBuzz(5));
        assertEquals("buzz", Main.fizzBuzz(7));
        assertEquals("fizzbuzz", Main.fizzBuzz(35));
        assertEquals("4", Main.fizzBuzz(4));
    }

    // Тесты для reverseString
    @Test
    public void testReverseString() {
        assertEquals("llatsni ekam", Main.reverseString("make install"));
        assertEquals("dcba", Main.reverseString("abcd"));
    }

    // Тесты для решения квадратного уравнения
    @Test
    public void testSolveQuadraticEquation() {
        assertEquals("Корни: 2.0, 1.0", Main.solveQuadraticEquation(1, -3, 2));
        assertEquals("Корень: -1.0", Main.solveQuadraticEquation(1, 2, 1));
        assertEquals("нет вещественных корней", Main.solveQuadraticEquation(1, 1, 1));
    }

    // Тесты для суммы ряда
    @Test
    public void testSumSeries() {
        double result = Main.sumSeries();
        assertTrue(result > 0);
    }

    // Тесты для проверки на палиндром
    @Test
    public void testIsPalindrome() {
        assertTrue(Main.isPalindrome("madam"));
        assertFalse(Main.isPalindrome("hello"));
    }
}