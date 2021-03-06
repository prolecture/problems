import java.util.*;

public class 최소동전개수_DFS {
	static int N, K;
	static int[][] G;	// 인접 행렬
	static int[] in;	// 진입 차수
	static int[] D;		// 시작점에서 최장 거리 저장
	static int max;
	
	static void DFS(int v){		
		for(int i = 1; i <= N; i++){
			if(G[v][i] == 1 && D[i] < D[v] + 1) {
				D[i] = D[v] + 1;
				max = Math.max(max, D[i]);
				DFS(i);
			}
		}
	}
	static void DFS(int v, int h){
		max = Math.max(max, h);
		for(int i = 1; i <= N; i++){
			if(G[v][i] == 1)
				DFS(i, h + 1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++){
			N = sc.nextInt();
			K = sc.nextInt();
			
			G = new int[N + 1][N + 1];
			in = new int[N + 1];
			D = new int[N + 1];
			
			for(int i = 0; i < K; i++){
				int u = sc.nextInt();
				int v = sc.nextInt();
				G[u][v] = 1;
				in[v]++;
			}
			max = 0;
			for(int i = 1; i <= N; i++){
				if(in[i] == 0)
					//DFS(i, 0);
					DFS(i);
			}
			System.out.printf("#%d %d\n", tc, max + 1);
		}
		sc.close();

	}

}
