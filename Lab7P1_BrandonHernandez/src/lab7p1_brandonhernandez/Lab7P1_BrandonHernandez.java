/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7p1_brandonhernandez;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author brhb2
 */
public class Lab7P1_BrandonHernandez {

    static Scanner sc = new Scanner(System.in);
    static Random ran = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        boolean menu = true;

        while (menu) {

            System.out.println("== MENU ==");
            System.out.println("1. She shoot, she scores!");
            System.out.println("2. Pierda, papel o …");
            System.out.println("3. Salir");
            System.out.println("Ingrese una opcion:");
            int opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    System.out.println("Ingrese el tamaño de las filas:");
                    int filas = sc.nextInt();
                    System.out.println("Ingrese el tamaño de las columnas:");
                    int columnas = sc.nextInt();
                    System.out.println("Ingrese la cantidad de disparos:");
                    int disparos = sc.nextInt();

                    while (validarMatriz(filas, columnas) == false) {
                        System.out.println("El tamaño de la matriz debe ser menor a 88");
                        System.out.println("Ingrese nuevamente el tamaño de las filas:");
                        filas = sc.nextInt();
                        System.out.println("Ingrese nuevamente el tamaño de las columnas:");
                        columnas = sc.nextInt();
                    }

                    while (validarDisparos(filas, columnas, disparos) == false) {
                        System.out.println("La cantidad de disparos tiene que ser menor a la mitad de filas * columnas");
                        System.out.println("Ingrese nuevamente la cantidad de disparos:");
                        columnas = sc.nextInt();
                    }

                    int[][] matriz = new int[filas][columnas];
                    matriz = leer(filas, columnas);

                    System.out.println("---- Tablero de Juego ----");
                    imprimir(matriz);

                    int disp1 = disparos;
                    int disp2 = disparos;
                    int turno = 0;
                    int acum1 = 0;
                    int acum2 = 0;
                    
                    do {
                        String msg = "Elige que numero disparar Jugador ";
                        if (turno % 2 == 0) {
                            msg += "1";
                        } else {
                            msg += "2";
                        }

                        System.out.println(msg);
                        int num = sc.nextInt();

                        for (int i = 0; i < matriz.length; i++) {

                            for (int j = 0; j < matriz[0].length; j++) {

                                if (num == matriz[i][j]) {

                                    System.out.println("Tiro hacertado!");

                                    if (turno % 2 == 0) {
                                        acum1 += matriz[i][j];
                                        matriz[i][j] = 99;
                                        disp1--;

                                        imprimir(matriz);
                                        System.out.println("Le quedan: " + disp1 + " disparos");
                                    } else {
                                        acum2 = matriz[i][j];
                                        matriz[i][j] = 88;
                                        disp2--;
                                        
                                        imprimir(matriz);
                                        System.out.println("Le queda: " + disp2 + " disparos");
                                    }

                                }
                            }

                        }
                        
                        turno++;
                    } while (disp1 > 0 || disp2 > 0);

                    if (acum1 > acum2) {
                        System.out.println("Jugador 1 gana con " + acum1);
                        System.out.println("Jugador 2 pierde con " + acum2);
                    } else {
                        System.out.println("Jugador 2 gana con " + acum2);
                        System.out.println("Jugador 1 pierde con " + acum1);
                    }

                    break;

                case 2:
                    System.out.println("Piedra = 1, Papel = 2, Tijeras = 3, Lizard = 4, Spock = 5");
                    System.out.println("Elija que desea usar [Piedra / Papel / Tijeras / Lizard / Spock]:");
                    int entrada = sc.nextInt();
                    
//                    int[][] matrix = new int[5][5];
//                    matrix = leer(5, 5);
                    
                    int[][] matrix = {{0,0,1,1,0},{1,0,0,0,1},{0,1,0,0,1},{1,0,1,0,0},{0,1,0,1,0}};
                    imprimir(matrix);
                    
                    int compu = 1 + ran.nextInt(6);
                    
                    switch(compu){
                        
                        case 1:
                            if(compu == 1){
                            System.out.println("La maquina escogio piedra");
                            }
                            break;
                            
                        case 2:
                            if(compu == 2){
                            System.out.println("La maquina escogio papel");
                            }
                            break;
                            
                        case 3:
                            if(compu == 3){
                            System.out.println("La maquina escogio tijera");
                            }
                            break;
                            
                        case 4:
                            if(compu == 4){
                            System.out.println("La maquina escogio lizard");
                            }
                            break;
                            
                        case 5:
                            if(compu == 5){
                            System.out.println("La maquina escogio spock");
                            }
                            break;
                        
                    }
                    
                    int valor = matrix[entrada - 1][compu - 1];
                    
                    if(valor == 1){
                        System.out.println("Jugador Gana!");
                    } else if(valor == 0){
                        System.out.println("Gana la Maquina");
                    } else if(entrada == compu){
                        System.out.println("Empate");
                    }
                    
                    
                    break;

                case 3:
                    menu = false;
                    break;

                default:
                    System.out.println("Opcion Invalida!!!!!");

            }

        }

    }

    public static void imprimir(int[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[0].length; j++) {

                System.out.print("[ " + matriz[i][j] + " ]" + "\t");

            }
            System.out.println();
        }

    }

    public static int[][] leer(int fil, int colum) {

        int temp[][] = new int[fil][colum];
        int acum = 0;
        int random = 0;
        for (int i = 0; i < fil; i++) {// For de filas

            for (int j = 0; j < colum; j++) {//For de columnas

                random = 1 + ran.nextInt(fil * colum);
                while (repetidos(temp, random)) {
                    random = 1 + ran.nextInt(fil * colum);

                }
                temp[i][j] = random;
            }
        }
        return temp;
    }

    public static boolean validarMatriz(int filas, int columnas) {

        boolean valida = true;
        if (filas * columnas > 88) {
            valida = false;
        }
        return valida;
    }

    public static boolean validarDisparos(int filas, int columnas, int disp) {

        boolean valida = true;
        if (disp > filas * columnas / 2) {
            valida = false;
        }
        return valida;
    }

    public static boolean repetidos(int[][] matriz, int val) {

        boolean repetido = false;

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[0].length; j++) {

                if (matriz[i][j] == val) {
                    repetido = true;
                }

            }

        }
        return repetido;
    }
    
    

}
