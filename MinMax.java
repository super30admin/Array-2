public static void minmax(int[] a) {
 
	if (a == null || a.length < 1)
		return;
 
	int min, max;
 	if (a.length == 1) {
		max = a[0];
		min = a[0];
		System.out.println("min: " + min + "\nmax: " + max);
		return;
	}
 
	if (a[0] > a[1]) {
		max = a[0];
		min = a[1];
	} else {
		max = a[1];
		min = a[0];
	}
 
	for (int i = 2; i <= a.length - 1; i++) {
		if (max < a[i]) {
			max = a[i];
		} else if (min > a[i]) {
			min = a[i];
		}
	}
 
	System.out.println("min: " + min + "\nmax: " + max);
}
// 2n-1 comparison
