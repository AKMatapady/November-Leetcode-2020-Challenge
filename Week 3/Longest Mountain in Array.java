class Solution {
    public int longestMountain(int[] A) {
        int ans = 0;
        if(A == null || A.length < 3)
            return ans;
        //k -> start, j -> end
        int k = 0, j = 0;
        boolean up = true;
        int prev = A[0];
        for(int i = 1; i < A.length; i++)
        {
            //System.out.println(i + " " + up + " " + k + " " + j+ " " + ans);
            //System.out.println(A[i] + " " + prev);
            if(up)
            {
                if(A[i] > prev)
                {
                    prev = A[i];
                    continue;
                }
                if(A[i] < prev)
                {
                    //check for direct downward slope
                    if(k < i-1)
                        up = false;
                    else
                    {
                        k = i;
                        j = i;
                    }
                }
                else
                {
                    j = i;
                    //ans = Math.max(ans, j-k);
                    k = i;
                }
            }
            else
            {
                if(A[i] < prev)
                {
                    prev = A[i];
                    continue;
                }
                up = true;
                if(A[i] > prev)
                {
                    j = i;                    
                    ans = Math.max(ans, j-k);
                    k = i-1;
                }
                else
                {
                    j = i;
                    ans = Math.max(ans, j-k);
                    k = i;
                }
            }
            prev = A[i];
        }
        if(!up)
        {
            //System.out.println("last: " + (A.length-k));
            ans = Math.max(ans, A.length-k);
        }
        //System.out.println(ans);
        
        return (ans < 3)?0:ans;
    }
}