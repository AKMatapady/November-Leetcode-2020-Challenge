class Solution {
    
//     private int getIndex(int[] nums)
//     {
//         if(nums[0] < nums[nums.length-1])
//             return 0;
//         int start = 0, end = nums.length-1;
//         while(start < end)
//         {
//             int mid = start + (end-start)/2;
//             if(mid > 0 && nums[mid] < nums[mid-1])
//                 return mid;
//             if(nums[mid] > nums[0])
//             {
//                 start = mid + 1;
//             }
//             else if(nums[mid] == nums[0])
//             {
//                 if(nums[mid] < nums[nums.length-1])
//                     end = mid-1;
//                 else
                    
//             }
//             else
//             {
//                 end = mid;
//             }
//         }
//         return end;
//     }
    
//     private boolean get(int start, int end, int target)
//     {
//         if(start > end)
//             return false;
//         while(start <= end)
//         {
//             int mid = start + (end-start)/2;
//             if(n[mid] == target)
//                 return true;
//             if(n[mid] > target)
//                 end = mid-1;
//             else
//                 start = mid + 1;
//         }
//         return false;
//     }
    
//     int[] n;
    
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length < 1)
            return false;
        
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) 
        {
            while (start < end && nums[start] == nums[start + 1])
                start++;
            while (start < end && nums[end - 1] == nums[end])
                end--;
            
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target)
                return true;
            if (nums[mid] >= nums[start])
            {
                if (target >= nums[start] && target < nums[mid])
                  end = mid - 1;
                else
                  start = mid + 1;
            }
            else
            {
                if (target <= nums[end] && target > nums[mid])
                  start = mid + 1;
                else
                  end = mid - 1;
            }
        }

        return false;
    }
}