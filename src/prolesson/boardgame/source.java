package prolesson.boardgame;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 보드게임 
 * http://koitp.org/problem/SDS_PRO_7_3/read/
 */
public class source {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/prolesson/boardgame/input.txt"));
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] cards = br.readLine().split(" ");

		int M = sc.nextInt();
		int K = sc.nextInt();
		List<List<Node>> nlist = new ArrayList<>();
		for(int i=0; i<=M; i++){
			nlist.add(new ArrayList<Node>());
		}
		for(int i=0; i<K; i++){
			String[] split = br.readLine().split(" ");
			int from = Integer.parseInt(split[0]);
			int to = Integer.parseInt(split[1]);
			String c = split[2];
			nlist.get(from).add(new Node(to, c));
			nlist.get(to).add(new Node(from, c));
		}
		
		int[][] dy = new int[M+1][N+1];
		for(int i=1; i<=M; i++){
			for(int j=1; j<=N; j++){
				
			}
		}
		
		
	}
}

class Node{
	int num;
	String card;
	public Node(int num, String card) {
		this.num = num;
		this.card = card;
	}
	
}