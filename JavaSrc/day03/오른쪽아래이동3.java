import java.util.Scanner;
public class 오른쪽아래이동3 {
	static int[][] MAP = new int[101][101];
	static int[][] D = new int[101][101];
	
	static int matrixPath(int N, int M)
	{
		for(int i = 1; i <= M; i++) // 1행
			D[1][i] = D[1][i - 1] + MAP[1][i];
		for(int i = 1; i <= N; i++) // 1열
			D[i][1] = D[i - 1][1] + MAP[i][1];		
		
		for(int i = 2; i <= N; i++)	// 2 ~ N
		for(int j = 2; j <= M; j++)	// 2 ~ M
		{
			D[i][j] = (D[i][j - 1] + MAP[i][j]) < (D[i - 1][j] + MAP[i][j]) ? 
					(D[i][j - 1] + MAP[i][j]) : (D[i - 1][j] + MAP[i][j]);
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
			for(int j = 1; j <= M; j++)
				MAP[i][j] = sc.nextInt();				
	
			System.out.printf("#%d %2d\n", tc, matrixPath(N, M));
		}
		sc.close();
	}
}
