package br.com.supplyradar.core.command;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

import static java.util.Optional.ofNullable;

public class CommandContext extends HashMap<String, Object> implements Serializable {
    private static final String DATA = "data";
    private static final String RESULT = "result";

    public CommandContext() {
        super();
    }

    public CommandContext(final Objects data) {
        super.put(DATA, data);
    }

    public <R> R getProperty(final String key, final Class<R> clazz) {
        return ofNullable(get(key)).map(clazz::cast).orElse(null);
    }

    public <T extends Object> T getData(final Class<T> clazz) {
        return getProperty(DATA, clazz);
    }

    public void setData(final Object data) {
        put(DATA, data);
    }

    public void setResult(final Object result) {
        put(RESULT, result);
    }

    public <T extends Object> T getResult(final Class<T> clazz) {
        return getProperty(RESULT, clazz);
    }

    public Class<?> getDataClass() {
        return ofNullable(get(DATA)).map(Object::getClass).orElse(null);
    }

    public Class<?> getResultClass() {
        return ofNullable(get(RESULT)).map(Object::getClass).orElse(null);
    }

}
