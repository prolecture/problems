import java.util.*;

public class �ּҿ���Һ�_BFS {
	static int N;								// �� ũ��
	static int[][] G = new int[1001][1001];		// �� ����
	static int[][] D = new int[1001][1001];		// �Ÿ�	
	static int[] dx = new int[]{0, 0, 1, -1};
	static int[] dy = new int[]{1, -1, 0, 0};
	
	// ť�� ����Ǵ� ����
	private static class Vertex {
		int x, y; 		// (x, y)��ǥ
		Vertex(int _x, int _y){
			x = _x; y = _y; 
		}				
	}
	static Queue<Vertex> Q = new LinkedList<Vertex>();
	
	static void edgeRelaxation(int x, int y)	// ���� ��ȭ
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
				Q.add(new Vertex(tx, ty));
			}
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();		// �Է¼�
		
		for(int tc = 1; tc <= T; tc++)
		{
			N = sc.nextInt();		// �� ũ��
			for(int i = 0; i < N; i++) {				
				for(int j = 0; j < N; j++) {
					G[i][j] = sc.nextInt();
					D[i][j] = 0xffffff;
				}
			}
			D[0][0] = 0;			
			Q.add(new Vertex(0, 0));			
			
			while(!Q.isEmpty()){
				
				Vertex cur = Q.poll();				
				//if(cur.x == N - 1 && cur.y == N - 1) break;
				
				edgeRelaxation(cur.x, cur.y);
			}			
			System.out.printf("#%d %d\n", tc, D[N-1][N-1]);
		}
		
		sc.close();
	}
}
