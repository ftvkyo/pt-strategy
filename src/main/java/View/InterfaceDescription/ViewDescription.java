package View.InterfaceDescription;

import java.util.HashMap;
import java.util.Map;


public class ViewDescription {
    public Map<String, RenderableDescription> availableScreens = new HashMap<>();
    public String initialScreen = null;

    public float internalWidth = 0;
    public float internalHeight = 0;
}
