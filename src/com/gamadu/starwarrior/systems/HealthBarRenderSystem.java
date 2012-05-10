package com.gamadu.starwarrior.systems;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.EntityProcessingSystem;
import com.gamadu.starwarrior.components.Health;
import com.gamadu.starwarrior.components.Transform;

public class HealthBarRenderSystem extends EntityProcessingSystem {
	private GameContainer container;
	private Graphics g;
	private ComponentMapper<Health> healthMapper;
	private ComponentMapper<Transform> transformMapper;

	public HealthBarRenderSystem(GameContainer container) {
		super(Health.class, Transform.class);
		this.container = container;
		this.g = container.getGraphics();
	}

	@Override
	public void initialize() {
		healthMapper = new ComponentMapper<Health>(Health.class, world);
		transformMapper = new ComponentMapper<Transform>(Transform.class, world);
	}

	@Override
	protected void process(Entity e) {
		Health health = healthMapper.get(e);
		Transform transform = transformMapper.get(e);
		
		g.setColor(Color.white);
		g.drawString(health.getHealthPercentage() + "%", transform.getX()-10, transform.getY()-30);
	}

}
