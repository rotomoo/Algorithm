import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    private static int precedence(char op) {
        if (op == '*' || op == '/') {
            return 2;
        }
        if (op == '+' || op == '-') {
            return 1;
        }
        if (op == '(' || op == ')') {
            return 0;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String infix = br.readLine();
        StringBuilder postfix = new StringBuilder();
        Deque<Character> operatorStack = new ArrayDeque<>();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                postfix.append(ch);
            } else if (ch == '(') {
                operatorStack.offerLast(ch);
            } else if (ch == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peekLast() != '(') {
                    postfix.append(operatorStack.pollLast());
                }
                if (!operatorStack.isEmpty()) {
                    operatorStack.pollLast();
                }
            } else {
                while (!operatorStack.isEmpty() && precedence(operatorStack.peekLast()) >= precedence(ch)) {
                    postfix.append(operatorStack.pollLast());
                }
                operatorStack.offerLast(ch);
            }
        }

        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pollLast());
        }

        System.out.println(postfix);
    }
}