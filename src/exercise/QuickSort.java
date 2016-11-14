package exercise;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuickSort {
	
	@Test
	public void quickSort() {
		int[] arr = { 10, 5, 4, 3, -2, 1, 9, 8, 7, 6, 100, 1, -2 };
		int last = arr.length-1;
		sort(arr, 0, last);
		
		for(int i=0; i<=last; i++){
			System.out.print(arr[i] + " ");
		}
		assertEquals(arr[0], -2);
		assertEquals(arr[last], 100);
	}

	public static void sort(int[] arr, int start, int end) {
		int l = start;
		int r = end;
		int mid = arr[(l+r)/2];
		while(l<r){
			while(arr[l]<mid) l++;
			while(arr[r]>mid) r--;
			if(l<=r){
				int t = arr[l];
				arr[l] = arr[r];
				arr[r] = t;
				l++;
				r--;
			}
		}
		
		if(start < r) sort(arr, start, r);
		if(end > l) sort(arr, l, end);

	}

}
