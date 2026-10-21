class Solution {

    // Helper function to perform binary search. 
    // If 'firstOccurrence' is true, it finds the first index; otherwise, it finds the last index.
    public int findIndex(int[] nums, int target, boolean firstOccurrence) {
        int low = 0, high = nums.length - 1;
        int pos = -1; // Stores the most recent valid index found

        while(low <= high) {
            int mid = (low + high) / 2;
            
            // 1. Target found! Record the position and continue searching.
            if(nums[mid] == target) {
                pos = mid; 
                
                if(firstOccurrence) {
                    // To find the FIRST occurrence, discard the right side and look left
                    high = mid - 1;
                } else {
                    // To find the LAST occurrence, discard the left side and look right
                    low = mid + 1;
                }
            } 
            // 2. Standard binary search: Target is smaller, discard right half
            else if(target < nums[mid]) {
                high = mid - 1;
            } 
            // 3. Standard binary search: Target is larger, discard left half
            else {
                low = mid + 1;
            }
        }
        return pos;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        
        // Find the leftmost boundary (first occurrence)
        res[0] = findIndex(nums, target, true);
        
        // Find the rightmost boundary (last occurrence)
        res[1] = findIndex(nums, target, false);

        return res;
    }
}
