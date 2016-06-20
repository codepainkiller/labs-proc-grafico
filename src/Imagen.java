import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
/**
 *
 * @author usuario
 */
public class Imagen extends Component
{
    BufferedImage   img;
    double [][]     matrizImg;		 //matrizImg de la imagen en escala de grises
    double [][]     matrizImg_R;         //matrizImg de la imagen en R
    double [][]     matrizImg_G;         //matriz de la imagen en G
    double [][]     matrizImg_B;         //matriz de la imagen en B
    int             columnas;            //numero de columnas
    int             filas;               //numero de filas
    
    // matrices temporales para guardar variaciones en los canales
    double [][]     temp_R;         //matrizImg de la imagen en R
    double [][]     temp_G;         //matriz de la imagen en G
    double [][]     temp_B;         //matriz de la imagen en B
    double [][]     temp_Gris;         //matriz de la imagen en B
    

    public Imagen(String nombreImagen)
    {
        try
        {
            img = ImageIO.read(new File(nombreImagen));
            convertirImagenAMatriz();
        }
        catch (IOException e) {}
    }

    public Imagen(double [][]matriz)
    {
         convertirMatrizAImagen(matriz);
    }

    public void convertirImagenAMatriz()
    {
        filas = img.getHeight();
    	columnas = img.getWidth();

    	matrizImg = new double [filas][columnas];
    	matrizImg_R = new double [filas][columnas];
     	matrizImg_G = new double [filas][columnas];
    	matrizImg_B = new double [filas][columnas];
        
        // Matrices temporales
        this.temp_R = new double[this.filas][this.columnas];
        this.temp_G = new double[this.filas][this.columnas];
        this.temp_B = new double[this.filas][this.columnas];
        
        this.temp_Gris = new double[this.filas][this.columnas];
        
        
    	double r;
    	double g;
    	double b;

    	WritableRaster raster=img.getRaster();//leer cabecera
    	int numBandas=raster.getNumBands(); //numero de canales

    	for (int i=0;i<filas;i++) 
    	{
            for(int j=0;j<columnas;j++) 
            {
                if (numBandas==3)
                {   r=raster.getSampleDouble(j,i,0);
                    g=raster.getSampleDouble(j,i,1);
                    b=raster.getSampleDouble(j,i,2);
                 
                    matrizImg[i][j]=(r+g+b)/3;
                    matrizImg_R[i][j]=r;
                    matrizImg_G[i][j]=g;
                    matrizImg_B[i][j]=b;
                }
                if (numBandas==1)
                {   matrizImg[i][j]=raster.getSampleDouble(j,i,0);
                    matrizImg_R[i][j]=255;
                    matrizImg_G[i][j]=255;
                    matrizImg_B[i][j]=255;
                }
                
                // LLenado por default de matrices temporales
                this.temp_R[i][j] = 0;
                this.temp_G[i][j] = 0;
                this.temp_B[i][j] = 0;
                
                this.temp_Gris[i][j] = 0;
            }
        }
    }

