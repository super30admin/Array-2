//approach-here the problem statement state's we have an array of length n+1 which consists of 1-n numbers with missing numbers. my approach is to mark all the items present by iterating through the array in and at each item we go the the index it is supposed to be(4 is supposed to be at 3rd index in a sorted array) and mark that index by making that number negative. I used absolute value at each index so that even if i marked them negative i can use that. once done the positive numbers left at each index represents the number mssing(eg. at 3rd index we have positive that means we didnt found 4 in the array.) we again iterate through the array and get all the missing numbers
//time complexity-O(2(n)=O(n)since we are iterating the array twice

//space complexity-O(1)since we only have variables and which is again a  constant
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n=nums.length;
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            int index=Math.abs(nums[i])-1;
         nums[index]=Math.abs(nums[index])*-1;
        }
        for(int i=0;i<n;i++){
           if(nums[i]>0)result.add(i+1);
        }
        return result;
    }
}
