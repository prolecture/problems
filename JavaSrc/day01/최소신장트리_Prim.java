import java.util.*;

public class �ּҽ���Ʈ��_Prim {
	
	static int[][] G;			// ���� ���
	static boolean[] visited;	// Ʈ���� ���Ե� ������ ǥ��
	static int[] D;				// ������ ����ġ ����
	static int[] P; 			// �ּ� ���� Ʈ�� ����(���� ���� ����)	
	static int V, E;			// ������ ������ȣ, ������	
	
	public static int mstPrim(int s)	//  s: ������
	{									// MST ����ġ�� ��ȯ 
		for(int i = 0; i <= V; i++)
		{
			D[i] = 0xfffff;
			P[i] = i;
		}
		D[s] = 0;	// ������ D[] �ʱ�ȭ
				
		int cnt = V, cost = 0;
		while(cnt-- >= 0)
		{
			// Ʈ�� ������ �����߿��� D[]�� �ּ��� ���� ã��
			int v = 0, min = 0xfffffff;
			for(int i = 0; i <= V; i++)
			{
				if(visited[i] == false && min > D[i])
				{
					v = i; 
					min = D[i]; 
				}
			}
			visited[v] = true;		// ���� v�� Ʈ���� ���Ե�.			
			cost += D[v];				
			
			for(int i = 0; i <= V; i++)
			{
				if(G[v][i] != 0 && visited[i] == false && G[v][i] < D[i])
				{
					D[i] = G[v][i];
					P[i] = v;					
				}
			}
		}
		return cost;
	}	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++){
			V = sc.nextInt();
			E = sc.nextInt();
			
			// �ʿ��� ���� ���� ���� 
			G = new int[V + 1][V + 1];
			visited = new boolean[V + 1];
			D = new int[V + 1];
			P = new int[V + 1];
			
			int u, v, w;		// ����(u,v), ����ġ w
			for(int i = 0; i < E; i++)
			{
				u = sc.nextInt();
				v = sc.nextInt();
				w = sc.nextInt();				
				G[u][v] = G[v][u] = w;
			}
			
			System.out.printf("#%d %d\n", tc, mstPrim(0));
		}
		sc.close();		
	}	
}
