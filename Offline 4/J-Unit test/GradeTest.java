import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Testing Grade For Different Inputs")
public class GradeTest {
    Grade grade;

    public GradeTest() { }

    @BeforeEach
    void init() {
        grade = new Grade(); // creating grade instance for each test
    }

    @Test
    @DisplayName("Testing Whether Correct grade is calculated for valid marks")
    void testMark() {

        assertEquals('A',grade.gradeLetter(3,"260"), "For 3 credits Grade should be A");
        assertEquals('A',grade.gradeLetter(4,"350"),"For 4 credits Grade should be A");
        assertEquals('B',grade.gradeLetter(3,"220"), "For 3 credits Grade should be B");
        assertEquals('B',grade.gradeLetter(4,"300"),"For 4 credits Grade should be B");
        assertEquals('C',grade.gradeLetter(3,"200"), "For 3 credits Grade should be C");
        assertEquals('C',grade.gradeLetter(4,"260"),"For 4 credits Grade should be C");
        assertEquals('F',grade.gradeLetter(3,"160"), "For 3 credits Grade should be F");
        assertEquals('F',grade.gradeLetter(4,"220"),"For 4 credits Grade should be F");
    }

    @Test
    @DisplayName("Testing Whether Correct grade is calculated for Boundary Value marks")
    void testBoundaryValue() {

        assertEquals('A',grade.gradeLetter(3, "239.20"), "For 3 credits Grade should be A");
        assertEquals('A',grade.gradeLetter(3, "299.80"), "For 3 credits Grade should be A");
        assertEquals('A',grade.gradeLetter(4,"319.60"),"For 4 credits Grade should be A");
        assertEquals('A',grade.gradeLetter(4, "399.20"), "For 4 credits Grade should be A");
        assertEquals('B',grade.gradeLetter(3,"209.05"), "For 3 credits Grade should be B");
        assertEquals('B',grade.gradeLetter(3,"238.85"), "For 3 credits Grade should be B");
        assertEquals('B',grade.gradeLetter(4,"279.40"),"For 4 credits Grade should be B");
        assertEquals('B',grade.gradeLetter(4,"318.50"),"For 4 credits Grade should be B");
        assertEquals('C',grade.gradeLetter(3,"179.15"), "For 3 credits Grade should be C");
        assertEquals('C',grade.gradeLetter(3,"208.95"), "For 3 credits Grade should be C");
        assertEquals('C',grade.gradeLetter(4,"239.25"),"For 4 credits Grade should be C");
        assertEquals('C',grade.gradeLetter(4,"278.05"),"For 4 credits Grade should be C");
        assertEquals('F',grade.gradeLetter(3,"178.95"), "For 3 credits Grade should be F");
        assertEquals('F',grade.gradeLetter(3,"0.05"), "For 3 credits Grade should be F");
        assertEquals('F',grade.gradeLetter(4,"238.95"),"For 4 credits Grade should be F");
        assertEquals('F',grade.gradeLetter(4,"0.05"),"For 4 credits Grade should be F");
    }

    @Test
    @DisplayName("Testing Whether Proper Message is shown for Invalid numbers")
    void testInvalidNumbers() {

        assertEquals('Z',grade.gradeLetter(3, "-5"), "For 3 credits should exceed lower bound");
        assertEquals('Z',grade.gradeLetter(3, "305"), "For 3 credits should exceed upper bound");
        assertEquals('Z',grade.gradeLetter(4,"-8.05"),"For 4 credits should exceed lower bound");
        assertEquals('Z',grade.gradeLetter(4, "410.95"), "For 4 credits should exceed upper bound");

    }

    @Test
    @DisplayName("Testing Whether Proper Message is shown for Non-numbers")
    void testNonNumbers() {

        assertThrows(NumberFormatException.class,
                () -> {System.out.println("Input shouldn't be a non-number");
                   grade.gradeLetter(3,"One");},"Should be NumberFormatException for 3 credits");

        assertThrows(NumberFormatException.class,
                () -> {System.out.println("Input shouldn't be a non-number");
                    grade.gradeLetter(3, String.valueOf('v'));},"Should be NumberFormatException for 3 credits");

        assertThrows(NumberFormatException.class,
                () -> {System.out.println("Input shouldn't be a non-number");
                    grade.gradeLetter(4,"Two Hundred Twenty");},"Should be NumberFormatException for 4 credits");

        assertThrows(NumberFormatException.class,
                () -> {System.out.println("Input shouldn't be a non-number");
                     grade.gradeLetter(4, String.valueOf('c')); },"Should be NumberFormatException for 4 credits");

    }

}
