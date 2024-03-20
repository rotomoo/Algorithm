class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] canSays = {"aya", "ye", "woo", "ma"};
        for (String baby : babbling) {
            for (String say : canSays) {
                baby = baby.replace(say, " ");
            }
            if (baby.trim().isEmpty()) answer++;
        }
        return answer;
    }
}