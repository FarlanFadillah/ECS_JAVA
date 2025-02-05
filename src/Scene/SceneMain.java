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
import Math.Vec2;

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
		for(Entity temp : m_entityManager.getEntities("Player"))
		{
			CTransform ct = temp.getComponent(CTransform.class);
			CBoundingBox cb = temp.getComponent(CBoundingBox.class);

			Vec2 pos = ct.m_pos;
			Vec2 size = cb.m_size;

			Rectangle2D.Float rect = new Rectangle2D.Float(pos.x, pos.y, size.x, size.y);
			g2d.setColor(Color.blue);
			g2d.fill(rect);

			g2d.setColor(Color.red);
			g2d.draw(rect);
		}
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

		player.addComponent(new CTransform(new Vec2(10,10), new Vec2(5,5)));
		player.addComponent(new CBoundingBox(new Vec2(32, 32)));
		player.addComponent(new CInput());

		m_entityManager.update();
	}

	public void sMovement()
	{
		CInput pInput = player.getComponent(CInput.class);
		CTransform pTransform = player.getComponent(CTransform.class);
		if(pInput.up)
		{
			pTransform.m_pos.y -= pTransform.m_vel.y;
		}
		else if(pInput.down)
		{
			pTransform.m_pos.y += pTransform.m_vel.y;
		}

		if(pInput.left)
		{
			pTransform.m_pos.x -= pTransform.m_vel.x;
		}
		else if(pInput.right)
		{
			pTransform.m_pos.x += pTransform.m_vel.x;
		}
	}

}
