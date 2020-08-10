public class Controlador {
    private Lienzo objLienzo; //VISTA
    private AVL objArbol; //MODELO

    public Controlador(Lienzo objLienzo, AVL objArbol) {
        this.objLienzo = objLienzo;
        this.objArbol = objArbol;
    }
    
    public void iniciar() {
        objLienzo.setObjArbol(objArbol);
    }
}
