package teste_hilab;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Teste  {
    public static void main(String[] args) throws FileNotFoundException {
            
        Controlador controlador = new Controlador ();
        
        for (int i=0; i<=5; i++) {
            String res = controlador.POST ("Eduardo", "Cerolli", "educerolli@gmail.com", "Desenvolvedor", "31/13/2001");
            System.out.println (res);
        }

        String json = controlador.toJSON ();
        System.out.println (json);

        try (PrintWriter out = new PrintWriter("teste.json")) {
            out.println(json);
        }
    }
}