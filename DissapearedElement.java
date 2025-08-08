// This approach solves the problem using a concept where we try to swap the existing element until we find the existing supposed element or a duplicate elemet in the supposed index 
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList();
        for(int i=0;i<nums.length;i++) {
            // Correct position - just skip
            if(nums[i]-1==i) {
                continue;
            }
            // move the element to its right position and there is duplicated element
            while(nums[i]-1 != i && nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            }
        }

        // Traverse the array and add if the element is not at its position
        for(int i=0;i<nums.length;i++) {
            if(nums[i]-1!=i) list.add(i+1);
        }
        return list;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
