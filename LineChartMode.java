/**
 * @author : vaibhav
 * 
 *  
 *  creates and returns a new line chart 
 *
 */
package canvas;

public class LineChartMode extends Mode{
	public Graph create(String applicationTitle , String chartTitle){
		return new LineChart_AWT(applicationTitle,chartTitle );
	}

}
