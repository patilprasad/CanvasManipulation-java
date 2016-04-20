import net.lingala.zip4j.*;
import java.io.File;
import java.util.Calendar;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;


public class unzipping {
	public static void main(String[] args)
	{
		String source = "/home/rohit/unzip_this/unzip_this.zip";
		String destination = "/home/rohit/unzipped";   

		    try {
		        ZipFile zipFile = new ZipFile(source);
		        zipFile.extractAll(destination);
		    } catch (ZipException e) {
		        e.printStackTrace();
		    }
	}

}
