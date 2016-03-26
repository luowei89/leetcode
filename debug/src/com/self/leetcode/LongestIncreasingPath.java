package com.self.leetcode;

import java.util.*;

/**
 * Created by luowei on 3/25/16.
 */
public class LongestIncreasingPath {
    // My solution given in a Google onsite interview
    // Time Limit Exceeded
    // Optimize: cache calculated values
    private static Map<String, Integer> cache;
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        cache = new HashMap<>();
        PriorityQueue<Node> nodes = new PriorityQueue<>(new ComparatorMin());
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nodes.add(new Node(matrix[i][j], i, j));
            }
        }
        int longest = 0;
        while (nodes.size() > longest) {
            Node node = nodes.poll();
            int newLongest = dfs(matrix, node);
            if (newLongest > longest) {
                longest = newLongest;
            }
        }
        return longest;
    }

    // Optimize: cache calculated values with recursive call
    public int dfs(int[][] matrix, Node start){
        int x = start.getX(), y = start.getY();
        Integer cachedValue = cache.get(x + "," + y);
        if (cachedValue != null) {
            return cachedValue;
        }
        PriorityQueue<Node> queue = new PriorityQueue<>(new ComparatorMax());
        if (x + 1 < matrix.length) {
            queue.add(new Node(matrix[x + 1][y], x + 1, y));
        }
        if (x - 1 >= 0) {
            queue.add(new Node(matrix[x - 1][y], x - 1, y));
        }
        if (y + 1 < matrix[0].length) {
            queue.add(new Node(matrix[x][y + 1], x, y + 1));
        }
        if (y - 1 >= 0) {
            queue.add(new Node(matrix[x][y - 1], x, y - 1));
        }
        List<Integer> lengths = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node newNode = queue.poll();
            if (newNode.getVal() > start.getVal()) {
                lengths.add(dfs(matrix, newNode));
            }
        }
        int longest = 0 ;
        for (int length : lengths) {
            if (length > longest) {
                longest = length;
            }
        }
        cache.put(x + "," + y, longest + 1);
        return longest + 1;
    }

    public class ComparatorMin implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.getVal() - o2.getVal();
        }
    }

    public class ComparatorMax implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.getVal() - o1.getVal();
        }
    }

    public class Node implements Comparable {

        private int val;
        private int x;
        private int y;

        public Node(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Object o) {
            return this.val - ((Node) o).getVal();
        }

        public int getVal() {
            return this.val;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
