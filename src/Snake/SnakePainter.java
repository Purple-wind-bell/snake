package Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 贪吃蛇本体
 * 
 * @author 紫风铃
 * @version 1.2
 * @since 1.0
 */
public class SnakePainter extends JFrame {
	/** 版本校验 */
	private static final long serialVersionUID = 1L;
	LinkedList<Node> list = new LinkedList<Node>();
	Iterator<Node> iterator;
	Node firstNode;
	Walls walls;
	Snake snake;
	Food food;

	{
		walls = new Walls(Constant.getWallNum(), Constant.getBrickNum());
		list.addAll(walls.getList());
		snake = new Snake(list, Constant.getSnakeNodeNum());
		list.addAll(snake.getList());
		food = new Food(list, Constant.getFoodNum());
	}

	/**
	 * 所有node节点的刷新以及重绘
	 */
	public void print() {
		Painter move = new Painter();
		this.add(move);

		/**
		 * 线程监听及所有节点的更新处理
		 */
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {// 蛇是否前进进行判断
					if (!snake.isDirectionConflict(snake.getForwardDirection())) {
						snake.step(walls.getList());// 蛇去尾加头
					}

					iterator = food.getList().iterator();
					firstNode = snake.getList().getFirst();
					while (iterator.hasNext()) {// 遍历查找所有食物，确定是否与蛇的头部重合
						Node node = iterator.next();
						if (firstNode.equals(node)) {
							snake.addLastNode();// 由于之前的移动中已经删除尾部节点，所有重新加一个尾部节点
							iterator.remove();// 删除被吃的食物
						}
					}

					// 重新刷新食物
					if (food.isEmpty()) {
						list.clear();
						list.addAll(walls.getList());
						list.addAll(snake.getList());
						food.refresh(list, Constant.getFoodNum());// 刷新所有食物
					}

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					repaint();
				}
			}
		}).start();

		/**
		 * 鼠标点击事件，判断是否退出
		 */
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				switch (e.getButton()) {
				case 1:
					@SuppressWarnings("unused")
					int key = JOptionPane.showConfirmDialog(null, "是否继续？");
					// 0 是 1否 取消2 关闭-1
					break;
				case 3:
					System.exit(0);
					break;
				default:
					break;
				}
			}
		});

		/**
		 * 键盘移动事件监听，判别移动方向
		 */
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				snake.setForwardDirection(e.getKeyCode());
			}
		});

		// 6.定义窗体
		this.setUndecorated(true);
		this.setVisible(true);// 边框可见
		this.setResizable(true);
		this.setSize(Constant.getWidth(), Constant.getHeight());// 窗体大小
		this.setTitle("贪吃蛇");
		this.setLocation(0, 0);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@SuppressWarnings("serial")
	/**
	 * 绘制所有node节点
	 * 
	 * @author 紫风铃
	 *
	 */
	class Painter extends JPanel {
		public void paint(Graphics graphics) {
			super.paint(graphics);
			// 背景
			ImageIcon Image = new ImageIcon(getClass().getResource("/img/bg.jpg"));
			graphics.drawImage(Image.getImage(), 0, 0, Constant.getWidth(), Constant.getHeight(), null);

			// 画出横线
			for (int i = 0; i <= Constant.getHorizontalNodeNum(); i++) {
				graphics.drawLine(0, i * Constant.getNodeLength(), Constant.getWidth(), i * Constant.getNodeLength());
			}

			// 画出竖线
			for (int i = 0; i <= Constant.getVerticalNodeNum(); i++) {
				graphics.drawLine(i * Constant.getNodeLength(), 0, i * Constant.getNodeLength(), Constant.getHeight());
			}

			// 画墙
			for (int i = 0; i < Constant.getBrickNum() * Constant.getWallNum(); i++) {
				graphics.setColor(Color.BLACK);
				graphics.fillRect(walls.getNode(i).getX(), walls.getNode(i).getY(), Constant.getNodeLength(),
						Constant.getNodeLength());
			}

			// 画食物
			for (int i = 0; i < food.getListLength(); i++) {
				graphics.setColor(food.getNode(i).getColor());
				graphics.fillOval(food.getNode(i).getX(), food.getNode(i).getY(), Constant.getNodeLength(),
						Constant.getNodeLength());
			}

			// 方法一
			for (int i = 0; i < snake.getListLength(); i++) {
				graphics.setColor(snake.getNode(i).getColor());
				graphics.fillOval(snake.getNode(i).getX(), snake.getNode(i).getY(), Constant.getNodeLength(),
						Constant.getNodeLength());
			}
		}
	}
}
