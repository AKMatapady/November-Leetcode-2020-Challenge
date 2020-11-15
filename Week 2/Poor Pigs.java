class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        //return (int)( (Math.log(buckets) + Math.log((minutesToDie / minutesToTest) + 1)) / Math.log((minutesToDie / minutesToTest) + 1 ));
        int x = minutesToTest / minutesToDie + 1;
        return (int) Math.ceil(Math.log(buckets) / Math.log(x));
    }
}