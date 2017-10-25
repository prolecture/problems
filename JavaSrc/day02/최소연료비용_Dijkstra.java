import java.util.*;

public class 최소연료비용_Dijkstra {
	static int N;								// 크기
	static int[][] G = new int[1001][1001];		// 지도 저장
	static int[][] D = new int[1001][1001];		// 최단 거리 저장	
	static int[] dx = new int[]{0, 0, 1, -1};
	static int[] dy = new int[]{1, -1, 0, 0};
	
	// 우선 순위 큐에 저장할 객체
	private static class Vertex implements Comparable<Vertex> {
		int x, y, d; 		// (x, y):좌표, d:거리
		Vertex(int a, int b, int c){
			x = a; y = b; d = c; 
		}		
		public int compareTo(Vertex o) {
			return d - o.d;
		}				
	}
	static PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>();
	
	static void edgeRelaxation(int x, int y)	// 간선 완화
	{
		for(int i = 0; i < 4; i++)
		{
			int tx = x + dx[i]; 
			int ty = y + dy[i];
			if(tx < 0 || tx == N || ty < 0 || ty == N) continue;
			
			int w = G[tx][ty] - G[x][y];
			w = w < 0 ? 1: w + 1;
			
			if(D[tx][ty] > D[x][y] + w)
			{
				D[tx][ty] = D[x][y] + w;
				Q.add(new Vertex(tx, ty, D[tx][ty]));
			}
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();		
		
		for(int tc = 1; tc <= T; tc++)
		{
			N = sc.nextInt();		// 지도 크기
			for(int i = 0; i < N; i++) {				
				for(int j = 0; j < N; j++) {
					G[i][j] = sc.nextInt();
					D[i][j] = 0xffffff;
				}
			}
			D[0][0] = 0;			
			Q.add(new Vertex(0, 0, 0));			
			
			while(!Q.isEmpty()){
				
				Vertex cur = Q.poll();				
				
				edgeRelaxation(cur.x, cur.y); // 간선 완화
			}			
			System.out.printf("#%d %d\n", tc, D[N-1][N-1]);
		}
		
		sc.close();
	}
}
