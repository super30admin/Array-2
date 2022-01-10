class Solution {
    public static void main(String[] Args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10}; //this is the integer array
        int length = nums.length; // we take the length of it
        int maximum = nums[0]; // we set the max to the 1st element in the array
        int minimum = nums[0]; // we set the min to the 1st element in the array
        for(int i=1;i<length-1;i++){ // we iterate through all the elements in the array
            if(nums[i]>nums[i+1]){ // if the current element is greater than the next element
                maximum = Math.max(maximum, nums[i]); // we change the max
                minimum = Math.min(minimum, nums[i+1]); // we change the min
            }
            else{ // if the current element is less than or equal to the next element
                maximum = Math.max(maximum, nums[i+1]); // we change the max
                minimum = Math.min(minimum, nums[i]); // we change the min
            }
        }
        System.out.print("Max & Min are : " + maximum + " " + minimum); // in the end, we give print the result
    }
}

//tc and sc - O(n) and O(1)