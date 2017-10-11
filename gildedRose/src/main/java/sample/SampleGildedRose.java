package sample;

import java.util.ArrayList;
import java.util.Arrays;
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
        for (SampleItem item : inventory) {
            if (!stableQualityItems().contains(item.getName())) {
                if (item.getQuality() > 0) {
                    item.setQuality(item.getQuality() - 1);
                }
            }
//            } else {
//                if (item.getQuality() < 50) {
//                    item.setQuality(item.getQuality() + 1);
//
//                    if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
//                        if (item.getSellIn() < 11) {
//                            if (item.getQuality() < 50) {
//                                item.setQuality(item.getQuality() + 1);
//                            }
//                        }
//
//                        if (item.getSellIn() < 6) {
//                            if (item.getQuality() < 50) {
//                                item.setQuality(item.getQuality() + 1);
//                            }
//                        }
//                    }
//                }
//            }
//
            if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
                item.setSellIn(item.getSellIn() - 1);
            }

            if (item.getSellIn() < 0) {
                if (!"Aged Brie".equals(item.getName())) {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
                        if (item.getQuality() > 0) {
                            if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
                                item.setQuality(item.getQuality() - 1);
                            }
                        }
                    } else {
                        item.setQuality(item.getQuality() - item.getQuality());
                    }
                } else {
                    if (item.getQuality() < 50) {
                        item.setQuality(item.getQuality() + 1);
                    }
                }
            }
        }
        return inventory;
    }

    private List<String> stableQualityItems() {
        return Arrays.asList("Aged Brie", "Backstage passes to a TAFKAL80ETC concert",
                "Sulfuras, Hand of Ragnaros");
    }

    public List<SampleItem> getInventory() {
        return inventory;
    }
}