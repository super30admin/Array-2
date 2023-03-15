// Time Complexity: O(n)
// Space Complexity: O(n)


class DisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums){
            hs.add(num);
        }
        for(int i = 1; i <= nums.length; i++){
            if(!hs.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}





//Second solution using O(n) time but O(1) space
class DisappearedNumbers {
public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[Math.abs(nums[i])-1]>0)
            nums[Math.abs(nums[i])-1] = -1 * nums[Math.abs(nums[i])-1];
        }
        for(int i = 0; i <= n-1; i++){
            if(nums[i]<0){
                nums[i] = Math.abs(nums[i]);
            }
            else{
                list.add(i+1);
            }
        }
        return list;
    }
}
