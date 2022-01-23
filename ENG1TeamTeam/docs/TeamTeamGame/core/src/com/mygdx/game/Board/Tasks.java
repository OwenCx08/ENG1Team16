package com.mygdx.game.Board;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mygdx.game.GameObjects.Player;

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
            
        //Third task--destory the first EnemyCollege
        
        //Last task--destoryanother college(a stranger one?)
        
    }
}
