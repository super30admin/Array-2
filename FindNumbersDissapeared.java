import java.util.ArrayList;
import java.util.List;

// TIme complexity: O(n)
//Space Complexity: O(1)

public class FindNumbersDissapeared {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        //Loop through the array
        for(int i = 0; i < nums.length; i++){
            // Get the absolute value from the nums array and use it as an index
            int idx = Math.abs(nums[i]);
            // If the number in idx is positive make it negative to indicate that it has been visited
            if(nums[idx - 1] > 0){
                nums[idx - 1] *= -1;
            }
        }

        //loop throught the array and check if the value is greater than 0, then the index as a number has not been visited or missing hence add it to list
        for(int i=0; i < nums.length; i++){
            if(nums[i] < 0){
                nums[i] *= -1;
            }
            else{
                result.add(i+1);
            }
        }

        return result;

    }
}
