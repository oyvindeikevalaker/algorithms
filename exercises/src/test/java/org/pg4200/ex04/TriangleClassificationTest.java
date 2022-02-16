package org.pg4200.ex04;

import org.junit.jupiter.api.Test;
import org.pg4200.ex04.TriangleClassification.Classification;

import static org.junit.jupiter.api.Assertions.*;
import static org.pg4200.ex04.TriangleClassification.Classification.*;


public class TriangleClassificationTest {

    @Test
    public void testNegativeA() {
        Classification res = TriangleClassification.classify(-1, 2, 3);
        assertEquals(NOT_A_TRIANGLE, res);
    }

    @Test
    public void testNegativeB() {
        Classification res = TriangleClassification.classify(1, -2, 3);
        assertEquals(NOT_A_TRIANGLE, res);
    }

    @Test
    public void testNegativeC() {
        Classification res = TriangleClassification.classify(1, 2, -3);
        assertEquals(NOT_A_TRIANGLE, res);
    }

    @Test
    public void testZeroA() {
        Classification res = TriangleClassification.classify(0, 2, 3);
        assertEquals(NOT_A_TRIANGLE, res);
    }

    @Test
    public void testZeroB() {
        Classification res = TriangleClassification.classify(1, 0, 3);
        assertEquals(NOT_A_TRIANGLE, res);
    }

    @Test
    public void testZeroC() {
        Classification res = TriangleClassification.classify(1, 2, 0);
        assertEquals(NOT_A_TRIANGLE, res);
    }

    @Test
    public void testAllNegative() {
        Classification res = TriangleClassification.classify(-1, -2, -3);
        assertEquals(NOT_A_TRIANGLE, res);
    }

    @Test
    public void testAllZero() {
        Classification res = TriangleClassification.classify(0, 0, 0);
        assertEquals(NOT_A_TRIANGLE, res);
    }

    @Test
    public void testAllOnes() {
        Classification res = TriangleClassification.classify(1, 1, 1);
        assertEquals(EQUILATERAL, res);
    }

    @Test
    public void testAllIntegerMax() {
        int maxValue = Integer.MAX_VALUE;
        Classification res = TriangleClassification.classify(maxValue, maxValue, maxValue);
        assertEquals(EQUILATERAL, res);
    }

    @Test
    public void testOneTwoTwo() {
        Classification res = TriangleClassification.classify(1, 2, 2);
        assertEquals(ISOSCELES, res);
    }

    @Test
    public void testTwoOneTwo() {
        Classification res = TriangleClassification.classify(2, 1, 2);
        assertEquals(ISOSCELES, res);
    }

    @Test
    public void testTwoTwoOne() {
        Classification res = TriangleClassification.classify(2, 2, 1);
        assertEquals(ISOSCELES, res);
    }

    @Test
    public void testFiveTwoTwo() {
        Classification res = TriangleClassification.classify(5, 2, 2);
        assertEquals(NOT_A_TRIANGLE, res);
    }

    @Test
    public void testTwoFiveTwo() {
        Classification res = TriangleClassification.classify(2, 5, 2);
        assertEquals(NOT_A_TRIANGLE, res);
    }

    @Test
    public void testTwoTwoFive() {
        Classification res = TriangleClassification.classify(2, 2, 5);
        assertEquals(NOT_A_TRIANGLE, res);
    }

    @Test
    public void testHighMaxMax() {
        int maxValue = Integer.MAX_VALUE;
        Classification res = TriangleClassification.classify(maxValue - 1, maxValue, maxValue);
        assertEquals(ISOSCELES, res);
    }

    @Test

    public void testMaxHighMax() {
        int maxValue = Integer.MAX_VALUE;
        Classification res = TriangleClassification.classify(maxValue, maxValue - 1, maxValue);
        assertEquals(ISOSCELES, res);
    }

    @Test
    public void testMaxMaxHigh() {
        int maxValue = Integer.MAX_VALUE;
        Classification res = TriangleClassification.classify(maxValue, maxValue, maxValue - 1);
        assertEquals(ISOSCELES, res);
    }

    @Test
    public void testLowScalene() {
        Classification res = TriangleClassification.classify(2, 3, 4);
        assertEquals(SCALENE, res);
    }

    @Test
    public void testHighScalene() {
        int maxValue = Integer.MAX_VALUE;
        Classification res = TriangleClassification.classify(maxValue, maxValue - 1, maxValue - 2);
        assertEquals(SCALENE, res);
    }


}
