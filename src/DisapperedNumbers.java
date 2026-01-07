/*
Problem -Find All Numbers Disappeared in an Array
Approach1 - •We use each number in the array to mark its corresponding index negative.
•If any index remains positive, it means that number was missing from the array.
•So we collect all those index+1 values as the result.
time - O(n)
space - O(1)
Approach2 - •
We first put all numbers from the array into a set for quick lookup.
•Then we go from 1 to n and check which number isn’t in the set.
•If a number is missing, we add it to our result list.
time - O(n)
space - O(n)
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DisapperedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int temp = Math.abs(nums[i]) -1;
            if(nums[temp] > 0){
                nums[temp] *= -1; // change the number to negative only if the number is not negative in first place
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){ // if the modified number in the array is not negative add it to the result
                result.add(i+1);
            }
            else {
                nums[i] *= -1; // to change the state back to original one
            }
        }
        return  result;
    }
    public List<Integer> findDisappearedNumbersUsingSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]); // add all the numbers to a set
        }
        for(int i = 1; i <= nums.length; i++){ // iterate through the range of integers which is length of the array
            if(!set.contains(i)){ //if the number doesn't found in set add it to the result
                result.add(i);
            }
        }
        return  result;
    }
    public static void main(String[] args) {
        DisapperedNumbers d = new DisapperedNumbers();
        List<Integer> res = d.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        System.out.println(res);
        List<Integer> res2 = d.findDisappearedNumbersUsingSet(new int[]{4,3,2,7,8,2,3,1});
        System.out.println(res2);

    }
}
