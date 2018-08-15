import java.util.HashMap;
import java.util.Map;

public class SimpleMap
{


    public static void main(String[] args)
    {

        SimpleMap simplemap = new SimpleMap ();
        simplemap.demo();

    }



        private void demo()
    {
        Map<String,String > countries = new HashMap<String,String>();


        countries.put("USA",  "United States");
        countries.put("USA",  "United States 2");
        countries.put("MEX", "Mexico");
        countries.put ("CAN", "Canada ");
        String stars = countries.get("USA");
        System.out.println(stars);
        String maple = countries.get("CAN");
        System.out.println(maple);
        String removedValue = countries.remove("USA");
        System.out.println(countries);
    }
}
