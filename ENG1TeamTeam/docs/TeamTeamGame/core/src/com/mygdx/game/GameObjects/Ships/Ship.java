package com.mygdx.game.GameObjects.Ships;
import com.mygdx.game.GameObjects.Entity;
public class Ship extends Entity{
    protected int range;
    protected int moveRange;

    public Ship(int id, float width,float height, String spriteName, int health, int[] position, int range, int moveRange){
        super(id, width, height, spriteName, health, position);
        this.range = range;
        this.moveRange = moveRange;
    }

    public int[]  move(int x,int y){//moves the ship x,y "steps"
        this.position[0]+=x;
        this.position[1]+=y;
        return(this.position);
    }

    public Boolean detectCollision(){
        boolean collision = false;
        //Colision detection
        
        return(collision);
    }
    
    public int[] checkMove(int[] position){
        int[] data = {this.position[0]+position[0],this.position[1]=position[1]};
        //this.checkYBounds(this.position[0]+position[0]);
        //this.checkXBounds(this.position[1]+position[1]);
        return(data);//Where the ship will be, is it out of bounds?
    }


    public void relocate(int[] position){//Sets location to x,y
        this.position = position;
    }

    public int getRange(){
        return this.moveRange;
    }
}