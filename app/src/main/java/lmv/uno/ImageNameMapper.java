package lmv.uno;
import android.content.Context;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class ImageNameMapper {

    private static Map<Integer, String> imageResourceMap = new HashMap<>();

    static {
        imageResourceMap.put(R.drawable.uno_card_blue0, "uno_card_blue0");
        imageResourceMap.put(R.drawable.uno_card_blue1, "uno_card_blue1");
        imageResourceMap.put(R.drawable.uno_card_blue2, "uno_card_blue2");
        imageResourceMap.put(R.drawable.uno_card_blue3, "uno_card_blue3");
        imageResourceMap.put(R.drawable.uno_card_blue4, "uno_card_blue4");
        imageResourceMap.put(R.drawable.uno_card_blue5, "uno_card_blue5");
        imageResourceMap.put(R.drawable.uno_card_blue6, "uno_card_blue6");
        imageResourceMap.put(R.drawable.uno_card_blue7, "uno_card_blue7");
        imageResourceMap.put(R.drawable.uno_card_blue8, "uno_card_blue8");
        imageResourceMap.put(R.drawable.uno_card_blue9, "uno_card_blue9");
        imageResourceMap.put(R.drawable.uno_card_bluedraw2, "uno_card_bluedraw2");
        imageResourceMap.put(R.drawable.uno_card_bluereverse, "uno_card_bluereverse");
        imageResourceMap.put(R.drawable.uno_card_blueskip, "uno_card_blueskip");
        imageResourceMap.put(R.drawable.uno_card_red0, "uno_card_red0");
        imageResourceMap.put(R.drawable.uno_card_red1, "uno_card_red1");
        imageResourceMap.put(R.drawable.uno_card_red2, "uno_card_red2");
        imageResourceMap.put(R.drawable.uno_card_red3, "uno_card_red3");
        imageResourceMap.put(R.drawable.uno_card_red4, "uno_card_red4");
        imageResourceMap.put(R.drawable.uno_card_red5, "uno_card_red5");
        imageResourceMap.put(R.drawable.uno_card_red6, "uno_card_red6");
        imageResourceMap.put(R.drawable.uno_card_red7, "uno_card_red7");
        imageResourceMap.put(R.drawable.uno_card_red8, "uno_card_red8");
        imageResourceMap.put(R.drawable.uno_card_red9, "uno_card_red9");
        imageResourceMap.put(R.drawable.uno_card_reddraw2, "uno_card_reddraw2");
        imageResourceMap.put(R.drawable.uno_card_redreverse, "uno_card_redreverse");
        imageResourceMap.put(R.drawable.uno_card_redskip, "uno_card_redskip");
        imageResourceMap.put(R.drawable.uno_card_green0, "uno_card_green0");
        imageResourceMap.put(R.drawable.uno_card_green1, "uno_card_green1");
        imageResourceMap.put(R.drawable.uno_card_green2, "uno_card_green2");
        imageResourceMap.put(R.drawable.uno_card_green3, "uno_card_green3");
        imageResourceMap.put(R.drawable.uno_card_green4, "uno_card_green4");
        imageResourceMap.put(R.drawable.uno_card_green5, "uno_card_green5");
        imageResourceMap.put(R.drawable.uno_card_green6, "uno_card_green6");
        imageResourceMap.put(R.drawable.uno_card_green7, "uno_card_green7");
        imageResourceMap.put(R.drawable.uno_card_green8, "uno_card_green8");
        imageResourceMap.put(R.drawable.uno_card_green9, "uno_card_green9");
        imageResourceMap.put(R.drawable.uno_card_greendraw2, "uno_card_greendraw2");
        imageResourceMap.put(R.drawable.uno_card_greenreverse, "uno_card_greenreverse");
        imageResourceMap.put(R.drawable.uno_card_greenskip, "uno_card_greenskip");
        imageResourceMap.put(R.drawable.uno_card_yellow0, "uno_card_yellow0");
        imageResourceMap.put(R.drawable.uno_card_yellow1, "uno_card_yellow1");
        imageResourceMap.put(R.drawable.uno_card_yellow2, "uno_card_yellow2");
        imageResourceMap.put(R.drawable.uno_card_yellow3, "uno_card_yellow3");
        imageResourceMap.put(R.drawable.uno_card_yellow4, "uno_card_yellow4");
        imageResourceMap.put(R.drawable.uno_card_yellow5, "uno_card_yellow5");
        imageResourceMap.put(R.drawable.uno_card_yellow6, "uno_card_yellow6");
        imageResourceMap.put(R.drawable.uno_card_yellow7, "uno_card_yellow7");
        imageResourceMap.put(R.drawable.uno_card_yellow8, "uno_card_yellow8");
        imageResourceMap.put(R.drawable.uno_card_yellow9, "uno_card_yellow9");
        imageResourceMap.put(R.drawable.uno_card_yellowdraw2, "uno_card_yellowdraw2");
        imageResourceMap.put(R.drawable.uno_card_yellowreverse, "uno_card_yellowreverse");
        imageResourceMap.put(R.drawable.uno_card_yellowskip, "uno_card_yellowskip");
        imageResourceMap.put(R.drawable.uno_card_wildchange, "uno_card_wildchange");
        imageResourceMap.put(R.drawable.uno_card_wilddraw4, "uno_card_wilddraw4");
    }

    public static String getImageName(Context context, int resourceId) {
        String logicalName = imageResourceMap.get(resourceId);

        if (logicalName == null) {
            // Handle the case where the resource ID is not found in the map
            logicalName = "unknown_image";
        }

        return logicalName;
    }
}
