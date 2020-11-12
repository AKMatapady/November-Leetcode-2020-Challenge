class Solution {
    
    private double dist(int[] a, int[] b)
    {
        return Math.pow(a[0]-b[0], 2) + Math.pow(a[1]-b[1], 2);
    }
    
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        List<int[]> lst = new ArrayList();
        lst.add(p1);
        lst.add(p2);
        lst.add(p3);
        lst.add(p4);
        
        Collections.sort(lst, (int[] a, int[] b) -> {
           if(a[0] < b[0]) 
               return -1;
            if(a[0] > b[0])
                return 1;
            if(a[1] > b[1])
                return 1;
            if(a[1] < b[1])
                return -1;
            return 0;
        });
        
        if(dist(lst.get(0), lst.get(1)) == 0)
            return false;
        if(dist(lst.get(0), lst.get(1)) != dist(lst.get(1), lst.get(3)))
            return false;
        if(dist(lst.get(1), lst.get(3)) != dist(lst.get(3), lst.get(2)))
            return false;
        if(dist(lst.get(3), lst.get(2)) != dist(lst.get(2), lst.get(0)))
            return false;
        if(dist(lst.get(0), lst.get(3)) != dist(lst.get(1), lst.get(2)))
            return false;
        
        return true;
    }
}