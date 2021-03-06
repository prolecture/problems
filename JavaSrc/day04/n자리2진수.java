import java.util.*;

public class n자리2진수 {
	static int MAXN = 30;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int[] memo = new int[MAXN + 1];
		memo[1] = 1; 
		memo[2] = 2;		
		for(int i = 3; i <= MAXN; i++)
			memo[i] = memo[i - 1] + memo[i - 2];
		
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++){
			
			int N = sc.nextInt();		
			System.out.printf("#%d %d\n", tc, memo[N]);
		}		
		sc.close();
	}
}
