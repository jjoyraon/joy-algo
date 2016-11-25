package prolesson.nqueen;

import java.io.FileInputStream;
import java.util.Scanner;

/*
 * NQUEEN
 * http://koitp.org/problem/NQUEEN/read/
 */
public class source {
 
    private static int N;
    private static int ANS;
    private static int[] V;
    private static int[] VL;
    private static int[] VR;
 
    public static void main(String[] args) throws Exception {
 
        //System.setIn(new FileInputStream("src/nqueen/input.txt"));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        V = new int[N];
        VL = new int[150];
        VR = new int[150];
        ANS = 0;
         
        func(0);
         
        System.out.println(ANS);
        sc.close();
    }
 
    private static void func(int n) {
        if(n==N){
            ANS++;
            return;
        }
        for(int j=0; j<N; j++){
//          if(n==j) continue;
            if(V[j] != 0) continue;
            if(VL[N+ n-j] != 0) continue;
            if(VR[n+j] != 0) continue;
            V[j] = 1;
            VL[N+ n-j] = 1;
            VR[n+j] = 1;
            func(n+1);
            V[j] = 0;
            VL[N+ n-j] = 0;
            VR[n+j] = 0;
        }
         
         
    }
 
 
}
