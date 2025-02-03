package Scene;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import Action.Action;
import Engine.Engine;

public class SceneMain extends Scene{

	public SceneMain(Engine engine) {
		super(engine);
		// TODO Auto-generated constructor stub
		m_paused = false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(!m_paused)
		{
		}
	}

	@Override
	public void sRender(Graphics2D g2d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sDoAction(Action action) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEnd() {
		// TODO Auto-generated method stub
		
	}

}
