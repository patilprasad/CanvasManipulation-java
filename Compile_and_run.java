import java.io.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import org.apache.commons.io.*;

public class test extends JFrame
{
	static String[] file_names;
	public static void filenames()
	{
		File folder = new File("/home/rohit/List_Files/Testing_directory");
		File[] listOfFiles = folder.listFiles();
		 file_names = new String[listOfFiles.length];
		
			for (int i = 0; i < listOfFiles.length; i++) 
			{
				//System.out.println("File " + listOfFiles[i].getName());
				file_names[i] = listOfFiles[i].getName();
				//System.out.println(file_names[i]);
			}
	}

// copy all files from the folder containing .java files
// to current directory, for the ease of execution

	public static void File_Copy()
	{
		File source = new File("/home/rohit/List_Files/Testing_directory");
		File dest = new File("/home/rohit/java_proj");
	
		try 
		{
	    	FileUtils.copyDirectory(source, dest);
		} 
		catch (IOException e) 
		{
	    	e.printStackTrace();
		}
	}
	static JTextArea display;
	static JList<String> list;
	static DefaultListModel<String> model;
	//static JButton b;
	public test()
	{
		super("Test");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    display = new JTextArea();
	    
		JPanel p = new JPanel();
		Container c = getContentPane();
		model = new DefaultListModel<String>();
		for(int i = 0; i < file_names.length; i++)
		{
			final int i1 = i;
			//b = new JButton(file_names[i]);
			model.addElement(file_names[i]);
		}
		list = new JList<String>(model);
		JScrollPane pane = new JScrollPane(list);
		c.add(pane, BorderLayout.EAST);
		MouseListener mouseListener = new MouseAdapter() 
		{
		    public void mouseClicked(MouseEvent e) 
		    {
		    	String selectedItem = (String)list.getSelectedValue();
		    	if(selectedItem.endsWith(".java"))
				{
					display.setText("");
					try 
					{	
					
						runProcess("javac " + selectedItem);
						runProcess("java " + selectedItem.substring(0, selectedItem.length() - 5));
					} 
					catch (Exception e1) 
					{
						e1.printStackTrace();
					}
				}
		    	
		    	else if(selectedItem.endsWith(".cc"))
				{
					display.setText("");
					try 
					{	
					
						runProcess("g++ " + selectedItem + " -o " + selectedItem.substring(0, selectedItem.length() - 3));
						runProcess("./" + selectedItem.substring(0, selectedItem.length() - 3));
					} 
					catch (Exception e1) 
					{
						e1.printStackTrace();
					}
				}
		    	
		    	else if(selectedItem.endsWith(".cpp"))
				{
					display.setText("");
					try 
					{	
					
						runProcess("g++ " + selectedItem + " -o " + selectedItem.substring(0, selectedItem.length() - 4));
						runProcess("./" + selectedItem.substring(0, selectedItem.length() - 4));
					} 
					catch (Exception e1) 
					{
						e1.printStackTrace();
					}
				}
		    }
		};
		list.addMouseListener(mouseListener);
		
		
		
			/*p.add(b, BorderLayout.EAST);
			b.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					if(file_names[i1].endsWith(".java"))
					{
						System.out.println("JAVA CODE OUTPUT");
						display.setText("");
						try 
						{	
						
							runProcess("javac " + file_names[i1]);
							runProcess("java " + file_names[i1].substring(0, file_names[i1].length() - 5));
						} 
						catch (Exception e1) 
						{
							e1.printStackTrace();
						}*/
						/*File f = new File(file_names[i1]);
						File f1 = new File(file_names[i1].substring(0, file_names[i1].length() - 5) + ".class");
						f.delete();
						f1.delete();*/
					/*}
					
					else if(file_names[i1].endsWith(".cc"))
					{
						System.out.println(".cc CODE OUTPUT");
						display.setText("");
						try 
						{	
						
							runProcess("g++ " + file_names[i1] + " -o " + file_names[i1].substring(0, file_names[i1].length() - 3));
							runProcess("./" + file_names[i1].substring(0, file_names[i1].length() - 3));
						} 
						catch (Exception e1) 
						{
							e1.printStackTrace();
						}*/
						/*File f = new File(file_names[i1]);
						File f1 = new File(file_names[i1].substring(0, file_names[i1].length() - 3));
						f.delete();
						f1.delete();*/
					/*}
					
					else if(file_names[i1].endsWith(".cpp"))
					{
						System.out.println(".cpp CODE OUTPUT");
						display.setText("");
						try 
						{	
						
							runProcess("g++ " + file_names[i1] + " -o " + file_names[i1].substring(0, file_names[i1].length() - 4));
							runProcess("./" + file_names[i1].substring(0, file_names[i1].length() - 4));
						} 
						catch (Exception e1) 
						{
							e1.printStackTrace();
						}*/
						/*File f = new File(file_names[i1]);
						File f1 = new File(file_names[i1].substring(0, file_names[i1].length() - 4));
						f.delete();
						f1.delete();*/
					//}
					
				//}
				
				
			//});
		//}
		p.add(display, BorderLayout.WEST);
		JButton exit = new JButton("Exit");
		p.add(exit, BorderLayout.SOUTH);
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				for(int i = 0; i < file_names.length; i++)
				{
					if(file_names[i].endsWith(".java"))
					{
						File f = new File(file_names[i]);
						File f1 = new File(file_names[i].substring(0, file_names[i].length() - 5) + ".class");
						f.delete();
						f1.delete();
					}
					else if(file_names[i].endsWith(".cc"))
					{
						File f = new File(file_names[i]);
						File f1 = new File(file_names[i].substring(0, file_names[i].length() - 3));
						f.delete();
						f1.delete();
					}
					else if(file_names[i].endsWith(".cpp"))
					{
						File f = new File(file_names[i]);
						File f1 = new File(file_names[i].substring(0, file_names[i].length() - 4));
						f.delete();
						f1.delete();
					}
				}
			System.exit(0);
			}
			
		});
		
		
		setSize(1000,500);
		display.setPreferredSize(new Dimension(800, 500));
		//display.setText("test \n hello");
		c.add(p, BorderLayout.CENTER);
		setVisible(true);
		
		/*for(int i = 0; i < file_names.length; i++)
		{
			if(file_names[i].endsWith(".java"))
			{
				System.out.println("JAVA CODE OUTPUT");
			
				try 
				{	
				
					runProcess("javac " + file_names[i]);
					runProcess("java " + file_names[i].substring(0, file_names[i].length() - 5));
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
			
			else if(file_names[i].endsWith(".cc"))
			{
				System.out.println(".cc CODE OUTPUT");
			
				try 
				{	
				
					runProcess("g++ " + file_names[i] + " -o " + file_names[i].substring(0, file_names[i].length() - 3));
					runProcess("./" + file_names[i].substring(0, file_names[i].length() - 3));
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
			
			else if(file_names[i].endsWith(".cpp"))
			{
				System.out.println(".cpp CODE OUTPUT");
			
				try 
				{	
				
					runProcess("g++ " + file_names[i] + " -o " + file_names[i].substring(0, file_names[i].length() - 4));
					runProcess("./" + file_names[i].substring(0, file_names[i].length() - 4));
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
			
		}*/
		
	}
	
		
	public static void runProcess(String command) throws Exception 
	{
	    Process pro = Runtime.getRuntime().exec(command);
	    printLines(command + " Output:", pro.getInputStream());
	    printLines(command + " Error:", pro.getErrorStream());
	    pro.waitFor();
	}
	
	public static void printLines(String name, InputStream ins) throws Exception 
	{
	    String line = null;
	    String op_disp = "";
	    //display.setText("");	
	    BufferedReader in = new BufferedReader(
	        new InputStreamReader(ins));
	    while ((line = in.readLine()) != null) 
	    {
	        //System.out.println(name + " " + line);
	    	op_disp = op_disp + line + "\n";
	    }
	    display.append(op_disp);
	}
	
	
	public static void main(String[] args)
	{
		filenames();
		File_Copy();
		/*for(int i = 0; i < file_names.length; i++)
		{
			if(file_names[i].endsWith(".java"))
			{
				System.out.println("JAVA CODE OUTPUT");
			
				try 
				{	
				
					runProcess("javac " + file_names[i]);
					runProcess("java " + file_names[i].substring(0, file_names[i].length() - 5));
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
			
			else if(file_names[i].endsWith(".cc"))
			{
				System.out.println(".cc CODE OUTPUT");
			
				try 
				{	
				
					runProcess("g++ " + file_names[i] + " -o " + file_names[i].substring(0, file_names[i].length() - 3));
					runProcess("./" + file_names[i].substring(0, file_names[i].length() - 3));
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
			
			else if(file_names[i].endsWith(".cpp"))
			{
				System.out.println(".cpp CODE OUTPUT");
			
				try 
				{	
				
					runProcess("g++ " + file_names[i] + " -o " + file_names[i].substring(0, file_names[i].length() - 4));
					runProcess("./" + file_names[i].substring(0, file_names[i].length() - 4));
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
			
		}*/
		
		new test();
		
		

		


	}

	
	
}
