/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FABAME
 */
public class TriquiEspacio {

    private String[] triqui; //Espacio que representa la matriz
    private String[] triquiEspejo;
    private String simboloPC; //Simbolo pc "0"
    private String simboloHumano; //Simbolo para humano X
    private String simboloLibre; //Simbolo libre "_"

    private static int[] libres = new int[11]; //No ocupados
    private int cantidadLibres = 0;

    public TriquiEspacio() {
        this.triqui = new String[10];
        for (int i = 1; i < 10; i++) { //Se llena el vector
            this.triqui[i] = "_";

        }
    }

    public TriquiEspacio(String simboloPC, String simboloHumano, String simboloLibre) {
        this.simboloPC = simboloPC;
        this.simboloHumano = simboloHumano;
        this.simboloLibre = simboloLibre;
        this.triqui = new String[10];
        for (int i = 1; i < 10; i++) {
            this.triqui[i] = simboloLibre;

        }
    }

    //Busca las opciones libres
    public void buscarLibres() {
        int k = 1;
        this.cantidadLibres = 0;
        for (int i = 1; i < 10; i++) {
            if (triqui[i].equals("_")) {
                libres[k] = i;
                k++;
                this.cantidadLibres++;
            }
        }
    }

    public boolean estaLibre(int posicion) {
        for (int i = 0; i < this.cantidadLibres + 1; i++) {
            if (this.libres[i] == posicion) {
                return true;
            }
        }
        return false;
    }

    public void pasaEspejo() {
        this.triquiEspejo = this.triqui;
    }

    public int generarJugada() {
        int posicion = -1;
        //Sistema de reglas reglas
        if (this.triqui[5].equals(this.simboloLibre)) {
            posicion = 5;

        } else {
            if (this.triqui[1].equals(this.simboloHumano) && this.triqui[9].equals(this.simboloLibre)) {
                posicion = 9;
            }
            if (this.triqui[9].equals(this.simboloHumano) && this.triqui[1].equals(this.simboloLibre)) {
                posicion = 1;
            }
            if (this.triqui[3].equals(this.simboloHumano) && this.triqui[7].equals(this.simboloLibre)) {
                posicion = 7;
            }
            if (this.triqui[7].equals(this.simboloHumano) && this.triqui[3].equals(this.simboloLibre)) {
                posicion = 3;
            }
            if (this.triqui[3].equals(this.simboloHumano) && this.triqui[9].equals(this.simboloHumano) && this.triqui[1].equals(this.simboloLibre)) {
                posicion = 1;
            }
        }
        return posicion;

    }

    public int getPosicionesLibres(int lugar) {
        return libres[lugar];
    }

    public void imprimirLibres() {
        for (int i = 1; i < this.cantidadLibres + 1; i++) {
            System.out.println(" " + libres[i]);
        }
        System.out.println("");
    }

    public void ubicar(int posicion, String simbolo) {
        if (posicion >= 1 && posicion <= 9) {
            this.triqui[posicion] = simbolo;
        }
    }

    //Visualiza
    public void presentar() {
        for (int i = 1; i < 10; i++) {
            System.out.println(" " + this.triqui[i]);
            if (i % 3 == 0) {
                System.out.println(" ");
            }

        }
        System.out.println("");
    }

    public void presentarEspejo() {
        for (int i = 1; i < 10; i++) {
            System.out.println(" " + this.triqui[i]);
            if (i % 3 == 0) {
                System.out.println(" ");
            }
        }
    }

    public String[] busqueda(int inicial, int pasop, int fin) {
        int paso = pasop;
        int i = inicial;
        int ciclo = 0;
        String[] iguales = new String[3];
        iguales[0] = "0";
        iguales[1] = "0";
        iguales[2] = "0";
        buscarLibres();
        while (true) {
            //System.out.println("_" + i);
            // System.out.println("i******************" + i);
            if (ciclo == 0) {
                System.out.println("*******************" + i + "-->" + (i + paso));
                System.out.println("coloca (i+paso*2)" + (i + paso * 2));
                if (this.triqui.equals(this.triqui[i + paso])) {
                    iguales[0] = "" + (i + paso * 2);
                    iguales[1] = "1";
                    iguales[2] = this.triqui[i]; // Simbolo
                    break;
                }
                System.out.println("i " + i + " (i+paso*2) " + (i + paso * 2));
                System.out.println("coloca (i+paso)" + (i + paso));
                if (this.triqui.equals(this.triqui[i + paso * 2])) {
                    //System.out.println("*******************" +i+ "-->" + (i + paso));
                    //System.out.println("coloca (i+paso)" + (i+paso));
                    iguales[0] = "" + (i + paso);
                    iguales[1] = "1";
                    iguales[2] = this.triqui[i]; //Simbolo
                    break;
                }
            } else if (ciclo == 1) {
                //System.out.println("i else** " + i + " (i+ paso) "+ (i+paso));
                System.out.println("** " + i + " (1+paso)" + (i + paso));
                System.out.println("coloca (i-paso)" + (i - paso));

                if (this.triqui[i].equals(this.triqui[i + paso])) {
                    //System.out.println("coloca (i-paso)" + (i - paso));
                    iguales[0] = "" + (i - paso);
                    iguales[1] = "1";
                    iguales[2] = this.triqui[i]; // Simbolo
                    break;
                }
            }

            i += paso;
            ciclo++;
            if (i > fin) {
                break;
            }

        }
        //System.out.println("iguales *****"+iguales[0]+"****"+iguales[1]+"** iguales[2]");
        return iguales;
    }

    public int getLibres() {
        return this.cantidadLibres + 1;
    }

    public int busquedaVertical(String simbolo) {
        System.out.println("Vertical");
        String[] resultado = new String[3];
        int postgana = -1;
        buscarLibres();
        imprimirLibres();
        for (int i = 1; i < 4; i++) {
            System.out.print("i**************" + i);
            resultado = busqueda(i, 3, 9);
            if (estaLibre(Integer.parseInt(resultado[0])) && resultado[1].equals("1") && resultado[2].equals(simbolo)) {
                postgana = Integer.parseInt(resultado[0]);
                return postgana;
            }
        }
        //System.out.println("Termina vertical");
        return postgana;
    }

    public int busquedaHorizontal(String simbolo) {
        //System.out.println("Horizontal");
        String[] resultado = new String[3];
        int postgana = -1;
        buscarLibres();
        //imprimirLibres();
        for (int i = 1; i < 9; i += 3) {
            //System.out.print("i" + i);
            resultado = busqueda(i, 1, i + 2);
            if (estaLibre(Integer.parseInt(resultado[0])) && resultado[1].equals("1") && resultado[2].equals(simbolo)) {
                postgana = Integer.parseInt(resultado[0]);
                return postgana;
            }
        }
        //System.out.println("Termina horizontal");
        return postgana;
    }

    public int busquedaDiagonal(String simbolo) {
        //System.out.println("Diagonal");
        String[] resultado = new String[3];
        buscarLibres();
        //imprimirLibres();
        int t = 4;
        int f = 9;
        int postgana = -1;
        for (int i = 1; i < 4; i += 2) {
            //System.out.print("i" + i);
            resultado = busqueda(i, t, f);
            if (estaLibre(Integer.parseInt(resultado[0])) && resultado[1].equals("1") && resultado[2].equals(simbolo)) {
                postgana = Integer.parseInt(resultado[0]);
                return postgana;
            }
            t -= 2;
            f -= 2;
        }
        //System.out.println("Termina diagonal");
        return postgana;
    }

}
