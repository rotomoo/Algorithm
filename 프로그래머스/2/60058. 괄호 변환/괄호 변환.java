import java.util.HashMap;
import java.util.Stack;

class Solution {
    static String answer = "";

    public static boolean isPattern(String s) {
        if (s.equals("")) return true;
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        Stack<Character> stack = new Stack<>();
        for (char x : s.toCharArray()) {
            if (map.containsKey(x)) {
                if (stack.isEmpty() || stack.pop() == map.get(x)) return false;
            }
            else stack.push(map.get(x));
        }
        return stack.isEmpty();
    }

    public static boolean isCheck(String s) {
        if (s.equals("")) return true;
        int cnt1=0;
        int cnt2=0;
        for (char x : s.toCharArray()) {
            if (x=='(') cnt1++;
            else cnt2++;
        }
        return cnt1 == cnt2;
    }

    public static String remove(String s) {
        String tmp = "";
        for (int i = 1; i < s.length()-1; i++) {
            if (s.charAt(i)=='(') tmp += ')';
            else tmp += '(';
        }
        return tmp;
    }

    public static String DFS(String p) {
        if (p.equals("")) return p;
        String tmp = "";
        String tmp2 = "";
        for (int i = 0; i < p.length(); i++) {
            tmp += p.charAt(i);
            if (isCheck(tmp)) {
                String u = tmp;
                String v = p.substring(i+1);
                if (isPattern(u)) {
                    return u + DFS(v);
                }
                else {
                    tmp2 = "(";
                    tmp2 += DFS(v) + ")";
                    tmp2 += remove(u);
                    return tmp2;
                }
            }
        }
        return "";
    }

    public static String solution(String p) {
        if (isPattern(p)) return p;
        return DFS(p);
    }
}