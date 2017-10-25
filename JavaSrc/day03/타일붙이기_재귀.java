import java.util.Scanner;

public class 타일붙이기_재귀 {
	static int MAXN = 30;
	static long[] memo = new long[MAXN + 1];
	
	static long tile(int n) {
		if(n < 0) return 0;
		if(n == 0) return 1;
		if(memo[n] != 0) return memo[n];
		
		return memo[n] = tile(n - 1) + 2 * tile(n - 2) + tile(n - 3); 
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();	
		
		for(int tc = 1; tc <= T; tc++)
		{
			int N = sc.nextInt();				
			
			System.out.printf("#%d %d\n", tc, tile(N));
		}
		sc.close();

	}
}
