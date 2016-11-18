package prolesson.merchant;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * 상인
 * http://koitp.org/problem/SDS_PRO_4_8/read/
 */
public class source {
	
	private static ArrayList<ArrayList<Integer>> nlist;
	private static int[] depth;
	private static int[][] parent;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/prolesson/merchant/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		depth = new int[N+1];
		parent = new int[N+1][18];
		nlist = new ArrayList<>();
		
		for(int i=0; i<=N; i++)	nlist.add(new ArrayList<Integer>());
		
		for(int i=1; i<N; i++){
			String[] ab = br.readLine().split(" ");
			int a = Integer.parseInt(ab[0]);
			int b = Integer.parseInt(ab[1]);
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
		long res = 0;
		for(int i=1; i<N; i++){
			int lca = lca(i, i+1);
			int cost = depth[i] + depth[i+1] - (depth[lca]*2);
			res += cost;
		}
		
		System.out.println(String.format("%d", res));
	}
	
	private static int lca(int a, int b){
		int up = a;
		int stay = b;
		if(depth[a]!=depth[b]){
			if(depth[a] < depth[b]){
				up = b;
				stay = a;
			}else{
				up = a;
				stay = b;
			}
			for(int i=17; i>=0; i--){
				if(depth[stay]  <= depth[up] - (1<<i)){
					up = parent[up][i];
				}
			}
		}
		
		if(up==stay){
			return stay;
		}
		for(int i=17; i>=0; i--){
			if(parent[up][i] != parent[stay][i]){
				up = parent[up][i];
				stay = parent[stay][i];
			}
		}
		return parent[stay][0];
	}

	private static void dfs(int n) {
		for(int c : nlist.get(n)){
			if(parent[c][0]!=0){
				continue;
			}
			depth[c] = depth[n] + 1;
			parent[c][0] = n;
			dfs(c);
		}
	}
}