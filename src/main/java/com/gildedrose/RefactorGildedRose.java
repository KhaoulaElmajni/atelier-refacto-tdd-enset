package com.gildedrose;

public class RefactorGildedRose {
    Item[] items;

    public RefactorGildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality(){
        for (Item item:items) {
            switch (item.name){
                case "Aged Brie" :
                    if (item.quality < 50) {
                        item.quality ++;
                    }
                    if (item.sellIn < 11 && item.quality<50){
                        item.quality ++;
                        if (item.sellIn < 6)
                            item.quality ++;
                    }
                    item.sellIn --;
                    if(item.sellIn<0){
                        item.quality = 0;
                    }
                    ;break;
                case "Backstage passes to a TAFKAL80ETC concert" :
                    if (item.quality < 50) {
                        item.quality ++;
                    }
                    item.sellIn --;
                    if ((item.sellIn < 0)&&(item.quality < 50)) {
                        item.quality ++;
                    }
                    ;break;
                case "Sulfuras, Hand of Ragnaros" :
                    if (item.quality > 0 || item.sellIn < 0) {
                            item.quality -= 1;
                    }
                    ;break;
                default:
                    if (item.quality > 0)
                        item.quality --;
                    item.sellIn --;
                    if ((item.sellIn < 0)&& (item.quality > 0)){
                        item.quality --;
                    }
                    break;
            }
        }
    }
}
