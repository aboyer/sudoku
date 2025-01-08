package org.boyerfamily.sudoku;

import org.testng.annotations.Test;

import static org.boyerfamily.sudoku.Value.FOUR;
import static org.boyerfamily.sudoku.Value.ONE;
import static org.boyerfamily.sudoku.Value.THREE;
import static org.boyerfamily.sudoku.Value.TWO;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

public class ValueTest {
    @Test
    public void testGetVal() {
        assertTrue(ONE.getVal() == 1);
    }

    @Test
    public void testToString() {
        assertEquals(TWO.toString(), "2");
    }

    @Test
    public void testFromInt() {
        assertEquals(Value.fromInt(3), THREE);
        assertNull(Value.fromInt(0));
    }

    @Test
    public void testValueOf() {
        assertEquals(Value.valueOf("FOUR"), FOUR);
    }
}