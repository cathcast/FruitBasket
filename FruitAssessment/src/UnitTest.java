import java.util.Collections;
import java.util.List;

public class UnitTest {

    public static void main(String[] args){
        CSVReader reader = new CSVReader("abc.txt");


        int totalCount = reader.getTotalNumberOfFruits();
        int totalTypes = reader.getTotalTypesOfFruits();
        List<String> descOrder = reader.getFruitsInDescOrder();
        Collections.reverse(descOrder);
        List<Fruits> getCh = reader.getChOfFruit();

        if (totalCount == -1 && totalTypes == -1 && descOrder.size() == 0 && getCh.size() == 0){
            System.out.println("Error reading file");
            return;
        }


    }
}
