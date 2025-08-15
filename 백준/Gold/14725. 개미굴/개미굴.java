import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        Map<String, Node> child = new TreeMap<>();
    }

    private static void insert(Node root, String[] path) {
        Node cur = root;
        for (String key : path) {
            cur = cur.child.computeIfAbsent(key, k -> new Node());
        }
    }

    private static void dfsPrint(Node node, int depth, StringBuilder sb) {
        for (Map.Entry<String, Node> e : node.child.entrySet()) {
            for (int i = 0; i < depth; i++) sb.append("--");
            sb.append(e.getKey()).append('\n');
            dfsPrint(e.getValue(), depth + 1, sb);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        Node root = new Node();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            String[] path = new String[K];
            for (int k = 0; k < K; k++) path[k] = st.nextToken();
            insert(root, path);
        }

        StringBuilder sb = new StringBuilder();
        dfsPrint(root, 0, sb);
        System.out.print(sb.toString());
    }
}