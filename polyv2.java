import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Area;

import javax.swing.JButton;
import javax.swing.JFrame;

public class polyv2 extends JFrame{
	
	private static int mouseX =0;
	private static int mouseY =0;
	
	public polyv2()
	{
		setSize(400, 200);
		setUndecorated(true);
		setLayout(null);
		setBackground(new Color(0, 0, 0, 0));
		
		
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e)
			{
				int x = e.getXOnScreen()- mouseX;
				int y = e.getYOnScreen()- mouseY;
				setLocation(x,y);
			}
		});
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e)
			{
				mouseX=e.getX();
				mouseY=e.getY();
			}
		});
		
		
		
		JButton butExit = new JButton("X");
		butExit.setBounds(
				(getWidth()/2)-20, (getHeight()/2)-20, 40, 40);
		butExit.setBackground(Color.red);
		//butExit.setBackground(new Color(255, 0, 0));
		butExit.setBorderPainted(false);
		butExit.setFocusPainted(false);
		butExit.setForeground(Color.white);
		butExit.setMargin(new Insets(0,0,0,0));
		
		
		
		
		butExit.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				butExit.setBackground(Color.red);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				butExit.setBackground(Color.DARK_GRAY);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		add(butExit);
		
		
		
	}
	
	
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		//quality
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		

		/*int[] xpoints = {200,350,350,200, 50, 50};
		int[] ypoints =	{ 50,150,200,200,200,150};	
		Polygon poly = new Polygon(xpoints, ypoints, ypoints.length);*/
		
		
		int w = getWidth();
		int h = getHeight();
		
		int[] xpoints1 = {10,w/2,w/2-2,w-3,    w-3,        w,   w,w-10,w/2,w/2-2,  3,  3,      0, 0};
		int[] ypoints1 = { 0,  0,    3,  3,h-(h/3),h-(h/3)+2,h-10,   h,  h,  h-3,h-3,h/3,(h/3)-2,10};
		
		Polygon poly1 = new Polygon(xpoints1,ypoints1,xpoints1.length);
		
		
		int[] xpoints2 = {14, w/2-4,w/2-2, w-4,    w-4,      w-6, w-6,w-14,w/2-4,w/2-2,  4,  4,      6, 6};
		int[] ypoints2 = { 6,     6,    4,   4,h-(h/3),h-(h/3)-3,h-15, h-6,  h-6,  h-4,h-4,h/3,(h/3)+2,14};
		
		Polygon poly2 = new Polygon(xpoints2,ypoints2,xpoints2.length);
		
		Area area1 = new Area(poly1);
		Area area2 = new Area(poly2);
		
		area1.exclusiveOr(area2);
		
		g2d.setColor(Color.blue);
		g2d.fill(area1);
		
		
		GradientPaint gradient = new GradientPaint(0, 0, Color.red, 300,150,Color.magenta);
		g2d.setPaint(gradient);
		g2d.fill(poly2);

	}
	
	
	
	
	
	
	
	
	
	
	
	
}
