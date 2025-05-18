class Solution {
    public String solution(String s) {
        String answer = "";
        String[] tmp = s.toLowerCase().split("");
        boolean flag = true;
        for (String x : tmp) {
            answer += flag == true ? x.toUpperCase() : x;
            flag = x.equals(" ") ? true : false;
        }
        return answer;
    }
}