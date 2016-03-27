package com.self.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by luowei on 3/27/16.
 */
public class NumArrayTest {

    @Test
    public void testUpdate() throws Exception {
        int[] nums = {1,2,3,4,5,6};
        NumArray na = new NumArray(nums);
        assertEquals(na.sumRange(0,3), 10);
        na.update(2,9);
        assertEquals(na.sumRange(1,4), 20);
    }
}