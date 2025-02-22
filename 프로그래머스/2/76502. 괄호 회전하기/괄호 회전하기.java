import java.util.HashMap;
import java.util.Stack;

class Solution {

    public static boolean isCheck(String tmp) {
        HashMap<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        for (char x : tmp.toCharArray()) {
            if (!map.containsKey(x)) {
                stack.push(x);
            }
            else {
                if (stack.isEmpty() || stack.pop() != map.get(x)) return false;
            }
        }
        return stack.isEmpty();
    }

    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            String tmp = s.substring(i) + s.substring(0, i);
            if (isCheck(tmp)) answer++;
        }
        return answer;
    }
}