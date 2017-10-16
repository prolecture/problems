import java.util.*;
public class 오른쪽아래이동 {
	static int[][] MAP = new int[101][101];
	static int[][] D = new int[101][101];
	
	static int matrixPath(int N, int M)
	{
		D[1][1] = MAP[1][1];
		for(int i = 2; i <= N; i++) // 1��
		{
			if(MAP[i][1] != 0 && D[i - 1][1] != 0)
				D[i][1] = D[i - 1][1] + MAP[i][1];
			else D[i][1] = 0;
		}
		for(int i = 2; i <= M; i++) // 1��
		{
			if(MAP[1][i] != 0 && D[1][i - 1] != 0)
				D[1][i] = D[1][i - 1] + MAP[1][i];
			else D[1][i] = 0;
		}
		for(int i = 2; i <= N; i++)	// 2 ~ N
		for(int j = 2; j <= M; j++)	// 2 ~ M
		{
			if(MAP[i][j] == 0) continue;
			
			int left = Integer.MAX_VALUE, up = Integer.MAX_VALUE;
			
			if(D[i][j - 1] != 0)
				left = D[i][j - 1] + MAP[i][j];
			if(D[i - 1][j] != 0)
				up = D[i - 1][j] + MAP[i][j];
			int min = Math.min(left, up);
			if(min == Integer.MAX_VALUE) D[i][j] = 0;
			else D[i][j] = min;
		}
		return D[N][M];
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++){
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			for(int i = 1; i <= N; i++)	// 1 ~ N
			for(int j = 1; j <= M; j++){
				MAP[i][j] = sc.nextInt();				
				D[i][j] = 0;
			}
			System.out.printf("#%d %d\n", tc, matrixPath(N, M));
			//print(N, M);
		}
		sc.close();
	}
	static void print(int N, int M){
		for(int i = 1; i <= N; i++)	// 1 ~ N
		{
			for(int j = 1; j <= M; j++)
				System.out.printf("%2d ", D[i][j]);
			System.out.println();
		}
	}
}
