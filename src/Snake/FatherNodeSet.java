package Snake;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;

/**
 * 所有node节点的list的父类，提供共有方法
 * 
 * @author 紫风铃
 * @version 1.2
 * @since 1.1
 */
public class FatherNodeSet {
	/** node的list集合 */
	protected LinkedList<Node> List = new LinkedList<>();
	Random random = new Random();

	/**
	 * 创建不在exceptList内且长度为 num 的 LinkedList
	 * 
	 * @param exceptList
	 *            不包含的node
	 * @param num
	 *            节点数
	 * @return 创建成功return LinkedList<Node>
	 */
	protected LinkedList<Node> create(LinkedList<Node> exceptList, int num) {
		LinkedList<Node> tList = new LinkedList<>();
		Node node1 = null;
		Node node2 = null;
		int direction;
		Color color;
		int i = 0;
		// 创建第一个节点
		do {
			node1 = Tools.createRandomNode();
		} while (Tools.containNode(tList, node1) != null || Tools.containNode(exceptList, node1) != null
				|| !Tools.withinBorder(node1));

		while (i < num) {
			color = new Color(random.nextInt(155), random.nextInt(155), random.nextInt(155));
			direction = random.nextInt(4) + KeyEvent.VK_LEFT;
			node2 = Tools.createNextNode(node1, direction);
			if (Tools.containNode(tList, node2) == null && Tools.containNode(exceptList, node2) == null
					&& Tools.withinBorder(node2)) {
				node1.setNextNodeDirection(direction);
				node1.setColor(color);
				tList.add(node1);// 添加
				node1 = node2;
				i++;
			}
		}
		return tList;
	}

	/**
	 * 获得LinkedList对象
	 * 
	 * @return LinkedList<Node>对象
	 */
	protected LinkedList<Node> getList() {
		return List;
	}

	/**
	 * 更新所有节点的方向参数
	 */
	protected void updateDirection() {
		for (int i = 0; i < getListLength() - 1; i++) {
			int dir = Tools.determineDirection(getNode(i), getNode(i + 1));
			getNode(i).setNextNodeDirection(dir);
		}
		if (List.getLast().getnextNodeDirection() == 0) {
			List.getLast().setNextNodeDirection(KeyEvent.VK_RIGHT);
		}
	}

	/**
	 * 获得node节点对象
	 * 
	 * @param index
	 *            集合List的node元素的索引
	 * @return node节点
	 */
	protected Node getNode(int index) {
		return List.get(index);
	}

	/**
	 * 获得对象内List的长度
	 * 
	 * @return List的长度
	 */
	protected int getListLength() {
		return List.size();
	}

}