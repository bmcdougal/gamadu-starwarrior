package com.gamadu.starwarrior.systems;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.gamadu.starwarrior.components.Enemy;
import com.gamadu.starwarrior.components.Health;
import com.gamadu.starwarrior.components.Transform;

public class EnemyHealthBarRenderSystem extends EntityProcessingSystem {
	private GameContainer container;
	private Graphics g;
	private ComponentMapper<Health> healthMapper;
	private ComponentMapper<Transform> transformMapper;

	public EnemyHealthBarRenderSystem(GameContainer container) {
		super(Aspect.getAspectFor(Health.class, Transform.class, Enemy.class));
		this.container = container;
		this.g = container.getGraphics();
	}

	@Override
	public void initialize() {
		healthMapper = world.getMapper(Health.class);
		transformMapper = world.getMapper(Transform.class);
	}

	@Override
	protected void process(Entity e) {
		Health health = healthMapper.get(e);
		Transform transform = transformMapper.get(e);
		
		g.setColor(Color.darkGray);
		g.fillRect(transform.getX()-10, transform.getY()-15, 20, 2);
		
		g.setColor(Color.red);
		g.fillRect(transform.getX()-10, transform.getY()-15, health.getHealthFactor()*20, 2);
	}

}
