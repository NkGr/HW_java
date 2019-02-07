package nikolay.grigorik.com;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<E> implements CountMap<E> {

    private Map<E,Integer> elements;
    private Map<E,Integer> source;

    public CountMapImpl() {
        elements = new HashMap<>();
    }

    public void add(E e) {
        if (elements.containsKey(e)) {
            int value = elements.get(e);
            elements.put(e, ++value);
        } else {
            elements.put(e, 1);
        }
    }

    public int getCount(E e) {
        return elements.get(e);
    }

    public int remove(E e) {
        int count = elements.get(e);
        elements.remove(e);
        return count;
    }

    public int size() {
        return elements.size();
    }

    public void addAll(CountMap<E> source) {
        this.source = source.toMap();
        for (Map.Entry<E, Integer> entry : this.source.entrySet()) {
            if (elements.containsKey(entry.getKey())) {
                elements.put(entry.getKey(), elements.get(entry.getKey()) + entry.getValue());
            } else {
                elements.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public Map toMap() {
        return elements;
    }

    public void toMap(Map destination) {
        this.source = destination;
        for (Map.Entry<E, Integer> entry : elements.entrySet()) {
            if (source.containsKey(entry.getKey())) {
                source.put(entry.getKey(), source.get(entry.getKey()) + entry.getValue());
            } else {
                source.put(entry.getKey(), entry.getValue());
            }
        }
    }

}