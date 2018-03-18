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

        assertEquals(myLandscape.getPassableness(), 1);


        myFactory = new ForestLandscape.LandscapeFactory();
        myLandscape = myFactory.createInstance();

        assertEquals(myLandscape.getPassableness(), 3);


        myFactory = new MountainLandscape.LandscapeFactory();
        myLandscape = myFactory.createInstance();

        assertEquals(myLandscape.getPassableness(), 6);
    }
}
