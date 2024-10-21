package Programacion.Tema1;

public class Tema1Ejercicio5 {
    public static void main (String [] args){

        int op1= 24%5;
        System.out.println ("1. 24%5="+ op1);

        double op2= 7/2+2.5;
        System.out.println("2. 7/2+2.5"+ op2);

        double op3= 10.8/2+2;
        System.out.println("3. 10.8/2+2"+ op3);

        int op4= (4 + 6) *3 +2*(5-1);
        System.out.println( "4. (4+6) * 3 +2*(5-1)"+ op4);

        double op5= 5/2 + 17 % 3 ;
        System.out.println( "5. 5/2 + 17 % 3"+op5);

        boolean op6= (7>=5) || (27!=8);
        System.out.println("6. (7>=5) OR (27<>8)"+ op6);

        boolean op7= (45<=7) || !(7<=2);
        System.out.println("7. 45<=7 OR NOT (7<=2)"+ op7);

        double op8= (27%4+15/4);
        System.out.println("8. 27%4+15/4"+ op8);

        double op9= (37/4*4-2);
        System.out.println("9. 37/(4*4-2)"+ op9);

        boolean op10= (25<=7) &&!(7<=2);
        System.out.println("10. (25<=7) AND NOT (7=2)"+10);

        boolean op11= ('H' < 'J') && ('9' != '7');
        System.out.println ("11. ('H' < 'J') AND ('9' <> '7')"+ op11);

        boolean op12= (25>20&&13>5);
        System.out.println("12. (25>20 AND 13> 5) "+ op12);

        boolean op13= 10+4 < 15-3 || 2*5+1 > 14-2*2;
        System.out.println("13. 01+4 < 15-3 AND 2*5+1 > 14-2*2"+ op13);

        boolean op14=4*2<=8||2*2<5&&4>3+1 ;
        System.out.println("14. 4*2 <=8 OR 2* < 5 AND 4 > 3 + 1" + op14);

        boolean op15= 10<=2*5&&3<4||!(8>7)&&3*2<=4*2-1;
        System.out.println( "15. 10<= 2*5 AND 3<4 OR NOT (8<7) AND 3*2 <= 4*2-1" +  op15);
    }
}
