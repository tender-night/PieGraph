import java.awt.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Pie {
	int x, y, d;

	Pie(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;

	}

	void drawFillArc(Graphics a, int sarc, int earc, int r, int g, int b) {
		a.setColor(new Color(r, g, b));
		a.fillArc(x, y, d, d, sarc, earc);// 填充颜色
	}

	void drawArcBorder(Graphics a) {
		a.setColor(Color.black);
		a.drawOval(x, y, d, d);// 画边框
	}

	void drawLegend(Graphics a, int r, int g, int b, int i, String s, int everyamount, int totalamount) {
		double percentage;
		percentage = (double) (everyamount * 100) / totalamount;
		DecimalFormat df = new DecimalFormat("#.00");
		a.setColor(new Color(r, g, b));
		a.fillRect(x + d + d / 4, y + i * d / 8, d / 8, d / 16);
		a.drawString(s + ":" + df.format(percentage) + "%", x + d + d / 4 + d / 8 + d / 16, y + d / 16 + i * d / 8);// 画图例
	}

	public void paint(Graphics a, Pie p) {
		int totalamount = 0;
		int everyamount[] = new int[20];// 定义数组用来存放每一项项目的数量
		Scanner input = new Scanner(System.in);
		int angle;
		int sumangle = 0;
		int r = 0, g = 0, b = 0;
		int i;
		String item[] = new String[20];// 定义数组来存放图例中每一个项目的名称

		System.out.println("Do you want to draw the legend?'1' stands for yes and '0' stands for no.");
		// 询问用户是否需要绘制图例
		if (input.nextInt() == 1) {// 如需绘制则进入此段代码
			System.out.println("Please input every amount of item and the name of it which you want to draw");
			System.out.println("If you have finished, please input '-1' to end");
			// 让用户输入每一个项目的数量及对应名称
			for (i = 0; i < 10; i++) {
				everyamount[i] = input.nextInt();

				if (everyamount[i] == -1) {
					everyamount[i] = 0;
					break;
				}
				item[i] = input.next();
				totalamount += everyamount[i];
			}

			for (i = 0; i < 10; i++) {
				angle = (everyamount[i] * 360) / totalamount;
				if (everyamount[i] == 0) {
					p.drawFillArc(a, sumangle, 360 - sumangle, r, g, b);
					break;
				}
				r = (int) (Math.random() * 256);
				g = (int) (Math.random() * 256);
				b = (int) (Math.random() * 256);// 用于随机生成颜色
				p.drawFillArc(a, sumangle, angle, r, g, b);// 绘制扇形

				p.drawLegend(a, r, g, b, i, item[i], everyamount[i], totalamount);// 绘制图例
				sumangle += angle;

				if (sumangle > 360) {
					System.out.println("The sum of angels has beyond 360 degree, please check your input.");
					break;
				}
			}
		} else {// 若不需要绘制图例则进入此段代码
			System.out.println("Please input every amount of things you wnat to draw");
			System.out.println("If you have finished, please input '-1' to end");

			for (i = 0; i < 10; i++) {
				everyamount[i] = input.nextInt();
				if (everyamount[i] == -1) {
					everyamount[i] = 0;
					break;
				}
				totalamount += everyamount[i];
			}

			for (i = 0; i < 10; i++) {
				angle = (everyamount[i] * 360) / totalamount;
				if (everyamount[i] == 0) {
					p.drawFillArc(a, sumangle, 360 - sumangle, r, g, b);
					break;
				}
				r = (int) (Math.random() * 256);
				g = (int) (Math.random() * 256);
				b = (int) (Math.random() * 256);
				p.drawFillArc(a, sumangle, angle, r, g, b);
				sumangle += angle;

				if (sumangle > 360) {
					System.out.println("The sum of angels has beyond 360 degree, please check your input.");
					break;
				}
			}
		}

		System.out.println("Do you want to draw border of the pie?'1' stands for yes and '0' stands for no.");
		// 询问用户是否需要绘制扇形的边界
		if (input.nextInt() == 1) {
			p.drawArcBorder(a);
		}
	}
}
