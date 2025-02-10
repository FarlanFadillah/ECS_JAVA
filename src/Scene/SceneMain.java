package Scene;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

import Action.Action;
import Component.*;

import Engine.Engine;
import Entity.Entity;
import FileHandler.AssetsManager;
import Math.Vec2f;

public class SceneMain extends Scene{

	private Entity player;

	public SceneMain(Engine engine) {
		super(engine);
		// TODO Auto-generated constructor stub
		genPlayer();
		registerAction(KeyEvent.VK_W, "UP");
		registerAction(KeyEvent.VK_W, "UP");
		registerAction(KeyEvent.VK_S, "DOWN");
		registerAction(KeyEvent.VK_D, "RIGHT");
		registerAction(KeyEvent.VK_A, "LEFT");
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
	public void sRender(Graphics2D g2d) {
		// TODO Auto-generated method stub
		AssetsManager assets = getEngine().assets();
		for(Entity temp : m_entityManager.getEntities("Player"))
		{
			CTransform ct = temp.getComponent(CTransform.class);
			CBoundingBox cb = temp.getComponent(CBoundingBox.class);

			Vec2f pos = ct.m_pos;
			Vec2f size = cb.m_size;

			Rectangle2D.Float rect = new Rectangle2D.Float(pos.x, pos.y, size.x, size.y);
			g2d.setColor(Color.blue);
			g2d.fill(rect);

			g2d.setColor(Color.red);
			g2d.draw(rect);
		}

		int centerX = 192 + (192/2);
		int centerY = 192 + (192/2);
		double angle = Math.toRadians(45);

		// System.out.println(centerX + " " + centerY);
		g2d.rotate(angle);
		g2d.translate(centerX, centerY);

		g2d.drawImage(assets.getSprite("Idle_Fighter_Right").grabImage(1, 1, 192, 192), 192, 192, null);
		Rectangle2D.Float rect = new Rectangle2D.Float(192, 192,192, 192);
		g2d.setColor(new Color(0, 0, 255, 100));
		g2d.fill(rect);


		g2d.rotate(-angle);
		//g2d.translate(-centerX, -centerY);

		sAnimation();
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
		// TODO Auto-generated method stub
	}


	private void genPlayer()
	{
		player = m_entityManager.addEntity("Player");

		player.addComponent(new CTransform(new Vec2f(10,10), 5));
		player.addComponent(new CBoundingBox(new Vec2f(32, 32)));
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
