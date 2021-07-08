//time complexity : O(n) 
//space complexity : O(n/2) worst case if the array size contained with duplicates
//leet code execution : successfull
//steps: iterate the array and mark all the elements that exist whose index exists in array with -1.
// tihs way the elements which are abest will alone be positive values. now re-iterate and add those (index+1) to list and return list containing missing elements.

import java.util.ArrayList;
import java.util.List;

class FindAllNumsDisaapearedInArray448{


    public List<Integer> findDisappearedNumbers(int[] nums){

        List<Integer> result = new ArrayList<>();

        for(int i=0; i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index] = -1*nums[index];
            }
        }
        for(int i : nums){
            System.out.println(i);
        }
        for(int i=0; i<nums.length;i++){  
            if(nums[i] > 0){
                result.add(i+1);
            }
        }
        return result;

    }



    public static void main(String[] args) {
        FindAllNumsDisaapearedInArray448 fa = new FindAllNumsDisaapearedInArray448();
        int arr[] = {4,3,2,7,8,2,3,1};
        fa.findDisappearedNumbers(arr);
    }
}