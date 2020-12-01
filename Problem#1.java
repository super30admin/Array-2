// 518. Coin Change 2 ( #PR 22 S30)



 class Solution {
    public int change(int amount, int[] coins) {
        
        if (coins == null)
            return 0;
        int dp [][]= new int[coins.length+1] [amount+1];
        
        int rows = dp.length, cols = dp[0].length;
        
        for(int i =0; i<rows; i++)
        {
            dp[i][0] = 1;
        }
        
        for(int i=1; i<rows; i++)
        {
            for (int j=1; j<cols; j++)
            {
                if(j < coins[i-1]) {
                    dp[i][j]= dp[i-1][j];
                }
                else
                {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]; 
                }
            }
        }
        
        return dp[rows-1][cols-1];
    }
}


/*
Complexity Analysis

Time complexity: 
O(N×amount), where N is a length of coins array.

Space complexity: 
O(amount) to keep dp array.

*/ 