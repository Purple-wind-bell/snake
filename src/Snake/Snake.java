package Snake;

import java.util.LinkedList;

/**
 * 蛇类
 * 
 * @author 紫风铃
 * @version 1.2
 * @since 1.0
 */
public class Snake extends FatherNodeSet {
	/** 蛇的前进方向 */
	private int direction;

	/**
	 * 蛇的构造方法
	 * 
	 * @param exceptList
	 *            不能创建蛇的身体的node节点的集合
	 * @param length
	 *            蛇的长度
	 */
	public Snake(LinkedList<Node> exceptList, int length) {
		super();
		List = create(exceptList, length);
		updateDirection();// 更新所有节点方向
	}

	/**
	 * 判别方向direction是否与蛇头指向身体的方向冲突
	 * 
	 * @param direction
	 *            方向
	 * @return true:方向冲突
	 */
	public boolean isDirectionConflict(int direction) {
		// 判断前进方向是否与蛇身冲突
		if (direction == List.getFirst().getnextNodeDirection()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 蛇前进时的节点增删
	 * 
	 * @param exceptList
	 *            不可达的节点，例如墙，注意食物是可达的节点
	 * @return true：蛇节点完成增删
	 */
	public boolean step(LinkedList<Node> exceptList) {
		Node node = Tools.nextNodeStatus(List.getFirst(), this.direction, exceptList);
		if (node == null) {// 下一个节点不在墙内
			node = Tools.createNextNode(List.getFirst(), direction);
			// this.direction = 0;// 自动跑设置，0：不自动跑
			if (node != null && Tools.withinBorder(node)) {
				List.addFirst(node);
				List.removeLast();
				updateDirection();
				return true;
			}
		}
		return false;
	}

	/**
	 * 吃到食物后的加尾巴操作
	 * 
	 * @return true:加尾巴成功
	 */
	public boolean addLastNode() {
		// 根据尾部节点的方向值，创建新的尾部节点
		Node node = Tools.createNextNode(List.getLast(), List.getLast().getnextNodeDirection());
		if (node != null) {
			List.addLast(node);
			updateDirection();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获得蛇的前进方向
	 * 
	 * @return 前进方向
	 */
	public int getdirection() {
		return direction;
	}

	/**
	 * 设置蛇的前进方向
	 * 
	 * @param direction
	 *            前进方向
	 */
	public void setdirection(int direction) {
		this.direction = direction;
	}

}
