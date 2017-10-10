package sample;

import java.util.ArrayList;
import java.util.List;


public class SampleGildedRose {

    private List<SampleItem> inventory = null;

    public SampleGildedRose() {
        inventory = new ArrayList<>();
        inventory.add(new SampleItem("+5 Dexterity Vest", 10, 20));
        inventory.add(new SampleItem("Aged Brie", 2, 0));
        inventory.add(new SampleItem("Elixir of the Mongoose", 5, 7));
        inventory.add(new SampleItem("Sulfuras, Hand of Ragnaros", 0, 80));
        inventory.add(new SampleItem("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        inventory.add(new SampleItem("Conjured Mana Cake", 3, 6));
    }


    public List<SampleItem> updateQuality() {
//        for (int i = 0; i < inventory.size(); i++) {
//            if ((!"Aged Brie".equals(inventory.get(i).getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(inventory.get(i).getName())) {
//                if (inventory.get(i).getQuality() > 0) {
//                    if (!"Sulfuras, Hand of Ragnaros".equals(inventory.get(i).getName())) {
//                        inventory.get(i).setQuality(inventory.get(i).getQuality() - 1);
//                    }
//                }
//            } else {
//                if (inventory.get(i).getQuality() < 50) {
//                    inventory.get(i).setQuality(inventory.get(i).getQuality() + 1);
//
//                    if ("Backstage passes to a TAFKAL80ETC concert".equals(inventory.get(i).getName())) {
//                        if (inventory.get(i).getSellIn() < 11) {
//                            if (inventory.get(i).getQuality() < 50) {
//                                inventory.get(i).setQuality(inventory.get(i).getQuality() + 1);
//                            }
//                        }
//
//                        if (inventory.get(i).getSellIn() < 6) {
//                            if (inventory.get(i).getQuality() < 50) {
//                                inventory.get(i).setQuality(inventory.get(i).getQuality() + 1);
//                            }
//                        }
//                    }
//                }
//            }
//
//            if (!"Sulfuras, Hand of Ragnaros".equals(inventory.get(i).getName())) {
//                inventory.get(i).setSellIn(inventory.get(i).getSellIn() - 1);
//            }
//
//            if (inventory.get(i).getSellIn() < 0) {
//                if (!"Aged Brie".equals(inventory.get(i).getName())) {
//                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(inventory.get(i).getName())) {
//                        if (inventory.get(i).getQuality() > 0) {
//                            if (!"Sulfuras, Hand of Ragnaros".equals(inventory.get(i).getName())) {
//                                inventory.get(i).setQuality(inventory.get(i).getQuality() - 1);
//                            }
//                        }
//                    } else {
//                        inventory.get(i).setQuality(inventory.get(i).getQuality() - inventory.get(i).getQuality());
//                    }
//                } else {
//                    if (inventory.get(i).getQuality() < 50) {
//                        inventory.get(i).setQuality(inventory.get(i).getQuality() + 1);
//                    }
//                }
//            }
//        }
        return inventory;
    }

}