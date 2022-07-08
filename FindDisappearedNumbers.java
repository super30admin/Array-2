// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> resultList = new ArrayList<>();


        //range 1-n, indices 0 to n-1, so subtract 1 from the element to form the index
        // mark the element in that index negative to indicate that the index number(element) is present in the array
        for(int i=0; i<nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                nums[index] = -nums[index];
            }
        }

        // if an index has postive element, it means it is not present. So add (index+1) to the result list since the range is 1-n
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                resultList.add(i+1);
            } //mark the negative elements positive to retrieve the original array
            else {
                nums[i] = -nums[i];
            }
        }
        return resultList;
    }
}
