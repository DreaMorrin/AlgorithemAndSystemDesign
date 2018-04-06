package main.OA03032018;

import java.util.*;

public class ItemAssociation {
    public static void main(String[] args) {
        ItemAssociation ia = new ItemAssociation();
        String[][] items = {{"itemA", "itemB"}, {"itemC", "itemD"},
                {"itemA", "itemC"}, {"itemE", "itemF"}, {"itemG", "itemD"}};
        System.out.println(Arrays.toString(ia.count(items)));

    }

    public String[] count(String[][] items) {
        if (items == null || items.length == 0) {
            return null;
        }

        Map<String, String> hash = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            hash.put(items[i][0], items[i][0]);
            hash.put(items[i][1], items[i][1]);
        }

        for (String[] pair : items) {
            String val, unionKey;
            String k0 = hash.get(pair[0]);
            String k1 = hash.get(pair[1]);
            if (k0.compareTo(k1) < 0) {
                unionKey = k0;
                val = k1;
            } else {
                unionKey = k1;
                val = k0;
            }
//            hash.put(val, unionKey);
            for (Map.Entry<String, String> entry : hash.entrySet()) {
                if (entry.getValue().equals(val)) {
                    hash.put(entry.getKey(), unionKey);
                }
            }
        }
        Map<String, List<String>> map = new HashMap<>();
        for (Map.Entry<String, String> entry : hash.entrySet()) {
            if (map.containsKey(entry.getValue())) {
                map.get(entry.getValue()).add(entry.getKey());
            } else {
                List<String> list = new ArrayList<>();
                list.add(entry.getKey());
                map.put(entry.getValue(), list);
            }
        }

        int size = 0;
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > size) {
                list = entry.getValue();
                size = list.size();
            }
        }

        String[] res = new String[size];
        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        return res;
    }

    public List<String> findBookColl(List<List<String>> books){
        //map string to int
        int idx =0;
        HashMap<String, Integer> map = new HashMap<>();

        for (List<String> pair: books){
            for (String book: pair){
                if(!map.containsKey(book)){
                    map.put(book, idx++);
                }

            }
        }



        int cnt = idx;
        String[] revertedMap = new String[cnt];
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            revertedMap[entry.getValue()] = entry.getKey();
        }


        UnionFind uf = new UnionFind(idx);
        for (List<String> pair: books){
            uf.union(map.get(pair.get(0)), map.get(pair.get(1)));
        }


        int maxFather = -1;
        int maxChildren = 0;
        int[] res = uf.getFather();

        //father: list of children
        HashMap<Integer, List<Integer>> childrenMap = new HashMap<>();
        for (int i=0; i<cnt; i++){
            List<Integer> child = childrenMap.get(res[i]);
            if(child!=null){
                child.add(i);
            }else{
                child = new ArrayList<>();
                child.add(i);
                childrenMap.put(res[i], child);
            }

            if (child.size()>maxChildren){
                maxChildren = child.size();
                maxFather = res[i];
            }

        }


        List<String> res1 = new ArrayList<>();

        for (Integer child: childrenMap.get(maxFather)){
            res1.add(revertedMap[child]);
        }

        return res1;




    }

}

class UnionFind{
    int k;
    int[] fa = new int[k];
    int[] rank = new int[k];
    public UnionFind(int k){
        this.k = k;
        for (int i=0; i<k; i++){
            fa[i] = i;
        }
    }

    public int find(int x){
        if(this.fa[x]!=x){
            this.fa[x] = find(this.fa[x]);
        }
        return this.fa[x];
    }

    public void union(int x, int y){
        int xf = find(x);
        int yf = find(y);
        if(xf==yf) {
            return;
        }else if(this.rank[x]<this.rank[y]){
            this.fa[x] = y;
        }else if(this.rank[x]>this.rank[y]){
            this.fa[y] = x;
        }else{
            this.fa[y] = x;
            this.rank[y]++;
        }

    }

    public int[] getFather(){
        return this.fa;
    }
}