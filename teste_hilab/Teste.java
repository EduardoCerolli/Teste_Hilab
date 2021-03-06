package teste_hilab;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Teste  {
    public static void main(String[] args) throws FileNotFoundException {
        int op, campo, id;
        String nome, sobrenome, nascimento, email, categoria;
        String res, dado, json;
        
        // cria uma variel controlador que usa as funçoes POST, PUT e GET da API
        Controlador controlador = new Controlador ();

        // variaveis para ler do terminal
        Scanner ler_int = new Scanner (System.in);
        Scanner ler_string = new Scanner (System.in);
        
        op = 0;
        while (op != 4) {
            System.out.print ("Digite 1 para POST, 2 para PUT, 3 para GET, 4 para encerrar o programa e criar o json: ");
            op = ler_int.nextInt ();
            
            switch (op) {
                // caso POST, cria um usuario novo e retorna seu ID no terminal
                case 1:
                    System.out.print ("Qual o Nome: ");
                    nome = ler_string.nextLine();

                    System.out.print ("Qual o Sobrenome: ");
                    sobrenome = ler_string.nextLine();

                    System.out.print ("Qual a Data de Nascimento: ");
                    nascimento = ler_string.nextLine();

                    System.out.print ("Qual o E-Mail: ");
                    email = ler_string.nextLine();

                    System.out.print ("Qual a Categoria Profissional: ");
                    categoria = ler_string.nextLine();

                    res = controlador.POST (nome, sobrenome, email, categoria, nascimento);
                    System.out.println (res);
                    break;
            
                case 2:
                    // caso PUT, atualiza algum dado do usuario selecionado
                    System.out.print ("Qual o ID do Usuario: ");
                    id = ler_int.nextInt ();
                    System.out.println ("Digite 1 para alterar Nome e Sobrenome, 2 para alterar Data de Nascimento, 3 para alterar E-Mail, 4 para alterar Categoria Profissional:");
                    campo = ler_int.nextInt ();
                    switch (campo) {
                        case 1:
                            System.out.print ("Qual o Nome: ");
                            nome = ler_string.nextLine();
        
                            System.out.print ("Qual o Sobrenome: ");
                            sobrenome = ler_string.nextLine();

                            res = controlador.PUT (id, campo, nome, sobrenome);
                            System.out.println (res);
                            break;
                    
                        case 2:
                            System.out.print ("Qual a Data de Nascimento: ");
                            dado = ler_string.nextLine();

                            res = controlador.PUT (id, campo, dado);
                            System.out.println (res);
                            break;

                        case 3:
                            System.out.print ("Qual o E-Mail: ");
                            dado = ler_string.nextLine();

                            res = controlador.PUT (id, campo, dado);
                            System.out.println (res);
                            break;

                        case 4:
                            System.out.print ("Qual a Categoria Profissional: ");
                            dado = ler_string.nextLine();

                            res = controlador.PUT (id, campo, dado);
                            System.out.println (res);
                            break;

                        default:
                            System.out.print ("Campo Invalido!");
                            break;
                    }
                    break;

                    case 3:
                        // caso GET, escreve no terminal todos dados do usuario selecionado
                        System.out.print ("Qual o ID do Usuario: ");
                        id = ler_int.nextInt ();
                        controlador.GET (id);
                        break;
                    
                    case 4:
                        // cria o arquivo json com a lista de usuarios e encerra o programa
                        json = controlador.toJSON ();
                        try (PrintWriter out = new PrintWriter("usuarios.json")) {
                            out.println(json);
                        } 
                        break;
                default:
                    System.out.println ("Operacao Invalida!");
                    break;
            }
        }
   
        ler_string.close();
        ler_int.close();
    }
}