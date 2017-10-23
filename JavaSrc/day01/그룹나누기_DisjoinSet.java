import java.util.Scanner;

// 
public class 그룹나누기_DisjoinSet {
	static int[] p;
	static int[] r;
	static int size;
	static int N, M;
	
	static void makeSet(){
		size = N;
		p = new int[N + 1];
		r = new int[N + 1];
		for(int i = 1; i <= N; i++)
			p[i] = i;
	}
	static int findSet(int x){
		if(x != p[x]) p[x] = findSet(p[x]);		
		return p[x];
	}
	static void union(int x, int y){
		int a = findSet(x);
		int b = findSet(y);
		if(a == b) return;
		
		size--;	// 그룹(집합)수 감소
		
		if(r[a] > r[b])
			p[b] = a;
		else{
			p[a] = b;
			if(r[a] == r[b])
				r[b]++;
		}
	}
	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++){
			N = sc.nextInt();
			M = sc.nextInt();
			makeSet();
			for(int i = 0; i < M; i++){
				int u = sc.nextInt();
				int v = sc.nextInt();
				union(u, v);
			}
			System.out.printf("#%d %d\n", tc, size);
		}
		sc.close();
	}	
}
