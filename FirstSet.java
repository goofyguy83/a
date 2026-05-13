import java.util.*;

public class FirstSet {

    static String production[] = new String[10];
    static int n;

    // Function to find FIRST
    static void findFirst(char c) {

        for (int i = 0; i < n; i++) {

            // Match LHS
            if (production[i].charAt(0) == c) {

                // First symbol after ->
                char first = production[i].charAt(3);

                // If terminal
                if (!Character.isUpperCase(first)) {

                    System.out.print(first + " ");
                }

                // If non-terminal
                else {

                    findFirst(first);
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of productions: ");
        n = sc.nextInt();

        sc.nextLine();

        System.out.println("Enter productions:");

        for (int i = 0; i < n; i++) {

            production[i] = sc.nextLine();
        }

        System.out.println("\nFIRST Sets:\n");

        // Find FIRST for all productions
        for (int i = 0; i < n; i++) {

            char nonTerminal = production[i].charAt(0);

            System.out.print("FIRST(" + nonTerminal + ") = { ");

            findFirst(nonTerminal);

            System.out.println("}");
        }

        sc.close();
    }
}