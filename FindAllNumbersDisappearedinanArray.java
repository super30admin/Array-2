// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach


import java.util.ArrayList;
import java.util.List;

class FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    int n = nums.length;
    List<Integer> result = new ArrayList<>();

    for(int i = 0; i < nums.length; i++){
         int num = nums[i];
        int idx = Math.abs(num) - 1;
        if(nums[idx] >0){
        nums[idx] = nums[idx] * -1;
        }

    }

    for(int i = 0; i< nums.length; i++){
        if(nums[i] < 0){
            nums[i] = nums[i] *-1;

        }else{
            result.add(i+1);
        }
    }
    return result;

    }

    public static void main (String[] args)

    {
    
        FindAllNumbersDisappearedinanArray p = new FindAllNumbersDisappearedinanArray();
    
     int[] arr = new int[]{4,3,2,7,8,2,3,1};
     List<Integer> result = new ArrayList<>();

    
    
    
     result = p.findDisappearedNumbers(arr);
       System.out.println(result);
    
    }
}

//brute force TC-O(n^2)
//take one no check over all the array
//take no 2 check over all the array
//sc- o(1)

//sort and iterate TC- nlogn + on. sc - o(1)
//sort and binary search tc o(nlogn) + o(nlogn) sc- o(1)
//hashset/ boolean array - O(n) +o(n)  sc- O(n) 

//optimal approach where we can keep a boolean array and mark the presence of elements in nums 
// then we can just keep presence of elements in the same array like [4,3,2,7,8,2,3,1] 4 is 
//present then mark its presence in correpending index that is 3 so put nums[3] that is 7 as -7

//tc - O(2n) SC - O(1)

// if there are negative elements in the original array then we can add a offset then substrcat it from result