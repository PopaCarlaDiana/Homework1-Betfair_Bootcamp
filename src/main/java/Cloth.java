import java.util.Objects;

/**
 * Creational-Builder Pattern
 */
public class Cloth { // only getters and no public constructor

    private String nameOfCloth; //required
    private Integer size; //required
    private Float price; //requider
    private Cloth_season season; //optional
    private Cloth_material material; //optional
    private Boolean isLimitedEdition; //optional

    private Cloth(Builder builder){
        this.nameOfCloth=builder.nameOfCloth;
        this.size=builder.size;
        this.price=builder.price;
        this.season=builder.season;
        this.material=builder.material;
        this.isLimitedEdition=builder.isLimitedEdition;
    }

    @Override
    public String toString() {
        String string = "";
        string+=nameOfCloth+" size="+size+" price="+price+"$ ";
        if(season!=null){
            string+=season+" ";
        }
        if(material!=null){
            string+=material+" ";
        }
        if(isLimitedEdition!=null&&isLimitedEdition==true){
            string+="Is Limited Edition!";
        }
        return string;
    }

    public String getNameOfCloth() {
        return nameOfCloth;
    }

    public Integer getSize() {
        return size;
    }

    public Float getPrice() {
        return price;
    }

    public Cloth_season getSeason() {
        return season;
    }

    public Cloth_material getMaterial() {
        return material;
    }

    public Boolean getLimitedEdition() {
        return isLimitedEdition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cloth cloth = (Cloth) o;
        return nameOfCloth.equals(cloth.nameOfCloth) && size.equals(cloth.size) && price.equals(cloth.price) && season == cloth.season && material == cloth.material && Objects.equals(isLimitedEdition, cloth.isLimitedEdition);
    }

    public static class Builder {

        private String nameOfCloth; //required
        private Integer size; //required
        private Float price; //requider
        private Cloth_season season; //optional
        private Cloth_material material; //optional
        private Boolean isLimitedEdition; //optional

        public Builder(String name_of_cloth,Integer size,Float price){
            this.nameOfCloth=name_of_cloth;
            this.size=size;
            this.price=price;
        }

        public Builder setClothSeason(Cloth_season clothSeason){
            this.season=clothSeason;
            return this;
        }

        public Builder setClothMaterial(Cloth_material clothMaterial){
            this.material=clothMaterial;
            return this;
        }

        public Builder setIsLimitedEdition(Boolean isLimitedEdition){
            this.isLimitedEdition=isLimitedEdition;
            return this;
        }

        public Cloth build(){
            return new Cloth(this);
        }
    }
}
