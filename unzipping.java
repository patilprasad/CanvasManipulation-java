import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class unzipping {
	public static void main(String[] args)
	{
		String source = "/home/rohit/unzip_this/submissions.zip";
		String destination = "/home/rohit/unzipped";   

		    try {
		        ZipFile zipFile = new ZipFile(source);
		        zipFile.extractAll(destination);
		    } catch (ZipException e) {
		        e.printStackTrace();
		    }
	}

}

