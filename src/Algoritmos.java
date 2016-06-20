
public class Algoritmos {

    public static double[][] operadorUmbral(Imagen img, int umbral) {
        double[][] I;	//matriz de la imagen
        int m;          //m filas
        int n;          //n columnas

        I = img.getMatrizImg();
        m = img.getFilas();
        n = img.getColumnas();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (I[i][j] < umbral) {
                    I[i][j] = 0;
                } else {
                    I[i][j] = 255;
                }
            }
        }
        return I;
    }

    public static double[][] operadorInverso(Imagen img) {
        double[][] I;	//matriz de la imagen
        int m;          //m filas
        int n;          //n columnas

        I = img.getMatrizImg();
        m = img.getFilas();
        n = img.getColumnas();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                I[i][j] = 255 - I[i][j];
            }
        }
        return I;
    }

    public static Imagen pseudocolor(Imagen img) {
        double[][] I;	//matriz de la imagen
        double[][] R;         //matrizImg de la imagen en R
        double[][] G;         //matriz de la imagen en G
        double[][] B;         //matriz de la imagen en B

        int m;          //m filas
        int n;          //n columnas

        I = img.getMatrizImg();
        R = img.getMatrizImg_R();
        G = img.getMatrizImg_G();
        B = img.getMatrizImg_B();

        m = img.getFilas();
        n = img.getColumnas();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (I[i][j] > 200) {
                    R[i][j] = 125;
                    G[i][j] = 26;
                    B[i][j] = 114;
                } else if (I[i][j] > 200) {
                    R[i][j] = 180;
                    G[i][j] = 68;
                    B[i][j] = 188;
                } else if (I[i][j] > 150) {
                    R[i][j] = 31;
                    G[i][j] = 37;
                    B[i][j] = 132;
                } else if (I[i][j] > 100) {
                    R[i][j] = 97;
                    G[i][j] = 105;
                    B[i][j] = 188;
                } else if (I[i][j] > 65) {
                    R[i][j] = 138;
                    G[i][j] = 142;
                    B[i][j] = 214;
                } else {
                    R[i][j] = 0;
                    G[i][j] = 0;
                    B[i][j] = 0;
                }

            }
        }

        img.setMatrizImg_R(R);
        img.setMatrizImg_G(G);
        img.setMatrizImg_B(B);

        img.convertirMatrizAImagenRGB(R, G, B);

        return img;
    }

    public static Imagen suma(Imagen img, Imagen img2) {
        double[][] R = img.getMatrizImg_R();
        double[][] G = img.getMatrizImg_G();
        double[][] B = img.getMatrizImg_B();

        double[][] R2 = img2.getMatrizImg_R();
        double[][] G2 = img2.getMatrizImg_G();
        double[][] B2 = img2.getMatrizImg_B();

        double sumaR = 0;
        double sumaG = 0;
        double sumaB = 0;

        if (img.getFilas() >= img2.getFilas() && img.getColumnas() >= img2.getColumnas()) {
            for (int i = 0; i < img2.getFilas(); i++) {
                for (int j = 0; j < img2.getColumnas(); j++) {
                    sumaR = R[i][j] + R2[i][j];
                    sumaG = G[i][j] + R2[i][j];
                    sumaB = B[i][j] + R2[i][j];
                    
                    R[i][j] = (sumaR > 255) ? 255 : sumaR;
                    G[i][j] = (sumaG > 255) ? 255 : sumaG;
                    B[i][j] = (sumaB > 255) ? 255 : sumaB;
                }
            }

            img.convertirMatrizAImagenRGB(R, G, B);
        } else {
            System.out.println("Imagen 1 es menor que Imagen 2");
        }

        return img;
    }
    
    public static Imagen resta(Imagen img, Imagen img2) {
        double[][] R = img.getMatrizImg_R();
        double[][] G = img.getMatrizImg_G();
        double[][] B = img.getMatrizImg_B();

        double[][] R2 = img2.getMatrizImg_R();
        double[][] G2 = img2.getMatrizImg_G();
        double[][] B2 = img2.getMatrizImg_B();

        double restaR = 0;
        double restaG = 0;
        double restaB = 0;

        if (img.getFilas() >= img2.getFilas() && img.getColumnas() >= img2.getColumnas()) {
            for (int i = 0; i < img2.getFilas(); i++) {
                for (int j = 0; j < img2.getColumnas(); j++) {
                    restaR = Math.abs(R[i][j] - R2[i][j]);
                    restaG = Math.abs(G[i][j] - R2[i][j]);
                    restaB = Math.abs(B[i][j] - R2[i][j]);
                    
                    R[i][j] = (restaR < 0) ? 0 : restaR;
                    G[i][j] = (restaG < 0) ? 0 : restaG;
                    B[i][j] = (restaB < 0) ? 0 : restaB;
                }
            }

            img.convertirMatrizAImagenRGB(R, G, B);
        } else {
            System.out.println("Imagen 1 es menor que Imagen 2");
        }

        return img;
    }
    
    public static double[][] binarizacionGrisPromedioGlobal(Imagen img) {
        
        double[][] I = img.getMatrizImg();
        int filas = img.getFilas();
        int col   = img.getColumnas();
        int sumaMatriz = 0;
        double promedio = 0;
        
        System.out.println("binarizacionGrisPromedioGlobal");
        
        for (int i = 0; i < img.getFilas(); i++) {
            for (int j = 0; j < img.getColumnas(); j++) {
                sumaMatriz += I[i][j];
            }
        }
        
        promedio = sumaMatriz / (filas * col);
        System.out.println("Umbral: " + promedio);
        
        // Binarizacion
        for (int i = 0; i < img.getFilas(); i++) {
            for (int j = 0; j < img.getColumnas(); j++) {
                I[i][j] = (I[i][j] >= promedio) ? 255 : 0;
            }
        }
        
        return I;
    }
    
    public static double[][] binarizacionGrisPromedioLocal(Imagen img) {
        
        double[][] I = img.getMatrizImg();
        int filas = img.getFilas();
        int col   = img.getColumnas();
        int sumaMatriz = 0;
        double promedio = 0;
        
        double filasCuadrante  = Math.floor(filas / 2);
        double columnCuadrante = Math.floor(col / 2);
        double totalCuadrante  = filasCuadrante * columnCuadrante;
        
        double[] sumas = new double[4];
        double[] promedios = new double[4];
        
        sumas[0] = 0;
        sumas[1] = 0;
        sumas[2] = 0;
        sumas[3] = 0;
        
        System.out.println("binarizacionGrisPromedioLocal");
        
        for (int i = 0; i < filasCuadrante; i++) {
            for (int j = 0; j < columnCuadrante; j++) {
                int f =  (int) filasCuadrante;
                int c =  (int) columnCuadrante;
                
                sumas[0] += I[i + 1*f][j + 1*c];
                sumas[1] += I[i + 1*f][j + 2*c - 1];
                //sumas[2] += I[i + 2*f][j + 1*c];
                //sumas[3] += I[i + 2*f][j + 2*c];
            }
        }
        
        promedios[0] = sumas[0] / totalCuadrante;
        promedios[1] = sumas[1] / totalCuadrante;
        promedios[2] = sumas[2] / totalCuadrante;
        promedios[3] = sumas[3] / totalCuadrante;
        
        System.out.println("promedios[0] : " + promedios[0]);
        System.out.println("promedios[1] : " + promedios[1]);
        //System.out.println("promedios[2] : " + promedios[2]);
        //System.out.println("promedios[3] : " + promedios[3]);
        
        
        for (int i = 0; i < filasCuadrante; i++) {
            for (int j = 0; j < columnCuadrante; j++) {
                
                //I[i][j] = (I[i][j] > promedios[0]) ? 255 : 0;
                
                //I[i][j] = (I[i][j] > promedios[1]) ? 255 : 0;
                //I[i][j] = (I[i][j] > promedios[2]) ? 255 : 0;
                //I[i][j] = (I[i][j] > promedios[3]) ? 255 : 0;
                
                //I[i*1][j*1] = (I[i*1][j*1] > promedios[0]) ? 255 : 0;
                //I[i*1][j*2] = (I[i*1][j*2] > promedios[1]) ? 255 : 0;
                //I[i*2][j*1] = (I[i*2][j*1] > promedios[2]) ? 255 : 0;
                //I[i*2][j*2] = (I[i*2][j*2] > promedios[3]) ? 255 : 0;
            }
        }
        
        return I;
    }
    

    public static Imagen escalamiento(Imagen img) {
        double[][] R = img.getMatrizImg_R();
        double[][] G = img.getMatrizImg_G();
        double[][] B = img.getMatrizImg_B();
        
        for (int i = 0; i < img.getFilas(); i++) {
            for (int j = 0; j < img.getColumnas(); j++) {
                if (j%5 == 0 && j >=5) {
                    R[i][j]   = R[i][j-4];
                    R[i][j-1] = R[i][j-4];
                    R[i][j-2] = R[i][j-4];
                    R[i][j-3] = R[i][j-4];
 
                    G[i][j]   = G[i][j-4];
                    G[i][j-1] = G[i][j-4];
                    G[i][j-2] = G[i][j-4];
                    G[i][j-3] = G[i][j-4];

                    B[i][j]   = B[i][j-4];
                    B[i][j-1] = B[i][j-4];
                    B[i][j-2] = B[i][j-4];
                    B[i][j-3] = B[i][j-4];
                   
                }
            }
        }
        
        for (int i = 0; i < img.getFilas(); i++) {
            for (int j = 0; j < img.getColumnas(); j++) {
                if (i%5 == 0 && i >=5) {
                    R[i][j]   = R[i-4][j];
                    R[i-1][j] = R[i-4][j];
                    R[i-2][j] = R[i-4][j];
                    R[i-3][j] = R[i-4][j];
 
                    G[i][j]   = G[i-4][j];
                    G[i-1][j] = G[i-4][j];
                    G[i-2][j] = G[i-4][j];
                    G[i-3][j] = G[i-4][j];

                    B[i][j]   = B[i-4][j];
                    B[i-1][j] = B[i-4][j];
                    B[i-2][j] = B[i-4][j];
                    B[i-3][j] = B[i-4][j];
                   
                }
            }
        }

        img.setMatrizImg_R(R);
        img.setMatrizImg_G(G);
        img.setMatrizImg_B(B);
       
        img.convertirMatrizAImagenRGB(R, G, B);
        return img;
    }
    
    public static Imagen invertir(Imagen img, char orientacion) {
        int filas = img.getFilas();
        int col  = img.getColumnas();
        
        double[][] R = img.getMatrizImg_R();
        double[][] G = img.getMatrizImg_G();
        double[][] B = img.getMatrizImg_B();
        
        double[][] R2 = new double[filas][col];
        double[][] G2 = new double[filas][col];
        double[][] B2 = new double[filas][col];
        
        filas--;
        col--;
        
        
        for (int i = 0; i <= filas; i++) {
            for (int j = 0; j <= col; j++) {
                int ii = i;
                int jj = j;
                
                if (orientacion == 'x') {
                    jj = col - j;
                } else {
                    ii = filas - i;
                }
                
                R2[i][j] = R[ii][jj];
                G2[i][j] = G[ii][jj];
                B2[i][j] = B[ii][jj];
            }
        }
  
        img.convertirMatrizAImagenRGB(R2, G2, B2);
        return img;
    }
    
    
    public static Imagen trasladar(Imagen img, int x, int y) {
        int filas = img.getFilas();
        int col  = img.getColumnas();
        
        double[][] R = img.getMatrizImg_R();
        double[][] G = img.getMatrizImg_G();
        double[][] B = img.getMatrizImg_B();
        
        double[][] R2 = new double[filas][col];
        double[][] G2 = new double[filas][col];
        double[][] B2 = new double[filas][col];
        
        
        System.out.println("X=" + x + ", Y=" + y);
        System.out.println("filas=" + filas + ", col=" + col);
        
        if (x >= filas || y >= col) {
            System.out.println("Coordenadas demasiado grandes");
            return img;
        }
        
        for (int i = 0; i < filas-x; i++) {
            for (int j = 0; j < col-y; j++) {
                R2[i+x][j+y] = R[i][j];
                G2[i+x][j+y] = G[i][j];
                B2[i+x][j+y] = B[i][j];
            }
        }
  
        img.convertirMatrizAImagenRGB(R2, G2, B2);
        return img;
    }
    
    
}
