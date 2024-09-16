public class disappeared_num {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i =0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            if (nums[index] >0){
                nums[index] = -nums[index];
            }
        }
        for(int i =0;i<nums.length;i++){
            if(nums[i] >0)
                list.add(i+1);
        }
        return list ;

    }


    public static void main (String[] args) {

        int[]nums={4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));

    }
}
