package exercise;

import static org.junit.Assert.*;

import org.junit.Test;


public class QuickSelection {
	
	@Test
	public void quickSelection(){
		int[] arr = { 10, 8, 6, 4, 2, 1, 3, 5, 7, 9, 0};
		int k = 3;
		int kth = quickSelection(arr, 0, arr.length-1, k);
		assertEquals(kth, 2);
	}

	private int quickSelection(int[] arr, int left, int right, int k) {
		int l = left;
		int r = right;
		int pivot = arr[(l+r)/2];
		while(l<r){
			while(pivot > arr[l]) l++;
			while(pivot < arr[r]) r--;
			int t = arr[l];
			arr[l] = arr[r];
			arr[r] = t;
		}
		if(l==r && l==k-1){
			return pivot;
		}
		if(k-1 < l){
			return quickSelection(arr, left, l-1, k);
		}
		return quickSelection(arr, r+1, right, k);
		
	}
}
