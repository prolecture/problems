import java.util.*;

public class 집색칠 {
	static int[][] memo;
	static int N;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++){
			int N = sc.nextInt();
			memo = new int[N + 1][3];
			
			
			for(int i = 1; i <= N; i++)
			{
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				
				memo[i][0] = Math.min(memo[i-1][1], memo[i-1][2]) + a;
				memo[i][1] = Math.min(memo[i-1][0], memo[i-1][2]) + b;
				memo[i][2] = Math.min(memo[i-1][0], memo[i-1][1]) + c;
				
			}
			int min = Math.min(memo[N][0], memo[N][1]);
			min = Math.min(min, memo[N][2]);
			
			System.out.printf("#%d %d\n", tc, min);
		}		
		sc.close();
	}
}
