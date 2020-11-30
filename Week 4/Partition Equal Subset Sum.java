class Solution {
    
    private boolean dfs(int[] nums, Boolean[][] mem, int n, int sum)
    {
        if(sum == 0)
            return true;
        if(sum < 0)
            return false;
        if(n <= 0)
            return false;
        if(mem[n][sum] != null)
            return mem[n][sum];
        boolean ans = dfs(nums, mem, n-1, sum-nums[n]);
        if(!ans)
            ans = dfs(nums, mem, n-1, sum);
        mem[n][sum] = ans;
        return ans;
    }
    
    public boolean canPartition(int[] nums) {
        //if sum exceeds integer max limit then this will fail -> will have to change it
        int sum = 0;
        for(int x: nums)
            sum += x;
        if(sum % 2 == 1)
            return false;
        Boolean[][] mem = new Boolean[nums.length][(sum/2)+1];
        return dfs(nums, mem, nums.length-1, sum/2);
    }
}