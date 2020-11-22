class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        
        if(words == null || words.length < 1)
            return 0;
        
        String[] arr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> st = new HashSet();
        
        for(String s: words)
        {
            StringBuilder sb = new StringBuilder();
            for(char ch: s.toCharArray())
            {
                sb.append(arr[ch-'a']);
            }
            st.add(sb.toString());
        }
        
        return st.size();
    }
}