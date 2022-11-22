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
        maxCellSize = getMaxCellSize();
        minCellSize = getMinCellSize();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int row = 0; row <= size; row++) {
            builder.append(stringRow(row));
            builder.append(System.lineSeparator());
            builder.append(horizontalBorder());
            builder.append(System.lineSeparator());
        }

        return builder.toString();
    }

    protected String stringRow(int row) {
        StringBuilder stringRow = new StringBuilder();

        stringRow.append(stringCellForValue(row, minCellSize));
        for (int col = 1; col <= size; col++) {
            stringRow.append(VERTICAL_BORDER_SYMBOL);
            int nRow = row == 0 ? 1 : row;
            stringRow.append(stringCellForValue(col * nRow, maxCellSize));
        }

        return stringRow.toString();
    }

    protected String horizontalBorder() {
        StringBuilder border = new StringBuilder(maxCellSize * 2 * size);

        border.append(stringBorderForSize(minCellSize));

        String cellBorder = stringBorderForSize(maxCellSize);
        for (int i = 0; i < size; i++) {
            border.append(CORNER_SYMBOL);
            border.append(cellBorder);
        }

        return border.toString();
    }

    protected String stringBorderForSize(int size) {
        StringBuilder border = new StringBuilder(size);

        do {
            border.append(BORDER_SYMBOL);
            size--;
        } while (size > 0);

        return border.toString();
    }

    protected String stringCellForValue(int value, int maxSize) {
        StringBuilder stringCell = new StringBuilder(maxSize);

        for (int i = maxSize; i > 0; i--) {
            if (value > 0) {
                int digit = value % 10;
                value /= 10;
                stringCell.append(digit);
                continue;
            }
            stringCell.append(" ");
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
