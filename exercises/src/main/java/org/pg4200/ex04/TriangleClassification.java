package org.pg4200.ex04;

import static org.pg4200.ex04.TriangleClassification.Classification.*;

public class TriangleClassification {

    public enum Classification {NOT_A_TRIANGLE, EQUILATERAL, ISOSCELES, SCALENE}


    public static Classification classify(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return NOT_A_TRIANGLE;
        if (a == b && b == c) return EQUILATERAL;

        int max = Math.max(a, Math.max(b, c));
        if ((max == a && max - b - c >= 0)
                || (max == b && max - a - c >= 0)
                || (max == c && max - a - b >= 0))
            return NOT_A_TRIANGLE;

        if (a == b || b == c || a == c) {
            return ISOSCELES;
        } else {

            return SCALENE;
        }
    }
}
