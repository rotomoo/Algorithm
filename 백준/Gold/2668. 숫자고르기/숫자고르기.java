import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int id;
        Node next;
        boolean visitYn;
        boolean finishYn;
        boolean cycleYn;

        public Node(int id) {
            this.id = id;
        }
    }

    static int N;
    static List<Node> nodes = new ArrayList<>();

    private static void dfs(Node current) {
        current.visitYn = true;
        Node nextNode = current.next;

        if (!nextNode.visitYn) {
            dfs(nextNode);
            current.finishYn = true;
            return;
        }

        if (!nextNode.finishYn) {
            Node cycleNode = nextNode;
            while (true) {
                cycleNode.cycleYn = true;
                cycleNode = cycleNode.next;
                if (cycleNode == nextNode) break;
            }
        }

        current.finishYn = true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        // index 0 null (1-base)
        nodes.add(null); 
        
        for (int i = 1; i <= N; i++) {
            nodes.add(new Node(i));
        }

        for (int i = 1; i <= N; i++) {
            int toId = Integer.parseInt(br.readLine().trim());
            nodes.get(i).next = nodes.get(toId);
        }

        for (int i = 1; i <= N; i++) {
            if (!nodes.get(i).visitYn) dfs(nodes.get(i));
        }

        List<Integer> answers = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (nodes.get(i).cycleYn) answers.add(i);
        }
        Collections.sort(answers);

        StringBuilder sb = new StringBuilder();
        sb.append(answers.size()).append('\n');
        for (int num : answers) sb.append(num).append('\n');
        System.out.print(sb.toString());
    }
}