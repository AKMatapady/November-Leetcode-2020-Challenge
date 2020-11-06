class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        if(n < 2)
        {
            Set<Integer> as = new HashSet();
            if(n > 0)
                as.add(0);
            return new ArrayList<Integer>(as);
        }
        
        List<HashSet<Integer>> adj = new ArrayList();
        //Set<Integer> as = new HashSet();
        for(int i = 0; i < n; i++)
        {
            adj.add(new HashSet<Integer>());
            //as.add(i);
        }
        
        for(int[] e: edges)
        {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        int rem = n;
        
        Set<Integer> prev = new HashSet();
            for(int i = 0; i < n; i++)
            {
                if(adj.get(i).size() == 1)
                    prev.add(i);
            }
        
        while(rem > 2)
        {
            Set<Integer> s = new HashSet();
            
            for(int x: prev)
            {
                rem--;
                for(int y: adj.get(x))
                {
                    adj.get(y).remove((Integer)x);
                    if(adj.get(y).size() == 1)
                        s.add(y);
                }
            }
            
            prev = s;
        }
        return new ArrayList<Integer>(prev);
    }
}