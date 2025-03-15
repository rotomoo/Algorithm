class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int width = 3; width < brown + yellow; width++) {
            int height = (brown + yellow) / width;
            if (width >= height && width * height == brown + yellow && ((width - 2) * (height - 2) == yellow)) {
                answer[0] = width;
                answer[1] = height;
            }
        }
        return answer;
    }
}