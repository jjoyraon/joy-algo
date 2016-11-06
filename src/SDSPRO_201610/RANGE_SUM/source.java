package SDSPRO_201610.RANGE_SUM;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * 구간합  
 * http://koitp.org/problem/SDS_PRO_3_5/read/
 */
public class source {

	private static int N;
	private static long[] tree;
	private static int leafIndex;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/SDSPRO_201610/RANGE_SUM/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int Q = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[Q][3];
		for(int i=0; i<Q; i++){
			String[] split = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(split[0]);
			arr[i][1] = Integer.parseInt(split[1]);
			arr[i][2] = Integer.parseInt(split[2]);
		}
		
		// index tree
		int B = 2;
		for(;B<N;B*=2);
		tree = new long[N*3];
		leafIndex = B;
		for(int i=1; i<=N; i++){
			update(i, i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<Q; i++){
			int q = arr[i][0];
			int a = arr[i][1];
			int b = arr[i][2];
			if(q==0){
				update(a, b);
			}else{
				long sum = select(a, b);
				sb.append(sum).append("\n");
			}
		}
		System.out.println(sb.toString());
		
	}

	private static void update(int index, int num) {
		
		int next = leafIndex + index - 1;
		tree[next] = num;
		next = next/2;
		while(next>0){
			tree[next] = tree[2*next] + tree[2*next+1];
			next = next/2;
		}
	}
	
	private static long select(int from, int to){
		int l = leafIndex + from - 1;
		int r = leafIndex + to - 1;
		long sum = 0;
		while(l<=r){
			if(l%2==1){
				sum += tree[l++];
			}
			if(r%2==0){
				sum += tree[r--];
			}
			l = l/2;
			r = r/2;
		}
		return sum;
	}
}

