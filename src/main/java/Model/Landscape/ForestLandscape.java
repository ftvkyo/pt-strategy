package Model.Landscape;

public class ForestLandscape extends GenericLandscape {

    static public class LandscapeFactory extends GenericLandscapeFactory {

        public GenericLandscape createInstance() {
            GenericLandscape l = new ForestLandscape();
            l.setPassableness(3);
            return l;
        }
    }


    @Override
    public String getID() {
        return "landscape-forest";
    }
}
