//TC O(m)
//SC O(1)
//works in leetcode
//use input arry for dual purpose. number itself and +,- to indicate if that index is present or not
class ArrayDisappearedNumbers {


    public static  List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int val =0;
        for(int i=0; i< nums.length;i++){
            val = Math.abs(nums[i]);
            nums[val-1] = -1 * Math.abs(nums[val-1]);
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0)
                result.add(i+1);
        }


        return result;
    }


    public static void main(String [] args){
        int [] nums ={4,3,2,7,8,2,3,1};

        System.out.println(findDisappearedNumbers(nums));

    }
}