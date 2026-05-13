import java.util.*;

public class IntermediateCode {

    // Precedence function
    static int precedence(char ch) {

        if (ch == '+' || ch == '-')
            return 1;

        if (ch == '*' || ch == '/')
            return 2;

        return 0;
    }

    // Infix to Postfix
    static String infixToPostfix(String exp) {

        Stack<Character> stack = new Stack<>();

        String postfix = "";

        for (int i = 0; i < exp.length(); i++) {

            char ch = exp.charAt(i);

            // Operand
            if (Character.isLetterOrDigit(ch)) {

                postfix += ch;
            }

            // Opening bracket
            else if (ch == '(') {

                stack.push(ch);
            }

            // Closing bracket
            else if (ch == ')') {

                while (stack.peek() != '(') {

                    postfix += stack.pop();
                }

                stack.pop();
            }

            // Operator
            else {

                while (!stack.isEmpty() &&
                        precedence(stack.peek()) >= precedence(ch)) {

                    postfix += stack.pop();
                }

                stack.push(ch);
            }
        }

        // Remaining operators
        while (!stack.isEmpty()) {

            postfix += stack.pop();
        }

        return postfix;
    }

    // // Reverse string
    // static String reverse(String s) {

    //     String rev = "";

    //     for (int i = s.length() - 1; i >= 0; i--) {

    //         char ch = s.charAt(i);

    //         // Swap brackets
    //         if (ch == '(')
    //             rev += ')';

    //         else if (ch == ')')
    //             rev += '(';

    //         else
    //             rev += ch;
    //     }

    //     return rev;
    // }

    // // Infix to Prefix
    // static String infixToPrefix(String exp) {

    //     String rev = reverse(exp);

    //     String postfix = infixToPostfix(rev);

    //     return reverse(postfix);
    // }

    // Quadruples
    static void generateQuadruple(String postfix) {

        Stack<String> stack = new Stack<>();

        int temp = 1;

        System.out.println("\nQuadruples:");
        System.out.println("Op\tArg1\tArg2\tResult");

        for (int i = 0; i < postfix.length(); i++) {

            char ch = postfix.charAt(i);

            // Operand
            if (Character.isLetterOrDigit(ch)) {

                stack.push(ch + "");
            }

            // Operator
            else {

                String op2 = stack.pop();

                String op1 = stack.pop();

                String result = "t" + temp++;

                System.out.println(ch + "\t" +
                        op1 + "\t" +
                        op2 + "\t" +
                        result);

                stack.push(result);
            }
        }
    }

    // Triples
    static void generateTriple(String postfix) {

        Stack<String> stack = new Stack<>();

        int index = 0;

        System.out.println("\nTriples:");
        System.out.println("Index\tOp\tArg1\tArg2");

        for (int i = 0; i < postfix.length(); i++) {

            char ch = postfix.charAt(i);

            // Operand
            if (Character.isLetterOrDigit(ch)) {

                stack.push(ch + "");
            }

            // Operator
            else {

                String op2 = stack.pop();

                String op1 = stack.pop();

                System.out.println(index + "\t" +
                        ch + "\t" +
                        op1 + "\t" +
                        op2);

                stack.push("(" + index + ")");

                index++;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter infix expression: ");

        String infix = sc.nextLine();

        // Convert
        String postfix = infixToPostfix(infix);

        // String prefix = infixToPrefix(infix);

        // Print
        System.out.println("\nPostfix = " + postfix);

        // System.out.println("Prefix = " + prefix);

        // Generate Intermediate Code
        generateQuadruple(postfix);

        generateTriple(postfix);

        sc.close();
    }
}