class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();

        for(String ch:tokens)
        {
            if("+".equals(ch))
            {
                stack.push(stack.pop()+stack.pop());
            }
            else if("-".equals(ch))
            {
                int a= stack.pop();
                int b= stack.pop();
                stack.push(b-a);
            }
            else if("*".equals(ch))
            {
                stack.push(stack.pop()*stack.pop());
            }
            else if("/".equals(ch))
            {
                int a= stack.pop();
                int b= stack.pop();
                stack.push(b/a);
            }
            else
            {
                stack.push(Integer.parseInt(ch));
            }
        }

        return stack.pop();
    }
}
