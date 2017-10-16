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
			
			for (int visit = 1; visit < (1 << N); visit++) // visit: �湮�� �������� ����
			{
				for (int last = 0; last < N; last++)		// last: ������ �湮 ����
				{
					if ((visit & (1 << last)) == 0) continue; // last�� visit�� ���ԵǾ����� Ȯ��
					
					int prev = visit - (1 << last); 		 // prev: visit���� last�� ������ ������ 
					
					for (int v = 0; v < N; v++)				 // prev�� ���Ե� ���� �����ϱ�
					{
						if ((prev & (1 << v)) == 0 || G[v][last]== 0) // v->last ������ ���ų�, visit�� �������̸� ����
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
