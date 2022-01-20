package com.mygdx.game.GameObjects.Colleges;
import com.mygdx.game.GameObjects.Entity;
public class College extends Entity{
    protected int range;
    protected String name;
    public College(int id, String name,float width,float height, String spriteName, int health, int[] position, int range){
        super(id, width, height, spriteName, health, position);
        this.range = range;
        this.name = name;
    }
}