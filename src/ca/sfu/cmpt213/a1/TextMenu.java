package ca.sfu.cmpt213.a1;

import java.util.Scanner;

/**
 * Implements the main menu interface.
 * @author Steven Le
 */
public class TextMenu {
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
        System.out.println();
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
         return scanner.nextInt();

    }

    public int getSelection(Scanner scanner)
    {
        return getNumberBetween(1, options.length, scanner);
    }
}
