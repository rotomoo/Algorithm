import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] solutions = new int[n];

        for (int i = 0; i < n; i++) {
            solutions[i] = sc.nextInt();
        }

        int left = 0;
        int right = n - 1;
        int minSum = Integer.MAX_VALUE;
        int ansLeft = 0;
        int ansRight = 0;

        while (left < right) {
            int sum = solutions[left] + solutions[right];

            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                ansLeft = solutions[left];
                ansRight = solutions[right];
            }

            if (sum < 0) left++;
            else right--;
        }

        System.out.println(ansLeft + " " + ansRight);
    }
}