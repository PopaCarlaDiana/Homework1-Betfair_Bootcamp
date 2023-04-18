package org.example;

/**
 * Structural-Composite Pattern
 */

public interface Shop{
    public void showAllClothes();
    public void addCloth(Cloth cloth);
    public void buyCloth(Cloth cloth);
}
