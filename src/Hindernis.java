import GLOOP.*;
public class Hindernis{
    private GLQuader quader;
    private double breite, hoehe, tiefe;

    public Hindernis(double pX,double pY,double pZ, double pBreite, double pHoehe, double pTiefe){
        quader = new GLQuader(pX,pY,pZ,pBreite,pHoehe,pTiefe,"src/Marmor.jpg");
        breite = pBreite;  
        hoehe  = pHoehe;
        tiefe  = pTiefe;
    }

    public GLVektor gibPosition() { 
        return quader.gibPosition(); 
    }

    public double gibBreite(){ 
        return breite; 
    }

    public double gibHoehe(){ 
        return hoehe; 
    }

    public double gibTiefe(){ 
        return tiefe; 
    }
    public void rotate(double wX, double wY, double wZ){
        quader.drehe(wX, wY, wZ);
    }
    public void changeTexture(String pTexture){
        quader.setzeTextur(pTexture);
    }
    public void changeMaterial(float[][] pMaterial){
        quader.setzeMaterial(pMaterial);
    }
    public void changeColor(double r, double g, double b){
        quader.setzeFarbe(r,g,b);
    }
    public void setVisibility(boolean pVisibility){
        quader.setzeSichtbarkeit(pVisibility);
    }

}