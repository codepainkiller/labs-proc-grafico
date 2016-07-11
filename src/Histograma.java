import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.JLabel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class Histograma {
    BufferedImage grafica = null;
    JFreeChart chart;
    int paleta_EG[]=new int[256];
    int paleta_R[]=new int[256];
    int paleta_G[]=new int[256];
    int paleta_B[]=new int[256];
    
    int umbral_EG;
    int umbral_R;
    int umbral_G;
    int umbral_B;

    public int[] getPaleta_B() {
        return paleta_B;
    }

    public void setPaleta_B(int[] paleta_B) {
        this.paleta_B = paleta_B;
    }

    public int[] getPaleta_EG() {
        return paleta_EG;
    }

    public void setPaleta_EG(int[] paleta_EG) {
        this.paleta_EG = paleta_EG;
    }

    public int[] getPaleta_G() {
        return paleta_G;
    }

    public void setPaleta_G(int[] paleta_G) {
        this.paleta_G = paleta_G;
    }

    public int[] getPaleta_R() {
        return paleta_R;
    }

    public void setPaleta_R(int[] paleta_R) {
        this.paleta_R = paleta_R;
    }

    public int getUmbral_B() {
        return umbral_B;
    }

    public void setUmbral_B(int umbral_B) {
        this.umbral_B = umbral_B;
    }

    public int getUmbral_EG() {
        return umbral_EG;
    }

    public void setUmbral_EG(int umbral_EG) {
        this.umbral_EG = umbral_EG;
    }

    public int getUmbral_G() {
        return umbral_G;
    }

    public void setUmbral_G(int umbral_G) {
        this.umbral_G = umbral_G;
    }

    public int getUmbral_R() {
        return umbral_R;
    }

    public void setUmbral_R(int umbral_R) {
        this.umbral_R = umbral_R;
    }
    
    int filas_inicial;
    int filas_final;
    int columnas_inicial;
    int columnas_final;
    
    List<List<Integer>> I_EG;
    List<List<Integer>> I_R;
    List<List<Integer>> I_G;
    List<List<Integer>> I_B;
    JLabel label;
    Foto img;

    public void calcular_paletas(){
        //llenar paleta de escala grsises
        for (int i = filas_inicial; i < filas_final; i++) {
            List<Integer> fila = I_EG.get(i);
            for (int j = columnas_inicial; j < columnas_final; j++) {
                 paleta_EG[fila.get(j)]=paleta_EG[fila.get(j)]+1;                               
            } 
        }      
        umbral_EG=this.CalcularUmbral(I_EG);                 
        
        //llenar paleta de R
        for (int i = filas_inicial; i < filas_final; i++) {
            List<Integer> fila = I_R.get(i);
            for (int j = columnas_inicial; j < columnas_final; j++) {
                 paleta_R[fila.get(j)]=paleta_R[fila.get(j)]+1;                               
            } 
        }
        umbral_R=this.CalcularUmbral(I_R);
        
        //llenar paleta de G
        for (int i = filas_inicial; i < filas_final; i++) {
            List<Integer> fila = I_G.get(i);
            for (int j = columnas_inicial; j < columnas_final; j++) {
                 paleta_G[fila.get(j)]=paleta_G[fila.get(j)]+1;                               
            } 
        }
        umbral_G=this.CalcularUmbral(I_G);
        
        //llenar paleta de B
        for (int i = filas_inicial; i < filas_final; i++) {
            List<Integer> fila = I_B.get(i);
            for (int j = columnas_inicial; j < columnas_final; j++) {
                 paleta_B[fila.get(j)]=paleta_B[fila.get(j)]+1;                               
            } 
        }
        umbral_B=this.CalcularUmbral(I_B);
    }
    
    public Histograma(Foto img,int filas_inicial,int columnas_inicial,int filas_final,int columnas_final) {     
        this.img=img;
        this.filas_inicial=filas_inicial;
        this.columnas_inicial=columnas_inicial;
        this.filas_final=filas_final;
        this.columnas_final=columnas_final;
        //llenar matriz grises
        I_EG=img.getMatrizImg();//obtengo la matriz escala grises
        I_R=img.getMatrizImg_R();
        I_G=img.getMatrizImg_G();
        I_B=img.getMatrizImg_B();
        
        for (int i = 0; i < 256; i++) {
            paleta_EG[i]=0;
            paleta_R[i]=0;
            paleta_G[i]=0;
            paleta_B[i]=0;
        }        
        this.calcular_paletas();                                        
    }
    
    public BufferedImage crearGrafica(int w,int h,int paleta[],String Titulo)
  {
    //XYSeries series = new XYSeries("Grafico Dispersion 1");
    XYSeries serie1 = new XYSeries("PRUEBA");
      for (int i = 0; i < 256; i++) {
          serie1.add(i,paleta[i]);         
      }   
       XYSeriesCollection collection = new XYSeriesCollection();
       collection.addSeries(serie1);     
       chart = ChartFactory.createXYLineChart(Titulo,"Frecuencia Tono" , "Profundida de Tono", collection, PlotOrientation.VERTICAL,false,false, false);
       chart.setBackgroundPaint(Color.WHITE);//color de fondo               
       
        BufferedImage image = chart.createBufferedImage(w,h);
        return image;      
     }         
    
    public int CalcularUmbral(List<List<Integer>> I){
    //se calcula el valor inicial del umbral_EG
    double umbral0 = 0;

    for (int i = filas_inicial; i < filas_final; i++){

        for (int j = columnas_inicial; j < columnas_final; j++){
            umbral0 += I.get(i).get(j);
        } 
    } 

    umbral0 = umbral0 / ((filas_final-filas_inicial)*(columnas_final-columnas_inicial)); 

    //vamos a calcular el valor real 

    double umbral1 = 0; 
    double umbral_der = 0; 
    double umbral_izq = 0; 
    int cont_izq = 0; 
    int cont_der = 0; 

    while( Math.abs(umbral0 - umbral1) > 0){
        umbral1 = umbral0;
        umbral_der = 0;
        umbral_izq = 0;
        cont_izq = 0;
        cont_der = 0;

        for (int i = filas_inicial; i < filas_final; i ++){

            for (int j = columnas_inicial; j < columnas_final; j++){ 

                if (I.get(i).get(j) < umbral1){
                    umbral_izq += I.get(i).get(j);
                    cont_izq ++;
                }

                else{
                    umbral_der += I.get(i).get(j);
                    cont_der ++;
                }
            } 
        }

        umbral0 = (umbral_izq/cont_izq + umbral_der/cont_der)/2;
    }

        return (int)umbral0;        
    }

    Histograma equalizar() {
        Histograma histo_nueva=new Histograma(img, 0, 0, img.filas, img.columnas);
        // build a cumulative histogram as LUT
        int sum=0;
        int lut[]=new int[256];
        for ( int i=0; i < paleta_EG.length; i++ )
        {
            sum += paleta_EG[i];
            lut[i] = sum*255/(img.getFilas()*img.getColumnas());//posiciones alma
        }
        histo_nueva.setPaleta_EG(lut);
        return histo_nueva;
    }

    int[] equalizar_paleta() {
        int sum=0;
        int lut[]=new int[256];
        for ( int i=0; i < paleta_EG.length; i++ )
        {
            sum += paleta_EG[i];
            lut[i] = sum*255/(img.getFilas()*img.getColumnas());//posiciones alma
        }
        return lut;
    }
   

    
    
    
    
}
