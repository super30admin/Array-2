// Time Complexity :O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//Our approach is to take the number at any index and go to it;s supposed to be index if the array was sorted and put a - there indicatin
// this index position(if sorted) is present in the array.
// Then at last traversing thru the array, if we come across any positive element, that means element at that index is not present in the array
public List<Integer> findDisappearedNumbers(int[] nums) {
    if(nums == null || nums.length==0) return new ArrayList<>();
    
    List<Integer> list = new ArrayList<>();
    
    for(int i=0;i<nums.length;i++){ //O(N)
        int index = Math.abs(nums[i])-1;
        if(nums[index] >= 0){
            nums[index] = -nums[index];
        }
    }
    
    for(int i=0;i<nums.length;i++){
        if(nums[i] > 0){
            list.add(i+1);
        }
    }
    return list;
}