package teste_hilab;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Teste  {
    public static void main(String[] args) throws FileNotFoundException {
        int op, campo;
        String dado;
        
        Controlador controlador = new Controlador ();
        Scanner ler_op = new Scanner (System.in);
        Scanner ler_dado = new Scanner (System.in);
        

        System.out.print ("Digite 1 para POST, 2 para PUT ou 3 para GET: ");
        op = ler_op.nextInt ();
        if (op == 0 || op > 3)
            System.out.println ("Operacao Invalida!");
        else {
            switch (op) {
                case 1:
                    // coloque todos dados separados por espaços sem enter
                    System.out.println ("Entre com os dados:");
                    dado = ler_dado.nextLine ();
                    String[] dado_separado = dado.split(" ");
                    String nome = dado_separado [0];
                    String sobrenome = dado_separado [1];
                    String nascimento = dado_separado [2];
                    String email = dado_separado [3];
                    String categoria = dado_separado [4];
                    System.out.println (nome);
                    controlador.POST (nome, sobrenome, email, categoria, nascimento);
                    break;

            }
        }


        String json = controlador.toJSON ();
        System.out.println (json);

        try (PrintWriter out = new PrintWriter("teste.json")) {
            out.println(json);
        }
    }
}