/**
 * @author : vaibhav
 */
package canvas2;

import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.*;

import javax.swing.*;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class Window2 extends JFrame {
	private String courseID ;
	private String AssignID ;
	private JTextField display;
	
	
	public Window2(String applicationTitle , String chartTitle){
		super("Stevens 2");
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
	
	JButton b = new JButton("Teacher/TA");
	JButton b1 = new JButton("STUDENT");
	JButton b2 = new JButton("Back to course list");
	JButton b3 = new JButton("REFRESH");
	JButton b4 = new JButton("Logout");
	JButton b5 = new JButton("List COurses");
	JButton b6 = new JButton("Back to main");
	JButton b7 = new JButton("SUBMIT");
	JButton b8 = new JButton("Login");
	JButton b9 = new JButton("List Students");
	JButton b10 = new JButton("List Assignments");
	JButton b11 = new JButton("Change Date");
	JButton b12 = new JButton("Get Grades");
	JButton b13 = new JButton("Runtime");
	JButton b14 = new JButton("Back to Submitting courseID");
	JButton b15 = new JButton("SUBMIT Assignment ID");
	JButton b16 = new JButton("Back to Course");
	JButton b17 = new JButton("Line Graph");
	JButton b18 = new JButton("Bar Graph");
	JButton b19 = new JButton("Back to Submit Assignment ID");
	JButton b20 = new JButton("Both Graph");
	
	 
	Container c = getContentPane();
	//c.setBackground(Color.YELLOW);
	JPanel p = new JPanel();  // Logo screen
	JPanel p1 = new JPanel(); // logout screen
	JPanel p2 = new JPanel(); // T/TA, STUDENT, REFRESH ,Logout
	JPanel p3 = new JPanel(); // list courses, back
	JPanel p4 = new JPanel(); // List Course expanded-- list and id
	JPanel p5 = new JPanel(); // List Course expanded-- enter id , submit, logout, back
	JPanel p6 = new JPanel(); //ls,ls,cd,gg,runtime
	JPanel p7 = new JPanel(); //get grade
	JPanel p8 = new JPanel(); // get grade buttons
	JPanel p9 = new JPanel(); // graph list
	JPanel p10 = new JPanel();
	JPanel p11 = new ChartPanel( lineChart );
	JPanel p12 = new ChartPanel( barChart );
	

	//-----------adding logo------------------
			ImageIcon pic = new ImageIcon("src/S.gif");
			ImageIcon pic2 = new ImageIcon("src/Steves.jpg");
		    p.add(new JLabel(pic),BorderLayout.NORTH );
		    p.add(new JLabel(pic2),BorderLayout.NORTH );
	//-----------------------------------------
		    p9.setLayout(new GridLayout(2,2));
		    p9.add(b17);
		    b17.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					c.revalidate();
					c.repaint();
					c.remove(p9);
					c.remove(p);
					c.setLayout(new BorderLayout());
					//Container c = getContentPane();
					JButton b = new JButton("Back");
					b.setPreferredSize(new Dimension(50,1000));
					c.add(b,BorderLayout.EAST);
					JButton b1 = new JButton("Exit");
					b1.setPreferredSize(new Dimension(50,1000));
					c.add(b1,BorderLayout.EAST);
					
					p11.setPreferredSize(new Dimension(1600, 1000));
					c.add(p11, BorderLayout.WEST);
					
					
				}
			});
		    p9.add(b18);
		    b18.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					c.remove(p9);
					c.remove(p);
					c.setLayout(new BorderLayout());
					JButton b = new JButton("Back");
					c.add(b,BorderLayout.EAST);
					b.setPreferredSize(new Dimension(50,1000));
					
					b = new JButton("Exit");
					c.add(b,BorderLayout.EAST);
					b.setPreferredSize(new Dimension(50,1000));
					
					c.revalidate();
					c.repaint();
					c.add(p12, BorderLayout.WEST);
				}
			});
		    p9.add(b20);
		    b20.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					c.remove(p9);
					c.remove(p);
					c.setLayout(new GridLayout(1,1));
					c.add(p12, BorderLayout.CENTER);
					c.add(p11, BorderLayout.CENTER);
					JButton b = new JButton("Back");
					c.add(b,BorderLayout.WEST);
					b = new JButton("Exit");
					c.add(b,BorderLayout.WEST);
					c.revalidate();
					c.repaint();
					
				}
			});
		    p9.add(b19);
		    
		    p8.setLayout(new GridLayout(3,1));
		    p7.setLayout(new GridLayout(1,2));
		    display = new JTextField("assignment list and their ids to be ");
			 display.setEditable(false);
			 p7.add(display);
		    display = new JTextField("Enter Assignment ID");
			 display.addFocusListener(new FocusListener() {
				 public void focusGained(FocusEvent e) 
				 {
				   display.setText("");
				 }
			     public void focusLost(FocusEvent e) { }
			 });
			 p8.add(display);
			 p8.add(b15);
			 b15.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setAssignID(display.getText());
						c.remove(p7);
						c.add(p9);
						p9.setPreferredSize(new Dimension(1700, 1000));
						c.revalidate();
						c.repaint();
							}

					
						});
			 p8.add(b16);
			 p7.add(p8);
	//---------p6------------------
		    p6.setLayout(new GridLayout(2,3));
		    p6.add(b9);
		    p6.add(b10);
		    p6.add(b11);
		    p6.add(b12);
		    b12.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				c.remove(p6);
				c.add(p7);
				c.revalidate();
				c.repaint();
						}
					});
		    
		    p6.add(b13);
		    b13.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try 
					{
						runProcess("javac -cp *; test.java");
						runProcess("java -cp *; test");
					} 
					catch (Exception e1) 
					{
						e1.printStackTrace();
					}
				}
			});
		    p6.add(b14);
		    b14.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				c.remove(p6);
				c.add(p4);
				c.revalidate();
				c.repaint();
						}
					});
		    
		    
		    
	//-----------------------------	    
		   
		    p5.setLayout(new GridLayout(3,1));
		    
	//-------------panel p4----------------------
	p4.setLayout(new GridLayout(1,2));
	 display = new JTextField("course list and their ids to be ");
	 display.setEditable(false);
	 p4.add(display);
	 
	
	 display = new JTextField("Enter Course ID");
	 display.addFocusListener(new FocusListener() {
		 public void focusGained(FocusEvent e) 
		 {
		   display.setText("");
		 }
	     public void focusLost(FocusEvent e) { }
	 });
	 p5.add(display);
	 p5.add(b7);
	 b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//c.remove(p4);
			setCourseID(display.getText());
				//System.out.print(courseID);
			c.remove(p4);
			c.add(p6);
			
						c.revalidate();
						c.repaint();
					}
				});
	 
	 p5.add(b2);
	 b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.remove(p4);
				c.add(p3);
				c.revalidate();
				c.repaint();
			}
		});
	 p4.add(p5);
			
			
		    
	//-------------------------------------------	    
	
	
	c.setLayout(new GridLayout(2,1));
    p.setLayout(new GridLayout(1,2));
	c.add(p, BorderLayout.NORTH);
	p2.setBackground(Color.BLUE);
	p2.setLayout(new GridLayout(2,2));
	p2.add(b);
	b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			c.remove(p2);
			
			p3.setLayout(new GridLayout(2,1));
			p3.add(b5);
			b5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					c.remove(p3);
					c.add(p4);
					c.revalidate();
					c.repaint();
				}
			});
			
			
			p3.add(b6);
			b6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					c.remove(p3);
					c.add(p2);
					c.revalidate();
					c.repaint();
				}
			});
			c.revalidate();
			c.repaint();
			c.add(p3, BorderLayout.CENTER);
			}
		});
	p2.add(b1);
	b1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			c.removeAll();
			c.revalidate();
		    c.add(new JLabel(pic2),BorderLayout.CENTER );
		    c.add(p1);
		}
	});

	p2.add(b3);
	b3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			c.removeAll();
			c.revalidate();
		    c.add(new JLabel(pic2),BorderLayout.CENTER );
		    c.add(p1);
		}
	});
	
	
	p2.add(b4);
	b4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			c.removeAll();
			
		    c.add(new JLabel(pic2),BorderLayout.CENTER );;
		    p1.add(b8,BorderLayout.SOUTH);
		    b8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					c.remove(p1);
					c.removeAll();
					c.add(p);
					c.add(p2);
					c.revalidate();
					c.repaint();
				}
			});
		    
		    c.add(p1);
		    c.revalidate();
		    c.repaint();
		}
	});

	c.add(p2, BorderLayout.SOUTH);
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
	     // dataset.addValue( 30 , "grades" , "1980" );
	     // dataset.addValue( 60 , "grades" ,  "1990" );
	      //dataset.addValue( 100 , "grades" , "2000" );
			}
		 
		 
		} catch (Exception e1) 
		{
			
		}
	      return dataset;
			
	   }
	
	public static void runProcess(String command) throws Exception 
	{
	    Process pro = Runtime.getRuntime().exec(command);
	    pro.waitFor();
	}
	
public static void main(String[] a) {
	new Window2("Grade Vs Students" ,
		      "Grades Vs Stdents");
	}

public String getCourseID() {
	return courseID;
}

public void setCourseID(String courseID) {
	this.courseID = courseID;
}

public void setAssignID(String courseID) {
	this.AssignID = AssignID;
}

public String getAssignID() {
	return AssignID;
}
}