package Scene;
import java.awt.Graphics2D;
import java.util.Map;

import Action.Action;
import Engine.Engine;
public abstract class Scene {
	
	private Map<Integer, String> m_actionMap;
	private Engine m_game;
	public boolean m_paused = false;
	
	public Scene(Engine engine)
	{
		this.m_game = engine;
	}

	public abstract void update();
	public abstract void sRender(Graphics2D g2d);
	public abstract void sDoAction(Action action);
	public abstract void onEnd();
	
	public void registerAction(int key, String name)
	{
		m_actionMap.put(key, name); 
	}
}
