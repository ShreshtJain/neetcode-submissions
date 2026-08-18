class Solution {
    public int largestRectangleArea(int[] heights) {
        int n =heights.length;

        Stack<Integer> stack =new Stack<Integer>();
        int max = 0;

        for(int i=0;i<=n;i++)
        {
            while(!stack.isEmpty()&&(i==n||heights[i]<heights[stack.peek()]))
            {
                int val = heights[stack.pop()];
                int left =-1;
                
                if(!stack.isEmpty())
                    left=stack.peek();
                
                int right =i;

                int curr = val*(right-left-1);
                max=Math.max(max,curr);
            }

            if(i<n)
                stack.push(i);
        }

        return max;
    }
}
