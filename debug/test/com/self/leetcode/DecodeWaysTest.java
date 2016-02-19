package com.self.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by luowei on 2/18/16.
 */
public class DecodeWaysTest {

    DecodeWays dw = new DecodeWays();
    @Test
    public void testNumDecodings() {
        assertEquals(dw.numDecodings("24726"), 4);
        assertEquals(dw.numDecodings("1212"), 5);
        assertEquals(dw.numDecodings("10"), 1);
        assertEquals(dw.numDecodings("100"), 0);
        assertEquals(dw.numDecodings("110"), 1);
        assertEquals(dw.numDecodings("10120"), 1);
        assertEquals(dw.numDecodings("0"), 0);
        assertEquals(dw.numDecodings("1"), 1);
    }
}