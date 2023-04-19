/**
 * Structural-Composite Pattern
 */

public interface Shop{
    public void showAllClothes();
    public void addCloth(Cloth cloth);
    public void buyCloth(Cloth cloth);
    public Cloth buyCloth(String name, Integer size) throws Exception;
}
