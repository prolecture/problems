import java.util.*;
public class 최소이동거리_반복 {
	static int MAXN = 10;
	static int N;
	static int[][] G = new int[MAXN + 1][MAXN + 1];
	static int[][] D = new int[MAXN][1 << MAXN];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
			N = sc.nextInt();
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++){
					G[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < N; i++)
				for (int j = 0; j < (1 << N); j++)
					D[i][j] = 0xfffffff;
			
			D[0][1] = 0; // 0번에서 0으로
			
			for (int visit = 1; visit < (1 << N); visit++) {
				
				for (int i = 1; i < N; i++)		// 처음 방문하는 정점 
				{
					if ((visit & (1 << i)) == 0) continue;  
					
					int prev = visit - (1 << i); // i번 정점 제외한 집합  
					
					for (int j = 0; j < N; j++)	 // i번 다음에 방문할 정점 
					{
						if ((prev & (1 << j)) == 0 || G[i][j]== 0)  continue;
						
						D[i][visit] = Math.min(D[i][visit], G[i][j] + D[j][prev]);
					}
				}
			}
			int ans = 0xfffffff;
			for (int i = 1; i < N; i++)
				ans = Math.min(ans, G[0][i] + D[i][(1 << N) - 1]);
			System.out.printf("#%d %d\n", tc, ans);
		}
		sc.close();		
	}
}
