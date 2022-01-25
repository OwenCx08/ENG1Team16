package com.mygdx.game.Board;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mygdx.game.GameObjects.Player;
import com.mygdx.game.GameObjects.Ships.EnemyShip;

public class Tasks implements ApplicationListener {
    private SpriteBatch batch;
    private BitmapFont font;
    public int taskState=0;
        
    @Override
    public void create() {        
        batch = new SpriteBatch();    
        font = new BitmapFont();
        font.setColor(Color.RED);
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    public void Tasks(){
        //First task--MOVE!
        while(taskState==0){        
            Gdx.gl.glClearColor(1, 1, 1, 1);
            Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        
            batch.begin();
            font.draw(batch, "Try to click somewhere to move", 200, 200);
            batch.end();
            int[] position = checkmove();
            
            if(position!=[29,15]){
                taskState = 1;
                }
        }
        
            
        //Second task--destory an EnemyShip
        while(taskState == 1){
            Gdx.gl.glClearColor(1, 1, 1, 1);
            Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        
            batch.begin();
            font.draw(batch, "Time to destory som ships,try to click that enemy ship to attack it.", 200, 200);
            batch.end();
            //if ship hp == 0 then state2
            if(
        }
            
        //Third task--destory the first EnemyCollege
        while(taskState == 2){
            Gdx.gl.glClearColor(1, 1, 1, 1);
            Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        
            batch.begin();
            font.draw(batch, "At North-east of the lake, there is a college with great wealth. Conquer that college can help you to upgrade your ship.", 200, 200);
            batch.end();
            //if ship college1hp=0 then state3
        
        }
        //Last task--destoryanother college(a stranger one?)
        while(taskState == 3){
            Gdx.gl.glClearColor(1, 1, 1, 1);
            Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        
            batch.begin();
            font.draw(batch, "Now, sail to the south-west and conquer the last college.", 200, 200);
            batch.end();
            //if ship college2hp=0 then state4
    }
}
