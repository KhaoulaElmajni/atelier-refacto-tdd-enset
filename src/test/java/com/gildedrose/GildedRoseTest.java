package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
    }

    @Test
    void testQuality() {
        Item[] items = new Item[] {
            new Item("Sulfuras, Hand of Ragnaros", 1, -7),
            new Item("Backstage passes to a TAFKAL80ETC concert", 6, 65),
            new Item("Aged Brie", 19, 7)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[1].quality <= 50,true );
    }

   /* @Test
    void testQuality() {
        Item[] items = new Item[] {
            new Item("Sulfuras, Hand of Ragnaros", 1, -7),
            new Item("Backstage passes to a TAFKAL80ETC concert", 6, 65),
            new Item("Aged Brie", 19, 7)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[1].quality <= 50,true );
    }*/

    @Test
    void testerNegativeQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 19, 7) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality>=0,true);
    }

    @Test
    void testerSellInPassedDate() {
        Item[] items = new Item[] { new Item("foo", -2, 8) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6,app.items[0].quality);
    }

    @Test
    void tetsSellIn() {
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 1, -7),
            new Item("Sulfuras, Hand of Ragnaros", 21, 5),
            new Item("Aged Brie", 100, 2),
            new Item("Sulfuras, Hand of Ragnaros", 19, 10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 50, 26),
            };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("10", app.items[0].sellIn);
    }

}
