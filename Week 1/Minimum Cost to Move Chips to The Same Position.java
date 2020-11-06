class Solution {
    public int minCostToMoveChips(int[] position) {
        if(position == null || position.length < 1)
            return 0;
        int odd = 0, even = 0;
        for(int x: position)
        {
            if(x % 2 == 0)
                even++;
            else 
                odd++;
        }
        return Math.min(even, odd);
    }
}