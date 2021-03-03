// TC - O(n), SC - O(1)

// Constant space and O(n) approach
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Sanity check, if nums is null or length is 0, return empty arraylist
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        // Initialize a result ArrayList
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        // Itearate over nums array, if number at ith index is x, we update xth index to negative value, as we can make sure if there is negative value, we encountered that value in array and if it is positive we can say that index value is missing in array and add it to arraylist
        for(int i=0; i<n; i++){
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0){
                nums[idx] *= -1;
            }
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
        }
        return result;
    }
}


// Using HashMap TC - O(n), SC - O(n)
// class Solution {
//     public List<Integer> findDisappearedNumbers(int[] nums) {
//         if(nums == null || nums.length == 0){
//             return new ArrayList<>();
//         }
//         List<Integer> result = new ArrayList<>();
//         Map<Integer, Boolean> map = new HashMap<>();
        
//         for(int i=0; i<nums.length; i++){
//             map.put(nums[i], true);
//         }
        
//         for(int i=1; i<=nums.length; i++){
//             if(!map.containsKey(i)){
//                 result.add(i);
//             }
//         }
//         return result;
//     }
// }


// BruteForce - Time Limit Exceeded
// class Solution {
//     public List<Integer> findDisappearedNumbers(int[] nums) {
//         if(nums == null || nums.length == 0){
//             return new ArrayList<>();
//         }
//         List<Integer> result = new ArrayList<>();
//         boolean numFound = false;
//         for(int i=0; i<nums.length; i++){
//             numFound = false;
//             for(int j=0; j<nums.length; j++){
//                 if(nums[j] == i+1){
//                     numFound = true;
//                     break;
//                 }
//             }
//             if(numFound == false){
//                 result.add(i+1);
//             }
//         }
//         return result;
//     }
// }