import java.util.ArrayList;
import java.util.List;

public interface Test {

    public static void main(String[] args) {

    }

    public static List<Record> contactDetails(){
        List<Record> recordList = new ArrayList<>();
        Record email = new Record("fit@gmail.com");
        Record phone = new Record("83691240");
        Record itEmail = new Record("fitit@gmail.com");
        Record fax = new Record("+1 (555) 123-4567");
        Record address = new Record("Athlone City Center");
        recordList.add(email);
        recordList.add(phone);
        recordList.add(itEmail);
        recordList.add(fax);
        recordList.add(address);
        return  recordList;
    }
}
