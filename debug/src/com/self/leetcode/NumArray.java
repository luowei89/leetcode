package com.self.leetcode;

public class NumArray {
    // easy way:        constructor O(1), update O(1), sumRange O(n)
    // sums:            constructor O(n), update O(n), sumRange O(1)
    // segment tree:    constructor O(lgn), update O(lgn), sumRange O(lgn)
    private int[] nums;
    private SegTreeNode root;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.root = buildTree(0, nums.length - 1);
    }

    public void update(int i, int val) {
        update(this.root, 0, this.nums.length - 1, i, val - this.nums[i]);
        this.nums[i] = val;
    }

    private void update(SegTreeNode root, int start, int end, int i, int diff) {
        root.val += diff;
        if (start < end) {
            int mid = (start + end) >> 1;
            if (i <= mid) {
                update(root.left, start, mid, i, diff);
            } else {
                update(root.right, mid + 1, end, i, diff);
            }
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(this.root, 0, this.nums.length - 1, i, j);
    }

    private int sumRange(SegTreeNode root, int start, int end, int i, int j) {
        if (start == i && end == j) {
            return root.val;
        }
        int mid = (start + end) >> 1;
        if (mid < i) {
            return sumRange(root.right, mid + 1, end, i, j);
        } else if (mid >= j) {
            return sumRange(root.left, start, mid, i, j);
        } else {
            return sumRange(root.left, start, mid, i, mid) + sumRange(root.right, mid + 1, end, mid + 1, j);
        }
    }

    private SegTreeNode buildTree(int start, int end) {
        if (start == end) {
            return new SegTreeNode(this.nums[start]);
        }
        int mid = (start + end) >> 1;
        SegTreeNode left = buildTree(start, mid);
        SegTreeNode right = buildTree(mid + 1, end);
        SegTreeNode node = new SegTreeNode(left.val + right.val);
        node.left = left;
        node.right = right;
        return node;
    }

    public class SegTreeNode {
        int val;
        SegTreeNode left;
        SegTreeNode right;
        public SegTreeNode(int val) {
            this.val = val;
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
