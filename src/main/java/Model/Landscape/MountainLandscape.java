package Model.Landscape;

public class MountainLandscape extends GenericLandscape {

    static public class LandscapeFactory extends GenericLandscapeFactory {

        public GenericLandscape createInstance() {
            GenericLandscape l = new MountainLandscape();
            l.setPassableness(6);
            return l;
        }
    }


    @Override
    public String getID() {
        return "landscape-mountain";
    }
}
