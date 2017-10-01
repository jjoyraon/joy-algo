package koitp.midvalue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/*
 * 중앙값
 * http://koitp.org/problem/SDS_PRO_3_6/read/
 */
public class source {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/prolesson/midvalue/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		for(int i=1; i<=N; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		StringBuilder sb = new StringBuilder();
		sb.append(arr[1]).append("\n");
		
		int mid = arr[1];
		
		for(int i=2; i<=N; i+=2){
			int v1 = arr[i];
			int v2 = arr[i+1];
			if(v1>mid && v2>mid){
				maxHeap.offer(mid);
				minHeap.offer(v1);
				minHeap.offer(v2);
				mid = minHeap.poll();
			}else if(v1<mid && v2<mid){
				minHeap.offer(mid);
				maxHeap.offer(v1);
				maxHeap.offer(v2);
				mid = maxHeap.poll();
			}else{
				minHeap.offer(Math.max(v1, v2));
				maxHeap.offer(Math.min(v1, v2));
			}
			sb.append(mid).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
}

