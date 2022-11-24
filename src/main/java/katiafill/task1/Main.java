package katiafill.task1;

public class Main {
    public static void main(String[] args) {
        TableSizeScanner scanner = new TableSizeScanner();
        FormattedMultiplicationTable table = new FormattedMultiplicationTable(scanner.getTableSize());
        System.out.println(table.formattedTable());
    }
}