//  André Alberto Contreras Rivera  -   A01636183
//  Andrés Díaz de León Valdés      -   A01620020

public class Main {
    public static void main(final String[] args) {
        final TDA complejo = new TDA(3, -2);
        System.out.println(complejo.toString());

        System.out.println(complejo.modificarse(4, 6));
        System.out.println(complejo.conjugado());

        final TDA sumaEx = complejo.suma(7, -4);
        System.out.println(sumaEx.toString());

        final TDA multEx = sumaEx.multiplicacion(5, -2);
        System.out.println(multEx.toString());

        final TDA mult_escEx = sumaEx.multiplicacionEscalar(-3);
        System.out.println(mult_escEx.toString());
    }
}