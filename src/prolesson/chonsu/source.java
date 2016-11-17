package prolesson.chonsu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * 촌수 계산
 * http://koitp.org/problem/SDS_PRO_4_4/read/
 */
public class source {
	
	private static ArrayList<ArrayList<Integer>> nlist;
	private static int[] dep;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/prolesson/chonsu/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] ab = br.readLine().split(" ");
		int A = Integer.parseInt(ab[0]);
		int B = Integer.parseInt(ab[1]);
		
		dep = new int[N+1];
		nlist = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=N; i++){
			nlist.add(new ArrayList<Integer>());
		}
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i<M; i++){
			String[] sp = br.readLine().split(" ");
			int a = Integer.parseInt(sp[0]);
			int b = Integer.parseInt(sp[1]);
			nlist.get(a).add(b);
			nlist.get(b).add(a);
		}
		
		dfs(1);
		
		System.out.println();
	}
	
	private static void dfs(int n){
		for(int num : nlist.get(n)){
			dep[num] = dep[n] + 1;
			dfs(num);
		}
	}
}