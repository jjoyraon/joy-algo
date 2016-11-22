package exercise.pretest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {

	private static ArrayList<ArrayList<Node>> nlist;
	private static ArrayList<ArrayList<Trip>> ellyList;
	private static ArrayList<ArrayList<Trip>> noahList;
	private static int M;
	private static double ans;
	private static int N;
	private static double[][] elly;
	private static double[][] noah;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/exercise/pretest/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<=T;  test_case++){
			
			String[] nmk = br.readLine().split(" ");
			N = Integer.parseInt(nmk[0]);
			M = Integer.parseInt(nmk[1]);
			int K = Integer.parseInt(nmk[2]);
			
			nlist = new ArrayList<>();
			for(int i=0; i<=N; i++){
				nlist.add(new ArrayList<Node>());
			}
			ellyList = new ArrayList<>();
			noahList = new ArrayList<>();
			for(int i=0; i<=M; i++){
				ellyList.add(new ArrayList<Trip>());
				noahList.add(new ArrayList<Trip>());
			}
			for(int i=0; i<K; i++){
				String[] split = br.readLine().split(" ");
				int from = Integer.parseInt(split[0]);
				int to = Integer.parseInt(split[1]);
				double pos = Double.parseDouble(split[2]);
				nlist.get(from).add(new Node(from, to, pos));
			}
			elly = new double[M+2][N+2];
			noah = new double[M+2][N+2];
			
			bfs(elly, ellyList, 1);
			bfs(noah, noahList, N);
			
			ans = 0;
			dfs(1, 1);
			
			System.out.println(String.format("#%d %.3f", test_case, ans));
		}
		
	}
	
	
	private static void bfs(double[][] arr, ArrayList<ArrayList<Trip>> list, int city){
		LinkedList<Trip> q = new LinkedList<Trip>();
		q.offer(new Trip(1, city, 1d));
		list.get(1).add(new Trip(1, city, 1d));
		arr[1][city] = 1d;
		while(!q.isEmpty()){
			Trip poll = q.poll();
			if(poll.day>M){
				break;
			}
			for(Node node : nlist.get(poll.city)){				
				q.offer(new Trip(poll.day+1, node.next, poll.chance * node.pos));
				arr[poll.day+1][node.next] = arr[poll.day+1][node.next] + arr[poll.day][poll.city] * node.pos;
				list.get(1).add(new Trip(poll.day+1, node.next, poll.chance*node.pos));
			}
		}
	}
	
	private static void dfs(int day, int city){
		if(day>M){
			return;
		}
		
		if(elly[day][city]>0 && noah[day][city]>0){
			double m = (elly[day][city] * noah[day][city]);
			ans += m;
//			return;
		}
		
		for(Node m : nlist.get(city)){
			dfs(day+1, m.next);
		}
	}
	
		
}
class Trip{
	int day;
	int city;
	double chance;
	public Trip(int day, int city, double chance) {
		this.day = day;
		this.city = city;
		this.chance = chance;
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