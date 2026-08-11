class Solution {
    int[] nums;
    int target;
    public int search(int[] nums, int target) {
        this.nums=nums;
        this.target=target;
        return binarySearch(0,nums.length-1);
    }

    int binarySearch(int left, int right)
    {
            if (left > right)
        return -1;
        
        int mid=right-(right-left)/2;

        if(target==nums[mid])   
            return mid;

        if(nums[mid]>target)
        {
            return binarySearch(left,mid-1);
        }
        else
        {
            return binarySearch(mid+1,right);
        }
        
    }
}
