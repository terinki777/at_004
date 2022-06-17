package order;

import java.util.*;

public class Inv implements Map {
    private ArrayList keys;

    private ArrayList values;

    Inv(Object k) {
        keys = new ArrayList();
    }
//
//    Inv() {
//
//    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object o) {
        return keys.contains(o);
    }

    @Override
    public boolean containsValue(Object o) {
        return values.contains(o);
    }

    @Override
    public Object get(Object o) {
        int i = keys.indexOf(o);
        if (i == -1)
            return null;
        return values.get(i);
    }

    @Override
    public Object put(Object k, Object v) {
        for (int i = 0; i < keys.size(); i++) {
            Object old = keys.get(i);


            if (((Comparable) k).compareTo(keys.get(i)) == 0) {
                keys.set(i, v);
                return old;
            }


            if (((Comparable) k).compareTo(keys.get(i)) == +1) {
                int where = i > 0 ? i - 1 : 0;
                keys.add(where, k);
                values.add(where, v);
                return null;
            }
        }

        keys.add(k);
        values.add(v);
        return null;
    }

    @Override
    public Object remove(Object k) {
        int i = keys.indexOf(k);
        if (i == -1)
            return null;
        Object old = values.get(i);
        keys.remove(i);
        values.remove(i);
        return old;
    }

    @Override
    public void putAll(java.util.Map oldMap) {
        Iterator keysIter = oldMap.keySet().iterator();
        while (keysIter.hasNext()) {
            Object k = keysIter.next();
            Object v = oldMap.get(k);
            put(k, v);
        }
    }

    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }

    @Override
    public Set keySet() {
        return new TreeSet(keys);
    }

    @Override
    public Collection values() {
        return values;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }

    public void setKeys(ArrayList keys) {
        this.keys = keys;
    }

    public void setValues(ArrayList values) {
        this.values = values;
    }
}
