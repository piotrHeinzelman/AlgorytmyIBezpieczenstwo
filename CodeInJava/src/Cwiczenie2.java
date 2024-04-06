import java.util.ArrayList;

public class Cwiczenie2 {

    private Double length=0.0;
    public Cwiczenie2() {}



    public void run(){

        ArrayList<C> dataA = new ArrayList<>();

        ArrayList<C> dataB = new ArrayList<>();

        dataA.add( new C( 0,1,1 )); // 0
        dataA.add( new C( 1,3,1 )); // 1
        dataA.add( new C( 2,6,1 )); // 2

        dataB.add( new C( 2,1,-1 )); // 3
        dataB.add( new C( 3,3,-1 )); // 4
        dataB.add( new C( 4.0, 4.5 ,-1 )); // 5

        length=0.0;
        findAB(  dataA , dataB );
        findAB(  dataB , dataA );

    }






    public void findAB( ArrayList<C> dataA , ArrayList<C> dataB ){
        length=0.0;
        C ST=null;
        C EN=null;
        for ( C start : dataA ){
            for ( C end : dataA ){
                if ( start!=end ) {
                    Double min=99999.9;
                    C S=null;
                    C E=null;
                    C T=null;
                    for ( C target : dataB ) {
                        Double height = start.getHeight( end, target );
                        if ( height < min ) { min=height; S=start; E=end; T=target; }
                    }
                    C half=start.getHalf( T );
                    Double a_ = start.getA_(end);
                    Double b_ = start.getB_( a_ );

                    if ( min>length ) { ST=S; EN=E; length=min; System.out.println( min + " : a="+a_+ " b=" +b_ + " # S:" + S + ", E=" + E + ", target:" + T ); }

                }
            }
        }

        //System.out.println( "len:" + length + " a=" + ST.getAB( EN ).getA() + ", b="+ST.getAB( EN ).getB() );

        //System.out.println(  data.get(3).getAB( data.get(4) ) );
        //System.out.println(  data.get(3).getHeight( data.get(4) , data.get(0) ) );
    }



}
