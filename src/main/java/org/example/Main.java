package org.example;

import java.util.ArrayList;
import java.util.List;

//Structural-Composite
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to our online closet!");

        Cloth cloth1=new Cloth.Builder("hat",1,(float)10)
                .setClothSeason(Cloth_season.SUMMER_SEASON)
                .build();

        Cloth cloth2=new Cloth.Builder("T-shirt",34,(float)100)
                .setClothSeason(Cloth_season.SPRING_SEASON)
                .setClothMaterial(Cloth_material.COTTON)
                .setIsLimitedEdition(true)
                .build();

        List<Cloth> clothList = new ArrayList<>();
        clothList.add(cloth1);
        clothList.add(cloth2);

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
}