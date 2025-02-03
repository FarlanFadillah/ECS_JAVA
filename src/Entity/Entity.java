package Entity;

import java.util.HashMap;
import java.util.Map;

import Component.Component;

public class Entity {

    private boolean active = true;
    private String tag = "default";
    private long id = 0;
    private String name = "NONE";

    // Component storage using a Map for flexibility
    private final Map<Class<?>, Component> components = new HashMap<>();

    // Constructor only accessible within the package (mimicking C++ 'friend')
    Entity(long id, String tag) {
        this.id = id;
        this.tag = tag;

    }

    public String getTag() {
        return tag;
    }

    public boolean isActive() {
        return active;
    }

    public long getId() {
        return id;
    }

    public void destroy() {
        active = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addComponent(Component component) {
        components.put(component.getClass(), component);
    }

    public <T extends Component> T getComponent(Class<T> componentType) {
        return componentType.cast(components.get(componentType));
    }

    public boolean hasComponent(Class<? extends Component> componentType) {
        return components.containsKey(componentType);
    }
}
