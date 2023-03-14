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
