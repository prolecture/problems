// 교재의 방법으로 계산
import java.util.Scanner;
public class 건너뛰기1 {
	static int[][] MAP;
	static long[][] memo;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++){
			int N = sc.nextInt();
			int M = sc.nextInt();
			MAP =  new int[N][M];
			memo =  new long[N][M];
			for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				MAP[i][j] = sc.nextInt();
			
			memo[0][0] = 1;
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < M; j++)
				{
					// 왼쪽에서 오는 경우
					for(int k = 0; k < j; k++) {
						if(MAP[i][k] == j - k)
							memo[i][j] += memo[i][k];
					}
					// 위에서 오는 경우
					for(int k = 0; k < i; k++) {
						if(MAP[k][j] == i - k)
							memo[i][j] += memo[k][j];
					}
				}
			}
			System.out.printf("#%d %d\n", tc, memo[N - 1][M - 1]);
		}
		sc.close();
	}		
}
