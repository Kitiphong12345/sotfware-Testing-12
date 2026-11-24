import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class GradeCalculatorTest {

    private GradeCalculator calc;

    @Before
    public void setUp() {
        calc = new GradeCalculator();
    }

    @Test
    public void testGradeBoundaries() {
        assertEquals("A", calc.gradeOf(100));
        assertEquals("A", calc.gradeOf(80));
        assertEquals("B+", calc.gradeOf(79));
        assertEquals("B+", calc.gradeOf(75));
        assertEquals("B", calc.gradeOf(74));
        assertEquals("B", calc.gradeOf(70));
        assertEquals("C+", calc.gradeOf(69));
        assertEquals("C+", calc.gradeOf(65));
        assertEquals("C", calc.gradeOf(64));
        assertEquals("C", calc.gradeOf(60));
        assertEquals("D+", calc.gradeOf(59));
        assertEquals("D+", calc.gradeOf(55));
        assertEquals("D", calc.gradeOf(54));
        assertEquals("D", calc.gradeOf(50));
        assertEquals("F", calc.gradeOf(49));
        assertEquals("F", calc.gradeOf(0));

        // Additional boundary-neighbor cases
        assertEquals("F", calc.gradeOf(1));
        assertEquals("D", calc.gradeOf(51));
        assertEquals("D+", calc.gradeOf(56));
        assertEquals("C", calc.gradeOf(61));
        assertEquals("C+", calc.gradeOf(66));
        assertEquals("B", calc.gradeOf(71));
        assertEquals("B+", calc.gradeOf(76));
        assertEquals("A", calc.gradeOf(81));
        assertEquals("A", calc.gradeOf(99));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testScoreBelowZero() {
        calc.gradeOf(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testScoreAboveHundred() {
        calc.gradeOf(101);
    }
}