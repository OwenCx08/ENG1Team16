package com.mygdx.game.GameObjects;

import com.mygdx.game.GameObjects.Ships.EnemyShip;
import com.mygdx.game.GameObjects.Colleges.EnemyCollege;

public class Enemy{
    private int enemyID;
    private Boolean alive;
    protected int[] coord;
    public EnemyShip[] ships;
    public EnemyCollege college;
    
    
    public Enemy(int enemyID, String collegeName, int[] coord,int production){
        this.enemyID = enemyID;
        this.ships = this.CreateShips(production);//number of ships
        //int[] coord = {50, 50};
        this.coord = coord;
        this.college = new EnemyCollege(enemyID+1, collegeName ,1.0f,1.0f, "EnemyCollege", 10, coord, 3, enemyID);//
        this.alive = true;
    }

    public EnemyShip[] CreateShips(int numberOfShips){
        EnemyShip[] returnData=new EnemyShip[numberOfShips];
        for(int i=0;i<numberOfShips;i++){
            //int[] coord = {45, 45};
            returnData[i]= new EnemyShip(enemyID+1, 1.0f,1.0f, "EnemyShip", 3, this.coord, 5, 3,this.enemyID);
        }
        return(returnData);
    }


    public Boolean checkIfAlive(){
        return(this.alive);
    }

    public void draw(){
        //Fill in
    }
}