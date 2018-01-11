package ca.sfu.cmpt213.a1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static final String INTRO = "Welcome to the Evil Minion Tracter (tm) by Steven";
    public static final String OPTION1 = "List Minions";
    public static final String OPTION2 = "Add a new minion";
    public static final String OPTION3 = "Remove a minion";
    public static final String OPTION4 = "Attribute evil deed to a minion";
    public static final String OPTION5 = "DEBUG: Dump Objects (toString)";
    public static final String OPTION6 = "Exit";

    public static void main(String[] args)
    {
        starPrint(INTRO);
        System.out.println(INTRO);
        starPrint(INTRO);

        String[] options = new String[]{OPTION1, OPTION2,
                OPTION3, OPTION4,
                OPTION5, OPTION6};

        TextMenu menu = new TextMenu("Main Menu", options);
        ArrayList<Minion> listOfMinions = new ArrayList<Minion>();

        listOfMinions.add(new Minion("Steven", 1.6));
        listOfMinions.add(new Minion("james", 1.6));
        listOfMinions.add(new Minion("jonathan", 1.6));
        listOfMinions.add(new Minion("justin", 1.6));
        listOfMinions.add(new Minion("ryan", 1.6));
        listOfMinions.add(new Minion("brent", 1.6));
        listOfMinions.add(new Minion("mitch", 1.6));
        listOfMinions.add(new Minion("jenna", 1.6));

        menu.display();

//        addMinion(listOfMinions);
//        removeMinion(listOfMinions);

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while(isRunning)
        {
            isRunning = chooseOption(menu, listOfMinions, scanner);
        }
        scanner.close();

    }

    private static void starPrint(String title)
    {
        for(int i = 0; i < title.length(); i++)
        {
            System.out.print("*");
        }
        System.out.println();
    }

    private static void listMinions(ArrayList listOfMinions)
    {
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
        listMinions(listOfMinions);
    }

    private static void removeMinion(ArrayList listOfMinions, Scanner scanner)
    {
        listMinions(listOfMinions);
        int input = 0;

        input = scanner.nextInt();
        if(input == 0)
        {
            return;
        }

        listOfMinions.remove(input - 1);
        listMinions(listOfMinions);
    }

    private static boolean chooseOption(TextMenu menu, ArrayList listOfMinions, Scanner scanner)
    {
//        System.out.println("Enter an integer between " + 1 + " and " + 6);
//        int input = scanner.nextInt();

        int input = menu.getSelection(scanner);
        if(input < 0 || input > 6)
        {
            System.out.println("Error: Enter a valid selection between 1 and 6");
            return true;
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

    private static void incrementEvilDeeds(ArrayList listOfMinions, Scanner scanner)
    {
        listMinions(listOfMinions);
//        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        Minion minion = (Minion) listOfMinions.get(input - 1);
        minion.incrementEvilDeeds();
        System.out.println(minion.getName() + " now has " + minion.getNumEvilDeeds() + " evil deed(s)!");

    }

    private static void debugDump(ArrayList listOfMinions)
    {
        for(int rows = 0; rows < listOfMinions.size(); rows++)
        {
            System.out.print(rows + 1 + ". ");
            System.out.println(listOfMinions.get(rows));
        }
    }

}
