import java.util.*;

class Solution {
    static char[] cb;

    public static void DFS(int L, int s, String str, int cnt, HashMap<String,Integer> map) {
        if (L == cnt) {
            String result = new String(cb);
            map.put(result, map.getOrDefault(result, 0) + 1);
            return;
        }
        for (int i = s; i < str.length(); i++) {
            cb[L]=str.charAt(i);
            DFS(L+1, i+1, str, cnt, map);
        }
    }

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        for (int x : course) {
            HashMap<String, Integer> map = new HashMap<>();
            for (String s : orders) {
                cb = new char[x];
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                DFS(0, 0, new String(chars), x, map);
            }
            int max = Integer.MIN_VALUE;
            ArrayList<String> list = new ArrayList<>(map.keySet());
            Collections.sort(list, (o1, o2) ->{
                return map.get(o2) - map.get(o1);
            });
            for (String key : list) {
                int cnt = map.get(key);
                max = Math.max(max, cnt);
                if (cnt==1) break;
                if (max!=cnt) break;
                answer.add(key);
            }
        }
        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }
}