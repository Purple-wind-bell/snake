package Snake;

import java.util.LinkedList;

/**
 * 食物类
 * 
 * @version 1.2
 * @since 1.1
 * @author 紫风铃
 */
public class Food extends FatherNodeSet {

	/**
	 * 食物list构造方法
	 * 
	 * @param exceptList
	 *            不可以创建食物的node节点的list
	 * @param num
	 *            要创建的食物的数量
	 */
	public Food(LinkedList<Node> exceptList, int num) {
		refresh(exceptList, num);
	}

	/**
	 * 食物节点是否为空的判别
	 * 
	 * @return true: 食物节点为空，即没有食物
	 */
	public boolean isEmpty() {
		return List.isEmpty();
	}

	/**
	 * 食物刷新
	 * 
	 * @param exceptList
	 *            不可以创建食物的node节点的list
	 * @param num
	 *            要创建的食物的数量
	 * @return true:食物刷新成功
	 */
	public boolean refresh(LinkedList<Node> exceptList, int num) {
		List.clear();
		LinkedList<Node> linkedList = new LinkedList<Node>();
		for (int i = 0; i < num; i++) {
			linkedList = create(exceptList, 1);
			List.addAll(linkedList);
			exceptList.addAll(linkedList);
		}
		return true;
	}

}
