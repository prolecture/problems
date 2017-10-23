import java.util.*;

public class 최소동전개수_위상정렬 {
	static int N, K;
	static int[][] G;	// 인접 행렬
	static int[] in;	// 진입 차수
	static int[] coin;	// 동전 수
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++){
			N = sc.nextInt();
			K = sc.nextInt();
			
			G = new int[N + 1][N + 1];
			in = new int[N + 1];
			coin = new int[N + 1];
			
			for(int i = 0; i < K; i++){
				int u = sc.nextInt();
				int v = sc.nextInt();
				G[u][v] = 1;
				in[v]++;
			}
			Queue<Integer> Q = new LinkedList<Integer>();
			max = 0;
			for(int i = 1; i <= N; i++){
				if(in[i] == 0) Q.add(i);			
			}
			while(!Q.isEmpty()) {
				int v = Q.poll();
				for(int i = 1; i <= N; i++) {
					if(G[v][i] == 1 && in[i] != 0) {
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
