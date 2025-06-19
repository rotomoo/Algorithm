class Solution {
    public int solution(String s) {
        int minLen = s.length();

        for (int unit = 1; unit <= s.length() / 2; unit++) {
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, unit);
            int count = 1;

            for (int i = unit; i <= s.length(); i += unit) {
                String current;
                if (i + unit <= s.length()) {
                    current = s.substring(i, i + unit);
                } else {
                    current = s.substring(i);
                }

                if (prev.equals(current)) {
                    count++;
                } else {
                    if (count > 1) {
                        compressed.append(count);
                    }
                    compressed.append(prev);
                    prev = current;
                    count = 1;
                }
            }

            if (count > 1) {
                compressed.append(count);
            }
            compressed.append(prev);

            minLen = Math.min(minLen, compressed.length());
        }

        return minLen;
    }
}