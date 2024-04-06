import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class C {
    Double x;
    Double y;
    Integer claz;

    public C () {}

    public C (Integer x, Integer y , Integer claz ){
        this.x = 1.0*x;
        this.y = 1.0*y;
        this.claz = claz;
    }

    public Double getB() { return y; }
    public Double getA() { return x; }

    public void setA(Double x) { this.x = x; }
    public void setB(Double y) { this.y = y; }

    public C (Double x, Double y, Integer claz) {
        this.x = x;
        this.y = y;
        this.claz = claz;
    }



    public double getA_( C two ){
        Double dx = two.getX()-this.x;
        Double dy = two.getY()-this.y;
        Double a=( dx/dy );
        return a;
        /*out.setA( a );
        Double b =  this.y - a*this.x ;
        out.setB( b );

        return out;*/
    }

    public Double getB_( Double a ){

        Double b = ( 1.0*this.claz - a*this.x )/this.y;
        return b;
    }



/*out.setA( a );
        Double b =  this.y - a*this.x ;
        out.setB( b );

        return out;*/



    public Double getHeight(C end , C target ){
        C out = new C();

        Double dlugoscAB = Math.pow( Math.pow(this.x-end.getX(),2) + Math.pow(this.y-end.getY(),2) , .5)   ;
        C U = new C();
        U.setX( end.getX()-x );
        U.setY( end.getY()-y );

        C V = new C();
        V.setX( target.getX()-x );
        V.setY( target.getY()-y );



        Double skalar = U.o(V);
        Double odleglosc = Math.abs( skalar/dlugoscAB);

        return odleglosc;
    }


    public Double o( C V ){
        return x*V.getX() + y*V.getY();
    }

    public C getHalf( C V ){
        return new C ( ((x+V.getX())/2) , ((y+V.getY())/2) , 0 ) ;
    }


    @Override
    public String toString() {
        return  x + "," + y;
    }
}
