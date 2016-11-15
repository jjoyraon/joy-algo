package prolesson.LIS2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * LIS2 
 * http://koitp.org/problem/LIS2/read/
 */
public class source {

	private static int[] arr;
	private static int N;
	private static int[] tree;
	private static int leafIndex;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/prolesson/LIS2/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		Num[] numArr = new Num[N];
		arr = new int[N+1];
		String[] split = br.readLine().split(" ");
		for(int i=1; i<=N; i++){
			arr[i] = Integer.parseInt(split[i-1]);
			numArr[i-1] = new Num(arr[i], i);
		}
		
		Arrays.sort(numArr);
		
		// index tree
		int B = 2;
		for(;B<=N;B*=2);
		tree = new int[N*3];
		leafIndex = B;
		
		int[] path = new int[N+1];
		int pi = 0;
		int max = 0;
		for(int i=0; i<N; i++){
			Num num = numArr[i];
			int prevMax = select(1, num.index-1);
			update(num.index, prevMax + 1);
			if(pi>0 && path[pi-1]!=num.num){
				path[pi++] = num.num;
			}else if(pi==0){
				path[pi++] = num.num;
			}
			max = Math.max(max, prevMax + 1);
		}
		System.out.println(String.format("%d", max));
		
//		for(int i=0; i<pi; i++){
//			System.out.print(path[i] + " ");
//		}
	}

	private static void update(int index, int newValue) {
		
		int next = leafIndex + index - 1;
		tree[next] = newValue;
		next = next/2;
		while(next>0){
			int l = tree[2*next];
			int r = tree[2*next+1];
			tree[next] = Math.max(l, r);
			next = next/2;
		}
	}
	
	private static int select(int from, int to){
		int l = leafIndex + from - 1;
		int r = leafIndex + to - 1;
		int max = 0;
		while(l<=r){
			if(l%2==1){
				max = Math.max(max, tree[l]); 
				l++;
			}
			if(r%2==0){
				max = Math.max(max, tree[r]);
				r--;
			}
			l = l/2;
			r = r/2;
		}
		return max;
	}
}

class Num implements Comparable<Num>{
	int num;
	int index;
	public Num(int num, int index) {
		this.num = num;
		this.index = index;
	}
	@Override
	public int compareTo(Num o) {
		if(this.num==o.num){
			return o.index - this.index;
		}
		return this.num - o.num;
	}
	@Override
	public String toString() {
		return "Num [num=" + num + ", index=" + index + "]";
	}
	
	
}