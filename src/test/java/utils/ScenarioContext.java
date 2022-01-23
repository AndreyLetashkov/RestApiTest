package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ScenarioContext {
    private static ScenarioContext instance;
    private final ThreadLocal<Map<String, Integer>> contextHolder = ThreadLocal.withInitial(HashMap::new);

    public static ScenarioContext getInstance() {
        synchronized (ScenarioContext.class) {
            if (Objects.isNull(instance)) {
                instance = new ScenarioContext();
            }
            return instance;
        }
    }

    public void put(String key, Integer value) {
        contextHolder.get().put(key, value);
    }

    public Object get(String key) {
        return contextHolder.get().get(key);
    }

    public void clear() {
        instance.contextHolder.get().clear();
    }
}