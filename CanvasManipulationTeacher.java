/**
 *@ Author:Prasad patil
 *
 *Description: Displays Courses, Students, Assignment and Get Grades by taking in user input from GUI.
 */

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

public class CanvasManipulationTeacher extends CanvasManipulation {
	public static HttpURLConnection connection;
	public static String auth;

	public CanvasManipulationTeacher(String url1, String courseId) {
		super(url1);
		this.setUrl1(url1 + courseId + "/assignments/");
	}

	public CanvasManipulationTeacher(String url1, String courseId, int a) {
		super(url1);
		this.setUrl1(url1 + courseId + "/students/");
	}

	public CanvasManipulationTeacher(String url1) {
		super(url1);
	}

	public CanvasManipulationTeacher(String url1, String courseId,
			String assignmentId) {
		this(url1, courseId);
		this.setUrl1(url1 + courseId + "/assignments/" + assignmentId
				+ "/gradeable_students");
	}

	
	// File Reader
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
	// This Function Creates a text file with Json Format 
	
	public void CreatesFileWithJson() throws Exception {
		File file = new File("JSON.txt");
		// creates the file
		file.createNewFile();
		// creates a FileWriter Object
		FileWriter writer = new FileWriter(file);
		// Writes the content to the file

		// Read the response:
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));
		String line;
		StringBuffer response = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			response.append(line);
		}
		reader.close();
		System.out.println(response.toString());
		writer.write(response.toString());
		writer.flush();
		writer.close();
	}
