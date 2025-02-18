class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            // 짝수는 +1
            if (numbers[i]%2==0){
                answer[i] = numbers[i] + 1;
                continue;
            }
            // 홀수일때 0을 찾음.
            String tmp = Long.toString(numbers[i], 2);
            int zeroIdx = tmp.lastIndexOf("0");
            // 0이 없을때 2번째자리에 0만 추가
            if (zeroIdx == -1) {
                answer[i] = Long.parseLong("10" + "1".repeat(tmp.length() - 1), 2);
                continue;
            }
            // 0을 1로 이후 idx를 0으로
            StringBuilder sb = new StringBuilder(tmp);
            sb.setCharAt(zeroIdx, '1');
            sb.setCharAt(zeroIdx + 1,'0');
            answer[i] = Long.parseLong(sb.toString(), 2);
        }
        return answer;
    }
}