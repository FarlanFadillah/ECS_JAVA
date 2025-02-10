package Scene;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

import org.jsfml.window.Keyboard;

import Action.Action;
import Engine.Engine;
import Entity.EntityManager;
public abstract class Scene {
	
	public Map<Keyboard.Key, String> m_actionMap = new HashMap<>();
	public Engine m_game;
	public boolean m_paused = false;
	
	public EntityManager m_entityManager = new EntityManager();

	public Scene(Engine engine)
	{
		this.m_game = engine;
	}

	public abstract void update();
	public abstract void sRender();
	public abstract void sDoAction(Action action);
	public abstract void onEnd();
	public abstract void sAnimation();
	
	public void registerAction(Keyboard.Key key, String name)
	{
		m_actionMap.put(key, name); 
	}

	public Engine getEngine()
	{
		return m_game;
	}
}
