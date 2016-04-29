package canvas;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

 
public class changedate {
	public static HttpURLConnection connection;

	public static void main(String[] args) throws Exception {
			String auth = fileReader("auth.dat");
			// put the required courseID
			String courseId = "10300000000000133";
			String url1 = "https://canvas.instructure.com/api/v1/courses/10300000000000133/settings";
			URL url = new URL(url1 + courseId + "/assignments/10300000000043867/");
			
			connection = (HttpURLConnection) url.openConnection();			
			connection.setDoOutput(true);
			connection.setRequestProperty("Authorization", "Bearer " + auth);
			
			connection.setRequestMethod("PUT");
			// OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
//	PrintWriter out = new PrintWriter(new OutputStreamWriter(connection.getOutputStream()));
			
String input = "{\n" +
 " \"name\": DOV DEV,\n" +
"  \"start_at\": \"2014-07-01T13:31:00Z\",\n" +
"  \"grading_standard_id\": \"2013-08-28T23:59:00-06:00\",\n" +
"  \"is_public\": \"true\",\n" +
"  \"course_code\": \"DOV DEV\"\n"+
"}\n";
OutputStream os = connection.getOutputStream();
os.write(input.getBytes());
os.flush();
if (connection.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
    throw new RuntimeException("Failed : HTTP error code : "
        + connection.getResponseCode());
    }
BufferedReader br = new BufferedReader(new InputStreamReader(
        (connection.getInputStream())));

String output;
System.out.println("Output from Server .... \n");
while ((output = br.readLine()) != null) {
    System.out.println(output);
}

connection.disconnect();

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