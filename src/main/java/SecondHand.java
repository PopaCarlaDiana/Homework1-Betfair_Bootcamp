import java.util.ArrayList;
import java.util.List;

public class SecondHand implements Shop{

    private List<Cloth> clothList = new ArrayList<>();
    private Float profit=(float)0;

    @Override
    public void showAllClothes() {
        for(Cloth cloth:clothList){
            System.out.println(cloth.toString());
        }
        System.out.println();
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

    @Override
    public Cloth buyCloth(String name, Integer size) throws Exception {
        for(Cloth cloth:this.clothList){
            if(cloth.getNameOfCloth().equals(name) && cloth.getSize().equals(size)){
                Cloth cloth1 = cloth;
                this.clothList.remove(cloth);
                return cloth;
            }
        }
        throw new Exception("The cloth does not exist");
    }

    public List<Cloth> getClothList() {
        return clothList;
    }

    public Float getProfit() {
        return profit;
    }
}
