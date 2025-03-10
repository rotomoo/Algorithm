class Solution {
    static int Target;
    static int answer = 0;
    static int[] Numbers;

    public static void DFS(int L, int sum) {
        if (L > Numbers.length) return;
        if (L == Numbers.length) {
            if (sum==Target) {
                answer++;
            }
            return;
        }
        DFS(L+1, sum + Numbers[L]);
        DFS(L+1, sum - Numbers[L]);
    }

    public int solution(int[] numbers, int target) {
        Target = target;
        Numbers = numbers;
        DFS(0,0);
        return answer;
    }
}