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
	private static int[][] parent; // i의 2의 j 승번째 위의 부모 

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/prolesson/chonsu/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] ab = br.readLine().split(" ");
		int A = Integer.parseInt(ab[0]);
		int B = Integer.parseInt(ab[1]);
		
		dep = new int[N+1];
		nlist = new ArrayList<ArrayList<Integer>>();
		parent = new int[N+1][17+1];
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
		
		parent[1][0] = 1;
		dfs(1);
		for(int i=1; i<17; i++){
			for(int j=1; j<=N; j++){
				parent[j][i] = parent[parent[j][i-1]][i-1];
			}
		}
		int lca = lca(A, B);
		if(lca==0){
			System.out.println("-1");
		}else{
			int res = dep[A] + dep[B] - (dep[lca]*2);
			System.out.println(res);
		}
		
	}
	

	private static int lca(int a, int b){
		int up = 0;
		int stay = 0;
		if(dep[a]!=dep[b]){
			
			if(dep[a]>dep[b]){
				up = b;
				stay = a;
			}else{
				up = a;
				stay = b;
			}
			for(int i=17; i>=0; i--){
				if(dep[stay] - (i<<1) > dep[up]){
					up = parent[up][i];
				}
			}
		}
		if(up==stay){
			return up;
		}
		
		for(int i=17; i>=0; i--){
			if(parent[up][i]!=parent[stay][i]){
				up = parent[up][i];
				stay = parent[stay][i];
			}
		}
		return parent[up][0];
		
	}


	private static void dfs(int n){
		for(int num : nlist.get(n)){
			if(parent[num][0]!=0){
				continue;
			}
			dep[num] = dep[n] + 1;
			parent[num][0] = n;
			dfs(num);
		}
	}
}