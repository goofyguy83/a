import java.util.*;

public class LoaderLinker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of lines: ");

        int n = sc.nextInt();

        sc.nextLine();

        String lines[] = new String[n];

        // Store input
        System.out.println("Enter assembly program:");

        for (int i = 0; i < n; i++) {

            lines[i] = sc.nextLine();
        }

        ArrayList<String> extdef = new ArrayList<>();
        ArrayList<String> extref = new ArrayList<>();

        HashMap<String, Integer> symtab = new HashMap<>();

        int locctr = 0;

        // Process lines
        for (int i = 0; i < n; i++) {

            String line = lines[i];

            // EXTDEF
            if (line.startsWith("EXTDEF")) {

                String defs =
                        line.substring(7).replace(" ", "");

                String arr[] = defs.split(",");

                for (String s : arr) {

                    extdef.add(s);
                }
            }

            // EXTREF
            else if (line.startsWith("EXTREF")) {

                String refs =
                        line.substring(7).replace(" ", "");

                String arr[] = refs.split(",");

                for (String s : arr) {

                    extref.add(s);
                }
            }

            // Ignore START and END
            else if (line.contains("START")
                    || line.equals("END")) {

                continue;
            }

            else {

                String parts[] = line.split(" ");

                // Label exists
                if (parts.length == 3) {

                    String symbol = parts[0];

                    symtab.put(symbol, locctr);
                }

                // Every instruction = 3 bytes
                locctr += 3;
            }
        }

        // D Record
        System.out.print("\nD^");

        for (String s : extdef) {

            int addr = symtab.getOrDefault(s, 0);

            System.out.print(s + "^" +
                    String.format("%04X", addr) + "^");
        }

        // R Record
        System.out.print("\nR^");

        for (String s : extref) {

            System.out.print(s + "^");
        }

        // Symbol Table
        System.out.println("\n\nLocal Symbol Table");

        System.out.println("Symbol\tValue");

        for (String s : symtab.keySet()) {

            System.out.println(s + "\t" +
                    String.format("%04X",
                            symtab.get(s)));
        }

        sc.close();
    }
}