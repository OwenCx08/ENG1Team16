package com.mygdx.game.GameObjects; 
public class Entity{
    protected int ID;
    protected float width;
    protected float height;
    protected String spriteName;
    protected int health;
    protected int[] position;
    
    public Entity(int id, float width,float height, String spriteName, int health, int[] position){
        this.ID = id;
        this.width = width;
        this.height = height;
        this.spriteName = spriteName;
        this.health = health;
        this.position = position;
    }

    public int getHealth(){
        return(this.health);
    }

    public void attack(int[] position){
        //attach method
        //  -damage anything at position
        
    }


}