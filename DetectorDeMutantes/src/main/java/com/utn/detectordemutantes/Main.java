/*
 * Emmanuel Gimenez
 * Legajo: 42632
 */
package com.utn.detectordemutantes;

public class Main {

    public static void main(String[] args) {

          String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        //String[] dna ={"ATGCGA","AAGTGC","ATATGT","AGAAGT","ACTCGA","ATCACT"};
        //String[] dna = {"ATGCGA", "TAGTGC", "ATATGT", "AGGAGT", "ACTCAC", "ATCACA"};
        //String[] dna = {"CTGCTA","TCTTAG","ACCATC","CAACGT","GATCCG","ACCCTC"};
        //String[] dna ={"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"}; 
        //String[] dna ={"GAAGGA","AGAAGG","TATAGT","ATATGT","AAAGTG","AGCAGT"};
        //String[] dna ={"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"};
        
        AnalizadorDeADN analizadorDeADN = new AnalizadorDeADN();

        if (analizadorDeADN.isMutant(dna)) {
            System.out.println("Es mutante");
        } else {
            System.out.println("No es mutante");
        }

    }

}