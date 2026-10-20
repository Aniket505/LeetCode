class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        // --- EDGE CASES & BOUNDARY CONTROLS ---
        
        // 1. If the array has only one element, it is inherently a peak.
        if(n == 1) return 0;
        
        // 2. Check if the first element is a peak (strictly greater than its right neighbour).
        if(nums[0] > nums[1]) return 0;
        
        // 3. Check if the last element is a peak (strictly greater than its left neighbour).
        if(nums[n-1] > nums[n-2]) return n-1;

        // Since boundaries are checked, the peak must lie within the inner array index range [1 to n-2].
        int low = 1, high = n-2;

        // --- BINARY SEARCH (O(log N) Time Complexity) ---
        while(low <= high) {
            int mid = (low + high) / 2;
            
            // Condition A: mid is a peak if it is greater than both its left and right neighbours.
            if((nums[mid] > nums[mid - 1]) && (nums[mid] > nums[mid + 1])) {
                return mid;
            } 
            // Condition B: If mid is increasing to the right, a peak must exist on the right side.
            else if (nums[mid] < nums[mid+1]) {
                low = mid + 1;
            } 
            // Condition C: If mid is decreasing to the right (or part of a downward slope), 
            // a peak must exist on the left side.
            else {
                high = mid - 1;
            }
        }

        // Return -1 as a fallback, though LeetCode guarantees a peak element exists.
        return -1;
    }
}
