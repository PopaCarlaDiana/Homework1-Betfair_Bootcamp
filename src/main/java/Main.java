import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {

    static List<Cloth> basket = new ArrayList<>();

    static void ShopCall(Shop shop) throws IOException {

        String command = "";
        while(!command.equals("3")) {

            System.out.print("What do you want to do at "+ shop.getClass().getName() +" ? (type the number)\n" +
                    "1. See all clothes\n" +
                    "2. Buy a cloth\n" +
                    "3. Exit\n>>");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            command=br.readLine();

            switch (command){
                case "1":
                    shop.showAllClothes();
                    break;
                case "2":
                    System.out.print("Type the name:");
                    String name=br.readLine();
                    System.out.print("Type the size:");
                    Integer size= Integer.valueOf(br.readLine());
                    try {
                        Cloth cloth=shop.buyCloth(name,size);
                        basket.add(cloth);
                        System.out.println("Thank you for your order!\n");
                    } catch (Exception e) {
                        System.out.println("This cloth is not available\n");
                    }
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Invalid command\n");
                    break;
            }
        }
    }

    static void buy(SecondHand secondHand, ClothClub clothClub, RoundRockCloth roundRockCloth) throws IOException {

        String command = "";
        while(!command.equals("4")) {

            System.out.print("Chose a store (type the number)\n" +
                    "1. SecondHand\n" +
                    "2. ClothClub\n" +
                    "3. RoundRockCloth\n" +
                    "4. Exit\n>>");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            command = br.readLine();
            Shop shop;

            switch (command) {
                case "1":
                    shop = secondHand;
                    ShopCall(shop);
                    break;
                case "2":
                    shop = clothClub;
                    ShopCall(shop);
                    break;
                case "3":
                    shop = roundRockCloth;
                    ShopCall(shop);
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Invalid command\n");
                    break;
            }
        }
    }

    static void sell(SecondHand secondHand, ClothClub clothClub, RoundRockCloth roundRockCloth) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("What is the name of your cloth?\n>>");
        String name = br.readLine();

        System.out.print("What is the size of your cloth?\n>>");
        Integer size = Integer.valueOf(br.readLine());

        System.out.print("What is the price of your cloth?\n>>");
        Float price = Float.valueOf(br.readLine());

        System.out.print("In what season can this cloth be worn? (type summer, spring, winter, autumn or all)\n>>");
        Cloth_season season = null;
        Boolean ok=true;
        while(ok){
            switch (br.readLine()){
                case "summer":
                    season=Cloth_season.SUMMER_SEASON;
                    ok=false;
                    break;
                case "spring":
                    ok=false;
                    season=Cloth_season.SPRING_SEASON;
                    break;
                case "winter":
                    ok=false;
                    season=Cloth_season.WINTER_SEASON;
                    break;
                case "autumn":
                    ok=false;
                    season=Cloth_season.AUTUMN_SEASON;
                    break;
                case "all":
                    ok=false;
                    break;
                default:
                    System.out.print("Invalid command\n>>");
            }
        }

        System.out.print("What is this cloth made of?\n"+
                        "1) COTTON\n2) DENIM\n3) LACE\n4) LEATHER\n5) SATIN\n6) SILK\n7) SYNTHETICS\n8) VELVET\n9) WOOL\n10)Is not important\n>>");
        Cloth_material material = null;
        ok=true;
        while(ok){
            switch (br.readLine()){
                case "1":
                    material=Cloth_material.COTTON;
                    ok=false;
                    break;
                case "2":
                    material=Cloth_material.DENIM;
                    ok=false;
                    break;
                case "3":
                    material=Cloth_material.LACE;
                    ok=false;
                    break;
                case "4":
                    material=Cloth_material.LEATHER;
                    ok=false;
                    break;
                case "5":
                    material=Cloth_material.SATIN;
                    ok=false;
                    break;
                case "6":
                    material=Cloth_material.SILK;
                    ok=false;
                    break;
                case "7":
                    material=Cloth_material.SYNTHETICS;
                    ok=false;
                    break;
                case "8":
                    material=Cloth_material.VELVET;
                    ok=false;
                    break;
                case "9":
                    material=Cloth_material.WOOL;
                    ok=false;
                    break;
                case "10":
                    ok=false;
                    break;
                default:
                    System.out.print("Invalid command\n>>");
            }
        }


        System.out.print("Is your cloth limited edition? (type yes or no)\n>>");
        Boolean isLimitedEdition = null;
        ok=true;
        while(ok){
            switch (br.readLine()){
                case "yes":
                    ok=false;
                    isLimitedEdition=true;
                    break;
                case "no":
                    ok=false;
                    isLimitedEdition=false;
                    break;
                default:
                    System.out.print("Invalid command\n>>");
            }
        }



        Cloth cloth = new Cloth.Builder(name,size,price)
                .setClothSeason(season)
                .setClothMaterial(material)
                .setIsLimitedEdition(isLimitedEdition)
                .build();

        System.out.print("To which store do you want to sell the cloth?\n");
        System.out.print(
                "1. SecondHand\n" + "2. ClothClub\n" + "3. RoundRockCloth\n" +
                        ">>");
        String command = "";
        ok=true;
        while(ok){
            command = br.readLine();
            switch (command) {
                case "1":
                    ok=false;
                    secondHand.addCloth(cloth);
                    break;
                case "2":
                    ok=false;
                    clothClub.addCloth(cloth);
                    break;
                case "3":
                    ok=false;
                    roundRockCloth.addCloth(cloth);
                    break;
                default:
                    System.out.print("Invalid command\n>>");
                    break;
            }
        }
        System.out.println("Your sell is confirmed! Thank you!\n");
    }

    public static void main(String[] args) throws IOException {


        //Create items
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
                    "3. If you want to see your basket type basket\n" +
                    "4. If you want to exit type exit\n>>");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            command=br.readLine();
            switch (command){
                case "sell":
                    sell(secondHand,clothClub,roundRockCloth);
                    break;
                case "buy":
                    buy(secondHand,clothClub,roundRockCloth);
                    break;
                case "basket":
                    for(Cloth cloth:basket){
                        System.out.println(cloth.toString());
                    }
                    System.out.println();
                    break;
                case "exit":
                    System.out.println("Thank you for choosing us!");
                    break;
                default:
                    System.out.println("Invalid command\n");
                    break;
            }
        }

    }
}