package katiafill.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintMultipleTableTest {

    @Test
    void getMaxValue() {
        PrintMultipleTable table = new PrintMultipleTable(5);
        int value = table.getMaxValue();
        assertEquals(value, 25);
    }

    @Test
    void testNumberOfDigits() {
        PrintMultipleTable table = new PrintMultipleTable(5);
        int digits = table.numberOfDigitsForValue(6);
        assertEquals(digits, 1);
        digits = table.numberOfDigitsForValue(32*32);
        assertEquals(digits, 4);
    }

    @Test
    void getMaxCellSize() {
        PrintMultipleTable table = new PrintMultipleTable(5);
        int cellSize = table.getMaxCellSize();
        assertEquals(cellSize, 2);
    }

    @Test
    void testCellStrings() {
        PrintMultipleTable table = new PrintMultipleTable(5);
        String cell = table.stringCellForValue(1, 2);
        assertEquals(cell, "  1");

        cell = table.stringCellForValue(25, 2);
        assertEquals(cell, "2 5");

        cell = table.stringCellForValue(1,1);
        assertEquals(cell, "1");

        cell = table.stringCellForValue(100, 3);
        assertEquals(cell, "1 0 0");
    }

    @Test
    void testCellBorder() {
        PrintMultipleTable table = new PrintMultipleTable(5);
        String border = table.stringBorderForSize(2);
        assertEquals(border, "- -");
    }

    @Test
    void testHorizontalBorder() {
        PrintMultipleTable table = new PrintMultipleTable(5);
        String border = table.horizontalBorder();
        assertEquals(border, "- + - - + - - + - - + - - + - -");
    }

    @Test
    void testPrint2x2() {
        PrintMultipleTable table = new PrintMultipleTable(2);
        String result = table.toString();
        assertEquals(result,
                "  | 1 | 2\n" +
                        "- + - + -\n" +
                        "1 | 1 | 2\n" +
                        "- + - + -\n" +
                        "2 | 2 | 4\n" +
                        "- + - + -\n");
    }

    @Test
    void testPrint5x5() {
        PrintMultipleTable table = new PrintMultipleTable(5);
        String result = table.toString();
        assertEquals(result,
                "  |   1 |   2 |   3 |   4 |   5\n" +
                        "- + - - + - - + - - + - - + - -\n" +
                        "1 |   1 |   2 |   3 |   4 |   5\n" +
                        "- + - - + - - + - - + - - + - -\n" +
                        "2 |   2 |   4 |   6 |   8 | 1 0\n" +
                        "- + - - + - - + - - + - - + - -\n" +
                        "3 |   3 |   6 |   9 | 1 2 | 1 5\n" +
                        "- + - - + - - + - - + - - + - -\n" +
                        "4 |   4 |   8 | 1 2 | 1 6 | 2 0\n" +
                        "- + - - + - - + - - + - - + - -\n" +
                        "5 |   5 | 1 0 | 1 5 | 2 0 | 2 5\n" +
                        "- + - - + - - + - - + - - + - -\n");
    }
}