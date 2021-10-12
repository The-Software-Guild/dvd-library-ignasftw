package Model;

import javax.sql.DataSource;
import java.util.HashMap;

    public class DataStorage implements Storage{
        private HashMap<Integer, Data> dvdDataList = new HashMap<>();

        public boolean containsKey(Integer key){
            return dvdDataList.containsKey(key);
        }

        public Data get(Integer key){
            return dvdDataList.get(key);
        }

        public void put(Integer key, Data value){
            dvdDataList.put(key, value);
        }

        public void remove(Integer key){
            dvdDataList.remove(key);
        }

        public int size(){
            return dvdDataList.size();
        }

        public HashMap<Integer, Data> getAllDVDs() {
            return dvdDataList;
        }
    }



