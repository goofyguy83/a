import java.util.*;

public class LRParser {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");

        String input = sc.nextLine() + "$";

        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        int i = 0;

        while (true) {

            int state = stack.peek();

            char ch = input.charAt(i);

            // STATE 0
            if (state == 0) {

                if (ch == 'c') {

                    stack.push(3);
                    i++;

                    System.out.println("Shift 3");
                }

                else if (ch == 'd') {

                    stack.push(4);
                    i++;

                    System.out.println("Shift 4");
                }

                else {

                    System.out.println("Rejected");
                    return;
                }
            }

            // STATE 1
            else if (state == 1) {

                if (ch == '$') {

                    System.out.println("Accepted");
                    return;
                }
            }

            // STATE 2
            else if (state == 2) {

                if (ch == 'c') {

                    stack.push(3);
                    i++;

                    System.out.println("Shift 3");
                }

                else if (ch == 'd') {

                    stack.push(4);
                    i++;

                    System.out.println("Shift 4");
                }
            }

            // STATE 3
            else if (state == 3) {

                if (ch == 'c') {

                    stack.push(3);
                    i++;

                    System.out.println("Shift 3");
                }

                else if (ch == 'd') {

                    stack.push(4);
                    i++;

                    System.out.println("Shift 4");
                }
            }

            // STATE 4
            else if (state == 4) {

                // Reduce C->d
                stack.pop();

                int top = stack.peek();

                if (top == 0)
                    stack.push(2);

                else if (top == 2)
                    stack.push(5);

                else if (top == 3)
                    stack.push(6);

                System.out.println("Reduce C->d");
            }

            // STATE 5
            else if (state == 5) {

                if (ch == '$') {

                    System.out.println("Reduce S->CC");

                    stack.clear();

                    stack.push(1);
                }
            }

            // STATE 6
            else if (state == 6) {

                // Reduce C->cC
                stack.pop();
                stack.pop();

                int top = stack.peek();

                if (top == 0)
                    stack.push(2);

                else if (top == 2)
                    stack.push(5);

                else if (top == 3)
                    stack.push(6);

                System.out.println("Reduce C->cC");
            }
        }
    }
}