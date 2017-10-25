import java.util.Scanner;

public class LIS_Binary {
	static int MAXN = 1000;
	static int N;
	static int[] arr = new int[MAXN];
	static int[] LIS = new int[MAXN];
	static int[] C = new int[MAXN + 1];
	// C[] 배열에 대한 이진 탐색
	static int binarySearch(int lo, int hi, int key) {
		if(lo > hi) return lo;
				
		int mid = (lo + hi) / 2;
		if(C[mid] == key) return mid;
		else if(C[mid] < key) return binarySearch(mid + 1, hi, key);
		else return binarySearch(lo, mid - 1, key);
		
	}
	static int lower_bound(int lo, int hi, int key) {
		hi = hi + 1;
		while(lo < hi) {
			int mid = (lo + hi) / 2;
			
			if(C[mid] < key) lo = mid + 1; 
			else hi = mid;
		}
		return lo;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int T = sc.nextInt();			
		
		for(int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt();			
			int max = 0;
			C[0] = Integer.MIN_VALUE;
			int end = 0, pos = 0; 
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();				
				pos = binarySearch(0, end, arr[i]);				
				C[pos] = arr[i];
				LIS[i] = pos;				
				if(pos > end) end = pos;
				max = Math.max(max, LIS[i]);
			}						
			System.out.printf("#%d %d\n", tc, max);
		}
		sc.close();
	}
}
