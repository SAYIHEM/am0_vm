package Constants;

public abstract class ArgPatterns {

    public static final String GLOBAL_LOKAL = "\\((global|lokal), (\\d+|-\\d+)\\)";
    public static final String BRACKET_INT = "\\((\\d+|-\\d+)\\)";
    public static final String INT = "\\d+";


    public static final String AM0_COMMAND = "(\\w+ \\d+|\\w+)";

    ///////////////////////////////////////////////////////////////////////////
    // Input has to be like this: "(13,2:2,3:0:3:0,4,4,-)"
    // Stack Structures has to be: "1:3:2" or "-"
    ///////////////////////////////////////////////////////////////////////////
    public static final String AM1_INPUT = "\\(\\d+\\,(\\-|(\\d+(\\:\\d+|)+))\\,(\\-|(\\d+(\\:\\d+|)+))\\,\\d+\\,(\\-|(\\d+(\\:\\d+|)+))\\,(\\-|(\\d+(\\:\\d+|)+))\\)";
    public static final String COMMAND_SINGLE = "\\w+";
    public static final String COMMAND_PARAMETER = "\\w+ .+";


}
