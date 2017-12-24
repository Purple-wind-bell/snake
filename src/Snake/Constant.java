package Snake;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * 常量类，存储各类常量
 * 
 * @author 紫风铃
 * @version 1.1
 */
public final class Constant {
	/** 节点长度，指节点的边长 */
	private static int nodeLength = 30;
	/** 蛇的节点数量 */
	private static int snakeNodeNum = 3;
	/** 食物数量 */
	private static int foodNum = 10;
	/** 墙的数量 */
	private static int WallNum = 3;
	/** 每面墙砖的数量 */
	private static int BrickNum = 5;
	/** 屏幕高 */
	private static int height = 900;
	/** 屏幕宽 */
	private static int width = 900;
	/** 纵横方格数目 */
	private static int horizontalNodeNum;
	private static int verticalNodeNum;
	/** 背景图片对象 */
	private static BufferedImage bgImage;

	/**
	 * 读取背景图片，设置显示边框的大小
	 */
	static {
		try {
			bgImage = ImageIO.read(new FileInputStream("src/img/bg.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		width = dim.width;
		height = dim.height;
		nodeLength = height / 15;
		horizontalNodeNum = height / nodeLength;
		verticalNodeNum = width / nodeLength;
	}

	/**
	 * 获得蛇节点的初始长度
	 * 
	 * @return 蛇节点初始长度
	 */
	public static int getSnakeNodeNum() {
		return snakeNodeNum;
	}

	/**
	 * 获得食物数量
	 * 
	 * @return 食物数量
	 */
	public static int getFoodNum() {
		return foodNum;
	}

	/**
	 * 获得墙的数量
	 * 
	 * @return 墙的数量
	 */
	public static int getWallNum() {
		return WallNum;
	}

	/**
	 * 获得砖的数量
	 * 
	 * @return 砖数
	 */
	public static int getBrickNum() {
		return BrickNum;
	}

	/**
	 * 获得每个节点的大小
	 * 
	 * @return 节点边长
	 */
	public static int getNodeLength() {
		return nodeLength;
	}

	/**
	 * 获得显示屏幕的宽度
	 * 
	 * @return 屏幕宽度
	 */
	public static int getWidth() {
		return width;
	}

	/**
	 * 获得显示屏幕的高度
	 * 
	 * @return 屏幕高度
	 */
	public static int getHeight() {
		return height;
	}

	/**
	 * 获得绘制网格时的水平线的数目
	 * 
	 * @return 水平线数目
	 */
	public static int getHorizontalNodeNum() {
		return horizontalNodeNum;
	}

	/**
	 * 获得绘制网格时的垂直线的数目
	 * 
	 * @return 垂直线数目
	 */
	public static int getVerticalNodeNum() {
		return verticalNodeNum;
	}

	/**
	 * 获得背景图片
	 * 
	 * @return 背景图片对象
	 */
	public static BufferedImage getBgImage() {
		return bgImage;
	}

}
