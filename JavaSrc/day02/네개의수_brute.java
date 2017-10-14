import java.util.*;

public class 네개의수_brute {
	static int cnt;
	static int[] a;
	static void perm(int k, int sum){
		if(sum > a[3]) return;
		if(sum == a[3]) {
			cnt++; return;
		}
		for(int i = 0; i < 3; i++){
			perm(k + 1, sum + a[i]);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();		// 입력수		
		for(int tc = 1; tc <= T; tc++)
		{
			a = new int[4];
			for(int i = 0; i < 4; i++)
				a[i] = sc.nextInt();
			
			cnt = 0;
			perm(0, 0);
			
			System.out.printf("#%d %d\n", tc, cnt);
		}
		sc.close();
	}

}
