class HelloWorld {
    public static void getMaxMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                max = Math.max(nums[i], max);
                min = Math.min(nums[i + 1], min);
            } else {
                max = Math.max(nums[i + 1], max);
                min = Math.min(nums[i], min);
            }
        }

        System.out.println("Max is " + max);
        System.out.println("Min is " + min);
    }

    public static void main(String[] args) {
        int[] hi = { -1, 4, 2, 9, 4, -3, -6, 14 };
        getMaxMin(hi);
    }
}