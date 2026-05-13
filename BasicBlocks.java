import java.util.*;

public class BasicBlocks {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of TAC statements: ");

        int n = sc.nextInt();

        sc.nextLine();

        String tac[] = new String[n];

        System.out.println("Enter TAC statements:");

        for (int i = 0; i < n; i++) {

            tac[i] = sc.nextLine();
        }

        // Store leaders
        HashSet<Integer> leaders = new HashSet<>();

        // Rule 1: First statement
        leaders.add(1);

        // Find leaders
        for (int i = 0; i < n; i++) {

            String line = tac[i];

            // if/goto statement
            if (line.contains("goto")) {

                String parts[] = line.split("goto");

                int target =
                        Integer.parseInt(parts[1].trim());

                // Rule 2: Target is leader
                leaders.add(target);

                // Rule 3:
                // Next statement after goto
                if (i + 2 <= n) {

                    leaders.add(i + 2);
                }
            }
        }

        // Convert to sorted list
        ArrayList<Integer> list =
                new ArrayList<>(leaders);

        Collections.sort(list);

        // Print leaders
        System.out.println("\nLeaders:");

        for (int x : list) {

            System.out.print(x + " ");
        }

        // Print basic blocks
        System.out.println("\n\nBasic Blocks:\n");

        for (int i = 0; i < list.size(); i++) {

            int start = list.get(i);

            int end;

            if (i == list.size() - 1) {

                end = n;
            }

            else {

                end = list.get(i + 1) - 1;
            }

            System.out.println("Block " + (i + 1) + ":");

            for (int j = start; j <= end; j++) {

                System.out.println(j + ". " + tac[j - 1]);
            }

            System.out.println();
        }

        sc.close();
    }
}