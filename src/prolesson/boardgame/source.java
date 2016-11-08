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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] cards = new String[N+1];
		String[] cardSplit = br.readLine().split(" ");
		for(int i=1; i<=N; i++){
			cards[i] = cardSplit[i-1];
		}

		String[] mk = br.readLine().split(" ");
		int M =  Integer.parseInt(mk[0]);
		int K = Integer.parseInt(mk[1]);
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
		
		int[][] dy = new int[N+1][M+1];
		
		for(int i=0; i<=N; i++){
			for(int j=1; j<=M; j++){
				dy[i][j] = -98765;
			}
		}
		dy[0][1] = 0;
		for(int i=1; i<=N; i++){
			for(int j=1; j<=M; j++){
				if(dy[i-1][j] >=0){ // 현재 위치가 이미 확인되었을 경우에 다음 경로를 계산
					for(Node n : nlist.get(j)){
						int p = dy[i-1][j];
						if(n.card.equals(cards[i])){
							p += 1;
						}
						dy[i][n.num] = Math.max(p, dy[i][n.num]);
					}				
				}
			}
		}
		int max = 0;
		for(int i=1; i<=M; i++){
			max = Math.max(max, dy[N][i]);
		}
		System.out.println(max*10);
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