import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(a, map.getOrDefault(a, 0) + 1);
        map.put(b, map.getOrDefault(b, 0) + 1);
        map.put(c, map.getOrDefault(c, 0) + 1);
        map.put(d, map.getOrDefault(d, 0) + 1);
        
        List<Integer> mapKeys = new ArrayList<>(map.keySet());
        Collections.sort(mapKeys, (o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        
        int p = 0;
        int q = 0;
        int r = 0;
        
        switch(mapKeys.size()) {
            case 4:
                return Math.min(a, Math.min(b, Math.min(c, d)));
            case 1:
                return 1111 * a;
            case 2:
                p = mapKeys.get(0);
                q = mapKeys.get(1);
                if (map.get(p) == 3) {
                    return (int)Math.pow((10 * p + q), 2);
                }
                return (p + q) * (Math.abs(p-q));
            case 3:
                q = mapKeys.get(1);
                r = mapKeys.get(2);
                return q * r;


        }
        
        return 0;
    }
}