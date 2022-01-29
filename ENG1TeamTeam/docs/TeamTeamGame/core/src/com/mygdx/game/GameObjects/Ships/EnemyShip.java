package com.mygdx.game.GameObjects.Ships;
import com.mygdx.game.Board.Map; 
public class EnemyShip extends Ship{
    private Boolean alive;
    protected int enemyID;
    private Map gameMap;
    
    public EnemyShip(int id, float width,float height, String spriteName, int health, int[] position, int range, int moveRange,int enemyID, Map gameMap){
        super(id, width, height, spriteName, health, position,range,moveRange);
        this.gameMap = gameMap;
        this.enemyID = enemyID;
        this.alive=true;
    }
    //Searches around a radius of 2 around the ship to see if the player is there
    public int[] checkForPlayer(){
        int[] data = {-1,-1};
        for(int i=-2;i<3;i++){
            for(int j=-2;j<3;i++){
                /*if(this.gameMap.getAt(this.position[0]+i,this.position[1]+j)==3){
                    data[0] = this.position[0]+i;
                    data[1] = this.position[1]+j;
                    return (data);
                }*/
            }
        }
        //Get player pos
        //  - if in range return location/head to location
        return(null);
    }

    public Boolean checkIfAlive(){
        if(this.health<=0){
            this.alive=false;
            //Respawn?
        }
        return(this.alive);
    }
    public String getSpriteName(){
        return this.spriteName;
    }
}