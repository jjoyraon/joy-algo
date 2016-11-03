package SDSPRO_201610.pinary;

import java.io.FileInputStream;
import java.util.Scanner;

/*
 * ��ģ��
 * SW���� ����Ǯ�� Site
 */
public class Solution {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/SDSPRO_201610/pinary/input.txt"));
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
