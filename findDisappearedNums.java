class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> fin = new ArrayList<>();
        if(nums == null || nums.length == 0) return fin;
        
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1; //index of the element at ith position
            if(nums[index] > 0){ //check whether the number is positive
                nums[index] *= -1; 
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                fin.add(i + 1); //adding the missing numbers in fin list 
            }
        }
        return fin;
    }
}
