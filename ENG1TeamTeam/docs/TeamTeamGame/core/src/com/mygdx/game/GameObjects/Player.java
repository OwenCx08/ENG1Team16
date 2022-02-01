package com.mygdx.game.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Board.Map;
import com.mygdx.game.Board.TileType;
import com.mygdx.game.GameObjects.Colleges.PlayerCollege;
import com.mygdx.game.GameObjects.Ships.PlayerShip;


public class Player extends Entity{
    protected int[] screenDimentions ={-1,-1};
    protected Map gameMap;
	protected PlayerCollege college;
	protected PlayerShip ship;

	/**
	 * Player constructor
	 * @param health Current health of the player
	 * @param height
	 * @param id Id of the player
	 * @param position Position of the player
	 * @param spriteName Name of the players sprite
	 * @param width
	 *
	 */
    public Player(int id, float width,float height, String spriteName, int health, int[] position){
        super(id, width, height, spriteName, health, position);
        this.college = new PlayerCollege(id, "Vanbrugh",width, height,spriteName,health,position,2);
		this.ship = new PlayerShip(id, width, height, spriteName, health, position,1,1,gameMap);
	}
	/*
    public void move(int[] position){//moves the ship x,y "steps"
        this.position[0]+=position[0];
        this.position[1]+=position[1];
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
    }*/

	/**
	 * Getter for texture
	 * @return Player sprite texture
	 */
	public String getTexture(){
		return  this.spriteName;
	}
	/**
	 * Getter for player X position
	 * @return Player X position
	 */
	public int getX(){
		return  this.position[0];
	}
	/**
	 * Getter for player Y position
	 * @return Player Y position
	 */
	public int getY(){
		return  this.position[1];
	}
	/**
	 * Getter for Range of player ship
	 * @return Player's ship range
	 */
	public int getRange(){
		return ship.getRange();
	}

	/**
	 * Relocates the players ship based on position
	 * @param position position the player ship needs to be
	 */
    public void relocate(int[] position){//Sets location to x,y
		int X =position[0];
		int Y =position[1];
		int shipX = this.position[0];
		int shipY = this.position[1];
		if (X <= (shipX+32*ship.getRange()) || X >=(shipX-32*ship.getRange())){//&&
			if (Y <= (shipY+32*ship.getRange()) || Y >=(shipY-32*ship.getRange())){//&&
				this.position = position;
			}
		}


    }
	/*
    public void SetupMouse(int[] screenDimentions,Map map){
        this.screenDimentions = screenDimentions;
        this.gameMap = map;
		Gdx.input.setInputProcessor(new InputProcessor() {
			//@Override
            public boolean touchDown(int x, int y, int pointer, int button) {
                if (button == Input.Buttons.LEFT) {
                    onMouseDown(x,y);
                    return(true);
                }
                return(false);
            }
			
			
			public boolean touchUp(int x, int y, int pointer, int button){
				return(false);
			}

			//Auto-Generated methods required for InputProcessor to be initialised

			public boolean keyDown(int keycode) {
				// TODO Auto-generated method stub
				return false;
			}


			public boolean keyUp(int keycode) {
				// TODO Auto-generated method stub
				return false;
			}


			public boolean keyTyped(char character) {
				// TODO Auto-generated method stub
				return false;
			}


			public boolean touchDragged(int screenX, int screenY, int pointer) {
				// TODO Auto-generated method stub
				return false;
			}


			public boolean mouseMoved(int screenX, int screenY) {
				// TODO Auto-generated method stub
				return false;
			}


			public boolean scrolled(float amountX, float amountY) {
				// TODO Auto-generated method stub
				return false;
			}
			

        });

	}

	public void onMouseDown(int x, int y){
		//Grid is 32x18
		int[] coords = {x,y};
		int perX = screenDimentions[0]/32;
		int perY = screenDimentions[1]/18;
		int scaledX = Math.round(x/perX);
		int scaledY = Math.round(y/perY);
		int gridVal = this.gameMap.getAt(scaledX, scaledY);
		if(gridVal==0){
			//Move to location
			this.move(coords);
			//if land is 1 it means it is unable to get there
		}else if(gridVal==1){
			//land, collision detection needed
			System.out.println("Player cannot move there");
		}else{
			//if(this.playerOne.playerShip.attack){
				//Enemy react?
			//}else{
				this.move(coords);
			//}
			//Attacking Needs to be added
		}

	}
	*/

}
