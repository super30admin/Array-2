//Time compexity: O(n)
//Space complexity: O(1)
//Program ran successfully
/*
    Algorithm: 1. Problem is solved using the concept of state change
               2. Input array consists of numbers from 1 to n and has some repeated numbers, we solve the problem my modifying the input array
               3. We map the numbers that are present in the given array by setting the index corresponding to the value to negative. 
               4. A negative value in the array indicates that the element is present
               5. All positive values are returned
*/
class disappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) nums[index] *= -1;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                list.add(i+1);
            }
        }
        return list;
    }
}
