package katiafill.task1;

import java.util.Scanner;

public class TableSizeScanner {
    private Scanner scanner = new Scanner(System.in);

    public int getTableSize() {
        int size;

        while(true) {
            System.out.print("Type a table size: ");
            try {
                String line = scanner.nextLine();
                size = Integer.parseInt(line);
                checkSizeValue(size);
                break;
            } catch (Exception ex) {
                System.out.println(ex.getLocalizedMessage());
            }
        }

        return size;
    }

    private void checkSizeValue(int size) {
        if (size > 0 && size <= 32){
            return;
        }
        throw new IllegalArgumentException("Incorrect size " + size + ", size should be from 1 to 32.");
    }
}
