
package helioarai;

import java.util.*;

public class FilaBanco {


    public static void main(String[] args) {
        
        Scanner ler = new Scanner (System.in);
        
        ClientAttendance listaPessoa = new ClientAttendance(); // fila de pessoas novas
        ClientAttendance listaPessoaIdosa = new ClientAttendance(); // fila de pessoas idosas
        
        int naoIdoso=0;
        int idoso = 0 ;
       
        int escolha=0;
        int contador=0;// 0 e 1 e idoso e 2 e novo
        do {        //menu de opções na tela  
            
        
        escolha=AuxiliarMenu.menuEntrada();
        
        switch (escolha){
            case 1 : {   
                
            if (AuxiliarMenu.maxSize((listaPessoa.lenght())+listaPessoaIdosa.lenght())) {
                System.out.println("O numero de cliente aguardando foi excedido\n");
                break;
            }
                
                String nomeCliente= AuxiliarMenu.insereNome();

                int idadeCliente = AuxiliarMenu.insereIdade(); 
                
               
                naoIdoso = listaPessoa.lenght();
                idoso = listaPessoaIdosa.lenght();
                
                if (AuxiliarMenu.isElderly(idadeCliente)){
                    listaPessoaIdosa.addClient (idadeCliente,nomeCliente,(idoso));}
                else {listaPessoa.addClient (idadeCliente,nomeCliente,(naoIdoso));}
                
                break;
            }
            
            case 2 :
                    if (listaPessoa.isEmpty() && listaPessoaIdosa.isEmpty()){
                        System.out.println("A fila esta vazia, aguardando chegada de clientes");}
                    if (listaPessoaIdosa.lenght()>0 && contador<2){ 
                        listaPessoaIdosa.showNext();
                    }
                    else {if ((listaPessoa.lenght()>0 && contador==2) || (listaPessoaIdosa.lenght()==0 && listaPessoa.lenght()!=0)){
                        listaPessoa.showNext();
                        }
                    }
                    break;
              
               
            case 3 : 
                    if (listaPessoa.isEmpty() && listaPessoaIdosa.isEmpty()){
                        System.out.println("A fila esta vazia, aguardando chegada de clientes");}
                    
                    if (listaPessoaIdosa.lenght()>0 && contador<2){ 
                        contador=contador+1;
                        listaPessoaIdosa.getNext();
                    }
                    else {if ((listaPessoa.lenght()>0 && contador==2) || listaPessoaIdosa.lenght()==0 && listaPessoa.lenght()!=0){
                        listaPessoa.getNext();
                        contador=0;}
                    }
                    break;

            case 4 : System.out.println("O numero total de clientes esperando e de : " + (listaPessoa.numClients()+listaPessoaIdosa.numClients())+"\n" + "Numero de clientes idosos esperando e de : " +listaPessoaIdosa.numClients() );
                     break;
                     
            case 5 : System.out.println("Fila dos idosos : ");
                     listaPessoaIdosa.showQueues();
                     System.out.println("\nFila dos nao idosos : ");
                     listaPessoa.showQueues();  
                     System.out.println("\n");
                     break ;
                     
            case 6 : if ((listaPessoa.numClients()+listaPessoaIdosa.numClients())>0) {
                        System.out.println("Nao podemos encerrar, clientes aguardando na fila");                     
                        }
                     else   escolha =7;  
                     break ;
       
                     
        }
        } while (escolha!=7);
        
        System.out.println("Expediente encerrado, todos os clientes foram atendidos e horario de fechamento atingido");

    }
    
}
