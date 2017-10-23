import java.util.Scanner;

public class 구간합구하기_구간트리 {
	static int MAXN = 100000;
	static int N, M;
	static int[] arr = new int[MAXN];	
	static int[] st = new int[MAXN * 4];
	
	static void build(int id, int l, int r){		
		if(l == r) {
			st[id] = arr[l]; return;		
		}		
		int mid = (l + r)/2;
		build(id * 2, l, mid);
		build(id*2 + 1, mid + 1, r);
		
		st[id] = st[id*2] + st[id*2 + 1]; 
	}
	// [s, e]: 쿼리 구간
	static int query(int id, int l, int r, int s, int e){
		
		if(s <= l && r <= e) return st[id];
		if(r < s || e < l) return 0;
		
		int mid = (l + r)/2;
		return query(id * 2, l, mid, s, e) +  query(id*2 + 1, mid + 1, r, s, e);
	}
	// p: 갱신할 자료의 인덱스, v: 갱신값
	static void update(int id, int l, int r, int p, int v){
		
		if(r < p || p < l) return;
		if(p <= l && r <= p) {
			st[id] = v; return;
		}
		int mid = (l + r)/2;
		update(id * 2, l, mid, p, v);
		update(id*2 + 1, mid + 1, r, p, v);
		st[id] = st[id*2] + st[id*2 + 1];
	}
	static int getSize(){
		int size = 1;
		while(size < N)
			size = size <<= 1;
		size <<= 1;
		return size + 1;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++){
			N = sc.nextInt();
			M = sc.nextInt();			
			
			for(int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			
			build(1, 0, N - 1);
			int max = 0;
			for(int i = 0; i < M; i++) {
				int l = sc.nextInt();
				int r = sc.nextInt();				
				max = Math.max(max, query(1, 0, N - 1, l, r));				
			}
			System.out.printf("#%d %d\n", tc, max);
		}
		sc.close();
	}
}
