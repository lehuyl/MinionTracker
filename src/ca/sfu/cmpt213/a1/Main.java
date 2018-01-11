package ca.sfu.cmpt213.a1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class used to run the program files.
 * @author Steven Le
 */
public class Main {

    private static final String INTRO = "Welcome to the Evil Minion Tracter (tm) by Steven";
    private static final String OPTION1 = "List Minions";
    private static final String OPTION2 = "Add a new minion";
    private static final String OPTION3 = "Remove a minion";
    private static final String OPTION4 = "Attribute evil deed to a minion";
    private static final String OPTION5 = "DEBUG: Dump Objects (toString)";
    private static final String OPTION6 = "Exit";
    private static final int OPTIONS_MIN = 1;
    private static final int OPTIONS_MAX = 6;
    private static final String CANCEL = "Enter 0 to cancel";
    private static final String ALL_MINION_OBJECTS = "All minion objects:";

    /**
     * Main() used to start the program.
     * @param args
     */
    public static void main(String[] args)
    {
        starPrint(INTRO);
        System.out.println(INTRO);
        starPrint(INTRO);

        String[] options = new String[]{OPTION1, OPTION2, OPTION3, OPTION4, OPTION5, OPTION6};

        TextMenu menu = new TextMenu("Main Menu", options);
        ArrayList<Minion> listOfMinions = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while(isRunning)
        {
            isRunning = chooseOption(menu, listOfMinions, scanner);
        }
        scanner.close();

    }

    /**
     * Prints the stars under a subtitle heading.
     * @param title
     */
    private static void starPrint(String title)
    {
        for(int i = 0; i < title.length(); i++)
        {
            System.out.print("*");
        }
        System.out.println();
    }

    /**
     * Used to list all available minions.
     * @param listOfMinions
     */
    private static void listMinions(ArrayList listOfMinions)
    {
        String title = "List of Minions";
        System.out.println(title);
        starPrint(title);

        if(listOfMinions.size() <= 0)
        {
            System.out.println("No minions found");
            return;
        }
        for(int rows = 0; rows < listOfMinions.size(); rows++)
        {
            System.out.print(rows + 1 + ". ");
            Minion minion = (Minion) listOfMinions.get(rows);
            System.out.println(minion.getName() + ", " + minion.getHeight() + "m, "
                    + minion.getNumEvilDeeds() + " evil deed(s)");
        }
    }

    /**
     * Used to add minions to the underlying ArrayList database.
     * @param listOfMinions
     * @param scanner
     */
    private static void addMinion(ArrayList listOfMinions, Scanner scanner)
    {
        System.out.println("Enter minion name: ");
        scanner.nextLine();
        String name = scanner.nextLine();

        double height = 0;
        System.out.println("Enter minion height: ");
        if(scanner.hasNext())
        {
            height = scanner.nextDouble();
        }

        listOfMinions.add(new Minion(name, height));
    }

    /**
     * Removes minion from the ArrayList database.
     * @param listOfMinions
     * @param scanner
     */
    private static void removeMinion(ArrayList listOfMinions, Scanner scanner)
    {
        listMinions(listOfMinions);
        System.out.println(CANCEL);
        int input = 0;

        input = scanner.nextInt();
        while(input < 0 || input > listOfMinions.size())
        {
            System.out.println(errorSelection(listOfMinions));
            input = scanner.nextInt();
        }
        if(input == 0)
        {
            return;
        }

        listOfMinions.remove(input - 1);
    }

    /**
     * Main method that runs the entirety of the main menu interface and options.
     * @param menu
     * @param listOfMinions
     * @param scanner
     * @return
     */
    private static boolean chooseOption(TextMenu menu, ArrayList listOfMinions, Scanner scanner)
    {
        menu.display();
        int input = menu.getSelection(scanner);
        while(input < OPTIONS_MIN || input > OPTIONS_MAX)
        {
            System.out.println("Error: Enter a valid selection between " + OPTIONS_MIN
                    + " and " + OPTIONS_MAX);
            input = menu.getSelection(scanner);
        }

        switch (input)
        {
            case 1: listMinions(listOfMinions);
                    return true;
            case 2: addMinion(listOfMinions, scanner);
                    return true;
            case 3: removeMinion(listOfMinions, scanner);
                    return true;
            case 4: incrementEvilDeeds(listOfMinions, scanner);
                    return true;
            case 5: debugDump(listOfMinions);
                    return true;
            case 6: return false;
        }
        return false;
    }

    /**
     * Used to increment a specific minion of the user's choosing's evil deeds.
     * @param listOfMinions
     * @param scanner
     */
    private static void incrementEvilDeeds(ArrayList listOfMinions, Scanner scanner)
    {
        listMinions(listOfMinions);
        System.out.println(CANCEL);
        int input = scanner.nextInt();
        while(input < 0 || input > listOfMinions.size())
        {
            System.out.println(errorSelection(listOfMinions));
            input = scanner.nextInt();
        }
        if(input == 0)
        {
            return;
        }
        Minion minion = (Minion) listOfMinions.get(input - 1);
        minion.incrementEvilDeeds();
        System.out.println(minion.getName() + " now has " + minion.getNumEvilDeeds() + " evil deed(s)!");

    }

    /**
     * Prints all minions specifications.
     * @param listOfMinions
     */
    private static void debugDump(ArrayList listOfMinions)
    {
        System.out.println(ALL_MINION_OBJECTS);
        for(int rows = 0; rows < listOfMinions.size(); rows++)
        {
            System.out.print(rows + 1 + ". ");
            System.out.println(listOfMinions.get(rows));
        }
    }


    private static String errorSelection(ArrayList listOfMinions)
    {
        int min = 0;
        int max = listOfMinions.size();
        if(listOfMinions.size() > 0)
        {
            min = 1;
        }

        return "Error: Enter a valid selection between " + min + " and " + max;
    }

}
