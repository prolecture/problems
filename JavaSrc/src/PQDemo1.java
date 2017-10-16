import java.util.PriorityQueue;

public class PQDemo1 {
	public static void main(String[] args){
		int[] arr = new int[]{23, 45, 2, 5, 88, 12, 7, 49, 45, 16};
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int val: arr)
			pq.add(val);
		
		while(!pq.isEmpty())
			System.out.println(pq.poll());

	}
}
