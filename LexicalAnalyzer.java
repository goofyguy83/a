import java.util.*;

public class LexicalAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Sample keywords
        String keywords[] = {
                "int", "float", "if",
                "else", "while", "switch"
        };

        System.out.println("Enter statement:");

        String line = sc.nextLine();

        // Split tokens by space
        String tokens[] = line.split(" ");

        for (String token : tokens) {

            // Check keyword
            boolean isKeyword = false;

            for (String key : keywords) {

                if (token.equals(key)) {

                    System.out.println(token +
                            " -> Keyword");

                    isKeyword = true;

                    break;
                }
            }

            if (isKeyword)
                continue;

            // Check number
            if (token.matches("[0-9]+")) {

                System.out.println(token +
                        " -> Number");
            }

            // Check identifier
            else if (token.matches("[a-zA-Z][a-zA-Z0-9]*")) {

                System.out.println(token +
                        " -> Identifier");
            }

            // Check operator
            else if (token.matches("[+\\-*/=]")) {

                System.out.println(token +
                        " -> Operator");
            }

            else {

                System.out.println(token +
                        " -> Invalid");
            }
        }

        sc.close();
    }
}