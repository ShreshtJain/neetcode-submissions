class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0;i<temperatures.length;i++)
        {
            while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()])
            {
                int index = stack.pop();
                int val = i-index;
                temperatures[index]=val;
            }
                stack.push(i);
        }

        while(!stack.isEmpty())
        {
            temperatures[stack.pop()]=0;
        }

        return temperatures;
    }
}
