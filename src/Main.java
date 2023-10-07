import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args){

        ArrayList<PessoaFisica> listaPf = new ArrayList<>();


        System.out.println("Bem - Vindo");
        Scanner leitor = new Scanner(System.in);
        String opcao;
        opcao = leitor.nextLine();


        do {
            System.out.println("Escolha uma opcao: 1 - Fisica 2- Juridica 0- Sair");
            opcao = leitor.nextLine();
            switch (opcao) {
                case "1":

                    String opcaoCPF;

                        /*    do {
                                System.out.println("Escolha uma opcao: 1 - Cadastrar CPF 2- Listar CPF 0- Voltar");
                                opcaoCPF = leitor.nextLine();
                                switch (opcaoCPF) {
                                    case "1":
                                        break;
                                    case "2":
                                        break;
                                    case "0":
                                        break;
                                    default:
                                        System.out.println("default");
                                }
                            }while (!opcaoCPF.equals("0")) ;*/


                    PessoaFisica novapf = new PessoaFisica();
                    Endereco novoEndpf = new Endereco();

                    System.out.println("Digite o nome");
                    novapf.nome = leitor.nextLine();

                    System.out.println("Digite o cpf");
                    novapf.cpf = leitor.nextLine();

                    System.out.println("Digite o Rendimento");
                    novapf.rendimento = leitor.nextFloat();

                    System.out.println("Digite a data de nascimento (dd/mm/aaaa)");
                    novapf.dtNasc = LocalDate.parse(leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    Period idade = Period.between(novapf.dtNasc, LocalDate.now());
                    if (idade.getYears() >= 18) {
                        System.out.println("Idade valida");
                    }else {
                        System.out.println("Idade invalida");
                        break;
                    }

                    System.out.println("logradouro");
                    novoEndpf.logradouro = leitor.next();

                    System.out.println("Digite o numero");
                    novoEndpf.numero = leitor.nextInt();

                    System.out.println("Este endereco e comercial? s/n: ");
                    String endCom = leitor.next();
                    if(endCom.equals("S") || endCom.equals("s")) {
                    novoEndpf.endComercial = true;
                }else{
                    novoEndpf.endComercial = false;
                }
                listaPf.add(novapf);

                System.out.println("Cadastro Realizado com sucesso!");

                    break;
                case "2":
                    if(listaPf.size() >0){
                      // le uma lista
                        for (PessoaFisica cadapf: listaPf) {
                            System.out.println("Nome: " + cadapf.nome);
                            System.out.println("CPF: " + cadapf.cpf);
                            System.out.println("Data de Nascimento: " + cadapf.dtNasc.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                            System.out.println("Endereco: "+ cadapf.endereco.logradouro + "-" + cadapf.endereco.numero);
                            System.out.println();
                            System.out.println("Aperte Enter para continuar");
                            leitor.nextLine();
                        }

                    }else {
                        System.out.println("Lista Vazia!");
                    }

                    break;

                case "0":
                    break;

                default:
                    System.out.println("default");

            }
        }while (!opcao.equals("0"));
    }
}