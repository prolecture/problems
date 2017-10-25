
public class 부분집합합 {
	public static void main(String[] args) {
		int[] arr = {0, 1, 3, 4};
		int N = 3;
		int sum = 10;
		
		int[][] memo = new int[N + 1][sum + 1];
		
		// 0열 
		for(int i = 0; i <= N; i++) memo[i][0] = 1;
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= sum; j++) {
				if(j < arr[i])
					memo[i][j] = memo[i - 1][j];
				else
					memo[i][j] = memo[i - 1][j] | memo[i - 1][j - arr[i]];
			}
		}
		//------------------------------------------------------
		System.out.print("   ");
		for(int i = 0; i <= sum; i++)
				System.out.printf("%2d ", i);
		System.out.printf("\n---------------------------------------\n");
		for(int i = 0; i <= N; i++) {
			System.out.printf("%2d|", arr[i]);
			for(int j = 0; j <= sum; j++) {
				System.out.printf("%2d ", memo[i][j]);
			}
			System.out.println();
		}
	}
}
