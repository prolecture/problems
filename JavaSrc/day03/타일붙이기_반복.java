import java.util.*;

public class 타일붙이기_반복 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();		// 입력수
		long[] memo = new long[31];
		memo[1] = 1; memo[2] = 3; 
		memo[3] = 6;
		
		for(int i = 4; i <= 30; i++)
			memo[i] = memo[i-1] + memo[i-2]*2 + memo[i-3];
		
		for(int tc = 1; tc <= T; tc++)
		{
			int N = sc.nextInt();
				
			
			System.out.printf("#%d %d\n", tc, memo[N]);
		}
		sc.close();

	}

}
