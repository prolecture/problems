
public class 구간트리_단일값갱신 { 
	static int[] arr = {3, 9, 4, 2, 7, 8, 10, 1};
	static int N = arr.length;
	static int[] st;
	
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
		int size = getSize();		
		st = new int[size];
		build(1, 0, N - 1);
		update(1, 0, N - 1, 4, 3); 	// arr[4] <= 3
		System.out.println(query(1, 0, N - 1, 0, 5));
		System.out.println(query(1, 0, N - 1, 3, 8));
	}
}
