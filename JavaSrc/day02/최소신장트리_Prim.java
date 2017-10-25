import java.util.*;
public class 최소신장트리_Prim {	
	static int[][] G;			// 인접 행렬
	static boolean[] visited;	// 트리에 포함된 정점들 표시
	static int[] D;				// 간선의 가중치 저장
	static int[] P; 			// 최소 신장 트리 저장(간선 정보 저장)	
	static int V, E;			// 정점수, 간선수
	
	public static int mstPrim(int s)	//  s: 시작점
	{									// MST 가중치 반환 
		for(int i = 0; i <= V; i++)	{
			D[i] = 0xfffff;
			P[i] = i;
		}
		D[s] = 0;	// 시작점 D[] 초기화
				
		int cnt = V, cost = 0;
		
		while(cnt-- >= 0) // 정점수 V + 1
		{
			// 현재까지 생성된 트리에서 가장 가까운 정점 가져오기
			int v = 0, min = 0xfffffff;
			for(int i = 0; i <= V; i++)	{
				if(visited[i] == false && min > D[i]){
					v = i; 
					min = D[i]; 
				}
			}
			visited[v] = true;		// 정점 v가 트리에 포함됨.			
			cost += D[v];				
			// v의 인접정점들에 대해서 계산
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
			V = sc.nextInt();	// 정점 번호 = 0 ~ V까지
			E = sc.nextInt();
			
			// 필요한 저장 공간 생성 
			G = new int[V + 1][V + 1];
			visited = new boolean[V + 1];
			D = new int[V + 1];
			P = new int[V + 1];
			// 가중치가 부여된 무향 그래프
			int u, v, w;		// 간선(u,v), 가중치 w
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
