import java.util.*;

public class LeftRecursion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of productions: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int k = 0; k < n; k++) {

            System.out.print("Enter production: ");
            String str = sc.nextLine();

            String parts[] = str.split("->");

            String lhs = parts[0];

            String rhs[] = parts[1].split("\\|");

            ArrayList<String> alpha = new ArrayList<>();
            ArrayList<String> beta = new ArrayList<>();

            // Separate recursive and non-recursive
            for (String s : rhs) {

                if (s.startsWith(lhs)) {

                    alpha.add(s.substring(lhs.length()));

                } else {

                    beta.add(s);
                }
            }

            System.out.println("\nResult:");

            // If no left recursion
            if (alpha.size() == 0) {

                System.out.println(str);

            } else {

                // A -> beta A'
                System.out.print(lhs + "->");

                for (int i = 0; i < beta.size(); i++) {

                    System.out.print(beta.get(i) + lhs + "'");

                    if (i != beta.size() - 1)
                        System.out.print("|");
                }

                System.out.println();

                // A' -> alpha A' | ε
                System.out.print(lhs + "'" + "->");

                for (int i = 0; i < alpha.size(); i++) {

                    System.out.print(alpha.get(i) + lhs + "'|");
                }

                System.out.println("ε");
            }

            System.out.println();
        }

        sc.close();
    }
}