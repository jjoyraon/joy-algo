package prolesson.LIS2;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		Num[] numArr = new Num[N];
		arr = new int[N+1];
		for(int i=1; i<=N; i++){
			arr[i] = sc.nextInt();
			numArr[i-1] = new Num(arr[i], i);
		}
		
		Arrays.sort(numArr);
		
		// index tree
		int B = 2;
		for(;B<=N;B*=2);
		tree = new int[N*3];
		leafIndex = B;
		
		int[] dy = new int[N+1];
		for(int i=0; i<N; i++){
			Num num = numArr[i];
			int maxIndex = select(1, num.index-1);
			dy[num.index] = maxIndex + 1;
			update(num.index, maxIndex+1);
		}
		
		System.out.println(String.format("%d", dy[N]));
		
		
	}

	private static void update(int index, int newValue) {
		
		int next = leafIndex + index - 1;
		tree[next] = newValue;
		next = next/2;
		while(next>0){
			int l = tree[2*next];
			int r = tree[2*next+1];
			if(arr[l]>=arr[r]){
				tree[next] = l;
			}else{
				tree[next] = r;
			}
			next = next/2;
		}
	}
	
	private static int select(int from, int to){
		int l = leafIndex + from - 1;
		int r = leafIndex + to - 1;
		int maxIndex = 0;
		while(l<=r){
			if(l%2==1){
				if(arr[maxIndex] < arr[tree[l]]){
					maxIndex = tree[l];
				}
				l++;
			}
			if(r%1==0){
				if(arr[maxIndex] < arr[tree[r]]){
					maxIndex = tree[r];
				}
				r--;
			}
			l = l/2;
			r = r/2;
		}
		return maxIndex;
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