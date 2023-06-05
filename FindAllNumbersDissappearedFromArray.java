import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindAllNumbersDissappearedFromArray {
    //Time complexity: n(iterated the length of the array
    //Space complexity: number of unique elements in an array
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> missingNumbers = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }


        for(int num = 1; num <= nums.length; num++) {

            if(!set.contains(num)) {
                missingNumbers.add(num);
            }

        }
        return missingNumbers;

    }
}
