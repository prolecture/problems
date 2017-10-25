import java.util.Scanner;

public class 오른쪽아래이동_재귀 {
	static int[][] MAP = new int[101][101];
	static int[][] D = new int[101][101];
	
	static int matrixPath(int N, int M)
	{
		if(N == 1 && M == 1) return MAP[1][1];		
		if(D[N][M] != -1) return D[N][M];
		if(MAP[N][M] == 0) return D[N][M] = 0;
		
		int left = 0, up = 0;
		if(N != 1) 
			up = matrixPath(N - 1, M);
		if(M != 1) 
			left = matrixPath(N, M - 1);
		
		if(up == 0 && left == 0)
			return D[N][M] = 0;
		
		if(up == 0) D[N][M] = left + MAP[N][M];
		else if(left == 0) D[N][M] = up + MAP[N][M];
		else D[N][M] = Math.min(up, left) + MAP[N][M];
		
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
				D[i][j] = -1;
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
