package SDSPRO_201610.fungame;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 재밌는게임 
 * http://koitp.org/problem/SDS_PRO_1_8/read/
 */
public class source {

	private static int[][] map;
	private static int M;
	private static int N;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/SDSPRO_201610/fungame/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		
		map = new int[M+1][N+1];
		int[][] omap = new int[M+1][N+1];
		for(int i=1; i<=M; i++){
			for(int j=1; j<=N; j++){
				omap[i][j] = sc.nextInt();
			}
		}
		
		int min = 98765;
		for(int i=1; i<=M; i++){
			for(int j=1; j<=N; j++){
				init(omap);
				
				boolean isAllSame = false;
				int count = 0;
				while(!isAllSame){
					count++;
					bfs(i,j);
					if(isAllSame()){
						isAllSame = true;
					}
				}
				min = Math.min(min, count);
			}
		}
		
		System.out.println(String.format("%d", min));
		
		
	}
	private static void init(int[][] omap) {
		for(int i=1; i<=M; i++){
			for(int j=1; j<=N; j++){
				map[i][j] = omap[i][j];
			}
		}
		
	}
	private static boolean isAllSame(){
		int w = 0;
		int b = 0;
		for(int i=1; i<=M; i++){
			for(int j=1; j<=N; j++){
				int c = map[i][j];
				if(c==1){
					b++;
				}else{
					w++;
				}
				if(b>0 && w>0){
					return false;
				}
			}
		}
		if(b==N*M || w==N*M){
			return true;
		}
		return false;
	}

	private static void bfs(int i, int j) {
		
		int color = map[i][j];
		boolean[][] visit = new boolean[M+1][N+1];
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(i, j));
		visit[i][j] = true;
		
		while(!q.isEmpty()){
			Point poll = q.poll();
			map[poll.x][poll.y] = 1-color;
			
			int[] dx = {1, -1, 0, 0};
			int[] dy = {0, 0, 1, -1};
			
			for(int k=0; k<4; k++){
				int newi = poll.x + dx[k];
				int newj = poll.y + dy[k];
				if(newi<1 || newi>M || newj<1 || newj>N || visit[newi][newj]){
					continue;
				}
				if(map[newi][newj]!=color){
					continue;
				}
				q.offer(new Point(newi, newj));
				visit[newi][newj] = true;
			}
			
		}
		
		
	}
}

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}