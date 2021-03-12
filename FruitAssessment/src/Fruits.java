import java.util.List;

public class Fruits {
    String name,number;
    List<String> chars;

    public Fruits(String name, String number, List<String> chars) {
        this.name = name;
        this.number = number;
        this.chars = chars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<String> getChars() {
        return chars;
    }

    public void setChars(List<String> chars) {
        this.chars = chars;
    }
}
