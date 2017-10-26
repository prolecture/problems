// 2차 배열 행우선 순회로 계산
import java.util.Scanner;

public class 건너뛰기2 {
	
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
					if(memo[i][j] == 0) continue;
					if(i + MAP[i][j] < N)
						memo[i + MAP[i][j]][j] += memo[i][j];
					if(j + MAP[i][j] < M)
						memo[i][j + MAP[i][j]] += memo[i][j];
				}
			}
			System.out.printf("#%d %d\n", tc, memo[N - 1][M - 1]);
		}		
		sc.close();
	}
}
