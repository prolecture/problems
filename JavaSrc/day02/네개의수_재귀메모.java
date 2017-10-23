import java.util.Scanner;

public class 네개의수_재귀메모 {
	static int[] a = new int[4];
	static int[] memo;
 
	static int makeSum(int n){
		
		if(n == 0) return 1;
		if(memo[n] != 0) return memo[n];
		for(int i = 0; i < 3; i++){
			if(n < a[i]) continue;
			memo[n] += makeSum(n - a[i]);
		}
		return memo[n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();		
		for(int tc = 1; tc <= T; tc++){
			
			for(int i = 0; i < 4; i++)
				a[i] = sc.nextInt();			
			
			memo = new int[a[3] + 1];
			
			System.out.printf("#%d %d\n", tc, makeSum(a[3]));
		}
		sc.close();
	}
}
