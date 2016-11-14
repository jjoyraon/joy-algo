package prolesson.mostnum;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * 가장 많은 수  
 * http://koitp.org/problem/SDS_PRO_2_4/read/
 */
public class source {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/prolesson/mostnum/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
		sort(arr, 0, N-1);
		
		int prev = arr[0];
		int maxCount = 1;
		int currentCount = 1;
		int mostnum = prev;
		for(int i=1; i<N; i++){
			if(arr[i]==prev){
				currentCount++;
			}else{
				prev = arr[i];
				currentCount = 1;
			}
			if(currentCount>maxCount){
				maxCount = currentCount;
				mostnum = prev;
			}
		}
		System.out.println(mostnum);
		
	}

	private static void sort(int[] arr, int left, int right) {
		int l = left;
		int r = right;
		int pivot = arr[l + (r-l)/2];
		while(l<r){
			while(arr[l]<pivot) l++;
			while(arr[r]>pivot) r--;
			if(l<=r){
				int t = arr[l];
				arr[l] = arr[r];
				arr[r] = t;
				l++;
				r--;
			}
		}
		if(left<r) sort(arr, left, r);
		if(right>l) sort(arr, l, right);
	}

}