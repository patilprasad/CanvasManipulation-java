 package canvas;
  

  import java.io.*;
  import java.io.*;
  import static java.lang.System.*;
  import java.net.HttpURLConnection;
  import java.net.MalformedURLException;
  import java.net.URL;
  import java.util.Iterator;
  import org.json.simple.JSONArray;
  import org.json.simple.JSONObject;
  import org.json.simple.parser.ParseException;
  import org.json.simple.parser.JSONParser;
  
  public class project { 
  public static HttpURLConnection connection;
  public static void main(String[] args) throws Exception {
  	try {
  	String auth = fileReader("auth.dat");
  	// put the required courseID
  	String courseId="10300000000000133";
  	String url1= "https://canvas.instructure.com/api/v1/courses/";
  	URL url = new URL(url1 + courseId+ "/assignments/10300000000000860");
  	connection = (HttpURLConnection) url.openConnection();
  	connection.setRequestProperty("Authorization", "Bearer " +auth);
  	connection.setRequestMethod("GET");
      System.out.println("\nSending 'GET' request to URL : "  + url);
      System.out.println("Response code:"  + connection.getResponseCode());
      System.out.println("Response message:" + connection.getResponseMessage());
      
      File file = new File("JSON1.txt");
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
  	catch (MalformedURLException e1) {
  		e1.printStackTrace();
  	} catch (IOException e2) {
  		e2.printStackTrace();
  	}
  	jsonParser();

  }
  
  //File Reader is used to read the text file JSON1.txt
  
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
  
 //Parser is used to convert JSON input into human readable format
    
  public static void jsonParser() throws Exception{
      try{
      	String jsonData = fileReader("JSON1.txt");
      	JSONParser parser = new JSONParser();
      	// take each value from the json array separately
      	JSONObject innerObj = (JSONObject)parser.parse(jsonData);
         	
      	
      	// get a number from the JSON object
      	long id = (long) innerObj.get("id");         
      	// get a String from the JSON object
      	String assignmentName = (String) innerObj.get("name");
      	String dueAt = (String) innerObj.get("due_at");
      	//print id followed by due date followed by assignment name
      	System.out.println( id +"\t" +dueAt + "\t"+assignmentName+"\t" );

      	// String Read the file from parsedfile.txt   
      	FileWriter fw=new FileWriter("Parsedfile.txt");
		PrintWriter pw=new PrintWriter(fw);
		pw.println(dueAt);
		pw.close();
      	
      	
      	}catch(ParseException ex){
      		ex.printStackTrace();        	
      	}catch (IOException e2) {
      		e2.printStackTrace();
  		}
  	}
  }