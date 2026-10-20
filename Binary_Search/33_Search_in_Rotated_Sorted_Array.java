class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        // Modified Binary Search (O(log N) Time Complexity)
        while(low <= high) {
            int mid = (low + high) / 2;

            // 1. Found the target: return its index immediately.
            if(nums[mid] == target) {
                return mid;
            }

            // 2. CASE 1: The LEFT half [low...mid] is sorted.
            if(nums[mid] >= nums[low]) {
                // Check if the target lies within the boundaries of this sorted left half.
                if((target <= nums[mid]) && (target >= nums[low])) {
                    high = mid - 1; // Narrow search window to the left half.
                } else {
                    low = mid + 1;  // Target is not in the left half; look in the right half.
                }
            } 
            // 3. CASE 2: The RIGHT half [mid...high] must be sorted.
            else {
                // Check if the target lies within the boundaries of this sorted right half.
                if((target >= nums[mid]) && (target <= nums[high])) {
                    low = mid + 1;  // Narrow search window to the right half.
                } else {
                    high = mid - 1; // Target is not in the right half; look in the left half.
                }
            }
        }

        // Return -1 if the target element does not exist in the array.
        return -1;
    }
}