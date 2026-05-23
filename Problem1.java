class Problem1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;

        for(int i=0; i<n; i++){
            set.add(nums[i]);
        }

        for(int i=1; i<=n; i++){
            if(!set.contains(i)){
                result.add(i);
            }
        }

        return result;
    }
}
