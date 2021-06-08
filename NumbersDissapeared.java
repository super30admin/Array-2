class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        //o(n) space and o(n) time
        int[] array = new int[nums.length + 1];
        List<Integer> list = new ArrayList<Integer>();

        array[0] = 1;

        for (int i=0; i<nums.length; i++) {

            array[nums[i]] = 1;

        }

        for (int i=1; i<array.length; i++) {

            if (array[i] == 0) {
                list.add(i);
            }

        }

        return list;

    }
}