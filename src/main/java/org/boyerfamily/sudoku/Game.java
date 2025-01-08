package org.boyerfamily.sudoku;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final static String BOARD_PATH = "boards";

    private static List<Integer> readBoard(String fileName) throws IOException {
        Path boardPath = Path.of(BOARD_PATH, fileName);

        System.out.println("Loading board from: " + boardPath);
        if (!Files.exists(boardPath)) {
            System.err.println("Usage:\n\tjava Game <input_file>");
        }

        List<Integer> values = new ArrayList<>();
        try (Scanner scanner = new Scanner(boardPath)) {
            while (scanner.hasNextInt()) {
                values.add(scanner.nextInt());
            }
        }

        return values;
    }

    public static void main(String[] args) throws IOException {
        List<Integer> boardValues = readBoard(args[0]);
        Board board = new Board(boardValues);

        System.out.print("Starting board:\n" + board);

        long startTime = System.currentTimeMillis();
        while (board.scanForSolvedCells()) {
            if (board.isSolved()) {
                break;
            }
        }
        long endTime = System.currentTimeMillis();

        System.out.print("\nEnding board:\n" + board);
        if (board.isSolved()) {
            System.out.println("Time to solve (ms): " + (endTime - startTime));
        } else {
            System.out.println("Couldn't solve it.");
        }

        // TODO: Write out solve times to record performance improvements.
        // TODO: Maybe profile the code to see where it's spending it's time.
        // TODO: refactor out some of the bigger routines.
    }
}
