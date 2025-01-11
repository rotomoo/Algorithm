class Solution {
    public int solution(int[][] sizes) {
        int max_1 = 0;
        int max_2 = 0;
        for (int i=0; i<sizes.length; i++) {
            max_1 = Math.max(max_1, Math.max(sizes[i][0], sizes[i][1]));
            max_2 = Math.max(max_2, Math.min(sizes[i][0], sizes[i][1]));
        }
        return max_1 * max_2;
    }
}