package koitp.pinary;

import java.io.FileInputStream;
import java.util.Scanner;

/*
 * 이친수
 * SW검정 연습문제 사이트
 */
public class Solution {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/prolesson/pinary/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++){
			int N = sc.nextInt();
			
			long[] dy = new long[N+1];
			dy[0] = 0;
			dy[1] = 1;
			for(int i=2; i<=N; i++){
				dy[i] = dy[i-1] + dy[i-2];
			}
			System.out.println(String.format("#%d %d", test_case, dy[N]));
			
		}
	}
}
