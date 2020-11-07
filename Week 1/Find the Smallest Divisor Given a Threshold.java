class Solution {
    
    int[] n;
    
    private long getSum(long v)
    {
        long res = 0;
        for(int i = 0; i < n.length; i++)
        {
            res += ((n[i]+v-1)/v);
        }
        return res;
    }
    
    public int smallestDivisor(int[] nums, int threshold) {
        if(nums == null || nums.length < 1)
            return 1;
        n = nums;
        long min = 1, ans = Integer.MAX_VALUE;
        long sum = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
        }
        
        long max = sum;
        //System.out.println(max);
        while(min <= max)
        {
            //System.out.println(min + " " + max);
            long mid = min+(max-min)/2;
            if(getSum(mid) <= threshold)
            {
                //if(ans > mid)
                    ans = mid;
                max = mid-1;
            }
            else
            {
                min = mid+1;
            }
        }
        return (int)ans;
    }
}