package Arrays;

public class min_max {

	
	public static void main(String[] args) {
		
		int[] a= {13,14,61,9,35,89,51};
		int min= a[0],max=a[0];
		
		for(int i=0; i< a.length; i++){
			if(min> a[i]){
				min = a[i];
				
			}
			if(max<a[i]){
				max= a[i];
			}
			
		}
		System.out.println(max);
		System.out.println(min);
	}
}
