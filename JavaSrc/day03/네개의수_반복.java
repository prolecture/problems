import java.util.Scanner;

public class 네개의수_반복 {
	static int[] a = new int[4];
	static int[] memo;
 
	static int makeSum(int n){
		
		memo[0] = 1;
		
		for(int sum = 1; sum <= n; sum++) {
			for(int i = 0; i < 3; i++){
				if(sum < a[i]) continue;
				memo[sum] += memo[sum - a[i]];
			}
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
