class Solution {
    public boolean check(int[] nums) {
        int pivotCount = 0;

        // Loop through the array to count the number of drops (pivots)
        for(int i = 0; i < nums.length; i++) {
            // Using the modulo operator (i+1) % nums.length connects the last element 
            // back to the first element, treating the array as a circular loop.
            if(nums[i] > nums[(i+1) % nums.length]) {
                pivotCount++;
            }
        }

        // A valid sorted and rotated array can have at most 1 drop.
        // If it has 0 drops, the array is purely sorted (e.g., [1, 2, 3]).
        // If it has 1 drop, it is a single rotated sorted sequence (e.g., [3, 4, 1, 2]).
        // If it has more than 1 drop, it cannot be formed by rotating a sorted array.
        if(pivotCount > 1) return false;
        
        return true;
    }
}