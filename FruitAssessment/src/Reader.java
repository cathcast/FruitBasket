import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    private FileReader filename;

    public Reader(FileReader filename){
        this.filename = filename;
    }
    public List<String[]> readAll(){
        List<String[]> returnList = new ArrayList<>();
        try{
            try (BufferedReader br = new BufferedReader(filename)) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] splitter = line.split(",");
                    returnList.add(splitter);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnList;
    }
}
