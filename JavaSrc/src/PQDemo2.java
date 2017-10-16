import java.util.*;

public class PQDemo2 {

	private static class Edge{
		int u, v, key;
		Edge(int a, int b, int c){
			u = a; v = b; key = c;
		}
		public String toString(){
			return "(" + u +" " + v + ", " + key + ")\n";			
		}
	}
	public static Comparator<Edge> edgeComparator = new Comparator<Edge>(){
		public int compare(Edge arg0, Edge arg1) {
			//return arg0.key - arg1.key;
			return arg1.key - arg0.key;			
		}
	};
	public static void main(String[] args)
	{
		PriorityQueue<Edge> prq = new PriorityQueue<Edge>(edgeComparator);		
		prq.add(new Edge(1,2,3));
		prq.add(new Edge(2,3,7));
		prq.add(new Edge(2,4,9));
		prq.add(new Edge(1,3,6));
		prq.add(new Edge(1,4,5));
		prq.add(new Edge(3,4,7));
		
		while(!prq.isEmpty())
		{
			System.out.print(prq.poll());
		}		
	}
}
