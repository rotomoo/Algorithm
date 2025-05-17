import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int lt = 0;
        int rt = citations[citations.length - 1];
        while (lt <= rt) {
            int mid = (lt+rt)/2;
            int cnt = 0;
            for (int i = 0; i < citations.length; i++) {
                if (citations[i]>=mid) cnt++;
            }
            if (cnt >= mid) {
                answer = mid;
                lt = mid + 1;
            }
            else rt = mid - 1;
        }
        return answer;
    }
}