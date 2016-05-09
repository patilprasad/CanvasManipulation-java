/**
 *Author: Rohit Kulkarni
 *
 *Description:Compile and run java/c++ assignments in any specified directory
 *using class Runtime.
 *
 *File types supported: .java, .cpp, .cc 	
 */
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.apache.commons.io.*;

public class CompileRun extends JFrame {
	static JTextArea display;
	static JList<String> list;
	static DefaultListModel<String> model;
	static String[] file_names;

	public CompileRun() {
		super("View Assignments");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display = new JTextArea();
		JPanel p = new JPanel();
		Container c = getContentPane();
		model = new DefaultListModel<String>();
		/*
		 * Adding the list of assignments to a JList with a JScrollPane
		 */

		for (int i = 0; i < file_names.length; i++) {
			final int i1 = i;
			model.addElement(file_names[i]);
		}

		list = new JList<String>(model);
		list.setFont(new Font("Arial", Font.BOLD, 20));
		JScrollPane pane = new JScrollPane(list);

		/*
		 * Adding a MouseListener to display output/source code depending on the
		 * number of clicks.
		 */

		MouseListener mouseListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					display.setText("");
					FileReader input = null;
					BufferedReader br = null;
					String selectedItem = (String) list.getSelectedValue();
					try {

						input = new FileReader(selectedItem);
						br = new BufferedReader(input);
						String str;

						while ((str = br.readLine()) != null) {
							display.append(str + "\n");
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

				}

				else if (e.getClickCount() == 1) {
					String selectedItem = (String) list.getSelectedValue();
					if (selectedItem.endsWith(".java")) {
						display.setText("");
						try {

							runProcess("javac " + selectedItem);
							runProcess("java "
									+ selectedItem.substring(0,
											selectedItem.length() - 5));
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}

					else if (selectedItem.endsWith(".cc")) {
						display.setText("");
						try {

							runProcess("g++ "
									+ selectedItem
									+ " -o "
									+ selectedItem.substring(0,
											selectedItem.length() - 3));
							runProcess("./"
									+ selectedItem.substring(0,
											selectedItem.length() - 3));
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}

					else if (selectedItem.endsWith(".cpp")) {
						display.setText("");
						try {

							runProcess("g++ "
									+ selectedItem
									+ " -o "
									+ selectedItem.substring(0,
											selectedItem.length() - 4));
							runProcess("./"
									+ selectedItem.substring(0,
											selectedItem.length() - 4));
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}

				}
			}
		};

		list.addMouseListener(mouseListener);

		/*
		 * Adding an exit button to delete copied files before exiting the
		 * window.
		 */

		JButton exit = new JButton("EXIT");
		exit.setFont(new Font("Arial", Font.BOLD, 20));

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < file_names.length; i++) {
					if (file_names[i].endsWith(".java")) {
						File f = new File(file_names[i]);
						File f1 = new File(file_names[i].substring(0,
								file_names[i].length() - 5) + ".class");
						f.delete();
						f1.delete();
					}

					else if (file_names[i].endsWith(".cc")) {
						File f = new File(file_names[i]);
						File f1 = new File(file_names[i].substring(0,
								file_names[i].length() - 3));
						f.delete();
						f1.delete();
					}

					else if (file_names[i].endsWith(".cpp")) {
						File f = new File(file_names[i]);
						File f1 = new File(file_names[i].substring(0,
								file_names[i].length() - 4));
						f.delete();
						f1.delete();
					}
				}
				System.exit(0);
			}

		});

		setSize(1920, 1080);

		c.add(pane, BorderLayout.WEST);
		JScrollPane pane1 = new JScrollPane(display,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		p.add(pane1, BorderLayout.WEST);
		p.add(exit, BorderLayout.EAST);
		pane.setPreferredSize(new Dimension(300, 1000));
		pane1.setPreferredSize(new Dimension(1400, 1080));
		display.setFont(new Font("Arial", Font.BOLD, 20));
		exit.setPreferredSize(new Dimension(100, 100));
		p.setBorder(BorderFactory.createTitledBorder("OUTPUT"));
		c.add(p, BorderLayout.CENTER);
		setVisible(true);
	}

	/*
	 * Extracting file names from the folder containing the assignments.
	 */

	public static void filenames() {
		File folder = new File("/home/rohit/List_Files/Testing_directory");
		File[] listOfFiles = folder.listFiles();
		file_names = new String[listOfFiles.length];

		for (int i = 0; i < listOfFiles.length; i++) {
			file_names[i] = listOfFiles[i].getName();
		}
	}

	/*
	 * Temporarily copy assignments to current directory
	 */

	public static void File_Copy() {
		File source = new File("/home/rohit/List_Files/Testing_directory");
		File dest = new File("./");

		try {
			FileUtils.copyDirectory(source, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Run the specified command using class Runtime
	 */

	public static void runProcess(String command) throws Exception {
		Process pro = Runtime.getRuntime().exec(command);
		printLines(command + " Output:", pro.getInputStream());
		printLines(command + " Error:", pro.getErrorStream());
		pro.waitFor();
	}

	/*
	 * Print output stream/error stream of the assignment compiled
	 */

	public static void printLines(String name, InputStream ins)
			throws Exception {
		String line = null;
		String op_disp = "";
		BufferedReader in = new BufferedReader(new InputStreamReader(ins));
		while ((line = in.readLine()) != null) {
			op_disp = op_disp + line + "\n";
		}
		display.append(op_disp);
	}

	/*
	 * MAIN
	 */

	public static void main(String[] args) {
		filenames();
		File_Copy();
		new CompileRun();
	}

}
