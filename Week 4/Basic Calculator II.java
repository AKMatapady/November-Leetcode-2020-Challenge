class Solution {
    public int calculate(String s) {
        int ans = 0;
        int lastNum = 0, curr = 0;
        char lastOp = '+';
        
        for(char ch: s.toCharArray())
        {
            if(Character.isWhitespace(ch))
                continue;
            if(Character.isDigit(ch))
            {
                curr *= 10;
                curr += Integer.parseInt(ch+"");
            }
            else
            {
                if(lastOp == '+')
                {
                    ans += lastNum;
                    lastNum = curr;
                }
                else if(lastOp == '-')
                {
                    ans += lastNum;
                    lastNum = -curr;
                }
                else if(lastOp == '*')
                {
                    lastNum *= curr;
                }
                else if(lastOp == '/')
                {
                    lastNum /= curr;
                }
                lastOp = ch;
                curr = 0;
            }
            //System.out.println(ch + " " + lastNum + " " + curr + " " + ans);
        }
        
        //if(Character.isDigit(s.charAt(s.length()-1)))
        {
            if(lastOp == '+')
            {
                ans += lastNum;
                lastNum = curr;
            }
            else if(lastOp == '-')
            {
                ans += lastNum;
                lastNum = -curr;
            }
            else if(lastOp == '*')
            {
                lastNum *= curr;
            }
            else if(lastOp == '/')
            {
                lastNum /= curr;
            }
            curr = 0;
        }
        
        ans += lastNum;
        
        return ans;
    }
}