import java.util.Arrays;

public class matriz {
    
    public int filas;
    public int columnas;
    private double[][] mat;
    
    
    //Getter and setter
    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public double[][] getMat() {
        return mat;
    }

    public void setMat(double[][] mat) {
        this.mat = mat;
    }
    
    //contructor matriz
    
    public matriz(){
    }
    
    public matriz(int filas, int columnas){
        this.filas=filas;
        this.columnas=columnas;
        this.mat = new double[filas][columnas];
    }
    
    //LLena la matriz con valores por ventana
    public void LlenarMatriz(int fila, int columna, int valor){
        this.mat[fila][columna]=valor; 
    }
    
    //visualizar la matriz
    public String impresion(){
        String vaMA="";
        
        for(int i=0; i<this.filas; i++){
            vaMA=vaMA+"[ ";
            for(int j=0; j<this.columnas; j++){
                vaMA=vaMA+String.format("%.0f",mat[i][j])+"  "; 
            }
            vaMA=vaMA+"]\n";
        }
        return vaMA;
    }
    
    public String impresionRes(double [][]matriz){
        String vaMA="";
        
        for(int i=0; i<matriz.length; i++){
            vaMA=vaMA+"[ ";
            for(int j=0; j<matriz[0].length; j++){
                vaMA=vaMA+String.format("%.0f",matriz[i][j])+"  "; 
            }
            vaMA=vaMA+"]\n";
        }
        return vaMA;
    }
 
    
    public int MatrizCuadrada(){
        if(this.filas==this.columnas){
            return this.filas;  
        }else{
           return 0; 
        } 
    }
    
    //solo se puden sumar si son del mismo orden 
    public double [][] SumaMatriz(double [][]a, double[][]b){
        double[][] sum = new double[a.length][b[0].length];
            for(int i=0;i<a.length;i++){
                for(int j=0;j<b[0].length;j++){
        //sumo las matrices
                    sum[i][j]=a[i][j]+b[i][j];
                }
            }  
        
       return sum;
    }
    
    public double [][] RestaMatriz(double [][]a, double[][]b){
        double[][] res = new double[a.length][b[0].length];
            for(int i=0;i<a.length;i++){
                for(int j=0;j<b[0].length;j++){
        //resto las matrices
                    res[i][j]=a[i][j]-b[i][j];
                }
            }  
        
       return res;
    }
    
    public double TrazaMatriz(double [][] matriz){
        double tra=0;
        
        for(int i=0; i<matriz.length; i++){
                tra=tra+matriz[i][i]; 
            }
        return(double)tra; 
    }
    
    //cofactor dela matriz
    static void Cofactor(double matriz[][], double te[][], int a, int b, int c){
        int i=0, j=0;
        for(int x=0; x<c;x++){
            for(int y=0; y<c; y++){
                if(x!=a && y!=b){
                    te[i][j++]=matriz[x][y];
                    if(j==c-1){
                        j=0;
                        i++;   
                    }
                } 
            } 
        }  
    }
    //el determinante solo se aplica a matrices cuadradas
    public double DeterminanteMatriz(double [][]matriz, int c){
        
        double determinante=0;
        if(c==1){
            return matriz[0][0];
        }
        double tem[][]=new double [c][c];
        int mul =1;
        for(int f=0;f<c;f++){
            Cofactor(matriz, tem, 0, f, c);
            determinante += mul * matriz[0][f] * DeterminanteMatriz(tem, c-1);
            mul=-mul;
        }
        return determinante;
    }
}
