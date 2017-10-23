import java.util.Scanner;

public class 구간합구하기 {
	static int MAXN = 100000;
	static int N, M;
	static int[] arr = new int[MAXN];
	static int[] sum = new int[MAXN];	// sum[i] = [0, i] 구간합 저장
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++){
			N = sc.nextInt();
			M = sc.nextInt();			
			
			for(int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			
			sum[0] = arr[0];
			for(int i = 1; i < N; i++)
				sum[i] = sum[i - 1] + arr[i];
			
			int max = 0;
			for(int i = 0; i < M; i++) {
				int l = sc.nextInt();
				int r = sc.nextInt();
				if(l == 0)
					max = Math.max(max, sum[r]);
				else
					max = Math.max(max, sum[r] - sum[l - 1]);
			}
			System.out.printf("#%d %d\n", tc, max);
		}
		sc.close();
	}	
}
