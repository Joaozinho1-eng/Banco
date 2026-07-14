import java.util.ArrayList;
import java.util.Scanner;

public  class Banco {
    static ArrayList<Contaclientes> contas = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    private static class Contaclientes{
        private Integer id;
        private String nome;
        private double saldo;

        public int getId(){
            return id;
        }

        public double getSaldo(){
            return saldo;
        }

        public void setSaldo(double saldo){
            this.saldo = saldo;
        }


    }
    public static void mostrarMenu(){
        System.out.println("---MENU DO BANCO---");
        System.out.println("1- Criar conta");
        System.out.println("2- Listar contas");
        System.out.println("3- Buscar conta");
        System.out.println("4- Depositar");
        System.out.println("5- Sacar");
        System.out.println("6- Transferir");
        System.out.println("7- Consultar saldo");
        System.out.println("8- Sair");
    }

    public static void criarConta(){
     Contaclientes contac = new Contaclientes();
     System.out.println("Digite o seu ID de conta ");
     contac.id = input.nextLine();
     input.nextLine();

     System.out.println("Digite o seu nome : ");
     contac.nome = input.nextLine();

     System.out.println("Digite o seu saldo : ");
     contac.saldo = input.nextDouble();
     contas.add(contac);

     System.out.println("Conta cadastrada com sucesso! ");
    }

    public static void listarContas(){
        if (contas.isEmpty()){
            System.out.println("Nenhum conta foi encontrada!");
            return;
        }
        for (Contaclientes  conta : contas){
            System.out.println("ID"+ conta.id);
            System.out.println("Nome"+ conta.nome);
            System.out.println("Saldo"+ conta.saldo);
        }
    }
    public static void buscarConta(String id){
        System.out.println("Digite o ID da conta que deseja buscar: ");
        boolean encontrado = false;
        for (Contaclientes  conta : contas){
            if (conta.getId() == id){
                System.out.println("-----CONTA ENCONTRADA-----");
                System.out.println("ID"+ conta.id);
                System.out.println("Nome"+ conta.nome);
                System.out.println("Saldo"+ conta.saldo);
                encontrado=true;
                break;
            }
        }
        if (!encontrado){
            System.out.println("Nenhuma conta foi encontrada!");
        }
    }
    public static void depositar(String id){
       System.out.println("Digite o ID da conta que deseja depositar: ");
       int idBusca = input.nextInt();
       for  (Contaclientes  conta : contas){
           if (conta.getId() == idBusca){
               System.out.println("Digite o valor que deseja depositar: ");
               double valor = input.nextDouble();
               if (valor >= 0){
                   conta.getSaldo();
                   System.out.println("Depositado com sucesso!");
                   System.out.println("O novo saldo é de" + conta.saldo);
               } else{
                   System.out.print("Valor inválido!");
               }
               return;
           }
       }
       System.out.println("Nenhuma conta foi encontrada!");
       }







            public static void main(String[] args){

        char resposta;

        do {
            mostrarMenu();
            resposta = input.next().charAt(0);
            switch (resposta) {

                case '1':
                    criarConta();
                    break;

                case '2':
                    listarContas();
                    break;

                case '3':
                    buscarConta(input.next());
                    break;

                case '4':



            }
        }while(resposta !='8');
    }
}