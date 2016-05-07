/**
 * @author : vaibhav
 */
package canvas2;

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
	public Graph(String applicationTitle , String chartTitle){
		super("Stevens Canvas");
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

p.setLayout(new GridLayout(2,2));

	
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
	
	b = new JButton("Exit");
	p.add(b);
	
	c.add(p, BorderLayout.WEST);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
	 private DefaultCategoryDataset createDataset( )
	   {
		 DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
		 //DefaultCategorySeries series1 = new DefaultCategorySeries("test 1");
		 String series1 = "Java";
		 String series2 = "PHP";
		   
		 //--------------------------------------------
		try{
			Scanner inFile = new Scanner(new FileReader("src/data.txt"));
			Scanner inFile2 = new Scanner(new FileReader("src/data2.txt"));
		
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
		      "Grades Vs Stdents");
	}
}

