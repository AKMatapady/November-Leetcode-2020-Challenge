class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        if(A == null || A.length < 1 || A[0].length < 1)
            return A;
        int[][] ans = new int[A.length][A[0].length];
        for(int i = 0; i < A.length; i++)
        {
            for(int j = 0; j < (A[0].length+1)/2; j++)
            {
                ans[i][j] = (A[i][A[0].length-1-j]+1)%2;
                ans[i][A[0].length-1-j] = (A[i][j]+1)%2;
            }
        }
        return ans;
    }
}