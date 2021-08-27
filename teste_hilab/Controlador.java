package teste_hilab;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Controlador {
    private ArrayList <Ficha> fichas = new ArrayList <> ();

    private boolean nome_valido (String nome) {
        if (nome.equals("") || nome.equals (" "))
            return false;

        return true;
    }

    private boolean email_valido (String email) {
        // testa o formato do e-mail
        String modelo = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern p = Pattern.compile (modelo);
        Matcher m = p.matcher (email);
        return m.matches ();
    }

    private boolean nascimento_valido (String nascimento) {
        // testa o formato da data
        String modelo = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
        Pattern p = Pattern.compile (modelo);
        Matcher m = p.matcher (nascimento);
        return m.matches ();
    }

    private boolean categoria_valida (String categoria) {
        Boolean valida = false;

        switch (categoria) {
            case "Desenvolvedor": 
                valida = true;
                break;

            case "BDA": 
                valida = true;
                break;

            case "Gerente de Sistemas": 
                valida = true;
                break;

            case "Arquiteto de Software": 
                valida = true;
                break;
            }
        return valida;
    }

    // retorna o usuario com id recebido
    public void GET (Integer id) { 
        Ficha usuario = fichas.get(id-1);
        System.out.println ("Nome: "+usuario.getNome());
        System.out.println ("Sobrenome: "+usuario.getSobrenome());
        System.out.println ("Data de Nascimento: "+usuario.getNascimento());
        System.out.println ("E-Mail: "+usuario.getEmail());
        System.out.println ("Categoria Profissional: "+usuario.getCategoria());
    }

    // cria um usuario
    public String POST (String nome, String sobrenome, String email, String categoria, String nascimento) {
        if (! nome_valido (nome) ||  ! nome_valido (sobrenome))
            return "Nome e/ou Sobrenome Invalido!";

        if (! email_valido (email))
            return "E-mail Invalido!";

        
        if (! nascimento_valido (nascimento))
            return "Data de Nascimento Invalida";

        if (! categoria_valida (categoria))
            return "Categoria Profissional Invalida!";

        fichas.add (new Ficha (nome, sobrenome, email, categoria, nascimento));

        return "Usuario Cadastrado! id: "+fichas.size();
    }

    // atualiza algum campo do usuario
    public String PUT (int id, int campo, String dado) {
        if (id < 0 || id > fichas.size())
            return "ID invalido!";

        id--;

        switch (campo) {
            case 1:
                return "Nome e/ou Sobrenome Invalido!";

            case 2:
                if (! nascimento_valido (dado))
                    return "Data de Nascimento Invalida";
                fichas.get(id).setNascimento(dado);
                return "Data de Nascimento Alterada!";

            case 3:
                if (! email_valido (dado))
                    return "E-mail Invalido";
                fichas.get(id).setEmail (dado);
                return "E-mail Alterado!";

            case 4:
                if (! categoria_valida (dado))
                    return "Categoria Profissional Invalida!";
                fichas.get(id).setCategoria (dado);
                return "Categoria Profissional Alterada!";

            default:
                return "Campo Invalido!";
        }
    }

    // caso especifico para atualizar nome (sempre atualiza nome e sobrenome)
    public String PUT (int id, int campo, String nome, String sobrenome) {
        if (id < 0 || id > fichas.size())
            return "ID invalido!";

        id--;

        if (campo != 1)
            return "Campo Invalido!";

        if (! nome_valido (nome) ||  ! nome_valido (sobrenome))
            return "Nome e/ou Sobrenome Invalido!";

        fichas.get(id).setNome (nome);
        fichas.get(id).setSobrenome (sobrenome);

        return "Nome e/ou Sobrenome Alterado!";
    }

    // tranforma toda a lista em um json
    public String toJSON () {
        String json = "[ \n";

        for (Ficha ficha : fichas) {
            json += "{ ";
            json += "\"Nome\": " + "\"" + ficha.getNome() + "\""  + ",\n";
            json += "\"Sobrenome\": " + "\"" + ficha.getSobrenome() + "\"" + ",\n";
            json += "\"Data de Nascimento\": " + "\"" + ficha.getNascimento() + "\"" + ",\n";
            json += "\"E-Mail\": " + "\"" + ficha.getEmail() + "\"" + ",\n";
            json += "\"Categoria Profissional\": " + "\"" + ficha.getCategoria() + "\"" + "\n";
            json += " }";
            json += ",\n";
        } 

        // retira o ultimo '\n' e ',' que não pode ter
        json = json.substring(0, json.length() - 2);

        json += "\n]";

        return json;
    }
}
