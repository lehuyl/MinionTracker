package ca.sfu.cmpt213.a1;

import java.util.ArrayList;
import java.util.Scanner;

public class TextMenu {
    public static final int MENU_ROW_LIMIT = 3;
    public static final int MIDDLE_ROW = 1;
    private String title;
    private String[] options;

    public TextMenu(String title, String[] options)
    {
        this.title = title;
        this.options = options;
    }


    private static void starPrint(String title)
    {
        for(int i = 0; i < title.length()+ 4; i++)
        {
            System.out.print("*");
        }
        System.out.println();
    }

    public void display()
    {
        starPrint(title);
        System.out.print("* ");
        System.out.print(title);
        System.out.println(" *");
        starPrint(title);

        for(int rows = 0; rows < options.length; rows++)
        {
            System.out.print(rows + 1 + ". ");
            System.out.println(options[rows]);
        }
    }

    public static int getNumberBetween(int min, int max, Scanner scanner)
    {
//        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer between " + min + " and " + max);
        int i = scanner.nextInt();
//        scanner.close();

        return i;
    }

    public int getSelection(Scanner scanner)
    {
        return getNumberBetween(1, options.length, scanner);
    }
}
