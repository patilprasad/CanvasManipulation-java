/*
Author: Rohit Kulkarni
Description: A java program that compiles and runs another java program.
*/

package rohit;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;


public class Compile_and_Run 
{
	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager sjfm = jc.getStandardFileManager(null, null, null);
		
		
		File javaFile = new File("/home/rohit/workspace/Compile_Runtime/src/Compile_This_Code.java");
		Iterable fileObjects = sjfm.getJavaFileObjects(javaFile);
		String[] options = new String[]{"-d", "/home/rohit/workspace/Compile_Runtime/bin"}; 
		
		
		jc.getTask(null, null, null, Arrays.asList(options), null, fileObjects).call(); 
		sjfm.close();
		System.out.println("Class has been successfully compiled");
		
		
		URL[] urls = new URL[]{ new URL("file:///home/rohit/workspace/Compile_Runtime/bin/") }; 
		URLClassLoader ucl = new URLClassLoader(urls);
		Class clazz = ucl.loadClass("rohit.Compile_This_Code");
		System.out.println("Class has been successfully loaded");
		
		Method method = clazz.getDeclaredMethod("call_this_method", null);
		
		Object object = clazz.newInstance();
		method.invoke(object, null);

	}

}

