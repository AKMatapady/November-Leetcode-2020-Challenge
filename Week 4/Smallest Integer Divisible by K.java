class Solution {
    public int smallestRepunitDivByK(int K) {
        if(K % 2 == 0 )
            return -1;
        Set<Integer> rem = new HashSet();
        int r = 0, ans = 0;
        while(!rem.contains(r))
        {
            rem.add(r);
            r *= 10;
            r += 1;
            ans++;
            r %= K;
            if(r == 0)
                return ans;            
        }
        return -1;
    }
}