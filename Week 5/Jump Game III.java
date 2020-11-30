class Solution {
    public boolean canReach(int[] arr, int start) {
        
        if(arr == null || arr.length < 1 || start >= arr.length || start < 0)
            return false;
        
        if(arr[start] == 0)
            return true;
        
        //queue of indices
        Queue<Integer> idxs = new LinkedList<Integer>();
        
        //set to keep track of indices visited
        Set<Integer> done = new HashSet<Integer>();
        
        idxs.add(start);
        done.add(start);
        
        while(!idxs.isEmpty())
        {
            int index = idxs.poll();
            if(arr[index] == 0)
                return true;
            if(index + arr[index] < arr.length && index+arr[index] >= 0)
            {
                if(!done.contains(arr[index]+index))
                {
                    idxs.add(arr[index]+index);
                    done.add(arr[index]+index);
                }
            }
            if(index - arr[index] < arr.length && index-arr[index] >= 0)
            {
                if(!done.contains(-arr[index]+index))
                {
                    idxs.add(-arr[index]+index);
                    done.add(-arr[index]+index);
                }
            }
        }
        
        return false;
    }
}