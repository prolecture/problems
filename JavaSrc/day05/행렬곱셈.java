
import java.util.*;

public class Çà·Ä°ö¼À {
		static final int MAXN = 20;	
		static int[] ROWS = new int[MAXN + 1];
		static int[] COLS = new int[MAXN + 1];
		static int[][] memo = new int[MAXN + 1][MAXN + 1];
		static int N;
	
		// Àç±Í + ¸Þ¸ð
		static int multi_memo(int start, int end){			
			
			if (start == end) return 0;
			if (memo[start][end] != -1) return memo[start][end];
			
			int min = Integer.MAX_VALUE;
			for (int i = start; i < end; i++)
			{
				int l= multi_memo(start, i);
				int r = multi_memo(i + 1, end);
				int mid = ROWS[start] * COLS[i] * COLS[end];

				if (min > l + r + mid) min = l + r + mid;
			}
			return memo[start][end] = min;
		}
		// ¹Ýº¹
		static int multi_iter(){
			
			for (int start = N - 1; start >= 0; start--)
			{	
				for (int end = start; end <= N - 1; end++)
				{			
					if (start == end) memo[start][end] = 0;
					else
					{
						int min = Integer.MAX_VALUE;

						for (int i = start; i < end; i++)
						{
					 		int sum = memo[start][i] + memo[i + 1][end] + (ROWS[start] * COLS[i] * COLS[end]);
							if (min > sum) min = sum;
						}
						memo[start][end] = min;
					}
				}
			}
			return memo[0][N - 1];
		}
		public static void main(String[] args)
		{	
		    Scanner sc = new Scanner(System.in);
		    int T = sc.nextInt();
		    for(int tc = 1; tc <= T; tc++)
		    {
			    N = sc.nextInt();
			    boolean ok = true;
			    for(int i = 0; i < N; i++) {
			    	ROWS[i] = sc.nextInt();
			    	COLS[i] = sc.nextInt();			
			    	if(i != 0 && COLS[i - 1] != ROWS[i])
			    		ok = false;
			    }
			    if(ok){
				    // memo[][]¿¡ ÃÊ±â°ª ¼³Á¤
					for(int i = 0; i < N; i++)
						for(int j = 0; j < N; j++)
							memo[i][j] = -1;
				    
					//System.out.printf("#%d %d\n", tc, multi_iter());		
					System.out.printf("#%d %d\n", tc, multi_memo(0, N - 1));
			    }else
			    	System.out.printf("#%d 0\n", tc);
		    }		
		    sc.close();		
		}
	}
