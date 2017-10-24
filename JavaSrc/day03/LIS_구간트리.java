import java.util.Scanner;

public class LIS_구간트리 {
	static int MAXN = 1000;
	static int N, M;
	static int[] arr = new int[MAXN + 1];	
	static int[] st;
	
	// 구간 최대 값 저장하기, 최초 모두 0으로 저장된 상태	
	// [s, e]: 쿼리 구간
	static int query(int id, int l, int r, int s, int e){
    	if(s <= l && r <= e) return st[id];
    	if(r < s || e < l) return 0;
    	int mid = (l + r)/2;
    	return Math.max(query(id*2, l, mid, s, e), query(id*2+1, mid + 1, r, s, e)); 
    }
	// p: 갱신할 자료의 인덱스, v: 갱신값
	static void update(int id, int l, int r, int p, int v){
    	if( p < l || r < p) return;
    	
    	st[id] = Math.max(st[id], v);
    	
    	if(l == r) return;
    	
    	int mid = (l + r)/2;
    	update(id*2, l, mid, p, v);
    	update(id*2 + 1, mid+1, r, p, v);
    }
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++){
			N = sc.nextInt();
			st = new int[N * 4];
			int max = 0;
			for(int i = 1; i <= N; i++) {
				arr[i] = sc.nextInt();
				int len = query(1, 1, N, 1, arr[i] - 1);			
				update(1, 1, N, arr[i], len + 1);
				max = Math.max(max, len + 1);
			}			
			System.out.printf("#%d %d\n", tc, max);
		}
		sc.close();
	}
}
