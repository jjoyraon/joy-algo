package exercise.pretest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

	private static int M;
	private static int N;
	private static ArrayList<ArrayList<Node>> nlist;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/exercise/pretest/input2.txt"));
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
			for(int i=0; i<K; i++){
				String[] split = br.readLine().split(" ");
				int from = Integer.parseInt(split[0]);
				int to = Integer.parseInt(split[1]);
				double pos = Double.parseDouble(split[2]);
				nlist.get(from).add(new Node(from, to, pos));
			}
			
			System.out.println(String.format("#%d %.3f", test_case, func(1, 1, N)));
		}
		
	}

	private static double func(int day, int ellyCity, int noahCity) {
		
		if(day==M){
			if(ellyCity==noahCity){
				return 1d;
			}else{
				return 0d;
			}
		}
		if(ellyCity==noahCity){
			return 1d;
		}
		double sum = 0;
		for(Node n1 : nlist.get(ellyCity)){
			for(Node n2 : nlist.get(noahCity)){
				sum += (n1.pos * n2.pos * func(day+1, n1.next, n2.next));
			}
		}
		return sum;
		
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