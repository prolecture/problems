import java.util.*;

public class ¿µ¿ªÇÕ {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++){
			int N = sc.nextInt();
			
			
			int[][] arr = new int[N + 1][N + 1];
			int[][] sum = new int[N + 1][N + 1];
			
			int k = 0;
			for(int i = 1; i <= N; i++){
				for(int j = 1; j <= N; j++)
				{
					arr[i][j] = ((k++) % 10) + 1;
					sum[i][j] = arr[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
				}
			}
			int ans = 0;
			for(int cnt = 0; cnt < N; cnt++)
			{
				int i = sc.nextInt();
				int j = sc.nextInt();
				int x = sc.nextInt();
				int y = sc.nextInt();
				ans += sum[x][y] - sum[x][j - 1] - sum[i - 1][y] + sum[i - 1][j - 1];
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
		sc.close();
	}

}
