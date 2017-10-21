import java.util.*;

public class LIS_DP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();		// 테스트 케이스 수	
		for(int tc = 1; tc <= T; tc++)
		{
			int N = sc.nextInt();
			int[] arr = new int[N];
			int[] LIS = new int[N];
			int max = 0;
			for(int i = 0; i < N; i++){
				arr[i] = sc.nextInt();
				LIS[i] = 1;
			}			
			for(int i = 0; i < N; i++){
				for(int j = 0; j < i; j++){
					if(arr[i] > arr[j] && LIS[i] < LIS[j] + 1)
						LIS[i] = LIS[j] + 1;
				}
				max = Math.max(max, LIS[i]);
			}			
			System.out.printf("#%d %d\n", tc, max);
		}
		sc.close();
	}

}
