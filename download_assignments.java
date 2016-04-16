/*
Author: Rohit Kulkarni
Description: This class downloads assignments submitted by students in the test course DOV DEV.

********************************INCOMPLETE CODE************************************************

*/

import java.io.*;
import org.apache.commons.io.*;
import java.net.*;
public class download_assignments
{

// This is a test code that downloads one specific .java file and saves it.

	public static void main(String[] args)
	{
		File file = new File("assign.java");
		FileUtils.copyURLToFile(https://sit.instructure.com/courses/133/assignments/43867/submissions/22347?download=1443506, file);
	
		try {
		    FileUtils.copyURLToFile(https://sit.instructure.com/courses/133/assignments/43867/submissions/22347?download=1443506, file);
		} catch (Exception x) { x.printStackTrace(); }
	}
	
	/*
	//private static final String PATH = "C:\\project\\DownloadTest\\src\\main\\resources\\tmp\\";
	private static final String FILENAME = "assign.jpg";
	private static final String FURL = "http://www.wallpapersbyte.com/wp-content/uploads/2015/07/Barcelona-Football-Club-Spain-FCB-Logo-Flag-Blue-Red-WallpapersByte-com-3840x2400.jpg";
	*/
	}


}
