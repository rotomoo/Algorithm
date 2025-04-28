class Solution {
    public int solution(int[] a) {
        int answer = 0;

        int[] numCnt = new int[a.length];
        for(int num=0; num<a.length; num++){
            numCnt[a[num]]++;
        }
        
        for(int num=0; num<numCnt.length; num++){
            if(numCnt[num] <= answer) continue;
            
            int cnt = 0;
            for(int idx=0; idx<a.length-1; idx++){
                if(a[idx]!=a[idx+1] && (num==a[idx] || num==a[idx+1])){
                    cnt++;
                    idx++;
                }
            }
            
            answer = Math.max(answer, cnt);
        }
        
        return answer*2;
    }
}