// This Function Parses the Json Text File and Displays Courses for a Particular User 
	public void displayCourses() throws Exception {
		StringBuffer response = new StringBuffer();
		try {
			String jsonData = fileReader("JSON.txt");
			JSONParser parser = new JSONParser();
			JSONArray array = (JSONArray) parser.parse(jsonData);
			Iterator i = array.iterator();

			// take each value from the json array separately
			while (i.hasNext()) {
				JSONObject innerObj = (JSONObject) i.next();

				// get a number from the JSON object
				long id = (long) innerObj.get("id");
				// get a String from the JSON object
				String courseCode = (String) innerObj.get("course_code");
				String startAt = (String) innerObj.get("start_at");
				response.append(id + "\t" + startAt + "\t" + courseCode + "\n");
				File file = new File("response.txt");
				// creates the file
				file.createNewFile();
				// creates a FileWriter Object
				FileWriter writer = new FileWriter(file);
				writer.write(response.toString());
				writer.flush();
				writer.close();
			}
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		// System.out.println(response);
	}

	// This Function Parses the Json Text File and Displays Assignments in a particular Course 
	public void displayAssignments() throws Exception {
		StringBuffer response = new StringBuffer();
		try {
			String jsonData = fileReader("JSON.txt");
			JSONParser parser = new JSONParser();
			JSONArray array = (JSONArray) parser.parse(jsonData);
			Iterator i = array.iterator();
			response.append("id" + "\t\t" + "Due At" + "\t\t\t"
					+ "Assignment Name" + "\n");
			// take each value from the json array separately
			while (i.hasNext()) {
				JSONObject innerObj = (JSONObject) i.next();

				// get a number from the JSON object
				long id = (long) innerObj.get("id");
				// get a String from the JSON object
				String assignmentName = (String) innerObj.get("name");
				String dueAt = (String) innerObj.get("due_at");
				response.append(id + "\t" + dueAt + "\t\t" + assignmentName
						+ "\n");
				File file = new File("listassignments.txt");
				// creates the file
				file.createNewFile();
				// creates a FileWriter Object
				FileWriter writer = new FileWriter(file);
				writer.write(response.toString());
				writer.flush();
				writer.close();
			}
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
	// This Function Parses the Json Text File and get Grades of an Assignments inside a particular Course 

	public void gradeableStudents() throws Exception {
		try {
			String jsonData = fileReader("JSON.txt");
			JSONParser parser = new JSONParser();
			JSONArray array = (JSONArray) parser.parse(jsonData);
			Iterator i = array.iterator();
			System.out.println("\n    id \t\t\t Display Name");
			// take each value from the json array separately
			while (i.hasNext()) {
				JSONObject innerObj = (JSONObject) i.next();

				// get a number from the JSON object
				long id = (long) innerObj.get("id");
				// get a String from the JSON object
				String displayName = (String) innerObj.get("display_name");
				System.out.println(id + "\t " + displayName);
			}
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}

	// This Function Parses the Json Text File and Displays Students Enrolled in a particular Course 

	public void displayStudents() throws Exception {
		StringBuffer response = new StringBuffer();
		try {
			String jsonData = fileReader("JSON.txt");
			JSONParser parser = new JSONParser();
			JSONArray array = (JSONArray) parser.parse(jsonData);
			Iterator i = array.iterator();
			response.append("\n    id" + "\t\t\t\t" + "name" + "\n");
			// take each value from the json array separately
			while (i.hasNext()) {
				JSONObject innerObj = (JSONObject) i.next();

				// get a number from the JSON object
				long id = (long) innerObj.get("id");
				// get a String from the JSON object
				String name = (String) innerObj.get("name");
				response.append(id + "\t\t" + name + "\n");
				File file = new File("liststudents.txt");
				// creates the file
				file.createNewFile();
				// creates a FileWriter Object
				FileWriter writer = new FileWriter(file);
				writer.write(response.toString());
				writer.flush();
				writer.close();
			}
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		System.out.println(response);
	}

	public static void main(String[] args) throws Exception {
		String url1 = "https://canvas.instructure.com/api/v1/courses/";
		String auth = fileReader("auth.dat");
		File f = new File("getTeacherTa.txt");
		f.createNewFile();
		File f1 = new File("getListAssignmentButton.txt");
		f1.createNewFile();
		File f2 = new File("getSubmitButton.txt");
		f2.createNewFile();
		File f3 = new File("getListStudentsButton.txt");
		f3.createNewFile();
		File f4 = new File("getc.txt");
		f4.createNewFile();
		File f5 = new File("listGrades.txt");
		f.createNewFile();
		String teacherTa = fileReader("getTeacherTa.txt");
		String listAssignments = fileReader("getListAssignmentButton.txt");
		String submitButton = fileReader("getSubmitButton.txt");
		String listStudents = fileReader("getListStudentsButton.txt");
		String course_id = fileReader("getc.txt");
		String assign_id = fileReader("getassign.txt");
		String listGrades = fileReader("listGrades.txt");

		System.out.println(teacherTa.equals("True"));
		System.out.println(listAssignments.equals("True")
				&& submitButton.equals("True"));
		System.out.println(listStudents.equals("True")
				&& submitButton.equals("True"));

		if (teacherTa.equals("True")) {
			CanvasManipulationTeacher a = new CanvasManipulationTeacher(url1);
			URL url = new URL(a.getUrl1());
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Authorization", "Bearer " + auth);
			connection.setRequestMethod("GET");
			// a.urlConnection();
			a.CreatesFileWithJson();
			a.displayCourses();
		}

		else if (listAssignments.equals("True") && submitButton.equals("True")) {

			CanvasManipulationTeacher a = new CanvasManipulationTeacher(url1,
					course_id);
			URL url = new URL(a.getUrl1());
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Authorization", "Bearer " + auth);
			connection.setRequestMethod("GET");
			// a.urlConnection();
			a.CreatesFileWithJson();
			a.displayAssignments();
			// System.exit(0);
		}

		else if (listStudents.equals("True") && submitButton.equals("True")) {
			CanvasManipulationTeacher a = new CanvasManipulationTeacher(url1,
					course_id, 1);
			URL url = new URL(a.getUrl1());
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Authorization", "Bearer " + auth);
			connection.setRequestMethod("GET");
			// a.urlConnection();
			a.CreatesFileWithJson();
			a.displayStudents();
		}

		// for Grades
		else if (listGrades.equals("True")) {
			CanvasManipulationTeacher a = new CanvasManipulationTeacher(url1,
					course_id, assign_id);
			URL url = new URL(a.getUrl1());
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Authorization", "Bearer " + auth);
			connection.setRequestMethod("GET");
			// a.urlConnection();
			a.CreatesFileWithJson();
			a.gradeableStudents();
		}

	}
}
