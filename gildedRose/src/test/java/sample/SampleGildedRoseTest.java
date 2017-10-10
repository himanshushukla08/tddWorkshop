package sample;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class SampleGildedRoseTest {

    @Test
    public void inventoryContainsSixItems() {
        List<SampleItem> inventory = new SampleGildedRose().updateQuality();

        assertEquals(6, inventory.size());
    }
}
