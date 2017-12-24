package Snake;

import java.util.LinkedList;

/**
 * 墙类
 * 
 * @author 紫风铃
 * @version 1.2
 * @since 1.0
 */
public class Walls extends FatherNodeSet {

	/**
	 * 墙的构造方法
	 * 
	 * @param wallNum
	 *            墙的数量
	 * @param brickNum
	 *            每块墙的砖的数量
	 */
	public Walls(int wallNum, int brickNum) {
		super();
		LinkedList<Node> exceptList = new LinkedList<Node>();
		LinkedList<Node> linkedList = new LinkedList<Node>();
		// 创建墙，设置墙的数目与每面墙的砖数
		for (int i = 0; i < wallNum; i++) {
			linkedList = create(exceptList, brickNum);
			List.addAll(linkedList);
		}
	}

}
