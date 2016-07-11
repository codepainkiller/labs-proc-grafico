import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

public class Foto extends Component
{       
    BufferedImage   img;
    List<List<Integer>> matrizImg = new ArrayList<List<Integer>>();
    List<List<Integer>> matrizImg_R = new ArrayList<List<Integer>>();
    List<List<Integer>> matrizImg_G = new ArrayList<List<Integer>>();
    List<List<Integer>>matrizImg_B = new ArrayList<List<Integer>>();
    int             columnas;            //numero de filas
    int             filas;               //numero de

    public Foto(String nombreImagen)//con el nombre de la foto creo una nueva img y lo paso al buffer
    {
        try
        {
            img = ImageIO.read(new File(nombreImagen));//paso la img al buffer, este buffer recibe escala grises o rgb
            convertirImagenAMatriz();
        }
        catch (IOException e) {}
    }

    public void convertirImagenAMatriz()//paso del buffer a matrices
    {
        filas = img.getHeight();
    	columnas = img.getWidth();
    	double r;
    	double g;
    	double b;

    	WritableRaster raster=img.getRaster();//de la img en buffer lo rasterisoo convierto en matriz
    	int numBandas=raster.getNumBands(); 
        short aux;
    	for (int i=0;i<filas;i++) 
    	{
            List<Integer> filaEscalaGrises = new ArrayList<Integer>();//fila vacia
            List<Integer> filaMatrizImg_R = new ArrayList<Integer>();//fila vacia
            List<Integer> filaMatrizImg_G = new ArrayList<Integer>();//fila vacia
            List<Integer> filaMatrizImg_B = new ArrayList<Integer>();//fila vacia
            for(int j=0;j<columnas;j++) 
            {
                if (numBandas==3)//si la imagen es rgb
                {   r=raster.getSampleDouble(j,i,0);
                    g=raster.getSampleDouble(j,i,1);
                    b=raster.getSampleDouble(j,i,2);                                     
                    filaEscalaGrises.add((int)(r+g+b)/3);                    
                    filaMatrizImg_R.add((int)r);
                    filaMatrizImg_G.add((int)g);
                    filaMatrizImg_B.add((int)b);                   
                }
                if (numBandas==1)//si imagen es escala grises
                {   filaEscalaGrises.add((int)raster.getSampleDouble(j,i,0));                    
                    filaMatrizImg_R.add((int)raster.getSampleDouble(j,i,0));                
                    filaMatrizImg_G.add((int)raster.getSampleDouble(j,i,0));
                    filaMatrizImg_B.add((int)raster.getSampleDouble(j,i,0));                   
                }
            }
            matrizImg.add(filaEscalaGrises);
            matrizImg_R.add(filaMatrizImg_R);
            matrizImg_G.add(filaMatrizImg_G);
            matrizImg_B.add(filaMatrizImg_B);            
        }
    }

    public void convertirMatrizAImagenEscalaGrises()//servira para guardar en escala grises
    {
        int alto = matrizImg.size();
	int ancho = matrizImg.get(0).size();
        
        filas=alto;
        columnas=ancho;
        img = new BufferedImage(ancho,alto,BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster wr = img.getRaster();

        for (int i=0;i<alto;i++)
        {   
            for(int j=0;j<ancho;j++)
                {                                      
                    wr.setSample(j,i,0,matrizImg.get(i).get(j));                                                  
                }
        }                     
        img.setData(wr);
    }
    
    public void convertirMatrizAImagenRGB()//servira para guardar en rgb
    {
        int alto = matrizImg_R.size();
	int ancho = matrizImg_R.get(0).size();        
       filas=alto;
        columnas=ancho;
        img = new BufferedImage(ancho,alto,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = img.getRaster();
        for (int i=0;i<alto;i++)//filas
        {
            for(int j=0;j<ancho;j++)
            {                           
                    wr.setSample(j,i,0,matrizImg_R.get(i).get(j));
                    wr.setSample(j,i,1,matrizImg_G.get(i).get(j));
                    wr.setSample(j,i,2,matrizImg_B.get(i).get(j));
                    
            }
            
        }
        img.setData(wr);
    }
/*guardar matriz en gris modificada, los valores estan en rgb*/
    public void guardarImagen(String path)
    {       
        /*
        int alto = matrizImg_R.size();
	int ancho = matrizImg_R.get(0).size(); 
        img = new BufferedImage(ancho,alto,BufferedImage.TYPE_BYTE_GRAY);
        /*
        WritableRaster wr = img.getRaster();

        for (int i=0;i<alto ;i++)
        {            for(int j=0;j<ancho;j++)
            {
                wr.setSample(j,i,0,matrizImg_R.get(i).get(j));
            }
        }

        img.setData(wr);
         * 
         */
        try
        {
            ImageIO.write(img, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
    }
/*guardar matriz en rgb modificada, los valores estan en rgb*/
public void guardarImagen(double [][]matriz_R, double [][]matriz_G, double [][]matriz_B,String path)
 {
        BufferedImage imgn = new BufferedImage(matriz_R[0].length,matriz_R.length,BufferedImage.TYPE_INT_RGB);
        WritableRaster wr = imgn.getRaster();

        for (int i=0;i<matriz_R.length;i++)
        {   for(int j=0;j<matriz_R[0].length;j++)
            {
                wr.setSample(j,i,0,matriz_R[i][j]);
                wr.setSample(j,i,1,matriz_G[i][j]);
                wr.setSample(j,i,2,matriz_B[i][j]);
            }
        }

        img.setData(wr);
        try
        {
            ImageIO.write(img, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
    }
         
     /*Coloca una imagen gris en el label*/
    public static void ventana(Foto imagen,JLabel label)
    {
        //abro la imagen pero de forma scalada
        
        ImageIcon a= new ImageIcon(imagen.getImg());
        Icon icono = new ImageIcon(
        a.getImage().getScaledInstance(label.getWidth()-15,label.getHeight()-15,Image.SCALE_DEFAULT));
        label.setIcon(a);          
        
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public List<List<Integer>> getMatrizImg() {
        return matrizImg;
    }

    public void setMatrizImg(List<List<Integer>> matrizImg) {
        this.matrizImg = matrizImg;
    }

    public List<List<Integer>> getMatrizImg_B() {
        return matrizImg_B;
    }

    public void setMatrizImg_B(List<List<Integer>> matrizImg_B) {
        this.matrizImg_B = matrizImg_B;
    }

    public List<List<Integer>> getMatrizImg_G() {
        return matrizImg_G;
    }

    public void setMatrizImg_G(List<List<Integer>> matrizImg_G) {
        this.matrizImg_G = matrizImg_G;
    }

    public List<List<Integer>> getMatrizImg_R() {
        return matrizImg_R;
    }

    public void setMatrizImg_R(List<List<Integer>> matrizImg_R) {
        this.matrizImg_R = matrizImg_R;
    }
    
   

}
