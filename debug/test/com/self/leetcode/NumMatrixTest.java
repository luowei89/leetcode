package com.self.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by luowei on 2/27/16.
 */
public class NumMatrixTest {

    @Test
    public void testSumRegion() throws Exception {
        int[][] matrix = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        assertEquals(numMatrix.sumRegion(2,1,4,3), 8);
        assertEquals(numMatrix.sumRegion(1,1,2,2), 11);
        assertEquals(numMatrix.sumRegion(1,2,2,4), 12);
    }
}