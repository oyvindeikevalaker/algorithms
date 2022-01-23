package org.pg4200.ex01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MyArrayListIntegerTest {
    protected MyArrayListInteger getNewInstance() {
        return new MyArrayListInteger();
    }

    private MyArrayListInteger list;

    @BeforeEach
    public void initTest(){
        list = getNewInstance();
    }

    @Test
    public void testAddOneElement(){
        int n = list.size();

        list.add(1);

        assertEquals(n+1, list.size());
    }

    @Test
    public void testAddAndRetrieveElement(){
        list.add(1);

        int res = list.get(0);

        assertEquals(1, res);
    }

    @Test
    public void testAddAnd5Element(){
        assertEquals(0, list.size());

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        assertEquals(5, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
        assertEquals(5, list.get(4));
    }

    @Test
    public void testOutOfIndex(){

        assertNull(list.get(-5));
        assertNull(list.get(42));
    }

}
