package exercise.pretest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	private static ArrayList<ArrayList<Node>> nlist;
	private static int M;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/exercise/pretest/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<=T;  test_case++){
			
			String[] nmk = br.readLine().split(" ");
			int N = Integer.parseInt(nmk[0]);
			M = Integer.parseInt(nmk[1]);
			int K = Integer.parseInt(nmk[2]);
			
			nlist = new ArrayList<>();
			for(int i=0; i<=N; i++){
				nlist.add(new ArrayList<Node>());
			}
			for(int i=0; i<K; i++){
				String[] split = br.readLine().split(" ");
				int from = Integer.parseInt(split[0]);
				int to = Integer.parseInt(split[1]);
				double pos = Double.parseDouble(split[2]);
				nlist.get(from).add(new Node(from, to, pos));
			}
			double[][] mdy = new double[M+1][N+1];
			double[][] wdy = new double[M+1][N+1];
			
			bfs(mdy, 1);
			bfs(wdy, N);
			
			double ans = 0;
			
			boolean[][] noNeedToCheck = new boolean[M+1][N+1];
			for(int i=1; i<=M; i++){
				for(int j=1; j<=N; j++){
					if(mdy[i][j]>0d && wdy[i][j]>0d){
						double thisCase = mdy[i][j] * wdy[i][j];
						ans += thisCase;
					}
				}
			}
			System.out.println(String.format("#%d %f", test_case, ans));
		}
		
	}
	
	
	private static void bfs(double[][] dy, int num){
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(num);
		int day = 1;
		dy[day][num] = 1d;
		while(!q.isEmpty()){
			if(day>=M){
				break;
			}
			Integer poll = q.poll();
			for(Node node : nlist.get(poll)){
				dy[day+1][node.next] = dy[day][poll] * node.pos;
				q.offer(node.next);
			}
			day++;
		}
	}
		
}

class Node{
	int num;
	int next;
	double pos;
	public Node(int num, int next, double pos) {
		this.num = num;
		this.next = next;
		this.pos = pos;
	}
	@Override
	public String toString() {
		return "Node [num=" + num + ", next=" + next + ", pos=" + pos + "]";
	}
	
}