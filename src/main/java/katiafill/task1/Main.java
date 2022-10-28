package katiafill.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.print("Input a table size: ");
            size = scanner.nextInt();
        } while (size < 0 || size > 32);

        PrintMultipleTable table = new PrintMultipleTable(size);
        System.out.println(table);
    }
}