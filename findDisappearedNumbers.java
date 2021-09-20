
//   1
//Time complexity: O(n)
//Space complexity: O(1)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        //abosulte value of index - 1, and convert the value to negative value
        for(int i = 0; i < nums.length; i++) {
            int new_index = Math.abs(nums[i]) - 1;
            if(nums[new_index] > 0) {
                nums[new_index] *= -1;
            }
        }

        for(int i = 1; i <= nums.length; i++) {
            if(nums[i-1] > 0) {
                result.add(i);
            }
            //optional , to get the original array back
            else {
                nums[i-1] *= -1; 
            }
        }
        return result;
    }
    
    // public static void main(String[] args) {
//         System.out.println(new FindDisappearedNumbers().findDisappearedNumbers(new int[]{1,3,5,4,5,4,1}));
//     }
}

//   2


//Time complexity: O(n)
//Space complexity: O(n)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        //add elements to the set
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        //iterate through 1 to length of array and will return the elements that
        //are not present in the set (that will be our missing elements)
        for(int i = 1; i <= nums.length; i++) {
            if(!set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }
}