import java.util.ArrayList;
import java.util.List;

//Here we used the technique of temporary state change
//When traversing the array for the very first time we first change numbers to negative complements
// then we check for corresponing indices and see if the current index element is negative or not
// if yes, negative we change the element to positive and move to next index
// if positive, then corresponding element is missing

//Time Complexity: O(n)
//Space Complexity: O(1)

public class DisappearedNums {

    public static void main(String[] args)
    {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> result = DisappearedNums(nums);

        for(int i : result)
        {
            System.out.println("Missing Number " + i );
        }
    }

    public static List<Integer> DisappearedNums(int[] nums)
    {
        List<Integer> result = new ArrayList<>();

        int n = nums.length;

        //making all the numbers negative first
        for(int i=0; i<n; i++)
        {
            int idx = Math.abs(nums[i])-1;

            if(nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }

        // then we check for corresponing indices and see if the current index element is negative or not
        // if yes, negative we change the element to positive and move to next index
        // if positive, then corresponding element is missing
        for(int i=0; i<n ; i++)
        {
            if(nums[i]>0)
            {
                result.add(i+1);
            }
            else
            {
                nums[i] *= -1;
            }
        }
    return result;
    }
    
}
