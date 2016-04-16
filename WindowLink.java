/**
 * @author : vaibhav
 */
package canvas;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class WindowLink extends JPanel{
	private Mode mode;
	private Graph current;
	public WindowLink() {			// 	Constructor set the value of default mode and sets the mouse listener
		mode = new PieChartMode();
		addMouseListener(
				new MouseListener() {
					public void mousePressed(MouseEvent e) {
						
					/*	current = mode.create(String, String );
						current.create();*/
					}
					public void mouseReleased(MouseEvent e) {}
					public void mouseEntered(MouseEvent e) {}
					public void mouseExited(MouseEvent e) {}
					public void mouseClicked(MouseEvent e) {}
				} );
		}
	public void setMode(Mode m) { mode = m; } // sets the mode to set the selected graph as the current graph
	public void paint(Graphics g) {
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
	}
}
