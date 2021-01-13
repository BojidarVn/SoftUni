package workingWithAbstraction.greedyTimes;

import java.util.Iterator;
import java.util.Map;

public class Treasure implements Iterable<Treasure.Pair<String,Long>> {

    public static class Pair<K,V>{
        private K first;
        private V second;

        public Pair(K first,V second) {
            this.first=first;
            this.second=second;
        }

        public K getFirst(){
            return this.first;
        }

        public V getSecond() {
            return this.second;
        }
    }

    private String[] goods;


    public Treasure(String[] goods) {
        this.goods = goods;
    }

    @Override
    public Iterator<Pair<String,Long>> iterator() {
        return new Iterator<>() {
            private int index=0;
            @Override
            public boolean hasNext() {
                return index<goods.length;
            }

            @Override
            public Pair<String,Long> next() {
                String item=goods[index++];
                Long value=Long.parseLong(goods[index++]);
                return new Treasure.Pair<>(item,value);
            }
        };
    }


}
