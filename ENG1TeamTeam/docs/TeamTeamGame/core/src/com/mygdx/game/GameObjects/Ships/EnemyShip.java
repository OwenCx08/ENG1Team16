package com.mygdx.game.GameObjects.Ships;
public class EnemyShip extends Ship{
    private Boolean alive;
    protected int enemyID;
    
    public EnemyShip(int id, float width,float height, String spriteName, int health, int[] position, int range, int moveRange,int enemyID){
        super(id, width, height, spriteName, health, position,range,moveRange);
        this.enemyID = enemyID;
        this.alive=true;
    }

    public int[] checkForPlayer(){
        int[] data = {-1,-1};
        //Get player pos
        //  - if in range return location/head to location
        return(data);
    }

    public Boolean checkIfAlive(){
        if(this.health<=0){
            this.alive=false;
            //Respawn?
        }
        return(this.alive);
    }

}