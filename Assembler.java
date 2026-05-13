import java.util.*;

public class Assembler {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of lines: ");

        int n = sc.nextInt();

        sc.nextLine();

        String label[] = new String[n];
        String opcode[] = new String[n];
        String operand[] = new String[n];

        int address[] = new int[n];

        // Input
        System.out.println("Enter assembly program:");

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String parts[] = line.split(" ");

            label[i] = parts[0];
            opcode[i] = parts[1];
            operand[i] = parts[2];
        }

        int start = Integer.parseInt(operand[0]);

        int locctr = start;

        // Assign addresses
        for (int i = 0; i < n; i++) {

            address[i] = locctr;

            if (opcode[i].equals("START")) {

                continue;
            }

            else if (opcode[i].equals("RESW")) {

                locctr += 3 * Integer.parseInt(operand[i]);
            }

            else if (opcode[i].equals("RESB")) {

                locctr += Integer.parseInt(operand[i]);
            }

            else if (opcode[i].equals("WORD")) {

                locctr += 3;
            }

            else if (opcode[i].equals("BYTE")) {

                locctr += 1;
            }

            else if (opcode[i].equals("END")) {

                break;
            }

            else {

                // Normal instruction
                locctr += 3;
            }
        }

        int programLength = locctr - start;

        // H Record
        System.out.println("\nH Record:");
        System.out.println("H^" + label[0] +
                "^" + start +
                "^" + String.format("%04X", programLength));

        // Symbol Table
        System.out.println("\nSymbol Table:");
        System.out.println("Symbol\tValue");

        for (int i = 1; i < n; i++) {

            if (!label[i].equals("-")) {

                System.out.println(label[i] +
                        "\t" +
                        String.format("%04X", address[i]));
            }
        }

        // E Record
        System.out.println("\nE Record:");

        System.out.println("E^" +
                String.format("%04X", start));

        sc.close();
    }
}