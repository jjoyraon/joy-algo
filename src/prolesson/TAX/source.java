package prolesson.TAX;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * 세금  
 * http://koitp.org/problem/TAX/read/
 */
public class source {


	private static final long MIN = -1000000000l * 50l;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/prolesson/TAX/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nk = br.readLine().split(" ");
		int N = Integer.parseInt(nk[0]);
		int K = Integer.parseInt(nk[1]);
		long[] arr = new long[N+1];
		String[] split = br.readLine().split(" ");
		for(int i=1; i<=N; i++){
			arr[i] = Long.parseLong(split[i-1]);
		}
		long[] A = new long[K+2];
		long[] B = new long[K+2];
		long[] C = new long[K+2];
		for(int i = 1; i<=K; i++){
			A[i] = MIN; 
			B[i] = MIN;
		}
		
		for(int i=1; i<=N; i++){
			long n = arr[i];
			for(int j=1; j<=K; j++){
				A[j] += n; 
			}
			for(int j=1; j<=K; j++){
				if(A[j]<n){
					for(int p = K; p>=j; p--){
						A[p+1] = A[p];
					}
					A[j] = n;
					break;
				}
			}
			for(int j=1, l=1, r=1; j<=K; j++){
				if(A[l]>B[r]){
					C[j] = A[l++];
				}else{
					C[j] = B[r++];
				}
			}
			for(int j=1; j<=K; j++){
				B[j] = C[j];
			}
			
		}
		
		System.out.println(B[K]);
	}
}