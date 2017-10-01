package prolesson;

import static org.junit.Assert.*;

import org.junit.Test;

public class LowerBound {

	/*
	 * lower bound는 찾고자 하는 값 이상이 처음 나타나는 위치
	 */
	@Test
	public void lowerBound() throws Exception {
		int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int lowerBound = lowerBound(arr, 5);
		
		assertEquals(lowerBound, 5);

	}


	private int lowerBound(int[] arr, int k) {
		int s = 0;
		int e = arr.length-1;
		int m = 0;
		while(s<e){
			m = (s+e)/2;
			if(arr[m]<k){
				s = m+1;
			}else{
				e = m;
			}
		}
		return e;
	}


	/*
	 * 찾고자 하는 값보다 큰 값이 처음으로 나타나는 위치
	 */
	@Test
	public void upperBound() throws Exception {
		int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int upperBound = upperBound(arr, 5);

		assertEquals(upperBound, 6);

	}


	private int upperBound(int[] arr, int k) {
		int s = 0;
		int e = arr.length-1;
		int m = 0;
		
		while(s<e){
			m = (s+e)/2;
			if(arr[m]<=k){
				s = m+1;
			}else{
				e = m;
			}
		}
				
		return e;
	}

	


}
