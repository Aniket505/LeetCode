class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1, min = Integer.MAX_VALUE;

        // Binary Search loop to find the pivot/minimum element
        while(low <= high) {
            int mid = (low + high) / 2;
            
            // CASE 1: The LEFT half [low...mid] is sorted.
            if(nums[mid] >= nums[low]) {
                // Since this half is sorted, the smallest element in this window is at nums[low].
                min = Math.min(min, nums[low]);
                
                // Eliminate the left half and search for potentially smaller elements in the right half.
                low = mid + 1;
            } 
            // CASE 2: The RIGHT half [mid...high] is sorted.
            else {
                // Since this half is sorted, the smallest element in this window is at nums[mid].
                min = Math.min(min, nums[mid]);
                
                // Eliminate the right half and search for potentially smaller elements in the left half.
                high = mid - 1;
            }
        }

        // Return the global minimum found during the search
        return min;
    }
}