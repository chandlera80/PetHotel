import java.util.HashMap;
import java.util.Map;

public class TimeZoneDemo
{
    private Map<String, Integer> timeZones = new HashMap<>();

    public static void main(String[] args)
    {

        TimeZoneDemo timeZoneDemo = new TimeZoneDemo();
        timeZoneDemo.demo();
    }

    private void demo()
    {
        timeZones.put("EST", -5);
        timeZones.put("CST", -6);
        timeZones.put("MST", -7);
        timeZones.put("PST", -8);
        timeZones.put("GMT", 0);

        int diff = getTimeDiff("PST", "EST");
        System.out.println(diff);

    }
        private int getTimeDiff (String firstTimeZone, String secondTimeZone  )
        {
            int hoursBetween;

            int firstTimeZoneOffSet = timeZones.get(firstTimeZone);
            int secondTimeZoneOffSet = timeZones.get(secondTimeZone);
            hoursBetween = firstTimeZoneOffSet - secondTimeZoneOffSet;

        return hoursBetween;
    }
}

