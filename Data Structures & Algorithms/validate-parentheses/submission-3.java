class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c=='('||c=='{'||c=='[')
            {
                stack.push(s.charAt(i)); 
            }
            else
            {
                if(stack.isEmpty())
                        return false;

                char open= stack.pop();
               if ((c == ')' && open != '(') ||
                    (c == '}' && open != '{') ||
                    (c == ']' && open != '[')) {
                    return false;
                }
            }
        }
    if(!stack.isEmpty())
        return false;
    return true;
    }
}
