class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        for (String x : skill_trees) {
            if (skill.indexOf(x.replaceAll("[^"+skill+"]",""))!=0) answer--;
        }
        return answer;
    }
}

//class Solution {
//    static Stack<Character> stack;
//
//    public static boolean isCheck(String x) {
//        int length = x.length();
//        for (int i = 0; i < length; i++) {
//            if (!stack.contains(x.charAt(i))) continue;
//            if (stack.peek() != x.charAt(i)) return false;
//            stack.pop();
//        }
//        return true;
//    }
//
//    public int solution(String skill, String[] skill_trees) {
//        int answer = 0;
//        stack = new Stack();
//        for (String x : skill_trees) {
//            for (int i = 0; i < skill.length(); i++) {
//                stack.push(skill.charAt(skill.length() - i - 1));
//            }
//            if (isCheck(x)) answer++;
//            stack.clear();
//        }
//        return answer;
//    }
//}