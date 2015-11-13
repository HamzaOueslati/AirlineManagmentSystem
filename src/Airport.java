import java.util.ArrayList;

/**
 * Created by hamza on 02/11/2015.
 */
public class Airport {
    String code;

    public Airport(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static boolean testCode(String code){
        if(code.length() == 3)
            return true;
        else
            return false;
    }

    public static boolean testUniqCode( ArrayList <Airport> airports, String code)
    {
        boolean isUniq = true;
        for (Airport airport : airports){
            if(airport.getCode().equals(code))
            {
                isUniq = false;
            }
        }
        return isUniq;
    }
}
