package com.mygdx.game.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.game.Board.Map;
import com.mygdx.game.GameObjects.Colleges.PlayerCollege;
import com.mygdx.game.GameObjects.Ships.PlayerShip;

public class Player extends Entity{
    protected int[] screenDimentions ={-1,-1};
    protected Map gameMap;
	protected PlayerCollege college;
	protected PlayerShip ship;
    public Player(int id, float width,float height, String spriteName, int health, int[] position){
        super(id, width, height, spriteName, health, position);
        this.college = new PlayerCollege(id, "James",width, height,spriteName,health,position,2);
		this.ship = new PlayerShip(id, width, height, spriteName, health, position,2,5);
	}

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
    }
    
    public void relocate(int[] position){//Sets location to x,y
        this.position = position;
    }

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
		}else if(gridVal==1 || gridVal==2 || gridVal==3){
			//land, collision detection needed
			this.move(coords);//?
		}else{
			//if(this.playerOne.playerShip.attack){
				//Enemy react?
			//}else{
				this.move(coords);
			//}
			//Attacking Needs to be added
		}
	}
}