    public void convertirMatrizAImagen(double [][] matriz)
    {
        int alto = matriz.length;
	    int ancho = matriz[0].length;

        img = new BufferedImage(ancho,alto,BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster wr = img.getRaster();

        for (int i=0;i<alto;i++)
        {
            for(int j=0;j<ancho;j++)
            {
                wr.setSample(j,i,0,matriz[i][j]);
            }
        }
        img.setData(wr);
    }
    
    public void convertirMatrizAImagenRGB(double [][]matriz_R, double [][]matriz_G, double [][]matriz_B) {
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
    }

    public void guardarImagen(double [][]matriz, String path)
    {       
        BufferedImage img = new BufferedImage(matriz[0].length,matriz.length,BufferedImage.TYPE_BYTE_GRAY);//crear cabecera
        WritableRaster wr = img.getRaster();

        for (int i=0;i<matriz.length;i++)
        {            for(int j=0;j<matriz[0].length;j++)
            {
                wr.setSample(j,i,0,matriz[i][j]);
            }
        }

        img.setData(wr);

        try
        {
            ImageIO.write(img, "JPG", new File(path+".jpg"));
        }
        catch(IOException e){}
    }

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
    
    

    public void brillo(int rango, char canal) {
         
        for (int i = 0; i < this.columnas; i++) {
            for (int j = 0; j < this.filas; j++) {
               double resto = 0;
                switch(canal) {
                    case 'R':
                        resto = this.matrizImg_R[i][j] + rango + this.temp_R[i][j];
                        this.temp_R[i][j] = 0;
                        if (resto > 255) {
                            this.temp_R[i][j] = resto - 255;
                            resto = 255;
                        }

                        if (resto < 0) {
                            this.temp_R[i][j] = resto + this.matrizImg_R[i][j];
                            resto = 0;
                        }

                        this.matrizImg_R[i][j] = resto;
                        break;
                        
                    case 'G':
                        resto = this.matrizImg_G[i][j] + rango + this.temp_G[i][j];
                        this.temp_G[i][j] = 0;
                        if (resto > 255) {
                            this.temp_G[i][j] = resto - 255;
                            resto = 255;
                        }

                        if (resto < 0) {
                            this.temp_G[i][j] = resto + this.matrizImg_G[i][j];
                            resto = 0;
                        }

                        this.matrizImg_G[i][j] = resto;
                        break;
                        
                    case 'B':
                        resto = this.matrizImg_B[i][j] + rango + this.temp_B[i][j];
                        this.temp_B[i][j] = 0;
                        if (resto > 255) {
                            this.temp_B[i][j] = resto - 255;
                            resto = 255;
                        }

                        if (resto < 0) {
                            this.temp_B[i][j] = resto + this.matrizImg_B[i][j];
                            resto = 0;
                        }

                        this.matrizImg_B[i][j] = resto;
                        break;
                }
            }
        }
        
        this.convertirMatrizAImagenRGB(this.matrizImg_R, this.matrizImg_G, this.matrizImg_B);
    }
    
    public void brilloGris(int rango) {
         
        for (int i = 0; i < this.columnas; i++) {
            for (int j = 0; j < this.filas; j++) {
               double resto = 0;
               resto = this.matrizImg[i][j] + rango + this.temp_Gris[i][j];
                this.temp_Gris[i][j] = 0;
                if (resto > 255) {
                    this.temp_Gris[i][j] = resto - 255;
                    resto = 255;
                }

                if (resto < 0) {
                    this.temp_Gris[i][j] = resto + this.matrizImg[i][j];
                    resto = 0;
                }

                this.matrizImg[i][j] = resto; 
            }
        }
        
        this.convertirMatrizAImagen(this.matrizImg);
    }
    
    
    
     public void pseudocolor() {
         
        for (int i = 0; i < this.columnas; i++) {
            for (int j = 0; j < this.filas; j++) {
               this.matrizImg_R[i][j] = 255;
               this.matrizImg_B[i][j] = 255;
            }
        }
        
        this.convertirMatrizAImagenRGB(this.matrizImg_R, this.matrizImg_G, this.matrizImg_B);
    }
   
   @Override
    public void paint(Graphics g) {
        int x=0;
        int y=800;  //valor estandar de y
        int p=0;
        int q=0;
        
        x = img.getWidth(null) * y/img.getHeight(null);
        y = img.getHeight(null) * y/img.getHeight(null);
        
        //g.drawImage(img, 100, 100, null);
        g.drawImage(img, 0, 0, x, y, 0, 0, img.getWidth(null), img.getHeight(null), null);
        //Graphics2D g2 = (Graphics2D) g;           
      
    }

    @Override
    public Dimension getPreferredSize()
    {
        int x=0;
    	int y=800;
        if (img == null)
        {
             return new Dimension(100,100);
        }
        else
        {
             x = img.getWidth(null) * y/img.getHeight(null);
             y = img.getHeight(null) * y/img.getHeight(null);
             return new Dimension(x, y);
          }
    }
   
     /*Coloca una imagen en una ventana*/
    public static void ventana(double matriz[][],String nombre)
    {
        Imagen imagen=new Imagen(matriz);

    	try
        {
            JFrame f = new JFrame(nombre);
            f.addWindowListener(new WindowAdapter()
            {
                @Override
               public void windowClosing(WindowEvent e)
               {}
            }
         );
             f.add(imagen);
        	 f.pack();
        	 f.setVisible(true);
             f.repaint();
        }
        catch (Exception e)
        {
        }
    }
    
    public static void ventana(Imagen img,String nombre)
    {
        //Imagen imagen = new Imagen;

    	try
        {
            JFrame f = new JFrame(nombre);
            f.addWindowListener(new WindowAdapter()
            {
                @Override
               public void windowClosing(WindowEvent e)
               {}
            }
         );
             f.add(img);
        	 f.pack();
        	 f.setVisible(true);
             f.repaint();
        }
        catch (Exception e)
        {
        }
    }
    
    public double[][] getMatrizImg() {

        return matrizImg;
    }
    public int getColumnas() {
        return columnas;
    }
    public int getFilas() {
        return filas;
    }
    public BufferedImage getImg() {
        return img;
    }
    public double[][] getMatrizImg_B() {
        return matrizImg_B;
    }
    public double[][] getMatrizImg_G() {
        return matrizImg_G;
    }
    public double[][] getMatrizImg_R() {
        return matrizImg_R;
    }
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
    public void setFilas(int filas) {
        this.filas = filas;
    }
    public void setMatrizImg(double[][] matrizImg) {
        this.matrizImg = matrizImg;
    }
    public void setImg(BufferedImage img) {
        this.img=img;
    }
    public void setMatrizImg_B(double[][] matrizImg_B) {
        this.matrizImg_B = matrizImg_B;
    }
    public void setMatrizImg_G(double[][] matrizImg_G) {
        this.matrizImg_G = matrizImg_G;
    }
    public void setMatrizImg_R(double[][] matrizImg_R) {
        this.matrizImg_R = matrizImg_R;
    }

}
