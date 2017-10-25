import java.util.Scanner;

public class 이항계수 { 
	static int MAXN = 70;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();		
		long[][] memo = new long[MAXN + 1][MAXN + 1];
		
		for(int i = 0; i <= MAXN; i++){
			
			for(int j = 0; j <= i; j++){
				if(j == 0 || i == j) memo[i][j] = 1;
				else memo[i][j] = memo[i-1][j-1] + memo[i-1][j];
			}
		}  
		
		for(int tc = 1; tc <= T; tc++)
		{
			int N = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.printf("#%d %d\n", tc, memo[N][a]);
		}
		sc.close();
	}

}
