import java.util.ArrayList;

class Solution {
    static String[] arr = {"A", "E", "I", "O", "U"};
    static ArrayList<String> list = new ArrayList<>();
    static String wordTmp;
    static boolean flag = true;

    public static void DFS(int L, String s) {
        if (L==6) return;
        list.add(s);
        if (flag) {
            for (int i = 0; i < 5; i++) {
                DFS(L + 1, s + arr[i]);
            }
        }
    }

    public int solution(String word) {
        wordTmp = word;
        DFS(0, "");
        return list.indexOf(word);
    }
}