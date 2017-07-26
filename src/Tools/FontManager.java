package Tools;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FontManager {

    private int defaultSize = 10;
    private List<Font> fontList;

    // Add new Fonts here:
    public static Font UNICODE = new Font("Code2000", Font.PLAIN, 10);


    public FontManager() {

        this.fontList = new ArrayList<>();

        // Add new Fonts here:
        this.fontList.add(UNICODE);

    }


}
