package koitp.picnic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 피크닉  
 * http://koitp.org/problem/SDS_PRO_4_2/read/
 */
public class source {
	
	private static ArrayList<ArrayList<Integer>> nlist;
	private static int N;
	private static boolean[][] D;
	private static int[] starts;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/prolesson/picnic/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] knm = br.readLine().split(" ");
		int K = Integer.parseInt(knm[0]);
		N = Integer.parseInt(knm[1]);
		int M = Integer.parseInt(knm[2]);
		
		D = new boolean[K+1][N+1];
		
		starts = new int[K+1];
		for(int i=1; i<=K; i++){
			starts[i] = Integer.parseInt(br.readLine());
		}
		
		nlist = new ArrayList<>();
		for(int i=0; i<=N; i++){
			nlist.add(new ArrayList<Integer>());
		}
		
		
		for(int i=1; i<=M; i++){
			String[] se = br.readLine().split(" ");
			int s = Integer.parseInt(se[0]);
			int e = Integer.parseInt(se[1]);
			nlist.get(s).add(e);
		}
		
		for(int i=1; i<=K; i++){
			// 소의 시작 위치별로 bfs를 돌려서 닿는 모든 경로를 표시
			bfs(i);
		}
		
		int count = 0;
		for(int i=1; i<=N; i++){
			int countPerNode = 0;
			for(int j=1; j<=K; j++){
				if(D[j][i]){
					countPerNode++;
				}
			}
			if(countPerNode==K){
				count++;
			}
		}
		System.out.println(count);
	}

	private static void bfs(int k) {
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(starts[k]);
		D[k][starts[k]] = true;
		while(!q.isEmpty()){
			Integer poll = q.poll();
			for(int n : nlist.get(poll)){
				if(D[k][n]){
					continue;
				}
				D[k][n] = true;
				q.offer(n);
			}
		}
	}
}