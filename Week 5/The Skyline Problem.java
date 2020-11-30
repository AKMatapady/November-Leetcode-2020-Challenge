class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(buildings == null || buildings.length < 1 || buildings[0].length < 1)
            return ans;
        List<int[]> tranInp = new ArrayList();
        
        for(int[] b: buildings)
        {
            tranInp.add(new int[]{b[0], -b[2]});
            tranInp.add(new int[]{b[1], b[2]});
        }
        
        Collections.sort(tranInp, (int[] a, int[] b) -> {
           if(a[0] > b[0]) 
               return 1;
            if(a[0] < b[0])
                return -1;
            if(a[1] < b[1])
                return -1;
            if(a[1] > b[1])
                return 1;
            return 0;
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> (b-a));
        pq.add(0);
        int prevMaxHeight = 0;
        for(int[] x: tranInp)
        {
            if(x[1] > 0)
            {
                pq.remove(x[1]);
            }
            else
            {
                pq.add(-x[1]);
            }
            if(prevMaxHeight != pq.peek())
            {
                prevMaxHeight = pq.peek();
                List<Integer> temp = new ArrayList();
                temp.add(x[0]);
                temp.add(prevMaxHeight);
                ans.add(temp);
            }
        }
        return ans;
    }
}