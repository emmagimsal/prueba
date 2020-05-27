/*
 * Emmanuel Gimenez
 * Legajo: 42632
 */
package com.utn.codigojenkins;

/**
 *
 * @author Emmanuel Gimenez
 */
public class AnalizadorADN {
    private String[] dna = new String[6];
    private Character[] baseNitrogenada = {'A', 'T', 'G', 'C'};
    private Character[][] tabla = new Character[6][6];
    private int minimoMutante = 4;

    public AnalizadorADN() {
    }

    public boolean isMutant(String[] dna) {
        int resultado;
        //Compruebo que la cadena ingresada tenga la extensión válida
        for (String secuencia : dna) {
            if (secuencia.length() != 6) {
                System.out.println("La cadena " + secuencia + " es inválida");
                System.exit(0);
            }
        }
        //Generamos la tabla
        cargarTabla(dna);
        //Comienza la verificación de gen mutante:
        resultado = verificarFilas();
        resultado+= verificarColumnas();
        resultado+=verificarTransversales();
        resultado+=verificarTransversalesInversas();
        
        System.out.println("Cantidad de secuencias coincidentes: " + resultado);
        
        return resultado > 1;
    }

    public void cargarTabla(String[] dna) {
        for (int i = 0; i < dna.length; i++) { //Cargo las filas en una variable auxiliar
            Character[] fila = verificarBaseNitrogenada(dna[i]);
            for (int j = 0; j < fila.length; j++) { //Cargo la tabla, elemento por elemento
                tabla[i][j] = fila[j];
            }
        }
    }

    public Character[] verificarBaseNitrogenada(String secuencia) {
        Character[] fila = new Character[6];
        for (int i = 0; i < secuencia.length(); i++) {
            Character base = secuencia.charAt(i);
            for (Character bn : baseNitrogenada) {
                if (bn.equals(secuencia.charAt(0))) {
                    fila[i] = base;
                }
                if (fila.length != 6) {
                    System.out.println("La secuencia ingresada: " + secuencia + " no es valida");
                    System.exit(0);
                }
            }
        }
        return fila;
    }

    public int verificarFilas() {
        int contador;
        int aciertos = 0;
        for (Character[] secuencia : tabla) { //Por cada fila encontrada
            contador = 0;
            for (int j = 0; j < tabla.length - 1; j++) { //Le coloco -1, debido a que debo comparar hasta el elemento 4 con el 5
                if (contador >= minimoMutante - 1) { //Como realizo saltos, no tomo en cuenta la primer entrada, por lo que debo restarle 1 al mínimo para mutantes
                    aciertos++;
                    contador = 0;
                }
                if (secuencia[j].equals(secuencia[j + 1])) { //Si los caracteres son iguales   
                    contador++; //Si aun no se cumple la cantidad minima para ser mutante
                } else {
                    contador = 0; //No coinciden, por lo que se reinicia el contador
                }
            }
        }
        return aciertos;
    }

    public int verificarColumnas() {
        int contador;
        int aciertos = 0;
        for (int j = 0; j < tabla.length - 1; j++) {
            contador = 0; //Por si hay una coincidiencia entre las 2 últimas bases de la columna
            for (int i = 0; i < tabla.length - 1; i++) {
                if (contador >= minimoMutante - 1) {
                    aciertos++; //Se encontro una cadena con 4 bases iguales
                    contador = 0;
                }
                if (tabla[i][j].equals(tabla[i + 1][j])) { //Si los caracteres son iguales
                    if (minimoMutante > contador) { //Si aun no se cumple la cantidad minima para ser mutante
                        contador++;
                    }
                } else {
                    contador = 0;
                }
            }
        }

        return aciertos;
    }

    public int verificarTransversales() {
      int aciertos = 0;
        for(int i = tabla.length; i >= 0; i--){
            aciertos += verificarTransversal(i, 0);
        } 
        for(int j = 1; j < tabla.length; j++){ //Considero 1 como punto de inicio, para no considerar 2 veces el elemento (0,0)
            aciertos += verificarTransversal(0, j); 
          }
        return aciertos;
    }

    public int verificarTransversal(int auxiliarFila, int auxiliarColumna){
        int contador = 0;
        int aciertos = 0;
        while((auxiliarFila + 1) < tabla.length && (auxiliarColumna + 1) < tabla.length){ //Compruebo que las posiciones del array no se salgan de los límites
                  if (contador >= minimoMutante - 1) {
                    aciertos++; //Ya hay 4 (o más) bases identicas
                    contador = 0;
                  }
                    if (tabla[auxiliarFila][auxiliarColumna].equals(tabla[auxiliarFila + 1][auxiliarColumna + 1])) { //Si los caracteres son iguales
                        contador++;   //Si aun no se cumple la cantidad minima para ser mutante
                    } else {
                        contador = 0; //Si no coinciden, reiniciar el contador
                    }
                   auxiliarColumna++;   
                   auxiliarFila++;             
                   //Apunto a la siguiente
        }
         return aciertos;
    }
    
    public int verificarTransversalesInversas() {
        int aciertos = 0;
        for(int i = tabla.length; i >= 0; i--){
            aciertos += verificarTransversalInversa(i, tabla.length);
        } 
        for(int j = tabla.length; j >= 0 ; j--){
            aciertos += verificarTransversalInversa(0, j); 
          }
        return aciertos;
    }

    public int verificarTransversalInversa(int auxiliarFila, int auxiliarColumna){
        int contador = 0;
        int aciertos = 0;
        while((auxiliarColumna - 1) >= 0 && (auxiliarFila + 1) <= (tabla.length - 1) && (auxiliarColumna - 1) < (tabla.length - 1)){
                  if (contador >= minimoMutante - 1) {
                    aciertos++; //Ya hay 4 (o más) bases identicas, por lo que es mutante
                    contador = 0;
                  }
                    if (tabla[auxiliarFila][auxiliarColumna].equals(tabla[auxiliarFila + 1][auxiliarColumna - 1])) { //Si los caracteres son iguales
                        contador++;   //Si aun no se cumple la cantidad minima para ser mutante
                    } else {
                        contador = 0; //Si no coinciden, reiniciar el contador
                    }
                   auxiliarColumna--;
                   auxiliarFila++;
                }
         return aciertos;
    }
    
    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    public Character[] getBaseNitrogenada() {
        return baseNitrogenada;
    }

    public void setBaseNitrogenada(Character[] baseNitrogenada) {
        this.baseNitrogenada = baseNitrogenada;
    }

    public Character[][] getTabla() {
        return tabla;
    }

    public void setTabla(Character[][] tabla) {
        this.tabla = tabla;
    }

    public int getMinimoMutante() {
        return minimoMutante;
    }

    public void setMinimoMutante(int minimoMutante) {
        this.minimoMutante = minimoMutante;
    }
}
