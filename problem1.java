//Time Complexity = O(n)
//Space Complexity = O(1)

public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> arr = new ArrayList<>();
    if(nums==null || nums.length==0) return arr;
    int len = nums.length;
    for(int num:nums){
        int index = len-Math.abs(num);
        if(nums[index]>0)
            nums[index] = -nums[index];
        
    }
    for(int i=0;i<len;i++){
        if(nums[i]>0){
            arr.add(len-i);
        }
    }
    return arr;
}
}