import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        Set<String> gemTypes = new HashSet<>();
        Map<String, Integer> leftRights = new HashMap<>();
        int answerLength = Integer.MAX_VALUE;
        
        for (int i=0; i<gems.length; i++) {
            gemTypes.add(gems[i]);        
        }
        
        int left = 0;
        int right = 0;
        
        for (; right < gems.length; right++) {
            leftRights.put(gems[right], leftRights.getOrDefault(gems[right], 0) + 1);   
            
            while (leftRights.get(gems[left]) > 1) {
                leftRights.put(gems[left], leftRights.getOrDefault(gems[left], 0) - 1);
                left++;
            }
                
            if (leftRights.size() == gemTypes.size() && answerLength > right - left) {
                answerLength = right - left;
                answer[0] = left + 1;
                answer[1] = right + 1;
            }
        }
        
        return answer;
    }
}