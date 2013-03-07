

class MergeSort{

	private static void merge(int[] numbers, int first, int n1, int n2){
		int[] temp = new int[n1+n2];
		int copied = 0, copied1 = 0, copied2 = 0;
		while((copied1 < n1) && (copied2 < n2)){
			if (numbers[first + copied1] < numbers[first + n1 + copied2])
				temp[copied++] = numbers[first + copied1++];
			else	
				temp[copied++] = numbers[first + n1 + copied2++];
		}
		
		while(copied1 < n1)		
			temp[copied++] = numbers[first + copied1++];
		while(copied2 < n2)		
			temp[copied++] = numbers[first + n1 +copied2++];
		
		for(int i = 0; i < n1+n2; i++)
			numbers[first + i] = temp[i];	
	}
	
	public static void mergeSort(int[] numbers, int first, int last){
		int n1, n2;
		if (last > 1){
			n1 = last/2;
			n2 = last - n1;
			
			mergeSort(numbers, first, n1);
			mergeSort(numbers, first + n1, n2);
			
			merge(numbers, first, n1, n2);
		}
	}
	
	public static void printArray(int[] numbers){
		System.out.print("Numbers: ");
		for(int i = 0 ; i < numbers.length; i++){
			System.out.print(numbers[i] + " ");
		}
		System.out.println("");
	}
	
	public static void main(String[] args){
		int[] nums1 = new int[] {6,3,8,9,1,5,2,4,7};
		System.out.println("  **** Unsorted ****");
		printArray(nums1);
		System.out.println("\n  **** Sorted ****");
		
		mergeSort(nums1, 0, nums1.length);
		printArray(nums1);
		

	}
}