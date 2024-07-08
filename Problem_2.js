// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : No
//Compare 

// Your code here along with comments explaining your approach
var maxMinCom = function(nums){
    let minVal = nums[0];
    let maxVal = nums[0];
        //Iterate over the array by skipping two elements
        for(let i=0;i<nums.length-1;i=i+2){
            //check if ith ele is less than the next element, assign the min and max accordingly
            if(nums[i]<nums[i+1]){
                minVal=Math.min(minVal, nums[i]);
                maxVal=Math.max(maxVal, nums[i+1]);
            }else{
                minVal=Math.min(minVal, nums[i+1]);
                maxVal=Math.max(maxVal, nums[i]);
            }
        }
    return [minVal, maxVal];
}