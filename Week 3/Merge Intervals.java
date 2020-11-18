class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length < 2)
            return intervals;
        List<int[]> pre = new ArrayList<int[]>();
        Arrays.sort(intervals, (a, b) -> {
           if(a[0] < b[0]) 
               return -1;
            if(a[0] > b[0])
                return 1;
            if(a[1] > b[1])
                return -1;
            if(a[1] < b[1])
                return 1;
            return 0;
        });
        
        int start = intervals[0][0], end = intervals[0][1];
        for(int[] x: intervals)
        {
            if(x[0] > end)
            {
                int[] temp = new int[2];
                temp[0] = start;
                temp[1] = end;
                pre.add(temp);
                start = x[0];
                end = x[1];
            }
            else if(x[1] > end)
            {
                end = x[1];
            }
        }
        int[] temp = new int[2];
        temp[0] = start;
        temp[1] = end;
        pre.add(temp);
        
        int[][] res = new int[pre.size()][2];
        for(int i = 0; i < pre.size(); i++)
        {
            res[i][0] = pre.get(i)[0];
            res[i][1] = pre.get(i)[1];
        }
        return res;
    }
}