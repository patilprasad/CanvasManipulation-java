/**
 * @author : vaibhav
 */
package canvas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Window extends JFrame {
	public Window(String applicationTitle , String chartTitle){
		super("Canvas by Vaibhav");
	setSize(1800,1000);
	
	JFreeChart barChart = ChartFactory.createBarChart(
	         chartTitle,
	         "Students","Grades",
	         createDataset(),
	         PlotOrientation.VERTICAL,
	         true,true,false);
	 JFreeChart lineChart = ChartFactory.createLineChart(
	    	  chartTitle,
	    	  "Years","Number of Schools",
	    	  createDataset(),
	    	  PlotOrientation.VERTICAL,
	    	  true,true,false);	
	 
	Container c = getContentPane();
	JPanel p = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p1 = new ChartPanel( lineChart );
	JPanel p2 = new ChartPanel( barChart );
	c.setLayout(new GridLayout(2,2));
	//-----------adding logo------------------
		ImageIcon pic = new ImageIcon("src/S.gif");
		ImageIcon pic2 = new ImageIcon("src/Steves.jpg");
	    c.add(new JLabel(pic),BorderLayout.NORTH );
	    c.add(new JLabel(pic2),BorderLayout.NORTH );
	//-----------------------------------------
		 
	p.setBackground(Color.BLUE);
	p.setLayout(new GridLayout(4,3));

	
	JButton b = new JButton("LineChart");
	p.add(b);
	b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			c.remove(p2);
			c.revalidate();
			c.repaint();
			c.add(p1, BorderLayout.CENTER);
			
		}
	});
	b = new JButton("BarChart");
	p.add(b);
	b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			c.remove(p1);
			c.revalidate();
			c.repaint();
			c.add(p2, BorderLayout.CENTER);
		}
	});
	
	b = new JButton("Both");
	p.add(b);
	b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			c.remove(p1);
			c.remove(p2);
			c.revalidate();
			c.repaint();
			c.add(p1, BorderLayout.CENTER);
			c.add(p2, BorderLayout.CENTER);
		}
	});
	
	b = new JButton("Logout");
	p.add(b);
	b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			c.removeAll();
			c.revalidate();
			c.add(p3);
		    c.add(new JLabel(pic2),BorderLayout.CENTER );
		}
	});
	
	for (int i=1;i<=8;i++)
	{
	b = new JButton("     ");
	p.add(b);
	}
	c.add(p, BorderLayout.WEST);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
	
	 private DefaultCategoryDataset createDataset( )
	   {
	      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
	      dataset.addValue( 15 , "schools" , "1970" );
	      dataset.addValue( 30 , "schools" , "1980" );
	      dataset.addValue( 60 , "schools" ,  "1990" );
	      dataset.addValue( 100 , "schools" , "2000" );
	      return dataset;
	   }
public static void main(String[] a) {
	new Window("Grade Vs Students" ,
		      "Grades Vs Stdents");
	}
}
