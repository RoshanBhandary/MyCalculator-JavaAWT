
package calculator;

import java.awt.*; //importing java AWT which contains classes for creating graphical user interfaces

import java.awt.event.*;

public class Calculator extends Frame  {  //define class Calculator and extends(inherits) from Frame class (Frame is basic window in Java's AWT(Abstract Window Toolkit) to create GUI applications
	public Calculator () {                //constructor of Calculator class {Constructor is a special method called when object of the class i created
		setTitle("My Calculator");        //sets title of the window to "My Calculator"
		setSize (300,400);                //size of window in pixels 300 width and 400 height 
	    setLayout(new FlowLayout());      //sets layout of components like buttons, labels {FlowLayout arranges them in left to right flow
	    setVisible(true);                 //sets window to be visible on the screen
	}                                     //constructor closed
	

	public static void main(String[] args) {  //main method where java program begins execution
		new Calculator();                     //creates an instance(object) of the Calculator class which calls the constructor and displays the window

	}

}
