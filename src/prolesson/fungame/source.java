package prolesson.fungame;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/*
 * 재밌는게임 
 * http://koitp.org/problem/SDS_PRO_1_8/read/
 */
public class source {

	private static final int INF = 987654321;
	private static int[][] map;
	private static int[][] gmap;
	private static int M;
	private static int N;
	private static int[] xx = {1, -1, 0, 0};
	private static int[] yy = {0, 0, 1, -1};
	private static int G ;
	private static List<List<Integer>> nList;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/prolesson/fungame/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		
		map = new int[M+1][N+1];
		gmap = new int[M+1][N+1];
		for(int i=1; i<=M; i++){
			for(int j=1; j<=N; j++){
				map[i][j] = sc.nextInt();
			}
		}
		
		G = 0;
		for(int i=1; i<=M; i++){
			for(int j=1; j<=N; j++){
				if(gmap[i][j]==0){
					dfs(i, j, ++G);
				}
			}
		}
		nList = new ArrayList<>();
		for(int i=0; i<=G; i++){
			nList.add(new ArrayList<Integer>());
		}
		for(int i=1; i<=M; i++){
			for(int j=1; j<=N; j++){
				for(int k=0; k<4; k++){
					int newi = i + xx[k];
					int newj = j + yy[k];
					if(newi<1|| newi>M|| newj<1|| newj>N|| gmap[newi][newj]==gmap[i][j] ){
						continue;
					}
					nList.get(gmap[i][j]).add(gmap[newi][newj]);
				}
			}
		}
		int min = INF;
		for(int i=1; i<=G; i++){
			int max = bfs(i);
			min = Math.min(max, min);
		}
		
		System.out.println(String.format("%d", min));
		
		
	}
	
	private static void dfs(int i, int j, int g){
		gmap[i][j] = g;
		for(int k=0; k<4; k++){
			int newi = i + xx[k];
			int newj = j + yy[k];
			if(newi<1|| newi>M|| newj<1|| newj>N|| map[newi][newj]!=map[i][j] || gmap[newi][newj]!=0 ){
				continue;
			}
			dfs(newi, newj, g);
		}
	}

	private static int bfs(int n) {
		
		Queue<Integer> q = new LinkedList<>();
		int[] d = new int[G+1];
		boolean[] visit = new boolean[G+1];
		for(int i=0; i<=G; i++){
			d[i] = INF;
		}
		d[n] = 0;
		q.offer(n);
		visit[n] =true;
		while(!q.isEmpty()){
			Integer poll = q.poll();
			for(int a : nList.get(poll)){
				if(visit[a]){
					continue;
				}
				d[a] = d[poll] + 1;
				q.offer(a);
				visit[a] = true;
			}
		}
		int max = 0;
		for(int i=1; i<=G; i++){
			if(i!=n){
				max = Math.max(d[i], max);
			}
		}
		return max;
	}
}