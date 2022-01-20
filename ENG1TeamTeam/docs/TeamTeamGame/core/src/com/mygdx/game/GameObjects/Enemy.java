package com.mygdx.game.GameObjects;

import com.mygdx.game.GameObjects.Ships.EnemyShip;
import com.mygdx.game.GameObjects.Colleges.EnemyCollege;

public class Enemy{
    private int enemyID;
    public EnemyShip[] ships;
    public EnemyCollege college;
    private Boolean alive;
    public Enemy(int enemyID){
        this.enemyID = enemyID;
        this.ships = this.CreateShips(0);//number of ships
        int[] coord = {50, 50};
        this.college = new EnemyCollege(enemyID+1, "Name" ,1.0f,1.0f, "EnemyCollege", 10, coord, 3, enemyID);//
        this.alive = true;
    }

    public EnemyShip[] CreateShips(int numberOfShips){
        EnemyShip[] returnData=new EnemyShip[numberOfShips];
        for(int i=0;i<numberOfShips;i++){
            int[] coord = {45, 45};
            returnData[i]= new EnemyShip(enemyID+1, 1.0f,1.0f, "EnemyShip", 3, coord, 5, 3,this.enemyID);
        }
        return(returnData);
    }

    public Boolean checkIfAlive(){
        return(this.alive);
    }
}