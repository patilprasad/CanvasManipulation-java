/**
 * @author : vaibhav
 */
package canvas2;

import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.*;


public class Window2 extends JFrame {
	private String courseID ;
	private JTextField display;
	
	
	public Window2(String applicationTitle , String chartTitle){
		super("Stevens 2");
	setSize(1800,1000);
	
	JButton b = new JButton("T/TA");
	JButton b1 = new JButton("STUDENT");
	JButton b2 = new JButton("Back");
	JButton b3 = new JButton("REFRESH");
	JButton b4 = new JButton("Logout");
	JButton b5 = new JButton("List COurses");
	JButton b6 = new JButton("Back");
	JButton b7 = new JButton("SUBMIT");
	 
	Container c = getContentPane();
	c.setBackground(Color.YELLOW);
	JPanel p = new JPanel();  // Logo screen
	JPanel p1 = new JPanel(); // logout screen
	JPanel p2 = new JPanel(); // T/TA, STUDENT, REFRESH ,Logout
	JPanel p3 = new JPanel(); // list courses, back
	JPanel p4 = new JPanel(); // List Course expanded-- list and id
	JPanel p5 = new JPanel(); // List Course expanded-- enter id , submit, logout, back
	

	//-----------adding logo------------------
			ImageIcon pic = new ImageIcon("src/S.gif");
			ImageIcon pic2 = new ImageIcon("src/Steves.jpg");
		    p.add(new JLabel(pic),BorderLayout.NORTH );
		    p.add(new JLabel(pic2),BorderLayout.NORTH );
	//-----------------------------------------  
		   
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
						c.revalidate();
						c.repaint();
					}
				});
	 
	 p5.add(b2);
	 p5.add(b4);
	
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
					c.remove(p2);
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
			c.revalidate();
		    c.add(new JLabel(pic2),BorderLayout.CENTER );
		    c.add(p1);
		}
	});

	c.add(p2, BorderLayout.SOUTH);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
}
