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
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Window extends JFrame {
	public Window(String applicationTitle , String chartTitle){					// this method creates the window for the canvas adding 3 buttons for now for accessing graphs
		super("Canvas by Vaibhav");
	setSize(800,600);
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
	//-----------adding logo------------------
		ImageIcon pic = new ImageIcon("src/Steves.jpg");
	    p.add(new JLabel(pic));
	    c.add(p,BorderLayout.NORTH );
	    this.pack();
		
		
		//-----------------------------------------
	p.setBackground(Color.BLUE);
	p.setLayout(new GridLayout(2,1));
	
	
	/*
	try{
		BufferedImage myPicture = ImageIO.read(new File("Steves.jpg"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		
		//JLabel imgLabel = new JLabel(new ImageIcon("src/Steves.jpg"));
		//p.add(imgLabel,BorderLayout.NORTH);
		p.add(picLabel,BorderLayout.NORTH);
	} catch (IOException ex) {
        // handle exception...
   }
   */
	
	
	
	JButton b = new JButton("LineChart");
	p.add(b);
	b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JPanel p = new ChartPanel( lineChart );
			c.add(p, BorderLayout.EAST);
	
		}
	});
	b = new JButton("BarChart");
	p.add(b);
	b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JPanel p = new ChartPanel( barChart );
			c.add(p, BorderLayout.CENTER);
			
		}
	});
	/*b = new JButton("PieChart");
	p.add(b);
	b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
		
			
		}
	});
	*/
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
	      dataset.addValue( 120 , "schools" , "2000" );
	      dataset.addValue( 240 , "schools" , "2010" );
	      dataset.addValue( 300 , "schools" , "2014" );
	      return dataset;
	   }
public static void main(String[] a) {
	Window chart= new Window("Grade Vs Students" ,
		      "Grades Vs Stdents");
	}
}
