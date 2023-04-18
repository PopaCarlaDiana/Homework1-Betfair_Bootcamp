package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static void buy(SecondHand secondHand, ClothClub clothClub, RoundRockCloth roundRockCloth){
        System.out.print("Chose a store (type the number)\n" +
                "1. SecondHand\n" +
                "2. ClothClub\n" +
                "3. RoundRockCloth\n>>");

    }

    public static void main(String[] args) throws IOException {
        SecondHand secondHand = new SecondHand();
        ClothClub clothClub = new ClothClub();
        RoundRockCloth roundRockCloth = new RoundRockCloth();

        Cloth cloth1=new Cloth.Builder("hat",1,(float)10)
                .setClothSeason(Cloth_season.SUMMER_SEASON)
                .build();

        Cloth cloth2=new Cloth.Builder("T-shirt",34,(float)100)
                .setClothSeason(Cloth_season.SPRING_SEASON)
                .setClothMaterial(Cloth_material.COTTON)
                .setIsLimitedEdition(true)
                .build();

        secondHand.addCloth(cloth1);
        secondHand.addCloth(cloth2);

        Cloth cloth3=new Cloth.Builder("T-shirt",36,(float)100)
                .setClothSeason(Cloth_season.SPRING_SEASON)
                .setClothMaterial(Cloth_material.COTTON)
                .setIsLimitedEdition(true)
                .build();

        Cloth cloth4=new Cloth.Builder("T-shirt",38,(float)100)
                .setClothSeason(Cloth_season.SPRING_SEASON)
                .setClothMaterial(Cloth_material.COTTON)
                .setIsLimitedEdition(true)
                .build();

        Cloth cloth5=new Cloth.Builder("Jeans",32,(float)100)
                .setClothMaterial(Cloth_material.DENIM)
                .build();

        clothClub.addCloth(cloth3);
        clothClub.addCloth(cloth4);
        clothClub.addCloth(cloth5);

        Cloth cloth6=new Cloth.Builder("Jeans",40,(float)100)
                .setClothMaterial(Cloth_material.DENIM)
                .build();

        Cloth cloth7=new Cloth.Builder("Jeans",42,(float)100)
                .setClothMaterial(Cloth_material.DENIM)
                .build();

        Cloth cloth8=new Cloth.Builder("Jeans",36,(float)100)
                .setClothMaterial(Cloth_material.DENIM)
                .build();

        roundRockCloth.addCloth(cloth6);
        roundRockCloth.addCloth(cloth7);
        roundRockCloth.addCloth(cloth8);


        System.out.println("Welcome to our online closet!");

        String command = "";
        while(!command.equals("exit")){
            System.out.print("1. If you want to sell a cloth type sell\n" +
                    "2. If you want to buy a cloth type buy\n" +
                    "3. If you want to exit type exit\n>>");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            command=br.readLine();
            switch (command){
                case "sell":

                    break;
                case "buy":
                    buy(secondHand,clothClub,roundRockCloth);
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Invalid command\n");
                    break;
            }
        }

    }
}