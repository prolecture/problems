import java.util.Scanner;

public class 팩토리얼 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++){
			int N = sc.nextInt();
			int D = sc.nextInt();
			long[] memo = new long[N + 1];
			memo[0] = memo[1] =1;
			for(int i = 2; i <= N; i++)
				memo[i] = (memo[i - 1] * i) % D;
			System.out.printf("#%d %d\n", tc, memo[N]);
		}
		sc.close();
	}
}
