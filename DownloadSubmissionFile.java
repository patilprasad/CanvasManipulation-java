/**
 *@ Author:Prasad patil
 *
 *Description: Downloads Assignment Zip File
 */
import java.io.*;
import java.net.URL;
import java.net.URLConnection;


public class DownloadSubmissionFile {

  public static void main(String[] args) throws IOException {
	  	File f = new File("assignment.txt");
		f.createNewFile();
		String assign_id = fileReader("assignment.txt");
		File f1 = new File("getc.txt");
		f.createNewFile();
		String course_id = fileReader("getc.txt");
		 String saveTo = "/home/prasad/Desktop/";
		    try {
				URL url = new URL("https://sit.instructure.com/courses/"+course_id+"/assignments/"+ assign_id+ "/submissions?zip=1"); //The file that you want to download
		        URLConnection conn = url.openConnection();
		        InputStream in = conn.getInputStream();
		        FileOutputStream out = new FileOutputStream(saveTo + "submissions.zip");
		        byte[] b = new byte[1024];
		        int count;
		        while ((count = in.read(b)) >= 0) {
		            out.write(b, 0, count);
		        }
		        out.flush(); out.close(); in.close();                   

		    } catch (IOException e) {
		        e.printStackTrace();
		    }
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