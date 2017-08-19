package br.cefetmg.games;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Goomba extends ApplicationAdapter {
    private Texture goomba;
    private Texture field;
    private int x,y;
    private int fieldHeight,gHeight,fieldWidth,gWidth;
    
    public Goomba(Texture g, Texture f){
        this.goomba = g;
        this.field = f;
        x=30;
        y=10;
        fieldHeight=field.getHeight();
        fieldWidth=field.getWidth();
        gHeight=goomba.getHeight();
        gWidth=goomba.getWidth();
    }
    
    public void render(SpriteBatch batch) {     
        //batch.begin();        
        // desenhos são realizados aqui
        batch.draw(goomba, x, y);
        // batch.end();
    }
    
    
    public void update() {
            if(Gdx.input.isKeyPressed(Input.Keys.UP) && y<(fieldHeight-gHeight)){
               y++;
           }
            if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && y>(0)){
               y--;
           }
            if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && x>(0)){
               x--;
           }
            if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && x<(fieldWidth-gWidth)){
               x++;
           }
    }
    
    
}
