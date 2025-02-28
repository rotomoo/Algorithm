class Solution {
    public String solution(int[] priorities, String hand) {
        String answer = "";
        int[] lH={3,0};
        int[] rH={3,2};
        for(int x : priorities) {
            if (x==1 || x==4 || x==7) {
                answer+='L';
                lH=check(x);
            }
            else if (x==3 || x==6 || x==9) {
                answer+='R';
                rH=check(x);
            }
            else {
                int[] tmpxy=check(x);
                if (pri(tmpxy,lH,rH,hand)=='R') {
                    answer+='R';
                    rH=tmpxy;
                }
                else {
                    answer+='L';
                    lH=tmpxy;
                }
            }
        }
        return answer;
    }

    public int[] check(int x) {
        int[][] numxy={{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
        return numxy[x];
    }

    public char pri(int[] tmpxy, int[] lH, int[] rH,String hand) {
        char tmp=' ';
        int ldis=Math.abs(lH[0]-tmpxy[0])+Math.abs(lH[1]-tmpxy[1]);
        int rdis=Math.abs(rH[0]-tmpxy[0])+Math.abs(rH[1]-tmpxy[1]);
        if (ldis>rdis) tmp='R';
        else if (ldis<rdis) tmp='L';
        else {
            if (hand.equals("right")) tmp='R';
            else tmp='L';
        }
        return tmp;
    }
}