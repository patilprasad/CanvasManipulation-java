/**
 * @author : vaibhav
 * 
 * 
 * creates and returns a bar chart
 */

package canvas;

public class BarChartMode extends Mode {
	public Graph create(String applicationTitle , String chartTitle){
		return new BarChart_AWT(applicationTitle,chartTitle);
	}

}
