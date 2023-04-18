package org.example;

import java.util.ArrayList;
import java.util.List;

public class SecondHand implements Shop{

    private List<Cloth> clothList = new ArrayList<>();
    private Float profit=(float)0;

    @Override
    public void showAllClothes() {
        for(Cloth cloth:clothList){
            System.out.println("Cloth{" +
                    "nameOfCloth='" + cloth.getNameOfCloth() + '\'' +
                    ", size=" + cloth.getSize() +
                    ", price=" + cloth.getPrice() +
                    ", season=" + cloth.getSeason() +
                    ", material=" + cloth.getMaterial() +
                    ", isLimitedEdition=" + cloth.getLimitedEdition() +
                    '}'+"\n");
        }
    }

    @Override
    public void addCloth(Cloth cloth) {
        clothList.add(cloth);

    }

    @Override
    public void buyCloth(Cloth cloth) {
        if(clothList.contains(cloth)){
            profit+=cloth.getPrice();
            clothList.remove(cloth);
        }
    }

    public List<Cloth> getClothList() {
        return clothList;
    }

    public Float getProfit() {
        return profit;
    }
}
