package ee.bcs.valiit.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Lesson1MathUtilTest {

//    @Test
//    public void test() {
//        int result = Lesson1MathUtil.min(3,4);
//        Assertions.assertEquals(3, result);
//    }

    @Test
    void min() {
       assertEquals(3, Lesson1MathUtil.min(3,5));
       assertEquals(-5,Lesson1MathUtil.min(-5, 3));
    }

    @Test
    void max() {
        assertEquals(6, Lesson1MathUtil.max(6, 3));
        assertEquals(6, Lesson1MathUtil.max(3, 6));
    }

    @Test
    void abs() {
        assertEquals(6, Lesson1MathUtil.abs(6));
        assertEquals(6, Lesson1MathUtil.abs(-6));
    }

    @Test
    void isEven() {
        assertTrue(Lesson1MathUtil.isEven(6));
        assertFalse(Lesson1MathUtil.isEven(3));
    }

    @Test
    void testMin() {
        assertEquals(0, Lesson1MathUtil.min2(55, 6, 0));
        assertEquals(0, Lesson1MathUtil.min2(55, 0, 6));
        assertEquals(-3, Lesson1MathUtil.min2(-3,1,3));
    }

    @Test
    void testMax() {
        assertEquals(333, Lesson1MathUtil.max2(1,88,333));
        assertEquals(333, Lesson1MathUtil.max2(1,333, 88));
        assertEquals(333, Lesson1MathUtil.max2(333,88,-3));
    }
}
