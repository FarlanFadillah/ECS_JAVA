package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import Engine.Engine;

public class KeyInput implements KeyListener{
	
	private Engine m_engine;
	public KeyInput(Engine engine)
	{
		this.m_engine = engine;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyChar();
		System.out.println(key); 
		m_engine.userInput(key); 
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyChar();
		System.out.println(key);
		m_engine.userInput(key);
	}

}
