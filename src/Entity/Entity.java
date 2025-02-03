package Entity;

import java.util.HashMap;
import java.util.Map;

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

    public <T extends Component> T getComponent(Class<T> componentClass) {
        return componentClass.cast(components.get(componentClass));
    }

    public <T extends Component> boolean hasComponent(Class<T> componentClass) {
        return components.containsKey(componentClass);
    }

    public <T extends Component> void removeComponent(Class<T> componentClass) {
        components.remove(componentClass);
    }

    public <T extends Component> T addComponent(Class<T> componentClass, T component) {
        components.put(componentClass, component);
        return component;
    }

    // Base Component class to be extended by other components
    public static abstract class Component {
        public boolean has = false;
    }
}
