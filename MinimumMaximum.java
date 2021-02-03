package S30.Arrays2;

/* Time complexity: Number of comparisons are 1.5*n + 2; while TC remains same it is O(n)
*  Space complexity: No extra space is used O(1)
*
*  Approach: Here we are making pairs and finding which element is minimum or maximum element in between
*            both of them. Maximum element will be compared with max variable that stores max
*            value till then while minimum element will be compared with min variable. For each pair
*            we do 1 less comparison. In total we will be doing 1.5*n + 2 comparisons.
*
* */

public class MinimumMaximum {
    public static void main(String args[]){
        int[] a = {1000, 11, 445, 1, 330, 3000};
        findMinimumMaximumNumbers(a);
    }

    public static void findMinimumMaximumNumbers(int[] nums){
        int minimum = nums[0];
        int maximum = nums[0];
        for(int i=0; i<nums.length; i= i+2){
            if(i != nums.length-1) {
                int first = nums[i];
                int second = nums[i+1];
                if(first > second){
                    if(first > maximum )
                        maximum = first;
                    if(second < minimum)
                        minimum = second;
                }else if(second > first){
                    if(second > maximum)
                        maximum = second;
                    if(first < minimum)
                        minimum = first;
                }
            }else{
                if(nums[i] > maximum)
                    maximum = nums[i];
                else if(nums[i] < minimum)
                    minimum = nums[i];
            }
        }
        System.out.print("Minimum is: "+minimum +"\nMaximum is: "+ maximum);
    }
}
