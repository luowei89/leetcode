package com.self.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by luowei on 3/22/16.
 */
public class CoinsInALineTest {

    // copied from internet, for test
    public int coins(int[] A)
    {
        int n=A.length;
        int[][] sum=new int[n][n];
        int[][] dp=new int[n][n];

        for(int i=n-1;i>=0;i--)
            for(int j=i;j<n;j++)
                sum[i][j]=A[j]+(i==j?0:sum[i][j-1]);

        for(int i=n-1;i>=0;i--)
            for(int j=i;j<n;j++)
            {
                if(i==j)
                    dp[i][j]=A[i];
                else
                    dp[i][j]=sum[i][j]-Math.min(dp[i+1][j], dp[i][j-1]);
            }
        return dp[0][n-1];
    }

    @Test
    public void testMaxValue() throws Exception {
        CoinsInALine cil = new CoinsInALine();
        int[] coins = {1,2,3,4,5,6,7,8,9};
        assertEquals(cil.maxValue(coins), coins(coins));
        int[] coins1 = {2,5,3,7,1,4,9,8};
        assertEquals(cil.maxValue(coins1), coins(coins1));
    }
}