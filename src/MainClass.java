import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MainClass {

    private static Map<String, String> map;
    private static Map<String, Date> mapWithDate;
    private static SimpleDateFormat dateFormat;
    private static int surnameCounter;
    private static int nameCounter;
    private static Map.Entry<String, Date> data;


    public static void main(String[] args) {
        addNameAndSurnameToMap();
        System.out.println(checkTheSameSurname("Surname8"));
        System.out.println(checkTheSameName("Name1"));

        removeAllSummerPeople((HashMap<String, Date>) addSurnameAndDateToMap());

    }

    private static void addNameAndSurnameToMap() {
        map = new HashMap<>();
        for (int i = 0; i < 7; i++) {
            map.put("Surname" + i, "Name" + i);
        }
        map.put("Surname8", "Name1");
        map.put("Surname9", "Name4");
        map.put("Surname10", "Name1");
    }

    private static int checkTheSameSurname(String surname) {
        for(Map.Entry<String, String> s : map.entrySet())
            if(s.getKey().equals(surname)) surnameCounter++;
        return surnameCounter;
    }

    private static int checkTheSameName(String name){
        for(Map.Entry<String, String> s : map.entrySet())
            if(s.getValue().equals(name)) nameCounter++;
        return nameCounter;
    }

    private static Map<String, Date> addSurnameAndDateToMap() {
        mapWithDate = new HashMap<>();
        mapWithDate.put("A", new Date("JUNE-1-1980"));
        mapWithDate.put("B", new Date("AUGUST 5 1975"));
        mapWithDate.put("C", new Date("MARCH 1 1990"));
        mapWithDate.put("D", new Date("JANUARY 3 1989"));
        mapWithDate.put("F", new Date("SEPTEMBER 9 1976"));
        mapWithDate.put("G", new Date("JUNE 6 1999"));
        mapWithDate.put("E", new Date("OCTOBER 3 2000"));
        mapWithDate.put("T", new Date("JUNE 1 2000"));
        mapWithDate.put("X", new Date("MARCH 15 1950"));
        mapWithDate.put("Y", new Date("JUNE 1 2001"));

        return mapWithDate;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map){
        Iterator<Map.Entry<String,Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            data = iterator.next();
            if ((data.getValue().getMonth() == 5) || (data.getValue().getMonth() == 6) || (data.getValue().getMonth() == 7)) {
                iterator.remove();
            }
        }
        map.forEach((name, date) -> System.out.println("Name: " + name + "\nBirthDate: " + new SimpleDateFormat("dd MMMM YYYY").format(date)));
    }
}

