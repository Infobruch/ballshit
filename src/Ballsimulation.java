import GLOOP.*;
public class Ballsimulation{
    private GLKamera kamera;
    GLLicht licht;
    private GLTastatur tastatur;

    private Ball ball;
    private BouncingBall bouncingBall;
    private EpilepticBall epilepticBall;
    private DaReshapingOne daReshapingOne;
    private Hindernis[] hindernis;

    public Ballsimulation(){
        kamera = new GLSchwenkkamera(800,500);
        kamera.setzePosition(0,500,2000);
        licht  = new GLLicht();
        tastatur = new GLTastatur();

        hindernis = new Hindernis[6];
        hindernis[0] = new Hindernis(1000,200,0, 50,400,1300);
        hindernis[1] = new Hindernis(-1000,200,0, 50,400,1300);
        hindernis[2] = new Hindernis(0,200,650, 2000,400,50);
        hindernis[3] = new Hindernis(0,200,-650, 2000,400,50);
        hindernis[4] = new Hindernis(0,375,0, 2000,50,1300);
        hindernis[5] = new Hindernis(0,25,0, 2000,50,1300);
        for(int i=0; i<hindernis.length; i++){
            hindernis[i].changeMaterial(GLMaterial.GLAS);
        }
        //hindernis[2].setVisibility(false);

        ball = new Ball (0,200,0, 20);
        ball.werfen(new GLVektor(Math.random()*4-2,0,Math.random()*4-2));
        bouncingBall = new BouncingBall(0, 200, 0, 20);
        bouncingBall.werfen(new GLVektor(Math.random()*4-2,Math.random()*4-2 ,Math.random()*4-2));
        epilepticBall = new EpilepticBall(0, 200, 0, 20);
        epilepticBall.werfen(new GLVektor(Math.random()*4-2,Math.random()*4-2 ,Math.random()*4-2));
        daReshapingOne = new DaReshapingOne(0,200,0, 20);
        daReshapingOne.werfen(new GLVektor(Math.random()*2-1,Math.random()*2-1 ,Math.random()*2-1));

        fuehreAus();
    }

    public void fuehreAus(){
        while (!tastatur.esc()){

            ball.bewegeDich();
            bouncingBall.bewegeDich();
            epilepticBall.bewegeDich();
            daReshapingOne.bewegeDich();
            for (int j=0; j< hindernis.length; j++) {
                ball.bearbeiteHindernis(hindernis[j]);
                bouncingBall.bearbeiteHindernis(hindernis[j]);
                epilepticBall.bearbeiteHindernis(hindernis[j]);
                daReshapingOne.bearbeiteHindernis(hindernis[j]);
            }
            Sys.warte();
        }
        Sys.beenden();
        //juicy balls up in my mouth xd i l to succ yarrack
    }
    
}
