import java.util.ArrayList;
import java.util.List;
//TC On
//SC O1

class Solution {

    public static List<Integer> findDisappearedNumbers(int[] a) {
        List<Integer> l=new ArrayList<Integer>();

        for(int i=0;i<a.length;i++)
        {
            int index=Math.abs(a[i])-1;
            if(a[index]>0){
                a[index]=-a[index];}
        }


        for(int i=0;i<a.length;i++){
            if(a[i]>0){
                l.add(i+1);
            }
        }
        System.out.println(l);
        return l;
    }
}