// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Change of state
//We will not be using an aditionl array instead we will be using the same array and change the states of the elements
// we know that the range is 1 to n so if array is imagined sorted, then at any index element
//would be index+1 at 0 it would be 1.
//so we start from begning we get the value at i and go to i-1th index and change the value
//there to be negativ. that means index + 1 is now marked. each time before making negative we
//access the value as Math.abs because some elements might be repeatitive and multiplying by
//-1 again will turn them into positive numbers. so once we set all the present numbers i-1
//indices as negative. we travaerse through the array to find positive elements, and if we
//found positive element at index i that means i+1 is missing, we add it to arrayList.


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i =0; i<nums.length; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0){
            nums[index] = nums[index]* -1;
            }
            }
           
            for(int j =0; j<nums.length; j++){
                if(nums[j]>0){
                    result.add(j+1);
                }
            }
        
        return result;
    }
}