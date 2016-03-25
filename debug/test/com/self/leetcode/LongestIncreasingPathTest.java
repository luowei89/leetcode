package com.self.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by luowei on 3/25/16.
 */
public class LongestIncreasingPathTest {

    @Test
    public void testLongestIncreasingPath() throws Exception {
        LongestIncreasingPath lip = new LongestIncreasingPath();

        int[][] matrix1 = {{5,8,7,8,5}};
        assertEquals(lip.longestIncreasingPath(matrix1), 2);

        int[][] matrix = {{9,9,4}, {6,6,8}, {2,1,1}};
        assertEquals(lip.longestIncreasingPath(matrix), 4);
    }
}