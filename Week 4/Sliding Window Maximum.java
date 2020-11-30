class Solution {
    
    ArrayDeque<Integer> dq;
    int K;
    int[] n;
    
    private void checkQueue(int i)
    {
        if(dq != null)
        {
            if(!dq.isEmpty() && dq.peekFirst() == i-K)
                dq.removeFirst();
            while(!dq.isEmpty() && n[dq.peekLast()] < n[i])
                dq.removeLast();
        }
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 1 || nums.length < k || k < 1)
            return new int[0];
        dq = new ArrayDeque();
        K = k;
        n = nums;
        //int max = Integer.MIN_VALUE, idx = -1;
        int[] ans = new int[n.length-k+1];
        
        for(int i = 0; i < k; i++)
        {
            checkQueue(i);
            dq.add(i);
        }
        ans[0] = n[dq.peekFirst()];
        for(int i = k; i < n.length; i++)
        {
            checkQueue(i);
            dq.add(i);
            ans[i-k+1] = n[dq.peekFirst()];
        }
        return ans;
    }
}