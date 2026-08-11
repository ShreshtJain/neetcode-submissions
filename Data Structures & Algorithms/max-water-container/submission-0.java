class Solution {
    public int maxArea(int[] heights) {
        int left=0;
        int right=heights.length-1;

        int max=0;

        while(left<right)
        {
            int curr=(right-left);

            if(heights[left]<heights[right])
            {
                curr*=heights[left];
                left++;
            }
            else
            {
                curr*=heights[right];
                right--;
            }
            max=Math.max(max,curr);
        }

        return max;
    }
}
