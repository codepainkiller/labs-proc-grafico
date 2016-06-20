



/**
 *
 * @author Martin Cruz <i@martincruz.me>
 */
public class Suavizado {
    
    double[][] mask;

    public Suavizado() {
        double[][] maskMedia = {{1, 1, 1},{1, 2, 1}, {1, 1, 2}};
        
        this.mask = maskMedia;
    }
    
    public void showMask() {
        
        for (int i = 0; i < this.mask.length; i++) {
            for (int j = 0; j < this.mask[i].length; j++) {
                System.out.print(this.mask[i][j] + ", ");
            }
            System.out.println("");
        }
        System.out.println(this.mask.length);
        System.out.println(this.mask[0].length);
    }
    
    public Imagen algoritmmo(Imagen image) {
        
        int filas = image.getFilas();
        int columnas = image.getColumnas();
        
        double[][] I = image.getMatrizImg();
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                
            }
        }
        
        return image;
    }
    
    public boolean isValid(double i, double j, int filas, int columnas) {
        
        
        return false;
    }
    
    
    public static void main(String[] args) {
        Suavizado s = new Suavizado();
        s.showMask();
        
    }
}
