class Solution {
    public int longestSubstring(String s, int k) {
        
        if(s == null || s.length() < k)
            return 0;
        
        Set<Character> st = new HashSet();
        
        for(int i = 0; i < s.length(); i++)
        {
            st.add(s.charAt(i));
        }
        
        int[] map = new int[26];
        int ans = 0;
        
        for(int i = 1; i <= st.size(); i++)
        {
            Arrays.fill(map, 0);
            int unique = 0, atleastk = 0, start = 0, end = 0;
            
            while(end < s.length())
            {
                if(unique <= i)
                {
                    map[s.charAt(end)-'a']++;
                    if(map[s.charAt(end)-'a'] == 1)
                        unique++;
                    if(map[s.charAt(end)-'a'] == k)
                        atleastk++;
                    end++;
                }
                else
                {
                    if(map[s.charAt(start)-'a'] == k)
                        atleastk--;
                    map[s.charAt(start)-'a']--;
                    if(map[s.charAt(start)-'a'] == 0)
                        unique--;
                    start++;
                }
                if(unique == i && unique == atleastk && (end - start) > ans)
                    ans = (end - start);
            }
        }
        
        return ans;
    }
}