package Model.Landscape;

import org.junit.Test;

import static org.junit.Assert.*;


public class LandscapeFactoryTest {

    @Test
    public void LandscapeCreation_allTypes() {
        GenericLandscape myLandscape;
        GenericLandscape.GenericLandscapeFactory myFactory;


        myFactory = new PlainLandscape.LandscapeFactory();
        myLandscape = myFactory.createInstance();

        assertEquals(1, myLandscape.getPassableness());


        myFactory = new ForestLandscape.LandscapeFactory();
        myLandscape = myFactory.createInstance();

        assertEquals(3, myLandscape.getPassableness());


        myFactory = new MountainLandscape.LandscapeFactory();
        myLandscape = myFactory.createInstance();

        assertEquals(6, myLandscape.getPassableness());
    }
}
