class Solution {
    private int gcd(int a, int b)
    {
        if(a == 0)
            return b;
        return gcd( b%a, a);
    }
    public int mirrorReflection(int p, int q) {
        //this answer is from leetcode solution
        int g = gcd(p, q);
        p /= g;
        q /= g;
        p %= 2;
        q %= 2;
        if(p==1 && q==1)
            return 1;
        return (p==1)?0:2;
    }
}