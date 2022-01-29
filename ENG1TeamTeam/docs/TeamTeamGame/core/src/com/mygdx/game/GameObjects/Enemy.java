package com.mygdx.game.GameObjects;
import java.util.Random;
import com.mygdx.game.GameObjects.Ships.EnemyShip;
import com.mygdx.game.GameObjects.Colleges.EnemyCollege;
import com.mygdx.game.Board.Map;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
public class Enemy{
    private int enemyID;
    protected int[] coord;
    public EnemyShip[] ships;
    public EnemyCollege college;
    public Map gameMap;
    Random randomGen = new Random();
    
    
    public Enemy(int enemyID, String collegeName, int[] coord,int production, Map gameMap){
        this.gameMap = gameMap;
        this.enemyID = enemyID;
        this.college = new EnemyCollege(enemyID+1, collegeName ,1.0f,1.0f, collegeName, 10, coord, 3, enemyID);//
        this.ships = this.CreateShips(production);//number of ships
        //int[] coord = {50, 50};
        this.coord = coord;
        
        
    }

    public EnemyShip[] CreateShips(int numberOfShips){
        EnemyShip[] returnData = new EnemyShip[numberOfShips];
        for(int i=0;i<numberOfShips;i++){
            returnData[i] = new EnemyShip(enemyID+1, 1.0f,1.0f, (this.college.spriteName+"Boat.png"), 3, this.coord, 5, 3,this.enemyID,this.gameMap);
        }
        return(returnData);
    }
    public int[][] moveShips(){
        int[][] output = new int[this.ships.length][2];
        for(int i=0; i<this.ships.length;i++){
            if(this.ships[i].checkForPlayer() == null){
                output[i] = this.ships[i].move((randomGen.nextInt(4)-2),(randomGen.nextInt(4)-2));
            } else{
                int[] playerPos = this.ships[i].checkForPlayer();
                output[i] = this.ships[i].move(playerPos[0],playerPos[1]);
            }
        }
        return output;
    }
    public void updateMap(Map globalMap){
        this.gameMap = globalMap;
    }
    public Boolean checkIfAlive(){
        return(college.checkIfAlive());
    }

    public void draw(SpriteBatch sb){
        Sprite[] shipsSprites = new Sprite[ships.length];
        for(int i=0;i<ships.length;i++){
            shipsSprites[i] = new Sprite(new Texture(Gdx.files.internal(ships[i].getSpriteName())));
            shipsSprites[i].draw(sb);
            System.out.println(this.coord);
            shipsSprites[i].setPosition(this.coord[0],this.coord[1]);
        }
        
    }
}