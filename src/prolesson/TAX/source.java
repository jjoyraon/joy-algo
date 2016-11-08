package prolesson.TAX;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * 세금  
 * http://koitp.org/problem/TAX/read/
 */
public class source {

	private static int LEAF_START;
	private static long[] tree;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/prolesson/TAX/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nk = br.readLine().split(" ");
		int N = Integer.parseInt(nk[0]);
		int K = Integer.parseInt(nk[1]);
		long[] arr = new long[N+1];
		String[] split = br.readLine().split(" ");
		for(int i=1; i<=N; i++){
			arr[i] = Long.parseLong(split[i-1]);
		}
		int BIN = 1;
		for(; BIN<N ; BIN*=2);
		LEAF_START = BIN;
		tree = new long[BIN*3];
		
		for(int i=1; i<=N; i++){
			update(i, arr[i]);
		}
		
		long maxBorder = Long.MIN_VALUE;
		PriorityQueue<Long> minHeap = new PriorityQueue<>(64);
		for(int i=1; i<=N; i++){
			for(int j=1; j<=i; j++){
				long sum = select(j, i);
				if(sum<maxBorder){
					continue;
				}
				minHeap.offer(sum);
				if(minHeap.size()>K){
					Long poll = minHeap.poll();
					maxBorder = Math.max(poll,  maxBorder);
				}
			}
		}
		
		System.out.println(minHeap.poll());
	}
	private static void update(int i, long newValue){
		int next = LEAF_START - 1 + i;
		tree[next] = newValue;
		next = next/2;
		while(next>0){
			tree[next] = tree[next*2] + tree[next*2+1];
			next = (int)next/2;
		}
	}
	private static long select(int left, int right){
		int l = LEAF_START -1 + left;
		int r = LEAF_START -1 + right;
		long sum = 0;
		while(l<=r){
			if(l%2 == 1){
				sum += tree[l];
				l++;
			}
			if(r%2 == 0){
				sum += tree[r];
				r--;
			}
			l = l/2;
			r = r/2;
		}
		return sum;
	}
}