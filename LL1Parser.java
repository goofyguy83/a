import java.util.*;

public class LL1Parser {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stack<Character> stack = new Stack<>();

        System.out.print("Enter input string: ");

        String input = sc.nextLine() + "$";

        int i = 0;

        // Push $
        stack.push('$');

        // Push start symbol
        stack.push('E');

        while (!stack.isEmpty()) {

            char top = stack.peek();

            char current = input.charAt(i);

            // If terminal matches
            if (top == current) {

                stack.pop();
                i++;
            }

            // E -> iE'
            else if (top == 'E' && current == 'i') {

                stack.pop();

                stack.push('R');
                stack.push('i');
            }

            // R -> +iR
            else if (top == 'R' && current == '+') {

                stack.pop();

                stack.push('R');
                stack.push('i');
                stack.push('+');
            }

            // R -> epsilon
            else if (top == 'R' && current == '$') {

                stack.pop();
            }

            else {

                System.out.println("String Rejected");
                return;
            }
        }

        if (i == input.length()) {

            System.out.println("String Accepted");
        }

        else {

            System.out.println("String Rejected");
        }

        sc.close();
    }
}