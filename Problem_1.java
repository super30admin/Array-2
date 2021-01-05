// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

//Finding the missing numbers.

//Below is the brute force solution.
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list=new ArrayList<Integer>();
        int[] arr=new int[nums.length+1];

        for(int i=0;i<nums.length;i++){
            arr[nums[i]]=arr[nums[i]]+1;
        }
        //System.out.println(Arrays.toString(arr));
        for(int i=1;i<arr.length;i++){
            if(arr[i]==0){
                list.add(i);
            }
        }
        return list;
    }
}

// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

//Finding the missing numbers.

//Below is the more efficient solution.
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            
            nums[Math.abs(nums[i])-1]=-(Math.abs(nums[Math.abs(nums[i])-1]));
        }
        //System.out.println(Arrays.toString(nums));
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                list.add(i+1);
            }
        }
        return list;
    }
}