import java.util.*;

public class 최소동전개수_인접리스트 {
	static int N, K;
	static ArrayList<Integer>[] G;	// 인접 리스트
	static int[] in;		// 진입 차수
	static int[] coin;		// 동전 수
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++){
			N = sc.nextInt();
			K = sc.nextInt();
			
			G = new ArrayList[N + 1];
			for(int i = 1; i <= N; i++)
				G[i] = new ArrayList<Integer>();
			in = new int[N + 1];
			coin = new int[N + 1];
			
			for(int i = 0; i < K; i++){
				int u = sc.nextInt();
				int v = sc.nextInt();
				G[u].add(v);
				in[v]++;
			}
			Queue<Integer> Q = new LinkedList<Integer>();
			max = 0;
			for(int i = 1; i <= N; i++){
				if(in[i] == 0) Q.add(i);			
			}
			while(!Q.isEmpty()) {
				int v = Q.poll();
				for(int i: G[v]) {
					if(in[i] != 0) {
						in[i]--;
						if(in[i] == 0) Q.add(i);
						
						coin[i] = Math.max(coin[i], coin[v] + 1);
						max = Math.max(max, coin[i]);
					}
				}
			}
			System.out.printf("#%d %d\n", tc, max + 1);
		}
		sc.close();

	}
}
