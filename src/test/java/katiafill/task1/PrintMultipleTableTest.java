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
        int digits = table.numberOfDigitsFor(6);
        assertEquals(digits, 1);
        digits = table.numberOfDigitsFor(32*32);
        assertEquals(digits, 4);
    }

    @Test
    void getMaxCellSize() {
        PrintMultipleTable table = new PrintMultipleTable(5);
        int cellSize = table.getMaxCellSize();
        assertEquals(cellSize, 2);
    }
}