package Snake;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 * 工具类
 * 
 * @author 紫风铃
 * @version 1.2
 * @since 1.0
 */
public class Tools {
	static Random random = new Random();

	/**
	 * 根据传入节点的方向值及位置，创建新的节点
	 * 
	 * @param currentNode
	 *            当前节点对象
	 * @param direction
	 *            要创建的node节点在currentNode节点的方位
	 * @return 创建的node对象
	 */
	public static Node createNextNode(Node currentNode, int direction) {
		int x = currentNode.getX();
		int y = currentNode.getY();
		Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
		Node node;
		switch (direction) {
		case KeyEvent.VK_UP:
			node = new Node(x, y - Constant.getNodeLength(), color);
			break;
		case KeyEvent.VK_DOWN:
			node = new Node(x, y + Constant.getNodeLength(), color);
			break;
		case KeyEvent.VK_LEFT:
			node = new Node(x - Constant.getNodeLength(), y, color);
			break;
		case KeyEvent.VK_RIGHT:
			node = new Node(x + Constant.getNodeLength(), y, color);
			break;
		default:
			node = null;
			break;
		}
		return node;
	}

	/**
	 * 创建随机节点，包含x,y,color参数
	 * 
	 * @return 创建的node对象
	 */
	public static Node createRandomNode() {
		int x = random.nextInt(Constant.getVerticalNodeNum()) * Constant.getNodeLength();
		int y = random.nextInt(Constant.getHorizontalNodeNum()) * Constant.getNodeLength();
		// 创建随机颜色
		Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
		return new Node(x, y, color);
	}

	/**
	 * list中包含node的位置
	 * 
	 * @param list
	 *            node列表
	 * @param node
	 *            节点
	 * @return true ： node在list列表内
	 */
	public static Node containNode(LinkedList<Node> list, Node node) {
		Iterator<Node> iterator = list.iterator();
		while (iterator.hasNext()) {
			Node node2 = iterator.next();
			if (node2.equals(node)) {
				return node2;
			}
		}
		return null;
	}

	/**
	 * 节点是否在边界内的判别
	 * 
	 * @param node
	 *            节点
	 * @return true ：node在边界范围内
	 */
	public static boolean withinBorder(Node node) {
		if (node.getX() >= 0 && node.getX() <= (Constant.getWidth() - Constant.getNodeLength()) && node.getY() >= 0
				&& node.getY() <= (Constant.getHeight() - Constant.getNodeLength())) {
			return true;// node在屏幕范围内返回true
		} else {
			return false;
		}
	}

	/**
	 * 检测node是否正好到达边界
	 * 
	 * @param node
	 * @return node到达边界返回true
	 */
	public static boolean arriveBorder(Node node) {
		if (node.getX() == 0 || node.getX() == (Constant.getWidth() - Constant.getNodeLength()) || node.getY() == 0
				|| node.getY() == (Constant.getHeight() - Constant.getNodeLength())) {
			return true;// node到达边界返回true
		} else {
			return false;
		}
	}

	/**
	 * 检测当前前进方向的下一个节点是否存在其他物体，例如food、墙
	 * 
	 * @param node
	 *            当前节点
	 * @param direction
	 *            当前前进方向
	 * @param list
	 *            下一个节点可能存在的对象所属列表
	 * 
	 * @return 若下一个节点存在其他物体，则将其对象node返回,否则返回null
	 */
	public static Node nextNodeStatus(Node node, int direction, LinkedList<Node> list) {
		Node node2 = createNextNode(node, direction);
		if (node2 != null) {
			return containNode(list, node2);
		} else {
			return null;
		}
	}

	/**
	 * 节点方向判别
	 * 
	 * @param node
	 *            当前节点
	 * @param nextNode
	 *            下一个节点
	 * @return nextNode在node的那个方位
	 */
	public static int determineDirection(Node node, Node nextNode) {
		if (node.getX() < nextNode.getX()) {
			return KeyEvent.VK_RIGHT;// nextNode在当前node右边
		} else if (node.getX() > nextNode.getX()) {
			return KeyEvent.VK_LEFT;// nextNode在左边
		} else if (node.getY() < nextNode.getY()) {
			return KeyEvent.VK_DOWN;// nextNode在下边
		} else if (node.getY() > nextNode.getY()) {
			return KeyEvent.VK_UP;// nextNode在上边
		} else {
			return 0;
		}
	}
}
