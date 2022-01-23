package org.pg4200.ex01;

import org.junit.jupiter.api.Test;
import org.pg4200.ex01.TriangleClassification.Classification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.pg4200.ex01.TriangleClassification.Classification.*;
import static org.pg4200.ex01.TriangleClassification.classify;

public class TriangleClassificationTest  {
    @Test
    public void testNotATriangleNegative(){
        Classification res = classify(1,1,-1);
        assertEquals(NOT_A_TRIANGLE, res);
    }

    @Test
    public void testNotATriangleLargeA(){
        Classification res = classify(8,1,1);
        assertEquals(NOT_A_TRIANGLE, res);
    }

    @Test
    public void testNotATriangleLargeB(){
        Classification res = classify(2,7,1);
        assertEquals(NOT_A_TRIANGLE, res);
    }

    @Test
    public void testNotATriangleLargeC(){
        Classification res = classify(3,1,11);
        assertEquals(NOT_A_TRIANGLE, res);
    }

    @Test
    public void testEquilateral(){
        Classification res = classify(1,1,1);
        assertEquals(EQUILATERAL, res);
    }

    @Test
    public void testIsoscelesAB(){
        Classification res = classify(3,3,4);
        assertEquals(ISOSCELES,res);
    }

    @Test
    public void testIsoscelesAC(){
        Classification res = classify(3,4,3);
        assertEquals(ISOSCELES,res);
    }

    @Test
    public void testIsoscelesBC(){
        Classification res = classify(4,3,3);
        assertEquals(ISOSCELES,res);
    }

    @Test
    public void testScalene(){
        Classification res = classify(5,3,4);
        assertEquals(SCALENE, res);
    }


}
