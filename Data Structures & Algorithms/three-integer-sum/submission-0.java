class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);

        int n =nums.length;

        for(int i=0;i<n;i++)
        {
            if(i!=0&&nums[i-1]==nums[i])
                continue;
            
            int left=i+1;
            int right=n-1;

            while(left<right)
            {
                int sum = nums[left]+nums[right]+nums[i];
                
                if(sum<0)
                {
                    left++;
                                        // Skip duplicates for left
                    while (left < right && nums[left] == nums[left - 1]) 
                        left++;
                }
                else if(sum>0)
                {
                    right--;
                                        // Skip duplicates for right
                    while (left < right && nums[right] == nums[right + 1]) 
                        right--;
                }
                else
                {
                    List<Integer> temp=new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[left++]);
                    temp.add(nums[right--]);
                    list.add(temp);

                    // Skip duplicates for left
                    while (left < right && nums[left] == nums[left - 1]) 
                        left++;

                    // Skip duplicates for right
                    while (left < right && nums[right] == nums[right + 1]) 
                        right--;
                }


            }
        }
        return list;
    }
}
