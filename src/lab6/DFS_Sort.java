package lab6;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import lab6.Graph;

public class DFS_Sort {
	static int time = 0;
	
	public static Node[] DFS(Graph g){
		Set<Node> nodeSet = g.getNodeSet();
		if(nodeSet.size()<2){
			return nodeSet.toArray(new Node[0]);
		}
		for (Node s : nodeSet) {
			s.setColor(Color.WHITE);
			s.setParent(null);
		}
		LinkedList<Node> result = new LinkedList<Node>();
		for(Node n : nodeSet){
			if(n.getColor()==Color.WHITE){
				DFSvisit(g,n,result);
			}
		}
//		System.out.println("size: "+result.size());
		return result.toArray(new Node[0]);
	}
	
	public static void DFSvisit(Graph g,Node n,LinkedList<Node> result){
		time+=1;
		n.setD(time);
		n.setColor(Color.GRAY);
//		Map<K, V> adj = g.getAdj();
		Map<Node, Node[]> nAdj = g.getAdj();
//		得到n的相邻的节点
		Node[] adjOfN = nAdj.get(n);
//		System.out.println("lengthOfadj"+adjOfN.length);
		if(adjOfN!=null&&adjOfN.length>0){
			for(Node x: adjOfN){
//				System.out.println("sabi");
				if (x.getColor()==Color.WHITE) {
					x.setParent(n);
					DFSvisit(g, x, result);
				}
			}
		}
		n.setColor(Color.BLACK);
		time+=1;
		n.setF(time);
		result.addLast(n);
	}

	public static void main(String[] args) {
		Graph graph = new Graph();
		Set<Node> NodeSet = graph.getNodeSet();
		Map<Node, Node[]> edgeMap = graph.getAdj();

		Node twoNode = new Node("2");
		Node threeNode = new Node("3");
		Node fiveNode = new Node("5");
		Node sevenNode = new Node("7");
		Node eightNode = new Node("8");
		Node nineNode = new Node("9");
		Node tenNode = new Node("10");
		Node elevenNode = new Node("11");

		NodeSet.add(twoNode);
		NodeSet.add(threeNode);
		NodeSet.add(fiveNode);
		NodeSet.add(sevenNode);
		NodeSet.add(eightNode);
		NodeSet.add(nineNode);
		NodeSet.add(tenNode);
		NodeSet.add(elevenNode);

		edgeMap.put(twoNode, new Node[] { elevenNode });
		edgeMap.put(nineNode, new Node[] { elevenNode, eightNode });
		edgeMap.put(tenNode, new Node[] { elevenNode, threeNode });
		edgeMap.put(elevenNode, new Node[] { sevenNode, fiveNode });
		edgeMap.put(eightNode, new Node[] { sevenNode, threeNode });
		
		graph.setNodeSet(NodeSet);
		graph.setAdj(edgeMap);
		
		Node[] sortedNodes = DFS(graph);
//		System.out.println("sdffasdsafdsa");
//		System.out.println("nodesize:"+graph.getNodeSet().size());
		printNode(sortedNodes);
	}

	public static void printNode(Node[] nodes) {
//		System.out.println("sdffasdsafdsa  faxian"+nodes.length);
		for (Node node : nodes) {
//			System.out.println("sdffasdsafdsa"+node.getD()+"　　faxian");
			System.out.println(node.getName() + "  discover time:"
					+ node.getD() + "  finish time:"
					+ node.getF());
		}
	}
	
}
