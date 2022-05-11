//Time Complexity: O(n)
//Space Complexity: O(1)
public class MinMax {

    static class Pair {
        int min;
        int max;
    }

    public static Pair getMinMax(int[] nums) {
        if (nums == null) {
            return null;
        }
        Pair p = new Pair();

        if (nums.length == 1) {
            p.min = nums[0];
            p.max = nums[0];
        }

        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                p.min = nums[1];
                p.max = nums[0];
            } else {
                p.min = nums[0];
                p.max = nums[1];
            }
        }

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > p.max) {
                p.max = nums[i];
            } else if (nums[i] < p.min) {
                p.min = nums[i];
            }
        }

        return p;
    }

    public static void main() {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        Pair p = getMinMax(nums);
        System.out.println("min : "+p.min+" max : "+p.max);
    }
}
