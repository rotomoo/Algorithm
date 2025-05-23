class Solution {
    public int solution(int[] a) {
        int[] leftRightMins = new int[a.length];
        int[] rightLeftMins = new int[a.length];
        
        int min = Integer.MAX_VALUE;
        for (int i=0; i<a.length; i++) {
            min = Math.min(a[i], min);
            leftRightMins[i] = min;
        }
        
        min = Integer.MAX_VALUE;
        for (int i=a.length - 1; i>=0; i--) {
            min = Math.min(a[i], min);
            rightLeftMins[i] = min;
        }
        
        int answer = 0;
        
        for (int i=0; i<a.length; i++) {
            if (leftRightMins[i] >= a[i] || rightLeftMins[i] >= a[i]) {
                answer ++;
            }
        }
        
        return answer;
    }
}