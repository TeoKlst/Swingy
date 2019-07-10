package app;

import java.util.Scanner;

public class Menu {
    static Scanner console = new Scanner(System.in);
    protected static Boolean    CL;
    protected static String     buffer;

    public static void menuSelection () {
        System.out.println("Create new hero or load from existing save file?\nCreate or Load?");
        buffer = console.nextLine();
        while (!("create".equals(buffer.toLowerCase())) && !("load".equals(buffer.toLowerCase()))) {
            System.out.println("Invalid option!\nPlease choose Create or Load");
            buffer = console.nextLine();
        }
        if ("create".equals(buffer.toLowerCase()))
        CL = true;
        if ("load".equals(buffer.toLowerCase()))
        CL = false;
    }
}