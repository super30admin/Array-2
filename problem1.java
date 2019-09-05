//Passed all the test cases on Leet code
//Time Complexity : O(n)
//Solved using a Hash Set
//WW have fisrt added all the elemenst to the Hash Set and added the elements not present in the set to the List .

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet();
        List<Integer> list = new ArrayList();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int i = 1; i <= nums.length; i++)
        {
            if(!set.contains(i))
                list.add(i);
        }
        return list;
    }
}
