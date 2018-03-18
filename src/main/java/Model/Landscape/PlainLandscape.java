package Model.Landscape;

public class PlainLandscape extends GenericLandscape {

    static public class LandscapeFactory extends GenericLandscapeFactory {

        public GenericLandscape createInstance() {
            GenericLandscape l = new PlainLandscape();
            l.setPassableness(1);
            return l;
        }
    }
}
