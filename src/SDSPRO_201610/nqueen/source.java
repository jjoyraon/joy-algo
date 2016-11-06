package SDSPRO_201610.nqueen;

import java.io.FileInputStream;
import java.util.Scanner;

/*
 * NQUEEN
 * http://koitp.org/problem/NQUEEN/read/
 */
public class source {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/SDSPRO_201610/pinary/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		long[] dy = new long[N+1];
		dy[0] = 0;
		dy[1] = 1;
		for(int i=2; i<=N; i++){
			dy[i] = dy[i-1] + dy[i-2];
		}
		System.out.println(String.format("%d", dy[N]));
	}
}
