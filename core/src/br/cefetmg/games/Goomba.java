package br.cefetmg.games;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Goomba extends ApplicationAdapter {
    private Texture goomba;
    private Texture field;
    private int x,y;
    private int fieldHeight,fieldWidth,goombaHeight=24,goombaWidth=21;
    private TextureRegion[][] quadrosDaAnimacao;
    private Animation atual;
    private Animation andarParaBaixo;
    private Animation andarParaCima;
    private Animation andarParaEsquerda;
    private Animation andarParaDireita;
    private Animation parado;
    private Animation paradoDown;
    private Animation paradoRight;
    private Animation paradoUp;
    private Animation paradoLeft;
    
    private float tempoDaAnimacao;
    
    public Goomba(Texture g, Texture f){
        
        goomba = g;
        field = f;
        x=100;
        y=100;
        
        quadrosDaAnimacao = TextureRegion.split(g, 21, 24);
        andarParaBaixo = new Animation(0.1f,
                quadrosDaAnimacao[0][0], 
                quadrosDaAnimacao[0][1], 
                quadrosDaAnimacao[0][2],
                quadrosDaAnimacao[0][3],
                quadrosDaAnimacao[0][4]);
        andarParaBaixo.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        
        andarParaDireita = new Animation(0.1f,
                quadrosDaAnimacao[1][0], 
                quadrosDaAnimacao[1][1], 
                quadrosDaAnimacao[1][2],
                quadrosDaAnimacao[1][3],
                quadrosDaAnimacao[1][4]);
        andarParaDireita.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        
        andarParaCima = new Animation(0.1f,
                quadrosDaAnimacao[2][0], 
                quadrosDaAnimacao[2][1], 
                quadrosDaAnimacao[2][2],
                quadrosDaAnimacao[2][3],
                quadrosDaAnimacao[2][4]);
        andarParaCima.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        
        andarParaEsquerda = new Animation(0.1f,
                quadrosDaAnimacao[3][0], 
                quadrosDaAnimacao[3][1], 
                quadrosDaAnimacao[3][2],
                quadrosDaAnimacao[3][3],
                quadrosDaAnimacao[3][4]);
        andarParaEsquerda.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        
        paradoDown = new Animation(10f, quadrosDaAnimacao[0][2]);
        paradoDown.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
           
        paradoRight = new Animation(10f, quadrosDaAnimacao[1][2]);
        paradoRight.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        
        paradoUp = new Animation(10f, quadrosDaAnimacao[2][2]);
        paradoUp.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        
        paradoLeft = new Animation(10f, quadrosDaAnimacao[3][2]);
        paradoLeft.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        
        parado = paradoDown;
        atual = parado;
        
        tempoDaAnimacao = 0;
        
        fieldHeight=field.getHeight();
        fieldWidth=field.getWidth();
    }
    
    
    
    public void render(SpriteBatch batch) {     
        batch.draw((TextureRegion)atual.getKeyFrame(tempoDaAnimacao), x, y);
    }
    
    
    public void update(float delta) {
        if(Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.DOWN)|| 
           Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            
            if(Gdx.input.isKeyPressed(Input.Keys.UP) && y<(fieldHeight-goombaHeight)){
               y++;
               atual=andarParaCima;
               parado=paradoUp;
           }
            if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && y>(0)){
               y--;
               atual=andarParaBaixo;
               parado=paradoDown;
           }
            if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && x>(0)){
               x--;
               atual=andarParaEsquerda;
               parado=paradoLeft;
           }
            if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && x<(fieldWidth-goombaWidth)){
               x++;
               atual=andarParaDireita;
               parado=paradoRight;
           }
        }
        else{
            atual = parado;
        }
        tempoDaAnimacao += Gdx.graphics.getDeltaTime();
    }
}
