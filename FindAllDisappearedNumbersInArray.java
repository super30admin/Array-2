
/**

 Approach: Converting postive values to negatinve based on value-1 based indexing

 Working:
     loop 0..n-1
         get the current index value (i.e absolute value) and for an index = value-1
         if the index is value is positive, make it negative by multiplying -1

     loop 0..n-1
         if the current value is positive the the index i+1 is the missing number
         add the value in a list
         else
         set original value in the input array
     return list

 Time Complexity:O(n)
 Space Complexity:O(1)
 */

class FindAllDisappearedNumbersInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        if(nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<nums.length; i++) {
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index] = nums[index]*-1;
            }
        }

        for(int i=0;i<nums.length; i++) {
            if(nums[i]>0) {
                list.add(i+1);
            }
            else{
                nums[i] = nums[i]*-1;
            }
        }
        return list;
    }
}
