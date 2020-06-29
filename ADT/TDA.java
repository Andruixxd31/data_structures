//  André Alberto Contreras Rivera  -   A01636183
//  Andrés Díaz de León Valdés      -   A01620020

public class TDA {

    // * atributos
    private final int real;
    private final int imaginario;

    // * ---------------- Constructor ---------------------
    public TDA(final int real, final int imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }

    // * ---------------- Métodos ---------------------
    public String modificarse(final int real, final int imaginario) {
        final int sumaR = this.real + real;
        final int sumaI = this.imaginario + imaginario;
        if (sumaI < 0) {
            return sumaR + " " + sumaI + "i";
        } else {
            return sumaR + " + " + sumaI + "i";
        }
    }

    public String conjugado() {
        final int imaginarioC = this.imaginario * -1;
        if (imaginarioC < 0) {
            return this.real + " " + imaginarioC + "i";
        } else {
            return this.real + " + " + imaginarioC + "i";
        }
    }

    public TDA suma(final int real, final int imaginario) {
        final int sumaR = this.real + real;
        final int sumaI = this.imaginario + imaginario;
        final TDA tdaS = new TDA(sumaR, sumaI);
        return tdaS;
    }

    public TDA multiplicacion(final int real, final int imaginario) {
        final int realR = this.real * real - this.imaginario * imaginario;
        final int realI = this.real * imaginario + this.imaginario * real;
        final TDA tdaM = new TDA(realR, realI);
        return tdaM;
    }

    public TDA multiplicacionEscalar(final int varEscalar) {
        final int realE = this.real * varEscalar;
        final int imaginarioE = this.imaginario * varEscalar;
        final TDA tdaME = new TDA(realE, imaginarioE);
        return tdaME;
    }

    public String toString() {
        if (this.imaginario < 0) {
            return this.real + " " + this.imaginario + "i";
        } else {
            return this.real + " +" + this.imaginario + "i";
        }
    }
}