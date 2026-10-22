class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        
        // --- 1. BASE CASES & BOUNDARY CHECKS ---
        
        // If the array has only one element, it is the single element
        if (n == 1) {
            return nums[0];
        }
        // Check if the very first element is unique
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        // Check if the very last element is unique
        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }

        // --- 2. BINARY SEARCH SETUP ---
        // Shrink the search space to exclude the boundary elements we already checked
        int low = 1, high = n - 2;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            // Check if 'mid' is the single element (different from both its neighbors)
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            
            // --- 3. THE EVEN-ODD INDEX PATTERN ---
            // Before the single element, pairs always start at an EVEN index and end at an ODD index:
            //   - If mid is ODD, its partner must be at mid - 1 (EVEN).
            //   - If mid is EVEN, its partner must be at mid + 1 (ODD).
            // If this pattern holds true, we are still on the LEFT side of the single element.
            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                // Move to the right half
                low = mid + 1;
            } else {
                // The pattern broke, meaning we are on the RIGHT side of the single element
                // Move to the left half
                high = mid - 1;
            }
        }
        
        return -1;
    }
}