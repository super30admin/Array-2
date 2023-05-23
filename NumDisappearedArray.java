import java.util.List;
import java.util.ArrayList;


public class NumDisappearedArray {


        public List<Integer> findDisappearedNumbers(int[] nums) {

            // iterate over original array
            for( int i = 0; i < nums.length; i++) { // O(n)
                // new index
                int newIdx = Math.abs(nums[i]) - 1;
                // make number at new index negative, if it is positive
                if(nums[newIdx] > 0) {
                    nums[newIdx] *= -1;
                }
            }

            List<Integer> result = new ArrayList<Integer>();

            for(int i = 0; i < nums.length; i++) { // O(n)

                // if positive, add that index+1 as missing
                if(nums[i] > 0) {
                    result.add(i+1);
                }
                else{ // making back to original
                    nums[i] *= -1;
                }

            }
            return result;
        }


        /* Time Complexity = O(n)
        Space Complexity = O(1) as no auxiliary DS used */

        public static void main(String[] args){

            NumDisappearedArray object = new NumDisappearedArray();

            int[] Arr = {4,3,2,7,8,2,3,1};

            List<Integer> result = object.findDisappearedNumbers(Arr);

            System.out.println("Disappeared integers in the array are: " + result);
        }

}

//HASHMAP SOLUTION: T - O(N), S - O(N)

/*
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        HashMap<Integer, Boolean> hashCheck = new HashMap<Integer, Boolean>();

        for(int i = 0; i < nums.length; i++){

             hashCheck.put(nums[i] - 1, true);
        }

        List<Integer> result = new LinkedList<Integer>();

         for(int i = 0; i < nums.length; i++){

             if(!hashCheck.containsKey(i)){

                 result.add(i+1);
             }
        }

        return result;

    }
}

/* Time Complexity = O(n)
Space Complexity = O(n) as hashmap is used */
