import java.util.*;

public class FirstFollow {

    static String production[] = new String[10];
    static int n;

    static HashSet<Character> result;

    // FIRST Function
    static void findFirst(char c) {

        for (int i = 0; i < n; i++) {

            if (production[i].charAt(0) == c) {

                String rhs = production[i].substring(3);

                String parts[] = rhs.split("\\|");

                for (String p : parts) {

                    char first = p.charAt(0);

                    // terminal
                    if (!Character.isUpperCase(first)) {

                        result.add(first);
                    }

                    // non-terminal
                    else {

                        findFirst(first);
                    }
                }
            }
        }
    }

    // FOLLOW Function
    static void findFollow(char c) {

        // Start symbol
        if (production[0].charAt(0) == c) {

            result.add('$');
        }

        for (int i = 0; i < n; i++) {

            String prod = production[i];

            for (int j = 3; j < prod.length(); j++) {

                if (prod.charAt(j) == c) {

                    // Next symbol exists
                    if (j + 1 < prod.length()) {

                        char next = prod.charAt(j + 1);

                        // Ignore |
                        if (next == '|')
                            continue;

                        // terminal
                        if (!Character.isUpperCase(next)) {

                            result.add(next);
                        }

                        // non-terminal
                        else {

                            findFirst(next);
                        }
                    }

                    // At end
                    else {

                        char lhs = prod.charAt(0);

                        if (lhs != c) {

                            findFollow(lhs);
                        }
                    }
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

        // FIRST
        System.out.println("\nFIRST Sets:\n");

        for (int i = 0; i < n; i++) {

            char nonTerminal = production[i].charAt(0);

            result = new HashSet<>();

            findFirst(nonTerminal);

            System.out.print("FIRST(" + nonTerminal + ") = { ");

            for (char ch : result) {

                System.out.print(ch + " ");
            }

            System.out.println("}");
        }

        // FOLLOW
        System.out.println("\nFOLLOW Sets:\n");

        for (int i = 0; i < n; i++) {

            char nonTerminal = production[i].charAt(0);

            result = new HashSet<>();

            findFollow(nonTerminal);

            System.out.print("FOLLOW(" + nonTerminal + ") = { ");

            for (char ch : result) {

                System.out.print(ch + " ");
            }

            System.out.println("}");
        }

        sc.close();
    }
}