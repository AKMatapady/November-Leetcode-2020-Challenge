class Solution {
    
    private String recur()
    {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while(idx < str.length() && str.charAt(idx) != ']')
        {
            if(str.charAt(idx) == '[')
            {
                idx++;
                String sub = recur();
                while(num > 0)
                {
                    num--;
                    sb.append(sub);
                }
                //idx--;
            }
            else if(str.charAt(idx) >= '0' && str.charAt(idx) <= '9')
            {
                num *= 10;
                num += (Integer.parseInt(str.charAt(idx)+""));
            }
            else
            {
                sb.append(str.charAt(idx));
            }
            idx++;
        }
        
        return sb.toString();
    }
    
    String str;
    int idx;
    
    public String decodeString(String s) {
        if(s == null || s.length() < 2)
            return s;
        str = s;
        idx = 0;
        return recur();        
    }
}