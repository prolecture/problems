import java.util.Scanner;

public class 오른쪽아래이동3_재귀 {
	static int[][] MAP = new int[101][101];
	static int[][] D = new int[101][101];
	
	static int matrixPath(int N, int M)
	{
		if(N == 1 && M == 1) return MAP[1][1];
		if(D[N][M] != 0) return D[N][M];
		
		int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
		if(M != 1)
			a = matrixPath(N, M - 1) + MAP[N][M];
		if(N != 1)
			b = matrixPath(N - 1, M) + MAP[N][M];
		
		return D[N][M] = Math.min(a, b);
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++){
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			for(int i = 1; i <= N; i++)	// 1 ~ N
			for(int j = 1; j <= M; j++) {
				MAP[i][j] = sc.nextInt();
				D[i][j] = 0;
			}
			System.out.printf("#%d %2d\n", tc, matrixPath(N, M));
		}
		sc.close();
	}
}
