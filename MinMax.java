public static void minmax0(int[] a) {
	if (a == null || a.length < 1)
		return;
 
	int min = a[0];
	int max = a[0];
 
	for (int i = 1; i <= a.length - 1; i++) {
		if (max < a[i]) {
			max = a[i];
		}
 
		if (min > a[i]) {
			min = a[i];
		}
	}
 
	System.out.println("min: " + min + "\nmax: " + max);
}
