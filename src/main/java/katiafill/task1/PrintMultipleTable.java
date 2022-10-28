package katiafill.task1;

public class PrintMultipleTable {

    private final String verticalBorder = "|";
    private final String corner = "+";
    private final String space = " ";
    private final String newLineString = System.lineSeparator();
    private final String borderSymbol = "-";
    private final int size;
    private final int maxCellSize;
    private final int minCellSize;

    public PrintMultipleTable(int size) {
        this.size = size;
        maxCellSize = getMaxCellSize();
        minCellSize = getMinCellSize();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int row = 0; row <= size; row++) {
            builder.append(stringRow(row));
            builder.append(newLineString);
            builder.append(horizontalBorder());
            builder.append(newLineString);
        }

        return builder.toString();
    }

    protected String verticalBorder() {
        return space + verticalBorder + space;
    }

    protected String corner() {
        return space + corner + space;
    }

    protected String stringRow(int row) {
        StringBuilder stringRow = new StringBuilder();

        stringRow.append(stringCellForValue(row, minCellSize));
        for (int col = 1; col <= size; col++) {
            stringRow.append(verticalBorder());
            int nRow = row == 0 ? 1 : row;
            stringRow.append(stringCellForValue(col * nRow, maxCellSize));
        }

        return stringRow.toString();
    }

    protected String horizontalBorder() {
        StringBuilder border = new StringBuilder(maxCellSize * 2 * size);

        border.append(stringBorderForSize(minCellSize));

        String corner = corner();
        String cellBorder = stringBorderForSize(maxCellSize);
        for (int i = 0; i < size; i++) {
            border.append(corner);
            border.append(cellBorder);
        }

        return border.toString();
    }

    protected String stringBorderForSize(int size) {
        StringBuilder border = new StringBuilder(size * 2);

        border.append(borderSymbol);
        size--;
        while (size > 0) {
            border.append(space);
            border.append(borderSymbol);
            size--;
        }

        return border.toString();
    }

    protected String stringCellForValue(int value, int maxSize) {
        StringBuilder stringCell = new StringBuilder(maxSize * 2);

        for (int i = maxSize * 2 - 1; i > 0; i--) {
            if (value > 0) {
                int digit = value % 10;
                value /= 10;
                stringCell.append(digit);
                i--;
            }
            if (i > 0) {
                stringCell.append(space);
            }
        }

        stringCell.reverse();
        return stringCell.toString();
    }

    protected int getMinCellSize() {
        int minValue = size;
        return  numberOfDigitsForValue(minValue);
    }

    protected int getMaxCellSize() {
        int maxValue = getMaxValue();
        return numberOfDigitsForValue(maxValue);
    }

    // TODO: Вынести в отдельный класс
    protected int numberOfDigitsForValue(int value) {
        int size = 1;
        while (value >= 10) {
            value /= 10;
            size++;
        }
        return size;
    }

    protected int getMaxValue() {
        return size * size;
    }


}
