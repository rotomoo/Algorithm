import java.util.Scanner;

class Main {
    static int answer;
    public static void DFS(int L) {
        if(L == 0) {
            answer ++;
        }
        if (L>2) DFS(L-3);
        if (L>1) DFS(L-2);
        if (L>0) DFS(L-1);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        for(int i=0; i<x; i++) {
            answer = 0;
            DFS(sc.nextInt());
            System.out.println(answer);
        }
    }
}