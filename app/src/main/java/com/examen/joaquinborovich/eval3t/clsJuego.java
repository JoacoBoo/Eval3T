package com.examen.joaquinborovich.eval3t;

import android.util.Log;

import org.cocos2d.layers.Layer;
import org.cocos2d.nodes.Director;
import org.cocos2d.nodes.Scene;
import org.cocos2d.nodes.Sprite;
import org.cocos2d.opengl.CCGLSurfaceView;
import org.cocos2d.types.CCSize;

/**
 * Created by 42374778 on 16/11/2017.
 */

public class clsJuego
{
    String TAG = "clsJuego";
    CCGLSurfaceView _VistaDelJuego;
    CCSize PantallaDelDispositivo;
    float WidthDispositivo, HeightDispositivo;


    Sprite PersonaUno;
    Sprite PersonaDos;
    Sprite PersonaTres;
    Sprite PersonaCuatro;




    public clsJuego()
    {

    }
    public void ComenzarJuego()
    {
        Log.d(TAG, "ComenzarJuego: Comienza el Juego");
        Director.sharedDirector().attachInView(_VistaDelJuego);

        PantallaDelDispositivo = Director.sharedDirector().displaySize();
        Log.d(TAG, "ComenzarJuego: Pantalla del dispositivo - Ancho:" + PantallaDelDispositivo.width + " - Alto: " + PantallaDelDispositivo.height);

        Log.d(TAG, "ComenzarJuego: Guardo en dos variables por separado esta informacion");
        WidthDispositivo = PantallaDelDispositivo.width;
        Log.d(TAG, "ComenzarJuego: Ancho"+ WidthDispositivo);

        HeightDispositivo = PantallaDelDispositivo.height;
        Log.d(TAG, "ComenzarJuego: Alto" + HeightDispositivo);

        Log.d(TAG, "ComenzarJuego: Calculo la mitad de la pantalla");
        float MitadHeight = HeightDispositivo/2;
        float MitadWidth = WidthDispositivo/2;


        Log.d(TAG, "ComenzarJuego: Calculo los cuartos de la pantalla");
        float CuartoHeight = MitadHeight/2;
        float CuartoWidth = MitadWidth/2;


        Log.d(TAG, "ComenzarJuego: Calculo 3 cuartos de la pantalla");
        float TresCuartosHeight = CuartoHeight*3;
        float TresCuartosWidth = CuartoWidth*3;

        Log.d(TAG, "ComenzarJuego: Le digo al director que ejecute la escena");
        Director.sharedDirector().runWithScene(EscenaDelJuego());
    }

    private Scene EscenaDelJuego()
    {
        Log.d(TAG, "EscenaDelJuego: Comienza el armado de la escena del juego");

        Log.d(TAG, "EscenaDelJuego: Declaro e instancio la escena en si");
        Scene EscenaADevolver;
        EscenaADevolver=Scene.node();


        Log.d(TAG, "EscenaDelJuego: Declaro e instancio la capa que va a contener la imagen de fondo");
        CapaGente MiCapaPrincipal;
        MiCapaPrincipal = new CapaGente();



        Log.d(TAG, "EscenaDelJuego: Agrego a la escena la capa del fondo mas a tras y la del frente mas adelante");
        EscenaADevolver.addChild(MiCapaPrincipal, 10);

        return EscenaADevolver;
    }

    class CapaGente extends Layer
    {
        String TAG = "CapaDelFondo";
        public CapaGente()
        {
            Log.d(TAG, "CapaDelFondo: Comienza el constructor de la capa del frente");

            Log.d(TAG, "CapaDelFondo: Pongo el jugador en su posicion inicial");
            PonerGente();
            this.setIsTouchEnabled(true);
        }

        private void PonerGente()
        {
            PersonaUno = Sprite.sprite("asman.jpg");
            PersonaDos = Sprite.sprite("axel.jpg");
            PersonaTres = Sprite.sprite("cebo.jpg");
            PersonaCuatro = Sprite.sprite("lishu.jpg");

            super.addChild(PersonaUno);
            super.addChild(PersonaDos);
            super.addChild(PersonaTres);
            super.addChild(PersonaCuatro);
        }

    }

}
