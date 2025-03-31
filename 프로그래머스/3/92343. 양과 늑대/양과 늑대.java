import java.util.*;

class Solution {
    static class Node {
        public int id;
        public boolean isSheep;
        public List<Node> children = new ArrayList<>();

        Node(int id, boolean isSheep) {
            this.id = id;
            this.isSheep = isSheep;
        }
    }

    public int maxSheep = 0;

    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i, info[i] == 0);
        }

        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            nodes[parent].children.add(nodes[child]);
        }

        List<Node> availableNodes = new ArrayList<>();
        availableNodes.add(nodes[0]);
        dfs(0, 0, availableNodes, nodes[0]);

        return maxSheep;
    }

    private void dfs(int sheep, int wolf, List<Node> availableNodes, Node currentNode) {
        if (currentNode.isSheep) {
            sheep++;
        } else {
            wolf++;
        }

        if (wolf >= sheep) {
            return;
        }

        maxSheep = Math.max(maxSheep, sheep);

        List<Node> nextNodes = new ArrayList<>(availableNodes);
        nextNodes.remove(currentNode);
        nextNodes.addAll(currentNode.children);

        for (Node node : nextNodes) {
            dfs(sheep, wolf, nextNodes, node);
        }
    }
}