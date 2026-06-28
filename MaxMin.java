import java.util.*;

public class MaxMin {

    // nums = [-3,-5,5,2,3,7];

    public List<Integer> maxMin(int[] nums) {
        ArrayList<Integer> sortedArr = new ArrayList<>();
        for (int num : arr) {
            sortedArr.add(num);
        }
        
        // Sort ArrayList
        Collections.sort(sortedArr);
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(sortedArr.get(0));               
        result.add(sortedArr.get(sortedArr.size() - 1)); 
        
        return result;
    }
}
