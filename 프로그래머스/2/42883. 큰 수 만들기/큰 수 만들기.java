import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char x : number.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() < x && k>0) {
                stack.pop();
                k--;
            }
            stack.push(x);
        }
        while (k>0) {
            stack.pop();
            k--;
        }
        for (char x: stack) answer.append(x);
        return answer.toString();
    }
}