package util;

import java.util.List;

public class ListUtil {

    public static String listOfStringsToString(List<String> strings) {

        String toReturn = "";

        for (int i = 0; i < strings.size(); i++) {
            toReturn += strings.get(i);
            if (i != strings.size() - 1) {
                toReturn += ", ";
            }
        }

        return toReturn;
    }

}
