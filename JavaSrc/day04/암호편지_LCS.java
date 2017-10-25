import java.util.Scanner;

public class 암호편지_LCS {
	static String today = "today";
	static String tomorrow = "tomorrow";
	
	static int LCS(String x, String y) { 
		int m = x.length();
		int n = y.length();
		int[][] memo = new int[m + 1][n + 1];
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(x.charAt(i - 1) == y.charAt(j - 1))
					memo[i][j] = memo[i - 1][j - 1] + 1;
				else
					memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
			}
		}
		return memo[m][n];
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++){
			String str = sc.next();
			if(LCS(str, today) == today.length())
				System.out.printf("#%d today\n", tc);
			else if(LCS(str, tomorrow) == tomorrow.length())
				System.out.printf("#%d tomorrow\n", tc);
			else
				System.out.printf("#%d none\n", tc);
		
		}
		sc.close();
	}

}
