package com.AngelaAmor.tema4maven;

import com.github.lalyos.jfiglet.FigletFont;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Guion {
  // Método que crea y devuelve la lista completa de líneas
  public static List<String> crearGuion() throws IOException {
    // Lista vacía para almacenar
    List<String> lineas = new ArrayList<>();
    //Banner ASCII
    String banner = FigletFont.convertOneLine("Angela Amor");
    //Dividimos el banner en líneas individuales
    String[] lineasBanner = banner.split("\n");
    // 4. Añadir líneas del banner a la lista
    for (String linea : lineasBanner) {//for-each:
      lineas.add(linea);
    }
    lineas.add(" ");
    lineas.add("***** CURRICULUM VITAE *****");
    lineas.add(" ");
    //Info del CV
    lineas.add("Ángela Amor Ramírez");

    lineas.add(" ");
    lineas.add("---> ACERCA DE MÍ <---");
    lineas.add("Perfil Senior SAC & Estudiante Dev.Multiplataforma");
    lineas.add("Mi objetivo es aportar una visión analítica");
    lineas.add("para traducir las necesidades del usuario");
    lineas.add("en soluciones de software efectivas.");
    lineas.add("----> FORMACIÓN ACADÉMICA <----");
    lineas.add("Técnico Superior en DAM-En proceso.");
    lineas.add("--> EXPERIENCIA PROFESIONAL <---");
    lineas.add("Vendedora GALPEnergía 2021-2024");
    lineas.add("---> HABILIDADES TÉCNICAS <---");
    lineas.add("Idiomas: Español (nativo), Inglés (B1), Valenciano (nativo)");
    lineas.add("Herramientas: Git, Gradle, Maven, IntelliJ");
    lineas.add("Lenguajes: Java, JavaScript");
    lineas.add("----> CONTACTO <----");
    lineas.add("Email: angamoram@alu.edu.gva.es");
    // Devolver lista
    return lineas;
  }

  // Método para probar el guión
  public static void main(String[] args) throws IOException {
    // Obtenemos el guión completo
    List<String> guionCompleto = crearGuion();

    // Imprimimos cada línea en la consola
    for (String linea : guionCompleto) {
      System.out.println(linea);
    }
  }
}
