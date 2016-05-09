/*
 * Author : Vaibhav Jindal
 * Description:Read the names and grades of students and plot the graph 
 * */
 
import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.*;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Graph extends JFrame {
	static Container c;
	static JPanel p, p1, p2,p3,p4;
	public Graph(String applicationTitle , String chartTitle){
		super("STUDENT PERFORMANCE");
	setSize(1800,1000);
	
	JFreeChart barChart = ChartFactory.createBarChart(
	         chartTitle,
	         "Students","Grades",
	         createDataset(),
	         PlotOrientation.VERTICAL,
	         true,true,false);
	 JFreeChart lineChart = ChartFactory.createLineChart(
	    	  chartTitle,
	    	  "Students","Grades",
	    	  createDataset(),
	    	  PlotOrientation.VERTICAL,
	    	  true,true,false);	
	 
	c = getContentPane();
	 p = new JPanel();
	 p3 = new JPanel();
	 p4 = new JPanel();
	 p1 = new ChartPanel( lineChart );
	 p2 = new ChartPanel( barChart );

p.setLayout(new GridLayout(2,2));

	
	JButton b = new JButton("LineChart");
	p.add(b);
	b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			c.remove(p2);
			c.revalidate();
			c.repaint();
			c.remove(p4);
			c.add(p1, BorderLayout.CENTER);
			
		}
	});
	b = new JButton("BarChart");
	p.add(b);
	b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			c.remove(p1);
			c.remove(p4);
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
			c.add(p4,BorderLayout.CENTER);
			p4.setLayout(new GridLayout(1,2));
			p4.add(p1, BorderLayout.CENTER);
			p4.add(p2, BorderLayout.CENTER);
			
		}
	});
	
	b = new JButton("Exit");
	p.add(b);
	b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
	
	c.add(p, BorderLayout.WEST);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
	 private DefaultCategoryDataset createDataset( )
	   {
		 DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
		 //DefaultCategorySeries series1 = new DefaultCategorySeries("test 1");
		 String series1 = "TEST 1";
		 String series2 = "PASSING marks";
		   
		 //--------------------------------------------
		try{
			Scanner inFile = new Scanner(new FileReader("data.txt"));
			Scanner inFile2 = new Scanner(new FileReader("data2.txt"));
		
			while (inFile != null && inFile2!= null)
			{
				//Read Name & idNumber from inputgpa file
				String Name = inFile.nextLine(); // student name in file
				int idNumber = inFile.nextInt(); //student ID number
				
				String Name2 = inFile2.nextLine(); // student name in file
				int idNumber2 = inFile2.nextInt(); //student ID number
		 //------------------------------------------------
	      
	      dataset.addValue( idNumber , series1 , Name );
	      dataset.addValue( idNumber2 , series2 , Name2 );
			}
		} catch (Exception e1) 
		{}
	      return dataset;
			
	   }
	 
public static void main(String[] a) {
	new Graph("Grade Vs Students" ,
		      "Grades Vs Students");
	//Window2 w = new Window2();
	//System.out.println(w.getCourseID());
	}
}
