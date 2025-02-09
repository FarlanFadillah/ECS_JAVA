package Scene;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

import Action.Action;
import Engine.Engine;
import Entity.EntityManager;
public abstract class Scene {
	
	public Map<Integer, String> m_actionMap = new HashMap<>();
	private Engine m_game;
	public boolean m_paused = false;
	
	public EntityManager m_entityManager = new EntityManager();

	public Scene(Engine engine)
	{
		this.m_game = engine;
	}

	public abstract void update();
	public abstract void sRender(Graphics2D g2d);
	public abstract void sDoAction(Action action);
	public abstract void onEnd();
	public abstract void sAnimation();
	
	public void registerAction(int key, String name)
	{
		m_actionMap.put(key, name); 
	}
}
