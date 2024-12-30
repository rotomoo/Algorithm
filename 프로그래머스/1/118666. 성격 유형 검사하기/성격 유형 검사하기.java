import java.util.HashMap;
import java.util.Map;

class Solution {

    private String testPersonality(String curIndicator, Map<String, Integer> indicatorScore) {
        String indicatorResponse = "";
        String left = String.valueOf(curIndicator.charAt(0));
        String right = String.valueOf(curIndicator.charAt(1));
        if (indicatorScore.get(left) >= indicatorScore.get(right)) {
            indicatorResponse = left;
        }
        else indicatorResponse = right;
        return indicatorResponse;
    }

    public String solution(String[] survey, int[] choices) {

        Map<String, Integer> indicatorScore = new HashMap<>();
        indicatorScore.put("R", 0);
        indicatorScore.put("T", 0);
        indicatorScore.put("C", 0);
        indicatorScore.put("F", 0);
        indicatorScore.put("J", 0);
        indicatorScore.put("M", 0);
        indicatorScore.put("A", 0);
        indicatorScore.put("N", 0);

        int idx = 0;
        for (String curSurvey : survey) {
            int choice = choices[idx];
            if (choice - 4 < 0) {
                String key = String.valueOf(curSurvey.charAt(0));
                indicatorScore.put(key, indicatorScore.get(key) + Math.abs(choice - 4));
            }
            else if (choice - 4 > 0) {
                String key = String.valueOf(curSurvey.charAt(1));
                indicatorScore.put(key, indicatorScore.get(key) + Math.abs(choice - 4));
            }
            idx++;
        }

        String answer = "";

        answer += testPersonality("RT", indicatorScore);
        answer += testPersonality("CF", indicatorScore);
        answer += testPersonality("JM", indicatorScore);
        answer += testPersonality("AN", indicatorScore);

        return answer;
    }
}