class Solution {
    
    int[] n;
    List<List<Integer>> ans;
    HashMap<Integer, Integer> map;
    
    private void dfs(List<Integer> curr)
    {
        if(curr.size() == n.length)
        {
            ans.add(new ArrayList(curr));
            return;
        }
        
        for(Integer key: map.keySet())
        {
            int val = map.get(key);
            if(val < 1)
                continue;
            curr.add(key);
            map.put(key, val-1);
            
            dfs(curr);
            //as the number has duplicates we need to remove the last occurence of the nnumber from the curr list
            //curr.remove((Integer)key);
            curr.remove(curr.size()-1);
            map.put(key, val);
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
       
        ans = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 1)
            return ans;
        n = nums;
        map = new HashMap();
        for(Integer i = 0; i < nums.length; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        
        dfs(new ArrayList());
        
        return ans;
    }
}