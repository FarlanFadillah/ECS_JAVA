package Engine;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.HashMap;
import java.util.Map;

// project import
import Input.KeyInput;
import Scene.Scene;
import Scene.SceneMain;

public class Engine extends Canvas implements Runnable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean running = true;
	private String currentSceneName = "NULL";
	private Map<String, Scene> m_sceneMap = new HashMap<String, Scene>();
	
	private KeyInput keyIn;
	private Frame window;
	
	
	public Engine(String config)
	{
		window = new Frame(800, 600, "ECS_JAVA", this);
		keyIn = new KeyInput(this); 
		addKeyListener(keyIn);
		
		ChangeScene("MAIN", new SceneMain(this));
	}
	
	public void init(String config)
	{
		
	}
	
	public void update()
	{
		currentScene().update();
	}
	
	public void render()
	{
		BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            this.requestFocus();
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.black);
		g.fillRect(0,0, getWidth(), getHeight());
		
		currentScene().sRender(g2d);
		
		
		g.dispose();
        bs.show();
	}
	
	public void stop()
	{
		running = false;
	}
	public void start(){
        running = true;
        new Thread(this).start();
    }

	@Override
	public void run()
	{
		this.requestFocus();
		double draw = 1000000000;
		long time = System.nanoTime();
		double delta=0;
		long curentTime=0;
		
		double fps=0;
        int tick=0;
		long timer=0;
		
		while(running) {
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
//                this.Guifps = fps;
//                this.Guitick = tick;
                tick = 0;
				fps = 0;
				timer=0;
			}
		}
		stop();
	}
	
	public void userInput(int key)
	{
		if(key == KeyEvent.VK_ESCAPE)
		{
			stop();
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
}
