package Arrays;

public class min_max_opt {

	public static void main(String[] args) {
			
			int[] a= {17,14,61,9,35,89,567,-98,51,78,94,18,34,1};
			int min= a[0],max=a[0];
			
			for(int i=0; i< a.length; i+=2){
				System.out.println(i);
				if(i==a.length-1){
					if(a[i]>max){
						max= a[i];
					}
					if(a[i]<min){
						min= a[i];
					}
				}
				
				else if(a[i]< a[i+1]){
					if(min>a[i]){
						min = a[i];
					}
					if(max<a[i+1]){
						max=a[i+1];
					}
					
				}
				else if(a[i]> a[i+1]) {
					if(min>a[i+1]){
						min = a[i+1];
					}
					if(max<a[i]){
						max=a[i];
					}
					
				}
				System.out.println(max);
				System.out.println(min);
			}
			System.out.println(max);
			System.out.println(min);
		}
	}

