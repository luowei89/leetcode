package com.self.leetcode;

/**
 * * * * * Coins in a Line * * * * *
 * There are n coins in a line. Two players take turns to take a coin
 * from one of the ends of the line until there are no more coins left.
 * The player with the larger amount of money wins. Assume that you go
 * first, describe an algorithm to compute the maximum amount of money
 * you can win.
 */
public class CoinsInALine {

    public int maxValue(int[] coins) {
        int n = coins.length;
        int[][] values = new int[n][n];
        for (int i = 0; i < n; i++) {
            values[i][i] = coins[i];
        }
        for (int win = 0; win < n; win++) {
            for (int i = 0; i + win < n; i++) {
                if (win == 0) {
                    values[i][i+win] = coins[i];
                } else if (win == 1) {
                    values[i][i+win] = Math.max(coins[i], coins[i+win]);
                } else {
                    int valueI = coins[i] + Math.min(values[i + 2][i + win], values[i+1][i + win - 1]);
                    int valueJ = coins[i + win] + Math.min(values[i+1][i + win - 1], values[i][i + win - 2]);
                    values[i][i + win] = Math.max(valueI, valueJ);
                }
            }
        }
        return values[0][n-1];
    }
}
