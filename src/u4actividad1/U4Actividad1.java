/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u4actividad1;

import java.util.Scanner;

/**
 * Actividad 4 de la Unidad de Trabajo 4
 * @author Rober
 */
public class U4Actividad1 {

    /**
     * Método principal main
     * @param args 
     */
    public static void main(String[] args) {

        U4Actividad1 programa = new U4Actividad1();
        programa.inicio();
    }

    /** 
     * Método inicio
     */
    public void inicio() {
        
        String palabraSecreta = generarPalabraSecreta();
        String respuestaUsuario;
        
        System.out.println(palabraSecreta);
        boolean seHaAcertado;
        
        do {
            
            respuestaUsuario = pedirRespuestaEnFormatoValido();
            seHaAcertado = resolverRespuesta(palabraSecreta, respuestaUsuario);
        }while(!seHaAcertado);
    }

    /**
     * Método de nivel 3: Genera una letra aleatoria
     * @return la letra aleatoria generada
     */
    public char generarLetraAleatoria() {
        int ASCIIcaracterA = 97;
        int ASCIIcaracterZ = 122;

        int numAleatorio = (int) (Math.random() * (ASCIIcaracterZ - ASCIIcaracterA) + ASCIIcaracterA);
        return (char) numAleatorio;
    }

    /**
     * Método de nivel 2: Genera una palabra de 5 letras aleatorias
     * @return la palabra aleatoria de longitud cinco
     */
    
    public String montarPalabra() {

        String palabra = "";

        for (int i = 0; i < 5; i++) {
            palabra += generarLetraAleatoria();
        }

        return palabra;
    }

    /**
     * Método de nivel 2: Pide al usuario que introduzca una cadena de texto
     * @return La cadena de texto introducida por el usuario
     */
    public String leerRespuesta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Escribe 5 letras minúsculas: ");
        return scanner.nextLine();
    }

    /**
     * Método de nivel 2: Indica si la respuesta proporcionada cumple con el formato especificado
     * @param respuesta La respuesta a analizar su formato
     * @return CIERTO si es un formato válido (5 letras y minúsculas), FALSO en cualquier otro caso
     */
    public boolean comprobarFormato(String respuesta) {

        if (respuesta.length() != 5) {
            return false;
        } else {
            for (int i = 0; i < respuesta.length(); i++) {

                char letraRespuesta = respuesta.charAt(i);
                if (letraRespuesta < 'a' || letraRespuesta > 'z') {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Método de nivel 2: A partir de la palabra secreta y una respuesta del usuario proporciona la pista correspondiente
     * @param palabraSecreta La palabra secreta generada
     * @param respuesta La respuesta del usuario para adivinar la palabra secreta
     * @return La pista generada a raíz de la comparación entre la palabra secreta y la respuesta
     */
    public String generarPista(String palabraSecreta, String respuesta) {

        String pista = "";
        for (int i = 0; i < palabraSecreta.length(); i++) {
            String letra = String.valueOf(respuesta.charAt(i));
            
            if (respuesta.charAt(i) == palabraSecreta.charAt(i)) {
                pista += "0";
            } else if (palabraSecreta.contains(letra)) {
                pista += "X";
            } else {
                pista += "-";
            }
        }
        return pista;
    }

    /**
     * Método de nivel 2: Indica si la pista proporcionada es la ganadora o no
     * @param pista La pista a analizar
     * @return CIERTO si es la pista ganadora (00000) o falso en cualquier otro caso
     */
    public boolean darRespuesta(String pista) {

        boolean esPistaGanadora = pista.equals("00000");
        
        System.out.print("La respuesta es [" + pista + "].");
        
        if (!esPistaGanadora) {
            System.out.println(" Continúa intentándolo");
        } else {
            System.out.println(" ¡Has acertado!");
        }
        return esPistaGanadora;
    }

    /**
     * Genera una palabra secreta
     * @return La palabra secreta generada
     */
    public String generarPalabraSecreta() {

        return montarPalabra();
    }

    /**
     * Pide al usuario que introduzca una palabra para adivinar la palabra secreta
     * @return La palabra inntroducida por el usuario cumpliendo con el formato establecido
     */
    public String pedirRespuestaEnFormatoValido() {

        String respuestaUsuario;
        boolean esFormatoCorrecto;

        do {

            respuestaUsuario = leerRespuesta();
            esFormatoCorrecto = comprobarFormato(respuestaUsuario);
        } while (!esFormatoCorrecto);

        return respuestaUsuario;
    }

    /**
     * Indica si la respuesta introducida por el usuario es la palabra secreta
     * @param palabraSecreta La palabra secreta
     * @param respuesta La respuesta introducida por el usuario
     * @return CIERTO si la palabra secreta y la respuesta son iguales, FALSO en cualquier otro caso
     */
    public boolean resolverRespuesta(String palabraSecreta, String respuesta) {

        String pista = generarPista(palabraSecreta, respuesta);
        boolean esRespuestaCorrecta = darRespuesta(pista);

        return esRespuestaCorrecta;
    }
}
