package View.InterfaceDescription;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RenderableDescription {
    public String type = null;

    public List<Float> color = new ArrayList<>();

    public List<Float> coords = new ArrayList<>();

    public Map<String, RenderableDescription> children = new HashMap<>();

    public String callback = null;
}
