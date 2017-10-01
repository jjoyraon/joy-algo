package prolesson.rollercoaster;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * 롤러코스터
 * http://koitp.org/problem/USACO_2006DEC_ROLLERCOASTER/read/
 */
public class source {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/prolesson/rollercoaster/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		int N = sc.nextInt();
		int B = sc.nextInt();
		
		ArrayList<Part> list = new ArrayList<>();
		for(int i=0; i<N; i++){
			int start = sc.nextInt();
			int length = sc.nextInt();
			int fun = sc.nextInt();
			int cost = sc.nextInt();
			list.add(new Part(start+1, start + length, fun, cost));
		}
		int[][] dy = new int[L+1][B+1];
		for(int i=0; i<=L; i++){
			for(int j=0; j<=B; j++){
				dy[i][j] = -1;
			}
		}
		dy[0][0] = 0;
		
		Collections.sort(list);
		
		for(Part p : list){
			int s = p.start;
			int e = p.end;
			int c = p.cost;
			int f = p.fun;
			for(int i = 0; i<=B; i++){
				if((i-c) < 0 || dy[s-1][i-c] == -1){
					continue;
				}
				dy[e][i] = Math.max(dy[e][i], dy[s-1][i-c] + f);
			}
		}
		
		int max = -1;
		for(int i=0; i<=B; i++){
			max = Math.max(dy[L][i], max);
		}
		
		System.out.println(String.format("%d", max));
	}
}

class Part implements Comparable<Part>{
	int start;
	int end;
	int fun;
	int cost;
	public Part(int start, int end, int fun, int cost) {
		this.start = start;
		this.end = end;
		this.fun = fun;
		this.cost = cost;
	}
	@Override
	public int compareTo(Part that) {
		return this.end - that.end;
	}
	
}