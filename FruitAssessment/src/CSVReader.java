import java.io.FileReader;
import java.util.*;

public class CSVReader {

    private String filename;
    public CSVReader(String filename){
        this.filename = filename;
    }
    private void writeLog(String s){
        System.out.println(s);
    }
    public int getTotalNumberOfFruits(){
        int total = -1;
        try{
            Reader reader = new Reader(new FileReader(filename));
            List<String[]> data = reader.readAll();
            int i = 0;

            for (String[] array : data){
                if (i == 0){
                    if(!array[1].equals("age-in-days") && !array[0].equals("fruit-type")){
                        return -3;
                    }
                }
                if (i > 0){
                    total  = total + Integer.valueOf(array[1]);
                }
                i++;
            }
        }
        catch (Exception e){
            writeLog(e.getMessage());

        }
        return total;
    }
    public List<OrderBy> getOldestFruits(){
        List<OrderBy> returnList = new ArrayList<>();
        DuplicateMap<Integer,String> temp = new DuplicateMap<>();
        try{
            Reader reader = new Reader(new FileReader(filename));
            List<String[]> data = reader.readAll();
            int i = 0;
            int largest = 0;
            for (String[] array : data){
                if (i > 0){
                    if (Integer.valueOf(array[1]) > largest) {
                        largest = Integer.valueOf(array[1]);
                    }
                    temp.put(Integer.parseInt(array[1]),array[0]);
                }
                i ++;
            }
            ArrayList<String> values = temp.get(largest);

            for (String s : values){
                returnList.add(new OrderBy(s,largest));
            }
        }
        catch (Exception e){
            writeLog(e.getMessage());
        }

        return returnList;
    }
    public int getTotalTypesOfFruits(){
        int totalTypes = -1;
        List<String> types = new ArrayList<>();
        try{
            Reader reader = new Reader(new FileReader(filename));
            List<String[]> data = reader.readAll();
            int i = 0;
            for (String[] array : data){
                if (i > 0){
                    boolean shouldAdd = true;
                    for (int ii = 0; ii < types.size(); ii++){
                        if (types.get(ii).contains(array[0])){
                            shouldAdd = false;
                            break;
                        }
                    }
                    if (shouldAdd){
                        types.add(array[0]);
                    }
                }
                i ++;
            }
            totalTypes = types.size();
        }
        catch (Exception e){
            writeLog(e.getMessage());
        }

        return totalTypes;
    }
    public List<String> getFruitsInDescOrder(){
        List<String> returnList = new ArrayList<>();
        HashMap<String,Integer> temp = new HashMap<>();

        try{
            Reader reader = new Reader(new FileReader(filename));
            List<String[]> data = reader.readAll();
            int i = 0;

            for (String[] array : data){
                if (i > 0){
                    if (temp.containsKey(array[0])){
                        temp.replace(array[0],Integer.valueOf(Integer.valueOf(temp.get(array[0])) + Integer.valueOf(array[1])));
                    }else{
                        temp.put(array[0],Integer.valueOf(array[1]));
                    }
                }
                i ++;
            }
        }
        catch (Exception e){
            writeLog(e.getMessage());
        }
        Map<String, Integer> map = sortByValues(temp);
        Set set2 = map.entrySet();
        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
            Map.Entry me2 = (Map.Entry)iterator2.next();
            returnList.add(me2.getKey() + ": " + me2.getValue());

        }

        return  returnList;
    }
    private static HashMap sortByValues(HashMap map) {
        List list = new LinkedList(map.entrySet());
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });


        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }
    public List<Fruits> getChOfFruit(){
        List<Fruits> returnList = new ArrayList<>();
        try{
            Reader reader = new Reader(new FileReader(filename));
            List<String[]> data = reader.readAll();
            int i = 0;
            for (String[] array : data){
                String name,number = "";
                name = array[0];
                number = array[1];
                if (i > 0){
                    List<String> ChList = new ArrayList<>();
                    for (int ii = 2; ii < array.length; ii++){
                        ChList.add(array[ii]);
                    }
                    returnList.add(new Fruits(name,number,ChList));
                }
                i ++;
            }
        }
        catch (Exception e){
            writeLog(e.getMessage());
        }
        return  returnList;
    }

}
