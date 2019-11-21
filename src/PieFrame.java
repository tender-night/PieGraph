import java.awt.*;
import java.util.Scanner;

public class PieFrame extends Frame {
	Pie p1;
	Pie p2;
	Pie p3;
	Pie p4;
	Graphics a;

	public PieFrame() {
		this.setLayout(new FlowLayout());
		this.setVisible(true);
		this.setSize(1280, 800);
		a = getGraphics();

		p1 = new Pie(200, 200, 100);
		p2 = new Pie(600, 200, 100);
		p3 = new Pie(200, 600, 100);
		p4 = new Pie(600, 600, 100);

		p1.paint(a, p1);
		p2.paint(a, p2);
		p3.paint(a, p3);
		p4.paint(a, p4);
	}

}
