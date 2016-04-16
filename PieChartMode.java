/**
 * @author : vaibhav
 * 
 * 
 * creates the new pie chart 
 */

package canvas;

public class PieChartMode extends Mode{
	public Graph create(String applicationTitle , String chartTitle){
		return new PieChartSample();
	}

}
