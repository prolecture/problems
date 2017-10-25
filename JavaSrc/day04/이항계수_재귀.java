import java.util.Scanner;

public class 이항계수_재귀 {
	static int MAXN = 70;
	static long[][] memo = new long[MAXN + 1][MAXN + 1];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++)
		{
			int N = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.printf("#%d %d\n", tc, bino(N, a));
		}
		sc.close();
	}
	static long bino(int n, int r) {
		if(r == 0 || n == r) return 1;
		if(memo[n][r] != 0) return memo[n][r];
		
		memo[n][r] = bino(n - 1, r - 1) + bino(n - 1, r);
		return memo[n][r];
	}
}
