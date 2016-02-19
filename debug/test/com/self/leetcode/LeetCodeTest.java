package com.self.leetcode;

import com.beust.jcommander.internal.Lists;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by luowei on 2/13/16.
 */
public class LeetCodeTest {

    private LeetCode leetcode = new LeetCode();

    //107. Binary Tree Level Order Traversal II
    @Test
    public void testLevelOrderBottom() {
        TreeNode root = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        root.left = n1;
        root.right = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        leetcode.levelOrderBottom(root);
    }

    // 223. Rectangle Area
    @Test
    public void testComputeArea() {
        int area = leetcode.computeArea(-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1);
        assertEquals(area, 2);
    }
    // 38. Count and Say
    @Test
    public void testCountAndSay() {
        assertEquals(leetcode.countAndSay(3), "21");
    }

    // 290. Word Pattern
    @Test
    public void testWordPattern() {
        assertTrue(leetcode.wordPattern("abba", "dog cat cat dog"));
    }

    // 28. Implement strStr()
    @Test
    public void testStrStr() {
        assertEquals(leetcode.strStr("ABCBACBA", "CB"), 2);
    }

    // 278. First Bad Version
    @Test
    public void testFirstBadVersion() {
        assertEquals(leetcode.firstBadVersion(2126753390), 1702766719);
    }

    // 165. Compare Version Numbers
    @Test
    public void testCompareVersion() {
        assertEquals(leetcode.compareVersion("1","0"), 1);
        assertEquals(leetcode.compareVersion("1","1.1"), -1);
        assertEquals(leetcode.compareVersion("1","1.0"), 0);
    }

    // 8. String to Integer (atoi)
    @Test
    public void testMyAtoi() {
        assertEquals(leetcode.myAtoi("    10522545459"), 2147483647);
        assertEquals(leetcode.myAtoi(" -1010023630o4"), -1010023630);
        assertEquals(leetcode.myAtoi("2147483648"), 2147483647);
        assertEquals(leetcode.myAtoi("2.5"), 2);
        assertEquals(leetcode.myAtoi("   +0 123"), 0);
        assertEquals(leetcode.myAtoi("  -0012a42"), -12);
        assertEquals(leetcode.myAtoi("    2"), 2);
        assertEquals(leetcode.myAtoi("+-2"), 0);
        assertEquals(leetcode.myAtoi("+"), 0);
        assertEquals(leetcode.myAtoi("-1"), -1);
    }

    // 238. Product of Array Except Self
    @Test
    public void testProductExceptSelf() {
        int[] a = {1,2,3,4};
        int[] b = {24,12,8,6};
        assertEquals(leetcode.productExceptSelf(a), b);
    }

    // 319. Bulb Switcher
    @Test
    public void testBulbSwitch() {
        assertEquals(leetcode.bulbSwitch(9999999), 3162);
        assertEquals(leetcode.bulbSwitch(0), 0);
        assertEquals(leetcode.bulbSwitch(1), 1);
        assertEquals(leetcode.bulbSwitch(2), 1);
        assertEquals(leetcode.bulbSwitch(3), 1);

    }

    // 79. Word Search
    @Test
    public void testExist() {
        char[][] board1 = {{'A','B','C','E'},{'S', 'F', 'E', 'S'},{'A', 'D', 'E', 'E'}};
        assertTrue(leetcode.exist(board1, "ABCESEEEFS"));
    }

    // 187. Repeated DNA Sequences
    @Test
    public void testFindRepeatedDnaSequences() {
        assertEquals(leetcode.findRepeatedDnaSequences(""), Lists.newArrayList());
        assertEquals(leetcode.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"), Lists.newArrayList("AAAAACCCCC", "CCCCCAAAAA"));
    }

    // 137. Single Number II
    @Test
    public void testSingleNumber() {
        int[] nums = {-2,-2,1,1,-3,1,-3,-3,-4,-2};
        assertEquals(leetcode.singleNumber(nums), -4);
    }
}