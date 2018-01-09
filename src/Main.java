import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        String intro = "Welcome to the Evil Minion Tracter (tm) by Steven";
        starPrint(intro);
        System.out.println(intro);
        starPrint(intro);

        String[] options = new String[]{"List Minions", "Add a new minion",
            "Remove a minion","Attribute evil deed to a minion",
            "DEBUG: Dump Objects (toString)", "Exit"};

        TextMenu menu = new TextMenu("Main Menu", options);
        ArrayList<Minion> listofMinions = new ArrayList<Minion>();

        listofMinions.add(new Minion("Steven", 1.6));
        menu.display();

        addMinion(listofMinions);
        removeMinion(listofMinions);

    }

    private static void starPrint(String title)
    {
        for(int i = 0; i < title.length(); i++)
        {
            System.out.print("*");
        }
        System.out.println();
    }

    private static void listMinions(ArrayList listofMinions)
    {
        for(int rows = 0; rows < listofMinions.size(); rows++)
        {
            System.out.print(rows + 1 + ". ");
            System.out.println(listofMinions.get(rows));
        }
    }

    private static void addMinion(ArrayList listOfMinions)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter minion name: ");
        String name = scanner.nextLine();

        double height = 0;
        System.out.println("Enter minion height: ");
        if(scanner.hasNext())
        {
            height = scanner.nextDouble();
        }
        scanner.close();

        listOfMinions.add(new Minion(name, height));
//        listMinions(listOfMinions);
    }

    private static void removeMinion(ArrayList listofMinions)
    {
        listMinions(listofMinions);
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext())
        {
            int input = scanner.nextInt();
            if(input == 0)
            {
                return;
            }
            scanner.close();
            listofMinions.remove(input);
            listMinions(listofMinions);
        }
    }

}
