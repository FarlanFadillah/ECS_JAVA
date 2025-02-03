package Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class EntityManager {
	private List<Entity> m_entities = new ArrayList<>();
	private List<Entity> m_entitiesToAdd = new ArrayList<>();
	private Map<String, List<Entity>> m_entitiesMap= new HashMap<>();
	private int m_totalEntities = 0;
	
	private void removeDeadEntities(List<Entity> vec)
	{
		vec.removeIf(e -> (!e.isActive()));
	}
	
	public List<Entity> getEntities()
	{
		return m_entities;
	}
	
	
	public List<Entity> getEntities(String tag)
	{
		return m_entitiesMap.get(tag);
	}
	
	public Entity addEntity(String tag)
	{
		Entity entity = new Entity(m_totalEntities++, tag);
		
		m_entitiesToAdd.add(entity);
		
		return entity;
	}
	
	public void addEntity(Entity entity, String tag)
	{
		m_entitiesMap.get(tag).add(entity);
	}
	
	public void update()
	{
		for(Entity e : m_entitiesToAdd)
		{
			m_entities.add(e);
			m_entitiesMap.computeIfAbsent(e.getTag(),  k -> new ArrayList<>()).add(e); 
		}
		
		m_entitiesToAdd.clear();
		
		
		removeDeadEntities(m_entities);
		
		for(Entry<String, List<Entity>> e : m_entitiesMap.entrySet())
		{
			removeDeadEntities(e.getValue());
		}
	}
}
