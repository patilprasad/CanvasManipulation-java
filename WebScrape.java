package canvas;

import java.net.*;
import java.io.*;

public class WebScrape {
	public static void main(String[] args) {
		try {
			URL canvas = new URL("https://sit.instructure.com/courses/133/users");
			URLConnection conn = canvas.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
	                                    conn.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) 
				System.out.println(inputLine);
			in.close();
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();			
		}
	}
}
