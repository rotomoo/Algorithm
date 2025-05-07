import java.util.ArrayList;

class Solution {
    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add(words[0]);
        char cTmp = words[0].charAt(words[0].length() - 1);
        for (int i = 1; i < words.length; i++) {
            if (cTmp != words[i].charAt(0) || tmp.contains(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            tmp.add(words[i]);
            cTmp = words[i].charAt(words[i].length() - 1);
        }
        return answer;
    }
}