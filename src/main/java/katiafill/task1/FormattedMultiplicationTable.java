package katiafill.task1;

public class FormattedMultiplicationTable {

    private final static String VERTICAL_BORDER_SYMBOL = "|";
    private final static String CORNER_SYMBOL = "+";
    private final static String BORDER_SYMBOL = "-";

    private final int size;
    private final int maxCellSize;
    private final int minCellSize;

    public FormattedMultiplicationTable(int size) {
        this.size = size;
        maxCellSize = maxCellSize();
        minCellSize = minCellSize();
    }

    public String formattedTable() {
        StringBuilder builder = new StringBuilder();

        String horizontalBorder = horizontalBorder();
        String lineSeparator = System.lineSeparator();
        for (int row = 0; row <= size; row++) {
            builder.append(tableRow(row));
            builder.append(lineSeparator);
            builder.append(horizontalBorder);
            builder.append(lineSeparator);
        }

        return builder.toString();
    }

    protected String tableRow(int row) {
        StringBuilder stringRow = new StringBuilder();

        stringRow.append(cellValue(row, minCellSize));
        for (int col = 1; col <= size; col++) {
            stringRow.append(VERTICAL_BORDER_SYMBOL);
            int nRow = row == 0 ? 1 : row;
            stringRow.append(cellValue(col * nRow, maxCellSize));
        }

        return stringRow.toString();
    }

    protected String horizontalBorder() {
        StringBuilder border = new StringBuilder((maxCellSize + 2) * size);

        border.append(cellBorder(minCellSize));

        String cellBorder = cellBorder(maxCellSize);
        for (int i = 0; i < size; i++) {
            border.append(CORNER_SYMBOL);
            border.append(cellBorder);
        }

        return border.toString();
    }

    protected String cellBorder(int size) {
        return BORDER_SYMBOL.repeat(size);
    }

    protected String cellValue(int value, int maxSize) {
        StringBuilder stringCell = new StringBuilder(maxSize);

        if (value > 0) {
            stringCell.append(value);
        }

        int spaceCount = maxSize - stringCell.length();
        if (spaceCount > 0) {
            String spaces = " ".repeat(spaceCount);
            stringCell.insert(0, spaces);
        }

        return stringCell.toString();
    }

    protected int minCellSize() {
        return numberOfDigitsForValue(size);
    }

    protected int maxCellSize() {
        return numberOfDigitsForValue(size * size);
    }

    protected int numberOfDigitsForValue(int value) {
        return Integer.toString(value).length();
    }
}
