import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<PessoaFisica> listaPf = new ArrayList<>();
        PessoaFisica metodoPf = new PessoaFisica();

        ArrayList<PessoaJuridica> listaCNPJ = new ArrayList<>();
        PessoaJuridica metodoCNPJ = new PessoaJuridica();



        System.out.println("Bem vindo ao sistema de cadastro de Pessoas Físicas e Juridicas");

        Scanner leitor = new Scanner(System.in);

        String opcao;

        do {

            System.out.println("Escolha uma opção: 1 - Pessoa Física / 2 - Pessoa Jurídica / 0 - Sair");
            opcao = leitor.nextLine();

            switch (opcao){
                case "1":

                    String opcaoCPF;

                    do {
                        System.out.println("Digite uma opção: 1-Cadastrar PF / 2-Listar PF / 0-Voltar");
                        opcaoCPF = leitor.nextLine();

                        switch (opcaoCPF){
                            case "1":

                                PessoaFisica novaPf = new PessoaFisica();
                                Endereco novoEndPf = new Endereco();

                                System.out.println("Digite o nome:");
                                novaPf.nome = leitor.nextLine();

                                System.out.println("Digite o cpf:");
                                novaPf.cpf = leitor.nextLine();

                                System.out.println("Digite o rendimento:");
                                novaPf.rendimento = leitor.nextFloat();

                                System.out.println("Digite a data de nascimento: (dd/mm/aaaa)");
                                novaPf.dtNasc = LocalDate.parse(leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                                Period idade = Period.between(novaPf.dtNasc, LocalDate.now());

                                if (idade.getYears() >= 18){
                                    System.out.println("Idade Válida!");
                                } else {
                                    System.out.println("Idade Inválida!");
                                    break;
                                }

                                System.out.println("Digite o logradouro");
                                novoEndPf.logradouro = leitor.next();

                                System.out.println("Digite o numero");
                                novoEndPf.numero = leitor.nextInt();

                                System.out.println("Este endereço é comercial? S/N:");
                                String endCom = leitor.next();

//                                if (endCom.equalsIgnoreCase("s")){
                                if (endCom.equals("S") || endCom.equals("s")){
                                    novoEndPf.endComercial = true;
                                } else {
                                    novoEndPf.endComercial = false;
                                }

                                novaPf.endereco = novoEndPf;

                                listaPf.add(novaPf);

                                System.out.println("Cadastro realizado com sucesso!");

                                break;

                            case "2":

                                if (listaPf.size() > 0){

                                    for (PessoaFisica cadaCPF : listaPf) {
                                        System.out.println("Nome: " + cadaCPF.nome);
                                        System.out.println("CPF: " + cadaCPF.cpf);
                                        System.out.println("Data de Nascimento: " + cadaCPF.dtNasc.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                                        System.out.println("Imposto a ser pago: " + metodoPf.CalcularImposto(cadaCPF.rendimento));
                                        System.out.println("Endereço: " + cadaCPF.endereco.logradouro + "-" + cadaCPF.endereco.numero);

                                        System.out.println();
                                        System.out.println("Aperte ENTER para continuar");
                                        leitor.nextLine();
                                    }

                                } else {
                                    System.out.println("Lista vazia!");
                                }

                                break;

                            case "0":
                                System.out.println("Volta");
                                break;

                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }

                    }while(!opcaoCPF.equals("0"));

                    break;

                case "2":

                    String opcaoCNPJ;

                    do {
                        System.out.println("Digite uma opção: 1-Cadastrar CNPJ / 2-Listar CNPJ / 0-Voltar");
                        opcaoCNPJ = leitor.nextLine();

                        switch (opcaoCNPJ){
                            case "1":

                                PessoaJuridica novoCNPJ = new PessoaJuridica();
                                Endereco novoEndCNPJ = new Endereco();

                                System.out.println("Digite a Razao social:");
                                novoCNPJ.nome = leitor.nextLine();

                                System.out.println("Digite o CNPJ:");
                                novoCNPJ.cnpj = leitor.nextLine();

                                System.out.println("Digite o rendimento:");
                                novoCNPJ.rendimento = leitor.nextFloat();

                                System.out.println("Digite o logradouro");
                                novoEndCNPJ.logradouro = leitor.next();

                                System.out.println("Digite o numero");
                                novoEndCNPJ.numero = leitor.nextInt();

                                System.out.println("Este endereço é comercial? S/N:");
                                String endCom = leitor.next();

//                                if (endCom.equalsIgnoreCase("s")){
                                if (endCom.equals("S") || endCom.equals("s")){
                                    novoEndCNPJ.endComercial = true;
                                } else {
                                    novoEndCNPJ.endComercial = false;
                                }

                                novoCNPJ.endereco = novoEndCNPJ;

                                listaCNPJ.add(novoCNPJ);

                                System.out.println("Cadastro realizado com sucesso!");

                                break;

                            case "2":

                                if (listaCNPJ.size() > 0){

                                    for (PessoaJuridica cadaCNPJ : listaCNPJ) {
                                        System.out.println("Razao Social: " + cadaCNPJ.nome);
                                        System.out.println("CNPJ: " + cadaCNPJ.cnpj);
                                        System.out.println("Imposto a ser pago: " + metodoPf.CalcularImposto(cadaCNPJ.rendimento));
                                        System.out.println("Endereço: " + cadaCNPJ.endereco.logradouro + "-" + cadaCNPJ.endereco.numero);

                                        System.out.println();
                                        System.out.println("Aperte ENTER para continuar");
                                        leitor.nextLine();
                                    }

                                } else {
                                    System.out.println("Lista vazia!");
                                }

                                break;

                            case "0":
                                System.out.println("Volta");
                                break;

                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }

                    }while (!opcaoCNPJ.equals("0"));

                    break;

                case "0":
                    System.out.println("case 0");
                    break;

                default:
                    System.out.println("default");
                    break;
            }

        } while (!opcao.equals("0"));
    }
}