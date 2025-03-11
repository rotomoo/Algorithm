import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    static String[][] relationTmp;
    static int[] cb;
    static int answer;
    static ArrayList<HashSet<Integer>> list;

    public static boolean isCheck(int[] cb) {
        HashSet<String> set = new HashSet<>();
        HashSet<Integer> setTmp = new HashSet<>();
        int cnt=0;
        for (int i = 0; i < relationTmp.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j : cb) {
                sb.append(relationTmp[i][j]);
            }
            cnt++;
            set.add(sb.toString());
            if (set.size() != cnt) return false;
        }
        for (int x : cb) {
            setTmp.add(x);
        }
        for (HashSet<Integer> x: list) {
            if (setTmp.containsAll(x)) return false;
        }
        list.add(setTmp);
        return true;
    }

    public static void DFS(int L, int s, int size) {
        if (L == size) {
            if (isCheck(cb)) answer++;
            return;
        }
        for (int i=s; i<relationTmp[0].length; i++) {
            cb[L]=i;
            DFS(L+1 ,i+1, size);
        }
    }

    public int solution(String[][] relation) {
        relationTmp = relation;
        list = new ArrayList<>();
        for (int i = 0; i < relation[0].length; i++) {
            cb = new int[i+1];
            DFS(0,0, i+1);
        }
        return answer;
    }
}