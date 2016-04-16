/**
 * @author : vaibhav
 */
package canvas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window extends JFrame implements Graph {
	private WindowLink graphSelect;
	public Window(){					// this method creates the window for the canvas adding 3 buttons for now for accessing graphs
		super("Canvas by Vaibhav");
	setSize(800,600);
	Container c = getContentPane();
	JPanel p = new JPanel();
	p.setBackground(Color.BLUE);
	p.setLayout(new GridLayout(3,1));
	
	JButton b = new JButton("LineChart");
	p.add(b);
	b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			graphSelect.setMode(new LineChartMode());	
		}
	});
	b = new JButton("BarChart");
	p.add(b);
	b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		}
	});
	b = new JButton("PieChart");
	p.add(b);
	b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		}
	});
	
	c.add(p, BorderLayout.WEST);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public static void main(String[] a) {
	new Window();
	}
}
