public class 구간트리_구간나누기 {	
	static int[] arr = {3, 9, 4, 2, 7, 8, 10, 1};
	static int N = arr.length;
	static int[] st;
	
	static void build(int id, int l, int r){
		System.out.printf("%2d> (%d, %d)\n", id, l, r);
		if(l == r) return;
		
		int mid = (l + r)/2;
		build(id * 2, l, mid);
		build(id*2 + 1, mid + 1, r);
	}
	public static void main(String[] args){
		int size = 1;
		while(size < N)
			size = size * 2;
		st = new int[size * 2 + 1];
		
		build(1, 0, N - 1);
	}
}
