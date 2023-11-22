import java.util.ArrayList;
import java.util.List;

public class FindMinMax {
    
    private  static List<Integer> findMinMax(int[] array){
        List<Integer> results = new ArrayList<>();
        int min = array[0], max = array[0];
        for(int i=0;i<array.length-1;i+=2){
            if(array[i]<array[i+1]){
                min = Math.min(min, array[i]);
                max = Math.max(max, array[i+1]);
            }
            else{
                min = Math.min(min, array[i+1]);
                max = Math.max(max, array[i]);
            }
        }
        results.add(min);
        results.add(max);
        return results;
    }
    public static void main(String[] args) {
        int[] array = new int[]{4,8,-1,1,2,3,6,7};
        List<Integer> minMax = findMinMax(array);
        System.out.println(minMax);

    }
}
