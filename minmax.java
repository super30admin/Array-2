//Time complexity : O(n)
//Space Complxity : O(1)

class CalculateMinMAX {

    public void process(int [] array) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){
            if(min>array[i]){
                min=array[i];
            }
            if(max<array[i]){
                max=array[i];
            }
        }
System.out.println("Here are min and max respectively min= "+min + " max = "+max);

    }



    public static void main(String args[]) {
        int[] myArray = {23, 92, 56, 39, 93,-1};
        CalculateMinMAX m = new CalculateMinMAX();
        m.process(myArray);

    }
}