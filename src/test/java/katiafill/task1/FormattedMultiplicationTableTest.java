package katiafill.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormattedMultiplicationTableTest {

    @Test
    void testNumberOfDigits() {
        FormattedMultiplicationTable table = new FormattedMultiplicationTable(5);
        int digits = table.numberOfDigitsForValue(6);
        assertEquals(digits, 1);
        digits = table.numberOfDigitsForValue(32*32);
        assertEquals(digits, 4);
    }

    @Test
    void getMaxCellSize() {
        FormattedMultiplicationTable table = new FormattedMultiplicationTable(5);
        int cellSize = table.maxCellSize();
        assertEquals(cellSize, 2);
    }

    @Test
    void minCellSize() {
        FormattedMultiplicationTable table = new FormattedMultiplicationTable(5);
        int cellSize = table.minCellSize();
        assertEquals(cellSize, 1);
    }

    @Test
    void testCellStrings() {
        FormattedMultiplicationTable table = new FormattedMultiplicationTable(5);
        String cell = table.cellValue(1, 2);
        assertEquals(cell, " 1");

        cell = table.cellValue(25, 3);
        assertEquals(cell, " 25");

        cell = table.cellValue(1,1);
        assertEquals(cell, "1");

        cell = table.cellValue(100, 3);
        assertEquals(cell, "100");
    }

    @Test
    void testCellBorder() {
        FormattedMultiplicationTable table = new FormattedMultiplicationTable(5);
        String border = table.cellBorder(2);
        assertEquals(border, "--");
    }

    @Test
    void testHorizontalBorder() {
        FormattedMultiplicationTable table = new FormattedMultiplicationTable(5);
        String border = table.horizontalBorder();
        assertEquals(border, "-+--+--+--+--+--");
    }

    @Test
    void testPrint2x2() {
        FormattedMultiplicationTable table = new FormattedMultiplicationTable(2);
        String result = table.formattedTable();

        String newLine = System.lineSeparator();
        assertEquals(result,
                " |1|2" + newLine +
                        "-+-+-" + newLine +
                        "1|1|2" + newLine +
                        "-+-+-" + newLine +
                        "2|2|4" + newLine +
                        "-+-+-" + newLine);
    }

    @Test
    void testPrint5x5() {
        FormattedMultiplicationTable table = new FormattedMultiplicationTable(5);
        String result = table.formattedTable();

        String newLine = System.lineSeparator();
        assertEquals(result,
                " | 1| 2| 3| 4| 5" + newLine +
                        "-+--+--+--+--+--" + newLine +
                        "1| 1| 2| 3| 4| 5" + newLine +
                        "-+--+--+--+--+--" + newLine +
                        "2| 2| 4| 6| 8|10" + newLine +
                        "-+--+--+--+--+--" + newLine +
                        "3| 3| 6| 9|12|15" + newLine +
                        "-+--+--+--+--+--" + newLine +
                        "4| 4| 8|12|16|20" + newLine +
                        "-+--+--+--+--+--" + newLine +
                        "5| 5|10|15|20|25" + newLine +
                        "-+--+--+--+--+--" + newLine);
    }
}