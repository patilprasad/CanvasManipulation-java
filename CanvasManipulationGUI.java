/*
 * Author: Vaibhav Jindal
 * Contributer 1: Rohit Kulkarni
 * Contributer 2: Prasad Patil
 * 
 *  
 *  Description: This is the main GUI to the Stevens Canvas that we attempted to redesign. This is a Work in 
 *  			 progress and will be improved over time. Most of the features add are functioning and some that
 *  			 are not is because we are not authorized by Canvas API to do that.
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;

public class CanvasManipulationGUI extends JFrame {
	public CanvasManipulationGUI() {
	}

	private static String courseID;
	private static String AssignID;
	private JTextField display;
	private JTextField display_run;
	private JTextField display_course;
	private JTextField display_grph;
	private JTextArea textarea;
	private JList student_list;
	static Container c;
	static JButton b;
	static JPanel p, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13,
			p14, p15, p16;
	static ImageIcon pic, pic2;
	static JList<String> list;
	static DefaultListModel<String> model;
	static DefaultListModel<String> st_list;
	static JScrollPane list_ass;

	public CanvasManipulationGUI(String applicationTitle, String chartTitle)
			throws IOException {
		super("Stevens 2");
		setSize(1800, 1000);

		/*
		 * JButton b = new JButton("Teacher/TA"); JButton b1 = new
		 * JButton("STUDENT"); JButton b2 = new JButton("Back to course list");
		 * JButton b3 = new JButton("REFRESH"); JButton b4 = new
		 * JButton("Logout"); final JButton b5 = new JButton("List COurses");
		 * final JButton b6 = new JButton("Back to main"); JButton b7 = new
		 * JButton("SUBMIT"); final JButton b8 = new JButton("Login"); JButton
		 * b9 = new JButton("List Students"); JButton b10 = new
		 * JButton("List Assignments"); JButton b11 = new
		 * JButton("Change Date"); JButton b12 = new JButton("Get Grades");
		 * JButton b13 = new JButton("Runtime"); JButton b14 = new
		 * JButton("Back to Submitting courseID"); JButton b15 = new
		 * JButton("SUBMIT Assignment ID"); JButton b16 = new
		 * JButton("Back to Course"); JButton b17 = new JButton("Graph");
		 * JButton b18 = new JButton("Bar Graph"); JButton b19 = new
		 * JButton("Back to Submit Assignment ID"); JButton b20 = new
		 * JButton("Both Graph");
		 */

		c = getContentPane();
		p = new JPanel(); // Logo screen
		p1 = new JPanel(); // logout screen
		p2 = new JPanel(); // T/TA, STUDENT, REFRESH ,Logout
		p3 = new JPanel(); // list courses, back
		p4 = new JPanel(); // List Course expanded-- list and id
		p5 = new JPanel(); // List Course expanded-- enter id , submit, logout,
							// back
		p6 = new JPanel(); // ls,ls,cd,gg,runtime
		p7 = new JPanel(); // get grade
		p8 = new JPanel(); // get grade buttons
		p9 = new JPanel(); // graph list
		p10 = new JPanel();// list assignments
		p11 = new JPanel();// runtime
		p12 = new JPanel();
		p13 = new JPanel();
		p14 = new JPanel();
		p15 = new JPanel();
		p16 = new JPanel();

		// -----------adding logo------------------
		pic = new ImageIcon("S.gif");
		pic2 = new ImageIcon("Steves.jpg");
		p.add(new JLabel(pic), BorderLayout.NORTH);
		p.add(new JLabel(pic2), BorderLayout.NORTH);
		// -----------------------------------------
		b = new JButton("Back");
		b.setFont(new Font("Arial", Font.BOLD, 40));
		b.setPreferredSize(new Dimension(200, 100));
		p10.add(b);

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.remove(p10);
				c.add(p6);
				p9.setPreferredSize(new Dimension(1700, 1000));
				c.revalidate();
				c.repaint();
				StringBuffer response = new StringBuffer();
				try {
					String teacherTa = fileReader("getListAssignmentButton.txt");
					teacherTa = "false";

					File file = new File("getListAssignmentButton.txt");
					// creates the file
					file.createNewFile();
					// creates a FileWriter Object
					FileWriter writer = new FileWriter(file);
					response.append(teacherTa);
					writer.write(teacherTa);
					writer.flush();
					writer.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}

				try {
					String teacherTa = fileReader("getListStudentsButton.txt");
					teacherTa = "false";

					File file = new File("getListStudentsButton.txt");
					// creates the file
					file.createNewFile();
					// creates a FileWriter Object
					FileWriter writer = new FileWriter(file);
					response.append(teacherTa);
					writer.write(teacherTa);
					writer.flush();
					writer.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				setAssignID(display.getText());
				p9.setPreferredSize(new Dimension(1700, 1000));
				c.revalidate();
				c.repaint();
			}

		});
		p8.setLayout(new GridLayout(3, 1));
		p7.setLayout(new GridLayout(1, 2));
		display = new JTextField();
		p7.add(display);
		display = new JTextField("Enter Assignment ID");
		display.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				display.setText("");
			}

			public void focusLost(FocusEvent e) {
			}
		});

		b = new JButton("Back to Course");
		b.setFont(new Font("Arial", Font.BOLD, 40));
		p8.add(b);
		p7.add(p8);
		// ---------p6------------------
		p6.setLayout(new GridLayout(2, 3));
		b = new JButton("List Students");
		b.setFont(new Font("Arial", Font.BOLD, 40));
		p6.add(b);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuffer response;
				try {
					File file = new File("getListStudentsButton.txt");
					// creates the file
					file.createNewFile();
					// creates a FileWriter Object
					FileWriter writer = new FileWriter(file);
					response = new StringBuffer("True");
					writer.write(response.toString());
					writer.flush();
					writer.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}

				try {
					runProcess("javac -cp *: CanvasManipulationTeacher.java");
					runProcess("java -cp *: CanvasManipulationTeacher");
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				FileReader input = null;
				BufferedReader br = null;
				st_list = new DefaultListModel<String>();
				student_list = new JList();

				try {

					input = new FileReader("liststudents.txt");
					br = new BufferedReader(input);
					String str;

					while ((str = br.readLine()) != null) {
						// student_list.add(str + "\n");
						st_list.addElement(str);
					}
				}

				catch (IOException e1) {
					e1.printStackTrace();
				}

				finally {

					try {
						input.close();
						br.close();
					}

					catch (IOException x) {
						x.printStackTrace();
					}

				}

				student_list = new JList<String>(st_list);
				student_list.setFont(new Font("Arial", Font.BOLD, 20));
				JScrollPane stud = new JScrollPane(student_list);
				stud.setPreferredSize(new Dimension(1000, 500));
				p15.add(stud);
				c.remove(p6);
				c.add(p15);
				c.revalidate();
				c.repaint();
			}

		});

		b = new JButton("Back to options");
		b.setFont(new Font("Arial", Font.BOLD, 40));
		b.setPreferredSize(new Dimension(500, 100));
		p15.add(b);

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.remove(p15);
				c.add(p6);
				c.revalidate();
				c.repaint();
			}
		});
		b = new JButton("List Assignments");
		b.setFont(new Font("Arial", Font.BOLD, 40));
		p6.add(b);

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuffer response;
				try {
					File file = new File("getListAssignmentButton.txt");
					// creates the file
					file.createNewFile();
					// creates a FileWriter Object
					FileWriter writer = new FileWriter(file);
					response = new StringBuffer("True");
					writer.write(response.toString());
					writer.flush();
					writer.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}

				try {
					runProcess("javac -cp *: CanvasManipulationTeacher.java");
					runProcess("java -cp *: CanvasManipulationTeacher");
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				FileReader input = null;
				BufferedReader br = null;
				textarea = new JTextArea();

				try {

					input = new FileReader("listassignments.txt");
					br = new BufferedReader(input);
					String str;

					while ((str = br.readLine()) != null) {
						textarea.append(str + "\n");
					}
				}

				catch (IOException e1) {
					e1.printStackTrace();
				}

				finally {

					try {
						input.close();
						br.close();
					}

					catch (IOException x) {
						x.printStackTrace();
					}

				}
				textarea.setFont(new Font("Arial", Font.BOLD, 20));
				textarea.setPreferredSize(new Dimension(1200, 500));
				// textarea.setText(resp);
				p10.add(textarea, BorderLayout.WEST);
				c.remove(p6);
				c.add(p10);
				c.revalidate();
				c.repaint();

			}

		});
		b = new JButton("Change Date");
		b.setFont(new Font("Arial", Font.BOLD, 40));
		p6.add(b);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					runProcess("javac -cp *: JulianDate.java");
					runProcess("java -cp *: JulianDate");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
				
			});

		display_grph = new JTextField("Enter Assignment ID");
		display_grph.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				display_grph.setText("");
			}

			public void focusLost(FocusEvent e) {
			}
		});
		p16.add(display_grph);

		p16.setLayout(new GridLayout(3, 1));
		b = new JButton("Student Performance");
		b.setFont(new Font("Arial", Font.BOLD, 40));
		p6.add(b);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p12.add(p16);
				p12.remove(p11);
				c.remove(p6);
				c.add(p12);
				c.revalidate();
				c.repaint();
				model = new DefaultListModel<String>();
				FileReader input1 = null;
				BufferedReader br1 = null;
				try {

					input1 = new FileReader("listassignments.txt");
					br1 = new BufferedReader(input1);
					String str;
					int count = 0;

					while ((str = br1.readLine()) != null) {
						model.addElement(str + "\n");
					}
				}

				catch (IOException e1) {
					e1.printStackTrace();
				}

				finally {

					try {
						input1.close();
						br1.close();
					}

					catch (IOException x) {
						x.printStackTrace();
					}

				}
				list = new JList<String>(model);
				list_ass = new JScrollPane(list);

				MouseListener mouseListener = new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						String selectedItem = (String) list.getSelectedValue();
						display_grph.setText(selectedItem.substring(0, 17));
					}
				};
				list.addMouseListener(mouseListener);

				textarea.setFont(new Font("Arial", Font.BOLD, 20));
				textarea.setPreferredSize(new Dimension(900, 500));
				list_ass.setPreferredSize(new Dimension(900, 500));
				list.setFont(new Font("Arial", Font.BOLD, 20));
				c.remove(p6);
				c.add(p12);
				c.revalidate();
				c.repaint();

				p13.add(list_ass, BorderLayout.EAST);

			}

		});

		display_run = new JTextField("Enter Assignment ID");
		display_run.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				display_run.setText("");
			}

			public void focusLost(FocusEvent e) {
			}
		});
		p11.add(display_run);

		b = new JButton("Compile and Run");
		b.setFont(new Font("Arial", Font.BOLD, 40));
		p6.add(b);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p12.remove(p16);
				p12.add(p11);

				c.remove(p6);
				c.add(p12);

				c.revalidate();
				c.repaint();
				model = new DefaultListModel<String>();
				FileReader input1 = null;
				BufferedReader br1 = null;
				try {

					input1 = new FileReader("listassignments.txt");
					br1 = new BufferedReader(input1);
					String str;
					int count = 0;

					while ((str = br1.readLine()) != null) {
						model.addElement(str + "\n");
					}
				}

				catch (IOException e1) {
					e1.printStackTrace();
				}

				finally {

					try {
						input1.close();
						br1.close();
					}

					catch (IOException x) {
						x.printStackTrace();
					}

				}
				list = new JList<String>(model);
				list_ass = new JScrollPane(list);

				MouseListener mouseListener = new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						String selectedItem = (String) list.getSelectedValue();
						display_run.setText(selectedItem.substring(0, 17));
					}
				};
				list.addMouseListener(mouseListener);

				textarea.setFont(new Font("Arial", Font.BOLD, 20));
				textarea.setPreferredSize(new Dimension(900, 500));
				list_ass.setPreferredSize(new Dimension(900, 500));
				list.setFont(new Font("Arial", Font.BOLD, 20));
				c.remove(p6);
				c.add(p12);
				c.revalidate();
				c.repaint();

				p13.add(list_ass, BorderLayout.EAST);

			}

		});

		p11.setLayout(new GridLayout(3, 1));
		p12.setLayout(new GridLayout(1, 2));

		b = new JButton("SUBMIT ASSIGNMENT ID");
		b.setFont(new Font("Arial", Font.BOLD, 40));
		p16.add(b);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					runProcess("javac -cp *: Graph.java");
					runProcess("java -cp *: Graph");
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				c.repaint();
			}
		});

		b = new JButton("SUBMIT ASSIGNMENT");
		b.setFont(new Font("Arial", Font.BOLD, 40));
		p11.add(b);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					runProcess("javac -cp *: CompileRun.java");
					runProcess("java -cp *: CompileRun");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				c.revalidate();
				c.repaint();
			}
		});

		p12.setLayout(new GridLayout(1, 2));

		p12.add(p11);
		p12.add(p13);

		b = new JButton("Back");
		b.setFont(new Font("Arial", Font.BOLD, 40));
		p11.add(b);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textarea.setText("");
				c.remove(p12);
				p13.remove(list_ass);
				c.add(p6);
				c.revalidate();
				c.repaint();
			}
		});
		b = new JButton("Back");
		b.setFont(new Font("Arial", Font.BOLD, 40));
		p16.add(b);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textarea.setText("");
				c.remove(p12);
				p13.remove(list_ass);
				c.add(p6);
				c.revalidate();
				c.repaint();
			}
		});
		p4.add(p5, BorderLayout.EAST);
		p5.setPreferredSize(new Dimension(300, 500));

		b = new JButton("Back to Submitting courseID");
		b.setFont(new Font("Arial", Font.BOLD, 32));
		p6.add(b);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.remove(p6);
				c.add(p4);
				c.revalidate();
				c.repaint();

				FileReader input1 = null;
				BufferedReader br1 = null;
				try {

					input1 = new FileReader("response.txt");
					br1 = new BufferedReader(input1);
					String str;

					while ((str = br1.readLine()) != null) {
						textarea.append(str + "\n");
					}
				}

				catch (IOException e1) {
					e1.printStackTrace();
				}

				finally {

					try {
						input1.close();
						br1.close();
					}

					catch (IOException x) {
						x.printStackTrace();
					}

				}
				textarea.setFont(new Font("Arial", Font.BOLD, 20));
				textarea.setPreferredSize(new Dimension(1200, 500));

			}
		});

		p5.setLayout(new GridLayout(3, 1));
		textarea = new JTextArea();

		display_course = new JTextField("Enter Course ID");
		display_course.setFont(new Font("Arial", Font.BOLD, 20));
		display_course.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				display_course.setText("");
			}

			public void focusLost(FocusEvent e) {
			}
		});
		p5.add(display_course);

		b = new JButton("SUBMIT");
		b.setFont(new Font("Arial", Font.BOLD, 40));
		p5.add(b);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuffer response;
				try {
					File file = new File("getSubmitButton.txt");
					// creates the file
					file.createNewFile();
					// creates a FileWriter Object
					FileWriter writer = new FileWriter(file);
					response = new StringBuffer("True");
					writer.write(response.toString());
					writer.flush();
					writer.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				textarea.setText("");
				setCourseID(display_course.getText());
				response = new StringBuffer();
				try {

					File file = new File("getc.txt");
					// creates the file
					file.createNewFile();
					// creates a FileWriter Object
					FileWriter writer = new FileWriter(file);
					response.append(getCourseID());
					writer.write(response.toString());
					writer.flush();
					writer.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}

				try {
					String teacherTa = fileReader("getTeacherTa.txt");
					teacherTa = "false";
					File file = new File("getTeacherTa.txt");
					// creates the file
					file.createNewFile();
					// creates a FileWriter Object
					FileWriter writer = new FileWriter(file);
					response.append(getCourseID());
					writer.write(teacherTa);
					writer.flush();
					writer.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}

				c.remove(p4);
				c.add(p6);
				c.revalidate();
				c.repaint();
			}
		});

		b = new JButton("BACK TO \nCOURSE LIST");
		b.setFont(new Font("Arial", Font.BOLD, 20));
		p5.add(b);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textarea.setText("");
				c.remove(p4);
				c.add(p3);
				c.revalidate();
				c.repaint();
			}
		});
		p4.add(p5, BorderLayout.EAST);
		p5.setPreferredSize(new Dimension(300, 500));

		// -------------------------------------------

		c.setLayout(new GridLayout(2, 1));
		p.setLayout(new GridLayout(1, 2));
		c.add(p, BorderLayout.NORTH);
		b = new JButton("TEACHER / TA");
		b.setFont(new Font("Arial", Font.BOLD, 40));
		b.setPreferredSize(new Dimension(500, 250));
		p2.add(b);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuffer response = new StringBuffer();
				try {
					File file = new File("getTeacherTa.txt");
					// creates the file
					file.createNewFile();
					// creates a FileWriter Object
					FileWriter writer = new FileWriter(file);
					response.append("True");
					writer.write(response.toString());
					writer.flush();
					writer.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				try {
					runProcess("javac -cp *: CanvasManipulationTeacher.java");
					runProcess("java -cp *: CanvasManipulationTeacher");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				c.remove(p2);

				c.revalidate();
				c.repaint();
				c.add(p3, BorderLayout.CENTER);
			}
		});
		b = new JButton("STUDENT");
		b.setFont(new Font("Arial", Font.BOLD, 40));
		b.setPreferredSize(new Dimension(500, 250));
		p2.add(b);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.removeAll();
				c.revalidate();
				c.add(new JLabel(pic2), BorderLayout.CENTER);
				c.add(p1);
			}
		});

		b = new JButton("LOGOUT");
		b.setFont(new Font("Arial", Font.BOLD, 40));
		b.setPreferredSize(new Dimension(500, 250));
		p2.add(b);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.removeAll();

				c.add(new JLabel(pic2), BorderLayout.CENTER);
				b = new JButton("Login");
				p1.add(b, BorderLayout.SOUTH);
				b.addActionListener(new ActionListener() {
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

		b = new JButton("LIST COURSES");
		b.setFont(new Font("Arial", Font.BOLD, 40));
		b.setPreferredSize(new Dimension(500, 250));
		p3.add(b);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.remove(p3);
				c.add(p4);
				c.revalidate();
				c.repaint();
				model = new DefaultListModel<String>();
				FileReader input1 = null;
				BufferedReader br1 = null;
				try {

					input1 = new FileReader("response.txt");
					br1 = new BufferedReader(input1);
					String str;
					int count = 0;

					while ((str = br1.readLine()) != null) {
						model.addElement(str + "\n");
					}
				}

				catch (IOException e1) {
					e1.printStackTrace();
				}

				finally {

					try {
						input1.close();
						br1.close();
					}

					catch (IOException x) {
						x.printStackTrace();
					}

				}
				list = new JList<String>(model);
				JScrollPane list_courses = new JScrollPane(list);

				MouseListener mouseListener = new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						String selectedItem = (String) list.getSelectedValue();
						display_course.setText(selectedItem.substring(0, 17));
					}
				};
				list.addMouseListener(mouseListener);

				textarea.setFont(new Font("Arial", Font.BOLD, 20));
				textarea.setPreferredSize(new Dimension(1200, 500));
				list_courses.setPreferredSize(new Dimension(1200, 500));
				list.setFont(new Font("Arial", Font.BOLD, 20));

				p4.add(list_courses, BorderLayout.WEST);
			}
		});

		b = new JButton("BACK TO MAIN");
		b.setFont(new Font("Arial", Font.BOLD, 40));
		b.setPreferredSize(new Dimension(500, 250));
		p3.add(b);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				c.remove(p3);
				c.add(p2);
				c.revalidate();
				c.repaint();
			}
		});
		c.add(p2, BorderLayout.SOUTH);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void runProcess(String command) throws Exception {
		Process pro = Runtime.getRuntime().exec(command);
		printLines(command + " Output:", pro.getInputStream());
		pro.waitFor();
	}
	
	public static void printLines(String name, InputStream ins)
			throws Exception {
		String line = null;
		String op_disp = "";
		BufferedReader in = new BufferedReader(new InputStreamReader(ins));
		while ((line = in.readLine()) != null) {
			op_disp = op_disp + line + "\n";
		}
		System.out.println(op_disp);
	}

	public static void main(String[] a) throws IOException {
		new CanvasManipulationGUI("Grade Vs Students", "Grades Vs Stdents");
	}

	public static String getCourseID() {
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

	public static String fileReader(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			return sb.toString();
		} finally {
			br.close();
		}
	}
}
