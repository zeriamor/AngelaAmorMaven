package com.AngelaAmor.tema4maven;

import com.github.lalyos.jfiglet.FigletFont;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import java.io.IOException;
import java.util.List;

//TIP Para <b>ejecutar</b> el código, pulsar <shortcut actionId="Run"/> o
// Haz clic en el ícono <icon src="AllIcons.Actions.Execute"/> del margen.
public class Main {
  public static void main(String[] args) throws IOException, InterruptedException {
    //>>>>> Ejercicio 5 <<<<<//
    String miNombre = "Angela Amor";
    String banner = FigletFont.convertOneLine(miNombre);
    System.out.println(banner);

    //>>>>> Ejercicio 6 <<<<<//
    Screen screen = new DefaultTerminalFactory().createScreen();
    screen.startScreen();
    screen.setCursorPosition(null);
    //Tamaño de la pantalla
    TerminalSize size = screen.getTerminalSize();
    int height = size.getRows();
    int width = size.getColumns();

    //>>>>> Ejercicio 7 <<<<<//
    List<String> contenido = Guion.crearGuion();

    //>>>>> Ejercicio 8: ANIMACIÓN <<<<<//
    int yOffset = height; // Empieza "debajo" de la pantalla
    System.out.println("Iniciando animación... Pulsa CTRL+C para salir.");

    while (yOffset > -contenido.size()) { // Continua hasta que todo el texto salga por arriba
      drawFrame(screen, contenido, yOffset);
      Thread.sleep(90);
      yOffset--;
    }

    Thread.sleep(2000);
    screen.stopScreen();
    System.out.println("Animación completada ✓");
  }

  private static void drawFrame(Screen screen, List<String> lines, int yOffset)
          throws IOException {
    TerminalSize size = screen.getTerminalSize();
    int width = size.getColumns();
    int height = size.getRows();
    screen.clear();
    TextGraphics tg = screen.newTextGraphics();
    for (int i = 0; i < lines.size(); i++) {
      int y = yOffset + i;
      if (y < 0 || y >= height) continue;
      String line = lines.get(i);
// Centrado horizontal (opcional, pero queda mejor)
      int x = Math.max(0, (width - line.length()) / 2);
      if (x >= width) continue;
// Recorte simple si se sale por la derecha
      String visible = (line.length() > width) ? line.substring(0, width) :
              line;
      tg.putString(x, y, visible);
    }
    screen.refresh();
  }

}
