class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int len = String.valueOf(n).length();
        
        int[] dp = new int[len+1];
        int[] pre = new int[len+1];
        
        dp[len] = 1;
        
        for(int i = 0; i <= len; i++)
        {
            pre[i] = (int)Math.pow(digits.length, len-1-i);
        }
        
        for(int i = 1; i < len; i++)
            dp[0] += pre[len-i-1];
        
        for(int i = len-1; i >= 0; i--)
        {
            int curr = Integer.parseInt(""+String.valueOf(n).charAt(i));
            for(String x: digits)
            {
                if(((int)Integer.valueOf(x)) < curr)
                {
                    dp[i] += pre[i];
                }
                else if(((int)Integer.valueOf(x)) == curr)
                {
                    dp[i] += dp[i+1];
                }
            }
        }
        
        
        
        return dp[0];
    }
}