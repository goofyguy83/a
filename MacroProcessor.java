import java.util.*;

public class MacroProcessor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> deftab = new ArrayList<>();

        String macroName = "";

        int start = 0;
        int end = 0;

        System.out.print("Enter number of lines: ");

        int n = sc.nextInt();

        sc.nextLine();

        System.out.println("Enter macro program:");

        boolean macroStart = false;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            // MACRO begins
            if (line.equals("MACRO")) {

                macroStart = true;

                start = deftab.size() + 1;

                continue;
            }

            // Store lines in DEFTAB
            if (macroStart) {

                deftab.add(line);

                // First line after MACRO = macro name
                if (macroName.equals("")) {

                    macroName = line.split(" ")[0];
                }

                // MEND ends macro
                if (line.equals("MEND")) {

                    end = deftab.size();

                    macroStart = false;
                }
            }
        }

        // Print DEFTAB
        System.out.println("\nDEFTAB:");

        for (String line : deftab) {

            System.out.println(line);
        }

        // Print NAMETAB
        System.out.println("\nNAMETAB:");

        System.out.println("MacroName\tStart\tEnd");

        System.out.println(macroName +
                "\t\t" +
                start +
                "\t" +
                end);

        sc.close();
    }
}