package com.mygdx.game.GameObjects.Colleges;
public class PlayerCollege extends College{
    public PlayerCollege(int id, String name,float width,float height, String spriteName, int health, int[] position, int range){
        super(id, name,width, height,spriteName,health,position,range);
        
    }

    public int[] checkForEnemy(){
        int[] data = {-1,-1};
        //Get player pos
        //  - if in range return location/head to location
        return(data);
    }
}