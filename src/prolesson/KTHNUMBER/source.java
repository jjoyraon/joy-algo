package prolesson.KTHNUMBER;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * KTHNUMBER 
 * http://koitp.org/problem/KTHNUMBER/read/
 */
public class source {

	private static long[] arr;
	private static int K;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/prolesson/KTHNUMBER/input.txt"));
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nk = br.readLine().split(" ");
		int N = Integer.parseInt(nk[0]);
		K = Integer.parseInt(nk[1]);

		arr = new long[N+1];
		for(int i=1; i<=N; i++){
			arr[i] = Long.parseLong(br.readLine());
		}
		
		long kth = sort(1, N);
		
		
		System.out.println(String.format("%d", kth));
		
	}

	private static long sort(int left, int right) {
		if(left==right) return arr[left];
		
		int l = left;
		int r = right;
		long mid = arr[(l+r)/2];
		while(l<r){
			while(arr[l]<mid) l++;
			while(arr[r]>mid) r--;
			long temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
		}
		if(l==r && l==K){
			return mid;
		}
		if(K < l){
			return sort(left, l-1);
		}
		return sort(r+1, right);
		
	}

}