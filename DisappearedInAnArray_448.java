import java.util.*;
//TC: O(N) - We are iterating the same array and replacing the values. In order to search the value is not negative we are iterating the array one more time. Overall O(2N)
//SP: O(1) - We are not using any extra space for auxilary space. List is what the return needed for the method. So we can ignore that. It will O(1)

public class DisappearedInAnArray_448 {


    //TC: We are adding the all values in a hash set. So it will be O(N) and checking the indices present or not. It need one more O(N) . So it will be O(2N)
    //SC: We have hash set it id not the the return type, So it is O(N)
    List<Integer> findTheMissingElementsBruteForceSolution(int[] array) {
        HashSet cache = new HashSet(); // O(N)
        List<Integer> missingElements = new ArrayList<Integer>();

        for(int i=0;i<array.length;i++) { //O(N)
            cache.add(array[i]);
        }

        for(int i=1;i<array.length;i++) { //O(N)
            if(!cache.contains(i)) {
                missingElements.add(i);
            }
        }
        return missingElements;
    }


    //Since the problem mentioned the values will be 0 to n.
    //We just travers to all the elements and make those modify the values to negative if present.
    List<Integer> findTheMissingElementsOptimalSolution(int[] array) { 
        List<Integer> missingElements = new ArrayList<Integer>();
        for(int i =0;i<array.length;i++) { // O(N)
            int index = Math.abs(array[i]) -1;
            if(array[index] > 0) {
                array[index] *= -1;
            }
        }

        for(int i =0;i<array.length;i++) { // O(N)
            if(array[i] >0) {
                missingElements.add(i+1);
            }
        }

        return missingElements;
    }

    public static void main(String[] args) {
        DisappearedInAnArray_448 disappearedInAnArray_448 = new DisappearedInAnArray_448();
        List<Integer> missingElements = disappearedInAnArray_448.findTheMissingElementsOptimalSolution(new int[]{4,3,2,7,8,2,3,1});
        System.out.println(missingElements);
    }
}
