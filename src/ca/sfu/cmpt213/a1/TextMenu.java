package ca.sfu.cmpt213.a1;

import java.util.Scanner;

/**
 * Class that implements the main menu interface.
 * @author Steven Le
 */
public class TextMenu {
    private String title;
    private String[] options;

    /**
     * TextMenu constructor
     * @param title
     * @param options
     */
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

    /**
     * Displays the main menu in the terminal.
     */
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

    /**
     * Returns the user's menu selection.
     * @param scanner
     * @return
     */
    public int getSelection(Scanner scanner)
    {
        return getNumberBetween(1, options.length, scanner);
    }
}
