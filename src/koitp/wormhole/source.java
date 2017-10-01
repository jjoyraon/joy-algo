package prolesson.wormhole;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * 웜홀  
 * http://koitp.org/problem/SDS_PRO_4_6/read/
 */
public class source {
	
	private static final int INF = 9876543;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/prolesson/wormhole/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<=T; test_case++){
			String[] nmw = br.readLine().split(" ");
			int N = Integer.parseInt(nmw[0]);
			int M = Integer.parseInt(nmw[1]);
			int W = Integer.parseInt(nmw[2]);
			
			ArrayList<ArrayList<Node>> nlist = new ArrayList<>();
			for(int i=0; i<=N; i++){
				nlist.add(new ArrayList<Node>());
			}
			
			for(int i=0; i<M; i++){
				String[] set = br.readLine().split(" ");
				int s = Integer.parseInt(set[0]);
				int e = Integer.parseInt(set[1]);
				int t = Integer.parseInt(set[2]);
				nlist.get(s).add(new Node(s, e, t));
				nlist.get(e).add(new Node(e, s, t));
			}
			for(int i=0; i<W; i++){
				String[] set = br.readLine().split(" ");
				int s = Integer.parseInt(set[0]);
				int e = Integer.parseInt(set[1]);
				int t = Integer.parseInt(set[2]);
				nlist.get(s).add(new Node(s, e, -1*t));
			}
			
			int[] dist = new int[N+1];
			for(int i=0; i<=N; i++){
				dist[i] = INF;
			}
			dist[1] = 0;  // 시작점 거리를 입력
			boolean hasCycle = false;
			for(int i=1; i<=N; i++){
				for(int j=1; j<=N; j++){
					for(Node node : nlist.get(j)){
						int next = node.e;
						int cost = node.cost;
						
						if(dist[j] != INF && dist[next] > dist[j] + cost){
							dist[next] = dist[j] + cost;
							if(i==N){ // N-1번을 하고도 다시 거리가 줄어든다면 싸이클이 존재하는 것
								hasCycle = true;
							}
						}
					}
				}
			}
			if(hasCycle){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
			
		}
	}
}

class Node{
	int s;
	int e;
	int cost;
	public Node(int s, int e, int t) {
		this.s = s;
		this.e = e;
		this.cost = t;
	}
}