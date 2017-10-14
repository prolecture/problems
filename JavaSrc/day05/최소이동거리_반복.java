import java.util.*;
public class 최소이동거리_반복 {
	static int MAXN = 10;
	static int N;
	static int[][] G = new int[MAXN + 1][MAXN + 1];
	static int[][] dp = new int[1 << MAXN][MAXN];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
			N = sc.nextInt();
			
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N; j++){
					G[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < (1 << N); i++)
				for (int j = 0; j < N; j++)
					dp[i][j] = 0xfffffff;
			
			dp[1][0] = 0;
			
			for (int visit = 1; visit < (1 << N); visit++) // visit: 방문한 정점들의 집합
			{
				for (int last = 0; last < N; last++)		// last: 마지막 방문 정점
				{
					if ((visit & (1 << last)) == 0) continue; // last가 visit에 포함되었는지 확인
					
					int prev = visit - (1 << last); 		 // prev: visit에서 last를 제외한 정점들 
					
					for (int v = 0; v < N; v++)				 // prev에 포함된 정점 선택하기
					{
						if ((prev & (1 << v)) == 0 || G[v][last]== 0) // v->last 간선이 없거나, visit에 미포함이면 제외
							continue;
						
						dp[visit][last] = Math.min(dp[visit][last], dp[prev][v] + G[v][last]);
					}
				}
			}
			int ans = 0xfffffff;
			for (int i = 1; i < N; i++)
				ans = Math.min(ans, dp[(1 << N) - 1][i] + G[i][0]);
			System.out.printf("#%d %d\n", tc, ans);
		}
		sc.close();		
	}
}
