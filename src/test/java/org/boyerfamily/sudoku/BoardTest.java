package org.boyerfamily.sudoku;

import org.testng.annotations.Test;

import java.util.List;

import static org.boyerfamily.sudoku.Value.FOUR;
import static org.boyerfamily.sudoku.Value.SEVEN;
import static org.boyerfamily.sudoku.Value.THREE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BoardTest {
    private static final List<Integer> EMPTY_BOARD_SETUP = List.of(
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,

            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,

            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0);

    private static final List<Integer> SETUP_EASY1 = List.of(
            0, 0, 0, 0, 2, 4, 0, 7, 1,
            0, 2, 8, 1, 6, 0, 3, 0, 4,
            1, 0, 0, 0, 0, 0, 0, 0, 6,
            0, 0, 0, 6, 4, 0, 5, 3, 8,
            0, 3, 0, 2, 0, 8, 0, 1, 0,
            8, 9, 5, 0, 3, 1, 0, 0, 0,
            7, 0, 0, 0, 1, 0, 0, 0, 3,
            3, 0, 1, 0, 8, 0, 4, 2, 0,
            6, 8, 0, 4, 7, 0, 0, 0, 0);

    private static final List<Integer> SOLVED_EASY1 = List.of(
            5, 6, 3, 8, 2, 4, 9, 7, 1,
            9, 2, 8, 1, 6, 7, 3, 5, 4,
            1, 7, 4, 3, 9, 5, 2, 8, 6,
            2, 1, 7, 6, 4, 9, 5, 3, 8,
            4, 3, 6, 2, 5, 8, 7, 1, 9,
            8, 9, 5, 7, 3, 1, 6, 4, 2,
            7, 4, 9, 5, 1, 2, 8, 6, 3,
            3, 5, 1, 9, 8, 6, 4, 2, 7,
            6, 8, 2, 4, 7, 3, 1, 9, 5);

    private static final List<Integer> SETUP_MEDIUM1 = List.of(
            9, 0, 0, 2, 0, 0, 0, 0, 0,
            0, 0, 0, 9, 3, 6, 8, 0, 4,
            0, 0, 0, 0, 0, 0, 3, 9, 2,
            0, 0, 2, 0, 7, 0, 0, 0, 0,
            8, 1, 4, 0, 0, 0, 9, 2, 7,
            0, 0, 0, 0, 9, 0, 6, 0, 0,
            4, 7, 9, 0, 0, 0, 0, 0, 0,
            5, 0, 3, 8, 4, 9, 0, 0, 0,
            0, 0, 0, 0, 0, 5, 0, 0, 9);


    @Test
    public void testConstructor() {
        Board board = new Board(SETUP_EASY1);
        assertEquals(board.getCellValue(4, 1), THREE);
        assertEquals(board.getCellValue(6, 0), SEVEN);
        assertEquals(board.getCellValue(1, 8), FOUR);
    }

    @Test
    public void testIsSolved() {
        assertFalse(new Board(SETUP_EASY1).isSolved());
        assertTrue(new Board(SOLVED_EASY1).isSolved());
    }

    @Test
    public void testIsOnlyValidValue() {
        Board board = new Board(SETUP_MEDIUM1);
        assertTrue(board.isOnlyValidValue(board.getCell(0, 1), 2));
        assertTrue(board.isOnlyValidValue(board.getCell(3, 1), 8));
        assertFalse(board.isOnlyValidValue(board.getCell(3, 0), 8));
    }
}
