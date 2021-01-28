package ee.bcs.valiit.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lesson2Test {

    @Test
    void exercise1() {
        assertArrayEquals(new int[]{4, 3, 4, 9, 2, 10, 6, 11, 6, 5}, Lesson2.exercise1(new int[] {5, 6, 11, 6, 10, 2, 9, 4, 3, 4}));
    }

    @Test
    void exercise1Web() {
        assertArrayEquals(new int[]{4, 3, 4, 9, 2, 10, 6, 11, 6, 5}, Lesson2.exercise1Web(new int[] {5, 6, 11, 6, 10, 2, 9, 4, 3, 4}));
    }

    @Test
    void exercise2() {
        assertArrayEquals(new int[]{2,4,6}, Lesson2.exercise2(3));
    }

    @Test
    void exercise3() {
    }

    @Test
    void exercise4() {
    }

    @Test
    void exercise5() {
    }

    @Test
    void seqLength() {
    }
}