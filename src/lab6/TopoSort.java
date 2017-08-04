package lab6;

import java.util.Map;
import java.util.Set;
import lab6.DFS_Sort;
import lab6.Graph;

public class TopoSort {
	public static void main(String[] args){
		Graph graph = new Graph();
		Set<Node> nodeSet = graph.getNodeSet();
		Map<Node, Node[]> edgeMap = graph.getAdj();

		Node node0 = new Node("Java Or C++");
		nodeSet.add(node0);
		Node node1 = new Node("Web Application");
		nodeSet.add(node1);
		Node node2 = new Node("Internship");
		nodeSet.add(node2);
		Node node3 = new Node("All Courses");
		nodeSet.add(node3);
		Node node4 = new Node("Thesis");
		nodeSet.add(node4);
		Node node5 = new Node("Object Oriented Programming");
		nodeSet.add(node5);
		Node node6 = new Node("Database");
		nodeSet.add(node6);
		Node node7 = new Node("Data Structure and algorithm");
		nodeSet.add(node7);
		Node node8 = new Node("SoftWare Engineering");
		nodeSet.add(node8);
		Node node9 = new Node("Computer Systems");
		nodeSet.add(node9);
		Node node10 = new Node("Computer Architecture");
		nodeSet.add(node10);
		Node node11 = new Node("Caculus");
		nodeSet.add(node11);
		Node node12 = new Node("Project Management");
		nodeSet.add(node12);
		Node node13 = new Node("Computer Network");
		nodeSet.add(node13);
		Node node14 = new Node("Probability and Statistics");
		nodeSet.add(node14);
		Node node15 = new Node("Intelligent Systems");
		nodeSet.add(node15);
		Node node16 = new Node("Discrete Mathematics");
		nodeSet.add(node16);
		
		

		edgeMap.put(node0, new Node[] { node1,node5,node7 });
		edgeMap.put(node1, new Node[] { });
		edgeMap.put(node2, new Node[] { node4 });
		edgeMap.put(node3, new Node[] { node2,node4 });
		edgeMap.put(node4, new Node[] { });
		edgeMap.put(node5, new Node[] { node1,node8 });
		edgeMap.put(node6, new Node[] { node1,node8 });
		edgeMap.put(node7, new Node[] { node8,node15 });
		edgeMap.put(node8, new Node[] { node12,node15 });
		edgeMap.put(node9, new Node[] { node8,node10,node13 });
		edgeMap.put(node10, new Node[] {  });
		edgeMap.put(node11, new Node[] { node10,node14 });
		edgeMap.put(node12, new Node[] { });
		edgeMap.put(node13, new Node[] { node8 });
		edgeMap.put(node14, new Node[] { node15,node7 });
		edgeMap.put(node15, new Node[] {});
		edgeMap.put(node16, new Node[] { node15 });
		
		
		
		graph.setNodeSet(nodeSet);
		graph.setAdj(edgeMap);
	
//	调用拓扑排序算法
	topologicSort(graph);
	}
	
	
//	拓扑排序算法
	public static void topologicSort(Graph graph){
//		访问深度优先搜索
		Node[] sortedNodes = DFS_Sort.DFS(graph);
//		打印搜索结果
		DFS_Sort.printNode(sortedNodes);
//		用quickSort对节点按照完成时间排序
		Node[] re = quickSort(sortedNodes, 0, sortedNodes.length);
		System.out.println("\n\n拓扑排序的顺序是：");
		for(Node x:re){
			System.out.println(x.getName());
		}
	}
	
	
//	利用改进过后的quicksort方法对数组排序；
	public static Node[] quickSort(Node[] A, int p , int r){
		if (p<r){
			int q = partition(A, p ,r);
//			递归调用quickSort
			quickSort(A, p, q);
			quickSort(A, q+1, r);
		}
		return A;
	}
	
//	partition 过程将一个长数组划分为两部分
	public static int partition(Node[] A, int p, int r){
		int x = A[r-1].getF();
		int i = p-1;
		for(int j=p; j<r-1; j++){
//			当A[j]<=x的时候
			if(A[j].getF()>=x){
//				交换A[i]和A[j]的值
				i = i + 1;
				Node temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
//		交换A[i+1]和A[r]的值
		Node temp = A[i+1];
		A[i+1] = A[r-1];
		A[r-1] = temp;
		return i+1;
	}
	
}
