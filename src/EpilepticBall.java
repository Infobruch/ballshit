public class EpilepticBall extends BouncingBall{
    public EpilepticBall(double pX, double pY, double pZ, double pRadius){
        super(pX, pY, pZ, pRadius);
    }
    @Override
    public void bearbeiteHindernis(Hindernis pH){
        double dX = Math.abs(kugel.gibX() - pH.gibPosition().x);
        double dY = Math.abs(kugel.gibY() - pH.gibPosition().y);
        double dZ = Math.abs(kugel.gibZ() - pH.gibPosition().z);

        double b = pH.gibBreite();
        double h = pH.gibHoehe();
        double t = pH.gibTiefe();

        double R = Math.random(), G = Math.random(), B = Math.random();
        if((dX < b/2+radius/2)&&(dY < h/2 +radius/2)&&(dZ < t/2 +radius/2)){
            if (2*dX/b> 2*dY/h && 2*dX/b>2*dZ/t){
                bewegung.x = - bewegung.x;
                kugel.setzeSelbstleuchten(R, G, B);
                kugel.setzeFarbe(R, G, B);
            }
            if (2*dY/h>2*dX/b && 2*dY/h>2*dZ/t){
                bewegung.y = - bewegung.y;
                kugel.setzeSelbstleuchten(R, G, B);
                kugel.setzeFarbe(R, G, B);
            }
            if (2*dZ/t>2*dX/b && 2*dZ/t>2*dY/h){
                bewegung.z = - bewegung.z;
                kugel.setzeSelbstleuchten(R, G, B);
                kugel.setzeFarbe(R, G, B);
            }
        }
    }
}
