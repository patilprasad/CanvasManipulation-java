/**
 * @author : vaibhav
 */
//package canvas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Window_new extends JFrame {
	static Container c;
	static JPanel p, p1, p2, p3;
	static ImageIcon pic, pic2;
	public Window_new(String applicationTitle , String chartTitle){
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
	 
	c = getContentPane();
	p = new JPanel();
	p3 = new JPanel();
	p1 = new ChartPanel( lineChart );
	p2 = new ChartPanel( barChart );
	c.setLayout(new GridLayout(2,2));
	//-----------adding logo------------------
		pic = new ImageIcon("S.gif");
		pic2 = new ImageIcon("Steves.jpg");
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

	b = new JButton("Assignments");
	p.add(b);
	b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try 
			{
				runProcess("javac -cp *: test.java");
				runProcess("java -cp *: test");
			} 
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
	});
	
	b = new JButton("Logout");
	p.add(b);
	b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			c.removeAll();
			c.revalidate();
		    c.add(new JLabel(pic2),BorderLayout.CENTER );
		    c.add(p3);
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

	 public static void runProcess(String command) throws Exception 
		{
		    Process pro = Runtime.getRuntime().exec(command);
		    pro.waitFor();
		}

public static void main(String[] a) {
	new Window_new("Grade Vs Students" ,
		      "Grades Vs Stdents");
	}
}
