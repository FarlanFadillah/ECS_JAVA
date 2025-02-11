package Scene;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Keyboard;

import Action.Action;
import Component.*;

import Engine.Engine;
import Entity.Entity;
import FileHandler.AssetsManager;
import Math.Vec2f;
import Math.Vec2i;

public class SceneMain extends Scene{

	private Entity player;

	public SceneMain(Engine engine) {
		super(engine);
		// TODO Auto-generated constructor stub
		genPlayer();
		registerAction(Keyboard.Key.W, "UP");
		registerAction(Keyboard.Key.S, "DOWN");
		registerAction(Keyboard.Key.D, "RIGHT");
		registerAction(Keyboard.Key.A, "LEFT");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(!m_paused)
		{
			m_entityManager.update();
			sMovement();
		}
	}
	
	@Override
	public void sRender() {
		// TODO Auto-generated method stub
		RenderWindow window = m_game.window();
		window.clear(Color.BLACK);

		AssetsManager assets = getEngine().assets();
		for(Entity temp : m_entityManager.getEntities("Player"))
		{
			CTransform ct = temp.getComponent(CTransform.class);
			CBoundingBox cb = temp.getComponent(CBoundingBox.class);

			Vec2f pos = ct.m_pos;
			Vec2i size = cb.m_size;

			Sprite rect = new Sprite();
			rect.setTexture(assets.getTexture("Idle_Fighter_Right"));
			rect.setTextureRect(new IntRect(192,0, size.x, size.y));
			rect.setOrigin(new Vector2f(size.x/2, size.y/2));
			rect.setPosition(pos.x, pos.y);

			window.draw(rect);
		}

		sAnimation();

		window.display();
	}

	@Override
	public void sDoAction(Action action) {
		// TODO Auto-generated method stub
		if(action.type() == "START")
		{
			if(action.name() == "UP")
			{
				player.getComponent(CInput.class).up = true;
			}
			else if(action.name() == "DOWN")
			{
				player.getComponent(CInput.class).down = true;
			}
			else if(action.name() == "RIGHT")
			{
				player.getComponent(CInput.class).right = true;
			}
			else if(action.name() == "LEFT")
			{
				player.getComponent(CInput.class).left = true;
			}
		}
		else if(action.type() == "END")
		{
			if(action.name() == "UP")
			{
				player.getComponent(CInput.class).up = false;
			}
			else if(action.name() == "DOWN")
			{
				player.getComponent(CInput.class).down = false;
			}
			else if(action.name() == "RIGHT")
			{
				player.getComponent(CInput.class).right = false;
			}
			else if(action.name() == "LEFT")
			{
				player.getComponent(CInput.class).left = false;
			}
		}
	}

	@Override
	public void onEnd() {

	}


	private void genPlayer()
	{
		player = m_entityManager.addEntity("Player");

		player.addComponent(new CTransform(new Vec2f(100,100), 8));
		player.addComponent(new CBoundingBox(new Vec2i(192, 192)));
		player.addComponent(new CInput());

		m_entityManager.update();
	}

	public void sMovement()
	{
		CInput pInput = player.getComponent(CInput.class);
		CTransform pTransform = player.getComponent(CTransform.class);

		Vec2f playerVel = new Vec2f();

		if(pInput.up)
		{
			playerVel.y -= 1;
		}
		else if(pInput.down)
		{
			playerVel.y += 1;
		}

		if(pInput.left)
		{
			playerVel.x -= 1;
		}
		else if(pInput.right)
		{
			playerVel.x += 1;
		}

		pTransform.m_vel = playerVel;
		pTransform.m_vel.normalize();

		for(Entity e : m_entityManager.getEntities())
		{
			CTransform eTransform = e.getComponent(CTransform.class);
			eTransform.m_pos.plus(eTransform.m_vel.mult(eTransform.m_speed));
		}
	}

	@Override
	public void sAnimation() 
	{
		for(Entity e : m_entityManager.getEntities())
		{
			if(!e.hasComponent(CAnimation.class)) continue;
			e.getComponent(CAnimation.class).m_animation.update();
		}		
	}

	

}
