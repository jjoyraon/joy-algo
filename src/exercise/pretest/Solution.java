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
	private static double ans;

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
			double[][] mdy = new double[M+2][N+1];
			double[][] wdy = new double[M+2][N+1];
			
			bfs(mdy, 1);
			bfs(wdy, N);
			
			ans = 0;
			dfs(mdy, wdy, 1, 1);
			
			System.out.println(String.format("#%d %f", test_case, ans));
		}
		
	}
	
	private static void dfs(double[][] mdy, double[][] wdy, int day, int num){
		if(day>M){
			return;
		}
		if(mdy[day][num]>0d && wdy[day][num]>0d){
			ans += (mdy[day][num] * wdy[day][num]);
			return;
		}
		for(Node n : nlist.get(num)){
			dfs(mdy, wdy, day+1, n.next);
		}
	}
	
	private static void bfs(double[][] dy, int num){
		Queue<Trip> q = new LinkedList<Trip>();
		q.offer(new Trip(num, 1));
		dy[1][num] = 1d;
		while(!q.isEmpty()){
			Trip poll = q.poll();
			if(poll.day>M){
				break;
			}
			for(Node node : nlist.get(poll.num)){
				dy[poll.day+1][node.next] = dy[poll.day][poll.num] * node.pos;
				q.offer(new Trip(node.next, poll.day+1));
			}
		}
	}
		
}
class Trip{
	int num;
	int day;
	public Trip(int num, int day) {
		this.num = num;
		this.day = day;
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