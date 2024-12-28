import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();

        int idx = 0;
        for (String player : players) {
            map.put(player, idx++);
        }
        
        for (String calling : callings) {
            int callingIdx = map.get(calling);
            
            String tmp = players[callingIdx-1];
            players[callingIdx-1] = players[callingIdx];
            players[callingIdx] = tmp;
            
            map.put(players[callingIdx-1], callingIdx-1);
            map.put(tmp, callingIdx);
        }
        return players;
    }
}