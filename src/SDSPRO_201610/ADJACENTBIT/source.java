package SDSPRO_201610.ADJACENTBIT;

import java.io.FileInputStream;
import java.util.Scanner;

/*
 * 인접한 비트의 개수
 * http://koitp.org/problem/ICPC_2009GNY_ADJACENTBIT/read/
 */
public class source {

	private static long[][][] dy;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/SDSPRO_201610/ADJACENTBIT/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		prev();
		
		for(int test_case=1; test_case<=T; test_case++){

			int t = sc.nextInt();
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			System.out.println(String.format("%d %d", test_case, (dy[N][K][0] + dy[N][K][1])));
		}
		
	}
	
	private static void prev() {
        dy = new long[101][100][2];
        dy[1][0][0] = dy[1][0][1] = 1;
        for (int i = 2; i <= 100; i++) {
            for (int j = 0; j < i; j++) {
                dy[i][j][0] = dy[i - 1][j][0] + dy[i - 1][j][1];
                dy[i][j][1] = dy[i - 1][j][0];
                if (j > 0) {
                    dy[i][j][1] += dy[i - 1][j - 1][1];
                }
            }
        }
 
    }

}
