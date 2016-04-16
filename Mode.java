/**
 * @author : vaibhav
 */
package canvas;

public abstract class Mode implements Graph {	// this abstract class forces all the mode classes to have a 'public Graph create' method
	public abstract Graph create(String applicationTitle , String chartTitle);

}
