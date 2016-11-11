package prolesson.set;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 집합 
 * http://koitp.org/problem/SET/read/
 */
public class source {

	private static final int INF = 987654321;
	private static int N;
	private static int M;
	private static int[] A = new int[1001];
	private static int[] B = new int[1001];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/prolesson/set/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		int nn = Integer.parseInt(nm[0]);
		int mm = Integer.parseInt(nm[1]);
		String[] nnn = br.readLine().split(" ");
		String[] mmm = br.readLine().split(" ");
		if(nn>mm){
			M = nn;
			N = mm;
			A = new int[M+1];
			B = new int[N+1];
			for(int i=1; i<=M; i++)
				A[i] = Integer.parseInt(nnn[i-1]);
			for(int i=1; i<=N; i++)
				B[i] = Integer.parseInt(mmm[i-1]);
		}else{
			M = mm;
			N = nn;
			B = new int[N+1];
			A = new int[M+1];
			for(int i=1; i<=M; i++)
				A[i] = Integer.parseInt(mmm[i-1]);
			for(int i=1; i<=N; i++)
				B[i] = Integer.parseInt(nnn[i-1]);
		}
		Arrays.sort(A);
		Arrays.sort(B);
		int[][] D = new int[N+1][M+1];
		for(int i=0; i<=N; i++) for(int j=0; j<=M; j++){
			D[i][j] = INF;
		}
		D[0][0] = 0; // 작은 배열에서 i개, 큰 배열에서 j개 
		for(int i=0; i<=N; i++) for(int j=0; j<=M; j++){
			if(D[i][j]<INF){
				if(j<M){
					D[i][j+1] = Math.min(D[i][j+1], D[i][j]);
				}
				if(i<N && j<M){
					D[i+1][j+1] = Math.min(D[i+1][j+1], D[i][j] + Math.abs(B[i+1]-A[j+1]));
				}
			}
		}
		
		System.out.println(D[N][M]);
		
		
		
		
	}
}