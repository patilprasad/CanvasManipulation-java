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
//import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart_AWT extends JFrame 		
{
   public LineChart_AWT( String applicationTitle , String chartTitle )		// creates the frame for graph and labels x & y axis
   {
      super(applicationTitle);
      setSize(1000,1000);
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,
         "Years","Number of Schools",
         createDataset(),
         PlotOrientation.VERTICAL,
         true,true,false);
      
      Container c = getContentPane();    
      JPanel p = new ChartPanel( barChart );
      p.setBackground(Color.BLUE);
  	  //p.setLayout(new GridLayout(3,3));
  	  JButton b = new JButton("LineChart");
  	  c.add(b, BorderLayout.WEST);
  	  c.add(p, BorderLayout.CENTER);
  	  setVisible(true);
  	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      //setContentPane( chartPanel );
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
   public static void main( String[ ] args ) 
   {
      LineChart_AWT chart = new LineChart_AWT(
      "School Vs Years" ,
      "Numer of Schools vs years");

      //chart.pack( );
     // RefineryUtilities.centerFrameOnScreen( chart );
      //chart.setVisible( true );
   }
}