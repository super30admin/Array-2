// Time Complexity : O(log n), for diving the problem in 2 equal halves
// Space Complexity : O(log n), for the stack space
// I'm not sure about how to calculate total comparisions in this method

// Your code here along with comments explaining your approach
// Compute min and max for halves, compare and compute overall min and max
// Recur getMinMax(leftHalf), getMinMax(rightHalf) until array length == 2, compute local min max and return
// compare min, max across left, right halves to compute overall min max and return 

public class MinMaxOfArray {
    static int[] nums;
    static int compCount = 0;

    static class Pair {
        int min;
        int max;
    }

    private static Pair getMinMax(int l, int h){
        Pair minmax = new Pair();
        if(l==h){
            minmax.min = nums[l];
            minmax.max = nums[l];
            return minmax;
        }

        //main base case
        if(h==l+1){
            if(nums[l]<nums[h]){
                minmax.min = nums[l];
                minmax.max = nums[h];
                compCount += 1;
            }
            else{
                minmax.min = nums[h];
                minmax.max = nums[l];
                compCount += 1;
            }
            return minmax;
        }

        //divide problem into 2, calculate left half min and max, calculate right half min and max
        if(h-l>1){
            int mid = (l+h)/2;
            Pair left_half_minmax_pair = getMinMax(l, mid);
            Pair right_half_minmax_pair = getMinMax(mid+1, h);
            
            if(left_half_minmax_pair.min<right_half_minmax_pair.min){
                minmax.min = left_half_minmax_pair.min;
                compCount += 1;
            }
            else{
                minmax.min = right_half_minmax_pair.min;
            }
            if(left_half_minmax_pair.max>right_half_minmax_pair.max){
                minmax.max = left_half_minmax_pair.max;
                compCount += 1;
            }
            else{
                minmax.max = right_half_minmax_pair.max;
            }
            return minmax;
        }

        return minmax;
    }

    public static void main(String args[]){
        nums = new int[] {4,3,2,7,8,2,3,1};
        Pair result = getMinMax(0, nums.length-1);
        System.out.println("Min "+result.min+" Max "+result.max+" compCount "+ compCount+" 2*(n-2) "+2*(nums.length-2));
    }
    
}

// Time Complexity : O(n), iterates over array
// Space Complexity : O(1), just need min and max

// Your code here along with comments explaining your approach
//This is just the default bruteforce comparision, 2*(n-2) + 1 comaprisions in total in worst case
//when min element is at the end of the array, sorted in descending order
//in best case, 1 + (n-2) comparisions, max at the end of the array, sorted in ascending order

public class MinMaxOfArray {
    private static int[] findMinMax(int[] nums){
        if(nums==null || nums.length==0){
            return new int[] {-1,-1};
        }

        else if(nums.length==1){
            return new int[] {nums[0], nums[0]};
        }

        int min;
        int max;
        int compCount=0;

        if(nums[0]>nums[1]){
            min = nums[1];
            max = nums[0];
        }
        else{
            max = nums[1];
            min = nums[0];
        }
        compCount += 1;

        for(int i=2; i<nums.length;i++){
            if(nums[i]>max){
                max = nums[i];
                compCount += 1;
            }
            else if(nums[i]<min){
                min = nums[i];
                compCount += 1;
            }
        }
        return new int[] {min, max, compCount};
    }

    public static void main(String args[]){
        int[] arr = {4,3,2,7,8,2,3,1};
        int[] result = findMinMax(arr);
        System.out.println("Min "+result[0]+" Max "+result[1]+" compCount "+ result[2]+" 2*(n-2) "+2*(arr.length-2));
    }
    
}
