
package helioarai;

import java.util.*;

public class FilaBanco {


    public static void main(String[] args) {
        
        Scanner ler = new Scanner (System.in);
        
        ClientAttendance listaPessoa = new ClientAttendance(); // fila de pessoas novas
        ClientAttendance listaPessoaIdosa = new ClientAttendance(); // fila de pessoas idosas
        
        listaPessoa.addClient (23,"Antonio Marcos",0);
        listaPessoaIdosa.addClient (66,"Sergio da Silva",0); 
        listaPessoa.addClient (15,"Maria das Flores",1);
        listaPessoa.addClient (44,"Filomena Canedo",0);
        listaPessoaIdosa.addClient (78,"Matusalen",0);
        listaPessoaIdosa.addClient (69,"Caindo do ceu",0);

        int naoIdoso=3;
        int idoso = 3 ;

        
       
        int escolha=0;
        int contador=0;// 0 e 1 e idoso e 2 e novo
        do {        //menu de opções na tela    
        System.out.println ("************MENU DE ATENDIMENTO***************");
        System.out.println ("Escolha uma opcao na tela : ");
        System.out.println ("1) Chegada de novo cliente na agencia ");
        System.out.println ("2) Verificar proximo cliente a ser atendido ");
        System.out.println ("3) Atendimento do proximo cliente");
        System.out.println ("4) Número de cliente aguardando atendimento");
        System.out.println ("5) Exibicao das filas");
        System.out.println ("6) Finalizar a operacao ");
        
        escolha = ler.nextInt();// inserir novo cliente
        // colocar erro caso a escolha não seja um número dentro dos 5, ou pedir para o usuario novamente digitar
        
        
        switch (escolha){
            case 1 : {   
                System.out.print ("Inserir o nome do proximo cliente  ");
                String nomeCliente = ler.next();
                System.out.print ("Inserir a idade do proximo cliente:  ");
                int idadeCliente = ler.nextInt();  
                naoIdoso = listaPessoa.lenght();//novo 01_11
                idoso = listaPessoaIdosa.lenght();//novo 01_11
                if (idadeCliente<60){
                    listaPessoa.addClient (idadeCliente,nomeCliente,(naoIdoso));}
                else {listaPessoaIdosa.addClient (idadeCliente,nomeCliente,(idoso));}
                break;
            }
            
            case 2 :
                    if (listaPessoa.isEmpty() || listaPessoaIdosa.isEmpty()){
                        System.out.println("A fila acabou");}// rotina tem que sair do case
                    if (listaPessoaIdosa.lenght()>0 && contador<2){ 
                        //cont=cont+1;
                        listaPessoaIdosa.showNext();
                    }
                    else {if ((listaPessoa.lenght()>0 && contador==2) || (listaPessoaIdosa.lenght()==0 && listaPessoa.lenght()!=0)){
                        listaPessoa.showNext();
                        }
                    }
                    break;
              
               
            case 3 : 
                    if (listaPessoa.isEmpty() && listaPessoaIdosa.isEmpty()){
                        System.out.println("A fila acabou");}
                    
                    if (listaPessoaIdosa.lenght()>0 && contador<2){ 
                        contador=contador+1;
                        listaPessoaIdosa.getNext();
                    }
                    else {if ((listaPessoa.lenght()>0 && contador==2) || listaPessoaIdosa.lenght()==0 && listaPessoa.lenght()!=0){
                        listaPessoa.getNext();
                        contador=0;}
                    }
                    break;

            case 4 : System.out.println("O numero total de clientes esperando e de : " + (listaPessoa.numClients()+listaPessoaIdosa.numClients()));
                     break;
                     
            case 5 : System.out.println("Fila dos idosos : ");
                     listaPessoaIdosa.showQueues();
                     System.out.println("\nFila dos nao idosos : ");
                     listaPessoa.showQueues();  
                     System.out.println("\n");
                     break ;
                     
            case 6 : break;         
                     
        }
        } while (escolha!=6);
        

    }
    
}
