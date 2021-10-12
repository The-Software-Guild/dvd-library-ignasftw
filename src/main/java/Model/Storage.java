package Model;

import java.util.HashMap;

public interface Storage {
    boolean containsKey(Integer key);
    Data get(Integer key);
    void put(Integer key, Data value);
    void remove(Integer key);
    int size();
    HashMap<Integer, Data> getAllDVDs();
}
