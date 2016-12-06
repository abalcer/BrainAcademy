package com.brainacademy.music.persistence;

import java.util.HashMap;
import java.util.Map;


public class InMemoryEntityManager {
    private Map<String, Object[]> map;

    public InMemoryEntityManager() {
        this.map = new HashMap<>();
    }

    public void addEntity(Object entity) {
        String type = entity.getClass().getSimpleName();

        Object[] entities = map.get(type);
        if (entities == null) {
            entities = new Object[0];
        }

        int idx = indexOf(entity);
        if (idx == - 1) {
            Object[] tmp = new Object[entities.length + 1];
            tmp[0] = entity;
            for (int i = 1; i < tmp.length; i++) {
                tmp[i] = entities[i - 1];
            }
            entities = tmp;
        }

        map.put(type, entities);
    }

    public int indexOf(Object entity) {
        Object[] entities = map.get(entity.getClass().getSimpleName());
        if (entities == null) {
            return - 1;
        }

        int idx = - 1;
        for (int i = 0; i < entities.length; i++) {
            if (entities[i].equals(entity)) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    public Object[] getAll(String entityType) {
        return map.get(entityType);
    }

    public void update(Object entity) {
        int idx = indexOf(entity);
        if (idx != - 1) {
            Object[] entities = getAll(entity.getClass().getSimpleName());
            entities[idx] = entity;
        }
    }

    public void remove(Object entity) {
        int idx = indexOf(entity);
        if (idx != - 1) {
            String type = entity.getClass().getSimpleName();
            Object[] entities = getAll(type);
            Object[] tmp = new Object[entities.length - 1];
            int k = 0;
            for (int i = 0; i < entities.length; i++) {
                if(i == idx) {
                    continue;
                }
                tmp[k++] = entities[i];
            }

            map.put(type, tmp);
        }
    }
}
