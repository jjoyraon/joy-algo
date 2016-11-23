package prolesson.LCS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * LCS  
 * http://koitp.org/problem/LCS/read/
 * 
 * http://twinw.tistory.com/126 참고
 */
public class source {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/prolesson/LCS/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str1 = "0" + br.readLine();
		String str2 = "0" + br.readLine();
		
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		
		int len1 = str1.length();
		int len2 = str2.length();
		int[][] dy = new int[len2+1][len1+1];
		
		int lcsLength = 0;
		for(int i=1; i<len2; i++){
			int max = 0;
			for(int j=1; j<len1; j++){
				if(s2[i]==s1[j]){
					max = dy[i-1][j-1] + 1;
					dy[i][j] = max;
				}else{
					if(dy[i][j-1] > dy[i-1][j]){
						dy[i][j] = dy[i][j-1];
					}else{
						dy[i][j] = dy[i-1][j];
					}
				}
			}
			lcsLength = Math.max(lcsLength, max);
			
		}
//		System.out.println("lcs length: " + lcsLength);
		
		int jbegin = len1-1;
		
		int cur = lcsLength;
		int prev = cur-1;
		StringBuilder sb = new StringBuilder();
		
		for(int i=len2-1; i>0; i--){
			for(int j=jbegin; j>0; j--){
				if(dy[i][j] == cur && dy[i-1][j] == prev && dy[i][j-1] == prev && dy[i-1][j-1] == prev){
					sb.insert(0, s2[i]);
					cur--;
					prev--;
					jbegin = j;
					break;
				}
			}
		}
		System.out.println(sb.toString());
	}

}