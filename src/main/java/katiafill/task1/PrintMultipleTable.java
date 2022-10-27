package katiafill.task1;

public class PrintMultipleTable {

    private int size;

    public PrintMultipleTable(int size) {
        this.size = size;
    }

    @Override
    public String toString() {

        return "";
    }

    protected  int getMinCellSize() {
        int minValue = size;
        return  numberOfDigitsFor(minValue);
    }

    protected int getMaxCellSize() {
        int maxValue = getMaxValue();
        return numberOfDigitsFor(maxValue);
    }

    // TODO: Вынести в отдельный класс
    protected int numberOfDigitsFor(int value) {
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
