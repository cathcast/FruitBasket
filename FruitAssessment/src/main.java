import java.util.Collections;
import java.util.List;

public class main {

    public static void main(String[] args){
        boolean arg = false;
        if(args.length < 1) {
            System.err.println("Invalid command line, exactly one argument required");
            System.exit(1);
        }
        if (args[0].contains("-h")){
            System.out.println("use -f as path\ne.g -f users\\computer\\desktop\\sample.csv");
        }else if(args[0].contains("-f")){
            arg = true;

        }else{
            System.out.println("Invalid command, please try again or use -h for help.");
        }
        if (!arg){

            return;
        }
        CSVReader reader = new CSVReader(String.valueOf(args[1]));
        try{
            int totalCount = reader.getTotalNumberOfFruits();
            if (totalCount == -1){
                System.out.println("File doesn't exists...");
                System.exit(1);
            }else if (totalCount == -3){
                System.out.println("Wrong csv pattern, please use correct pattern for processing.");
                System.exit(1);
            }else{
                System.out.println("Total number of fruit: "+totalCount);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return;
        }
        try{
            int totalTypes = reader.getTotalTypesOfFruits();
            if (totalTypes == -1){
                System.out.println("File doesn't exists...");
            }else{
                System.out.println("Total types of fruit: "+totalTypes);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        List<OrderBy> oldestFruits = reader.getOldestFruits();
        List<String> descOrder = reader.getFruitsInDescOrder();
        Collections.reverse(descOrder);
        List<Fruits> getCh = reader.getChOfFruit();

        if (oldestFruits.size() > 0){
            System.out.println("\nOldest fruit & age:");
            for (OrderBy oldest : oldestFruits){
                System.out.println(oldest.getName() + " : "+oldest.getCount());
            }
        }


        if (descOrder.size() > 0){
            System.out.println("\nThe number of each type of fruit in descending order:");
            for (String item : descOrder){
                System.out.println(item);
            }
        }

        if (getCh.size() > 0){
            System.out.println("\nThe various characteristics (count, color, shape, etc...) of each fruit by type:");

            for (Fruits ch : getCh){
                String toPrint = ch.number + " "+ch.name + " : ";
                for (String chrs : ch.getChars()){
                    toPrint += chrs + ",";
                }
                System.out.println(toPrint);
            }
        }

    }
}
