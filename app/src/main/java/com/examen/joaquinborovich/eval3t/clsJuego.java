package com.examen.joaquinborovich.eval3t;

import android.util.Log;
import android.view.MotionEvent;

import org.cocos2d.actions.interval.IntervalAction;
import org.cocos2d.actions.interval.MoveBy;
import org.cocos2d.actions.interval.MoveTo;
import org.cocos2d.actions.interval.RotateBy;
import org.cocos2d.actions.interval.RotateTo;
import org.cocos2d.actions.interval.ScaleBy;
import org.cocos2d.actions.interval.ScaleTo;
import org.cocos2d.actions.interval.Sequence;
import org.cocos2d.layers.Layer;
import org.cocos2d.nodes.Director;
import org.cocos2d.nodes.Scene;
import org.cocos2d.nodes.Sprite;
import org.cocos2d.opengl.CCGLSurfaceView;
import org.cocos2d.types.CCSize;

import java.util.Random;

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


    float MitadHeight;
    float MitadWidth;
    float CuartoWidth;
    float CuartoHeight;
    float TresCuartosHeight;
    float TresCuartosWidth;


    public clsJuego(CCGLSurfaceView vistaPrincipal)
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
        MitadHeight = HeightDispositivo/2;
        MitadWidth = WidthDispositivo/2;


        Log.d(TAG, "ComenzarJuego: Calculo los cuartos de la pantalla");
        CuartoHeight = MitadHeight/2;
        CuartoWidth = MitadWidth/2;


        Log.d(TAG, "ComenzarJuego: Calculo 3 cuartos de la pantalla");
        TresCuartosHeight = CuartoHeight*3;
        TresCuartosWidth = CuartoWidth*3;

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

            PersonaUno.setPosition(CuartoWidth, CuartoHeight);
            PersonaDos.setPosition(CuartoWidth, TresCuartosHeight);
            PersonaTres.setPosition(TresCuartosWidth, CuartoHeight);
            PersonaCuatro.setPosition(TresCuartosWidth, TresCuartosHeight);

            super.addChild(PersonaUno);
            super.addChild(PersonaDos);
            super.addChild(PersonaTres);
            super.addChild(PersonaCuatro);
        }

        @Override
        public boolean ccTouchesBegan(MotionEvent event)
        {
            Random RandomNum = new Random();
            int azar = RandomNum.nextInt(3);

            switch (azar)
            {
                case 0:
                    PersonaUno.runAction(RotateBy.action(1f, 360f));
                    PersonaDos.runAction(RotateBy.action(1f, -360f));
                    PersonaTres.runAction(RotateBy.action(1f, -360f));
                    PersonaCuatro.runAction(RotateBy.action(1f, -360f));

                    break;
                case 1:
                    PersonaUno.runAction(RotateBy.action(1f, -360f));
                    PersonaDos.runAction(RotateBy.action(1f, 360f));
                    PersonaTres.runAction(RotateBy.action(1f, -360f));
                    PersonaCuatro.runAction(RotateBy.action(1f, -360f));

                    break;
                case 2:
                    PersonaUno.runAction(RotateBy.action(1f, -360f));
                    PersonaDos.runAction(RotateBy.action(1f, -360f));
                    PersonaTres.runAction(RotateBy.action(1f, 360f));
                    PersonaCuatro.runAction(RotateBy.action(1f, -360f));

                    break;
                case 3:
                    PersonaUno.runAction(RotateBy.action(1f, -360f));
                    PersonaDos.runAction(RotateBy.action(1f, -360f));
                    PersonaTres.runAction(RotateBy.action(1f, -360f));
                    PersonaCuatro.runAction(RotateBy.action(1f, 360f));

                    break;
                default:
                    break;
            }
            return true;
        }

        @Override
        public boolean ccTouchesMoved(MotionEvent event)
        {
            if (PersonaUno.getPositionX()>(0f+100f))
            {
                PersonaUno.runAction(MoveTo.action(0.1f, PersonaUno.getPositionX()-30f, PersonaUno.getPositionY()));
            }
            if (PersonaDos.getPositionX()>(0f+100f))
            {
                PersonaDos.runAction(MoveTo.action(0.1f, PersonaDos.getPositionX()-30f, PersonaDos.getPositionY()));
            }
            if (PersonaTres.getPositionX()<=(WidthDispositivo-100f))
            {
                PersonaTres.runAction(MoveTo.action(0.1f, PersonaTres.getPositionX()+30f, PersonaTres.getPositionY()));
            }
            if (PersonaCuatro.getPositionX()<=(WidthDispositivo-100f))
            {
                PersonaCuatro.runAction(MoveTo.action(0.1f, PersonaCuatro.getPositionX()+30f, PersonaCuatro.getPositionY()));
            }

            return true;
        }

        @Override
        public boolean ccTouchesEnded(MotionEvent event)
        {
            ScaleBy grande;
            ScaleTo normal;
            grande = ScaleBy.action(0.7f, 1.5f, 1.5f);
            //normal = ScaleBy.action(0.1f , -1f, -1f);
            normal = ScaleTo.action(0.5f , 1f, 1f);
            IntervalAction Secuencia = Sequence.actions(grande, normal, grande, normal, grande, normal);
            PersonaUno.runAction(Secuencia);
            return true;
        }
    }

}
