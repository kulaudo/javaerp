package view;

import java.awt.Component;
import java.util.Iterator;

import javax.swing.JFrame;

public interface MyComponent {
	public void add(MyComponent myComponent);
	public void remove(int i);
	public MyComponent getChild(int i);
	public String getName();	
	public MyComponent getChild(String name) ;
	public Iterator createIterator() ;
	public void print();
	public Component getComponent();
}
