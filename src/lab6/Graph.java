package lab6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
	
//	节点的集合
	private Set<Node> nodeSet = new HashSet<Node>();
//	节点的相邻节点集合
	private Map<Node, Node[]> adj = new HashMap<Node, Node[]>();
	
//	get和set方法
	public Set<Node> getNodeSet() {
		return nodeSet;
	}
	public void setNodeSet(Set<Node> nodeSet) {
		this.nodeSet = nodeSet;
	}
	public Map<Node, Node[]> getAdj() {
		return adj;
	}
	public void setAdj(Map<Node, Node[]> adj) {
		this.adj = adj;
	}
	
}

//节点类
class Node{
	private String name;  
	private Color color;  
	private Node parent;  

//	发现时间
	private int d;
//	完成时间
	private int f;
	
//	get和set方法
	public Node(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}
	
}

//颜色
enum Color{
	WHITE,GRAY,BLACK;
}