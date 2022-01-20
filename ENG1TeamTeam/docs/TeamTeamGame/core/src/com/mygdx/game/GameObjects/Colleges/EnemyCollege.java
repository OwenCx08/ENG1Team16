package com.mygdx.game.GameObjects.Colleges;
public class EnemyCollege extends College{
    protected int enemyID;
    public EnemyCollege(int id, String name,float width,float height, String spriteName, int health, int[] position, int range,int enemyID){
        super(id, name,width, height,spriteName,health,position,range);
        this.enemyID = enemyID;
    }

    public int[] checkForPlayer(){
        int[] data = {-1,-1};
        //Get player pos
        //  - if in range return location/head to location
        return(data);
    }
}