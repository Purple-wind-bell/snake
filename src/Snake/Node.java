package Snake;

import java.awt.Color;

/**
 * 节点类
 * 
 * @author 紫风铃
 * @version 1.1
 */
public class Node {
	/** 横坐标 */
	private int x;
	/** 纵坐标 */
	private int y;
	/** 节点颜色 */
	private Color color;
	/** 节点方向 */
	private int nextNodeDirection;

	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Node(int x, int y, int nextNodeDirection) {
		super();
		this.x = x;
		this.y = y;
		this.nextNodeDirection = nextNodeDirection;
	}

	public Node(int x, int y, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public Node(int x, int y, Color color, int nextNodeDirection) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
		this.nextNodeDirection = nextNodeDirection;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Color getColor() {
		return color;
	}

	public int getnextNodeDirection() {
		return nextNodeDirection;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setNextNodeDirection(int nextNodeDirection) {
		this.nextNodeDirection = nextNodeDirection;
	}

	/**
	 * 节点位置相同的判别方法
	 * 
	 * @Override
	 * @param obj
	 *            传入的node节点
	 * @return true: 节点位置相同
	 */
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Node) {
			Node temp = (Node) obj;
			if (temp.getX() == this.x && temp.getY() == this.y) {
				return true;
			}
		}
		return false;
	}
}
