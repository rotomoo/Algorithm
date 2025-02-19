class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] numberString = {"zero", "one", "two", "three", "four", "five",
                    "six", "seven", "eight", "nine", "ten"};

        for (int i = 0; i < 10; i++) {
            s = s.replaceAll(numberString[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }
}