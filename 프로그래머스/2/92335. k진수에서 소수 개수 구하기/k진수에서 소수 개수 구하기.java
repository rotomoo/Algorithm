class Solution {
    public boolean check (long v) {
        if (v == 1) return false;
        for (int i = 2; i <= Math.sqrt(v); i++) {
            if (v % i == 0) return false;
        }
        return true;
    }

    public int solution(int n, int k) {
        int answer = 0;
        String tmp = Integer.toString(n, k);
        String[] split = tmp.split("0");
        for (String x : split) {
            if (x.equals("")) continue;
            if (check(Long.parseLong(x))) answer++;
        }
        return answer;
    }
}