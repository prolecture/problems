/*
1
5
0 90 64 40 39 
90 0 94 71 38 
64 94 0 57 89 
40 71 57 0 82 
39 38 89 82 0 
*/
import java.util.Scanner;

public class 최소이동거리 {
	static int MAXN = 10;
	static int N;
	static int[][] G = new int[MAXN + 1][MAXN + 1];
	static int[][] D = new int[MAXN + 1][1 << (MAXN + 1)]; // N = 10이면 11개 비트 필요.
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++)
					G[i][j] = sc.nextInt();
			}
			for (int i = 0; i <= N; i++)
				for (int j = 0; j < (1 << N + 1); j++)
					D[i][j] = 0;
			
			int min = 0xfffffff;		// N이 5일때
			int s = (1 << (N + 1)) - 1;	// (1000000) - 1 = (111111)
			s = s & (~3);				// 1번을 제외한 정점들의 집합 (111111) & (111100) = (111100)
			
			for(int i = 2; i <= N; i++) {
				int set = s & (~(1 << i));
				//if(G[1][i] == 0) continue;
				min =  Math.min(min, G[1][i] +find(i, set));
			}			
			System.out.printf("#%d %d\n", tc, min);
		}
		sc.close();		
	}
	static int find(int n, int s) {
		if(s == 0) return D[n][s] = G[n][1];
		if(D[n][s] != 0) return D[n][s];
		
		int min = 0xfffffff;
		for(int i = 2; i <= N; i++) {
			if((G[n][1] != 0) &&(s & (1 << i)) != 0) {
				int set = s & (~(1 << i));
				min =  Math.min(min, G[n][i] +find(i, set));
			}
		}
		return D[n][s] = min;
	}
}
