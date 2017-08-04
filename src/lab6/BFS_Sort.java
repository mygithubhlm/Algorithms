package lab6;

import java.util.Map;
import java.util.Set;

import lab2.MyQueue;

public class BFS_Sort {
	public static void BFS(Graph g,Node s){
		Set<Node> nodeSet = g.getNodeSet();
		for (Node n : nodeSet) {
			s.setD(20000);
			s.setColor(Color.WHITE);
			s.setParent(null);
		}
		s.setColor(Color.GRAY);
		s.setD(0);
		s.setParent(null);
		MyQueue<Node> Q = new MyQueue<Node>();
		Q.enQueue(s);
		while(Q.size()!=0){
			Node u = Q.deQueue();
			Map<Node, Node[]> nAdj = g.getAdj();
//			得到n的相邻的节点
			Node[] adjOfN = nAdj.get(u);
			for (Node v: adjOfN) {
				if(v.getColor()==Color.WHITE){
					v.setColor(Color.GRAY);
					v.setD(u.getD()+1);
					v.setParent(u);
					Q.enQueue(v);
				}
			}
			u.setColor(Color.BLACK);
		}
	
	}
}
