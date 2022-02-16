// space complexity - o(1)
    //time - o(n)
    //Ran on leeetcode successfully : Yes
    // Problem faced  : No
    //Approach : -ve marker approach, use value of array element as index and mark element at that index as negative
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> l = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            int index  = Math.abs(nums[i]);
            if(nums[index-1] > 0){
                nums[index-1] *= -1;
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0)
                l.add(i+1);
        }
        return l;
    }
}
