class Solution {
    //Time Complexity : O(N)
    //Space Complexity : O(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {

        ArrayList<Integer> result = new ArrayList<>();
        int n = nums.length;

        for(int i=0;i<n;i++){
            int abs = Math.abs(nums[i]);
            if(nums[abs-1]>0) nums[abs-1] *=(-1);
        }

        for(int i=0;i<n;i++){
            if(nums[i]>0){
                result.add(i+1);
            }else{
                nums[i]*=(-1);
            }
        }
        return result;
        
    }

    //Time Complexity : O(N)
    //Space Complexity : O(N)
    // public List<Integer> findDisappearedNumbers(int[] nums) {

    //     int n = nums.length;
    //     int[] num_unique = new int[n];

    //     for (int i = 0; i < n; i++) {
    //         num_unique[nums[i] - 1] = nums[i];
    //     }

    //     ArrayList<Integer> result = new ArrayList<Integer>();

    //     for (int i = 0; i < n; i++) {
    //         if (num_unique[i] == 0) {
    //             result.add(i + 1);
    //         }
    //     }

    //     return result;
    // }
}