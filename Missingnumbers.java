class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++){
            if (nums[i] != (i+1)){
                int prev = nums[i];
                while (prev != nums[prev-1]){
                    int t = nums[prev-1];
                    nums[prev-1] = prev;
                    prev = t;
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if (nums[i] != (i+1)){
                ans.add(i+1);
            }
        }
        return ans;
    }

}

//TC: O(n)
//SC no extra space
