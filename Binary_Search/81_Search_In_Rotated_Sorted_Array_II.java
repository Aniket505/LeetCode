class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // 1. Found the target: return true immediately.
            if(nums[mid] == target) return true;

            // 2. THE DUPLICATE EDGE CASE:
            // When nums[low] == nums[mid] == nums[high], we cannot determine which half is sorted.
            // Example: nums =[3,3,3,1,3,3,3,3,3], target = 1
            // low = 0 (val:3), mid = 4 (val:1 -> wait, if target=2, mid is 4, etc. Let's look at index values)
            // If mid points to a 3: low=0(3), mid=4(1), high=9(3) -> mid is not 3 here.
            // But if nums =, low=0(3), mid=3(3), high=6(3). Both halves look sorted!
            // Solution: Shrink the search space from both ends until the ambiguity is broken.
            if((nums[low] == nums[mid]) && (nums[mid] == nums[high])) {
                low++;
                high--;
                continue; // Skip the rest of the loop and re-calculate mid with the new boundaries.
            }
            
            // 3. CASE 1: The LEFT half [low...mid] is sorted.
            if(nums[mid] >= nums[low]) {
                // Check if the target lies within the boundaries of this sorted left half.
                if((target <= nums[mid]) && (target >= nums[low])) {
                    high = mid - 1; // Narrow search window to the left half.
                } else {
                    low = mid + 1;  // Target is not in the left half; look in the right half.
                }
            } 
            // 4. CASE 2: The RIGHT half [mid...high] must be sorted.
            else {
                // Check if the target lies within the boundaries of this sorted right half.
                if((target >= nums[mid]) && (target <= nums[high])) {
                    low = mid + 1;  // Narrow search window to the right half.
                } else {
                    high = mid - 1; // Target is not in the right half; look in the left half.
                }
            }
        }

        // Target not found in the array.
        return false;
    }
}
