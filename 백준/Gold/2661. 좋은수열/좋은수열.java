import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        backtracking("");
    }

    public static void backtracking(String str) {
        if (str.length() == n) {
            System.out.println(str);
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            String next = str + i;
            if (goodYn(next)) {
               backtracking(next); 
            }
        }
    }

    private static boolean goodYn(String str) {
        int len = str.length();
        for (int i = 1; i <= len / 2; i++) {
            String front = str.substring(len - i * 2, len - i);
            String back = str.substring(len - i, len);
            if (front.equals(back)) {
                return false;
            }
        }
        return true;
    }
}