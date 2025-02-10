package Engine;


import java.util.HashMap;
import java.util.Map;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.Keyboard;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

import Action.Action;

// project import
import Scene.Scene;
import Scene.SceneMain;
import FileHandler.AssetsManager;

public class Engine{
	
	
	private boolean running = true;
	private String currentSceneName = "NULL";
	private Map<String, Scene> m_sceneMap = new HashMap<String, Scene>();
	private AssetsManager m_assets = new AssetsManager();

	private RenderWindow window = new RenderWindow();
	
	
	public Engine(String config)
	{
	
        window.create(new VideoMode(800, 600), "JSFML Example");

		m_assets.loadFromFile("res/config/assets.json");
		
		ChangeScene("MAIN", new SceneMain(this));
	}
	
	public void init(String config)
	{
		
	}
	
	public void update()
	{
		userInput();
		currentScene().update();
	}

	public void render()
	{
		currentScene().sRender();
	}
	
	
	
	public void stop()
	{
		running = false;
		window.close();
		System.exit(0);
	}
	

	
	public void run()
	{
		double draw = 1000000000;
		long time = System.nanoTime();
		double delta=0;
		long curentTime=0;
		
		double fps=0;
        int tick=0;
		long timer=0;
		
		while(window.isOpen() && running) {
			curentTime = System.nanoTime();
			delta += (curentTime - time) / (draw/60);
			
			timer +=curentTime - time;
			time = curentTime;
			
			if(delta >= 1) {
                update();
                tick++;
                delta--;
			}
			
            render();
            fps++;
			if(timer >= 1000000000) {
                System.out.println("tick : " + tick + ", fps : " + fps);
                tick = 0;
				fps = 0;
				timer=0;
			}
		}
		stop();
	}
	
	public void userInput()
	{
		for (Event event : window.pollEvents()) {
			if (event.type == Event.Type.CLOSED) {
				window.close();
			}

			else if(event.type == Event.Type.KEY_PRESSED || event.type == Event.Type.KEY_RELEASED)
			{
				if(event.asKeyEvent().key == Keyboard.Key.ESCAPE) stop();
				if(!currentScene().m_actionMap.containsKey(event.asKeyEvent().key))
				{
					continue;
				}

				String actionType = event.type == Event.Type.KEY_PRESSED ? "START" : "END";
		
				currentScene().sDoAction(new Action(actionType, currentScene().m_actionMap.get(event.asKeyEvent().key)));
			}
        }
	}
	
	public Scene currentScene()
	{
		return m_sceneMap.get(currentSceneName);
	} 
	
	public void ChangeScene(String name, Scene scene)
	{
		currentSceneName = name;
		m_sceneMap.put(name, scene);
	}

	public AssetsManager assets()
	{
		return m_assets;
	}

	public RenderWindow window()
	{
		return window;
	}
}
