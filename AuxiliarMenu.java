
package helioarai;

import java.util.*;

public class AuxiliarMenu {

    public static String clientName;
    public static String clientAge;
    public static String escolhaMenu ;
    
    public static int menuEntrada (){
        Scanner ler = new Scanner (System.in);
        boolean continua=true;
        do {
            System.out.println ("\n************MENU DE ATENDIMENTO***************");
            System.out.println ("Escolha uma opcao na tela (1 a 6) : \n");
            System.out.println ("1) Chegada de novo cliente na agencia ");
            System.out.println ("2) Verificar proximo cliente a ser atendido ");
            System.out.println ("3) Atendimento do proximo cliente");
            System.out.println ("4) Numero de cliente aguardando atendimento");
            System.out.println ("5) Exibicao das filas");
            System.out.println ("6) Finalizar a operacao ");
            
            escolhaMenu = ler.next();
            continua = (isInt(escolhaMenu)|| validaIdade (Integer.parseInt(escolhaMenu),1,6));
            
         } while (continua);
       return  Integer.parseInt(escolhaMenu);
    } 
    
    
    public static String insereNome (){
        Scanner ler = new Scanner (System.in);
        boolean continua=true;
        do {
            System.out.print ("Inserir o nome do proximo cliente (no minimo 5 caracteres ) ");
            clientName = ler.nextLine();
            continua=validaNome(clientName);
       } while (continua);
       return clientName ;
   } 
    
 
   public static boolean validaNome(String nome){
       boolean valido = true;
       if( nome.replace(" ", "").length()>=5){
           valido = false;
       }
       
       return valido;
   }
   
   
   public static int insereIdade (){
        Scanner ler = new Scanner (System.in);
        boolean continua=true;
        do {
            System.out.print ("Inserir a idade proximo cliente (idade minima 16 anos, maxima de 110 anos) ");
               
            clientAge = ler.next();
            continua = (isInt(clientAge)|| validaIdade (Integer.parseInt(clientAge),16,110));
            
         } while (continua);
       return  Integer.parseInt(clientAge);

   } 
   
   
   public static boolean validaIdade(int idade, int min, int max){
       boolean valido = true;
       if(idade >= min && idade<=max ){
          valido = false;}
       return valido;
   }
   
   public static boolean isInt(String v) {
    try {
        Integer.parseInt(v);
        return false;
    } catch (Exception e) {
        return true;
    }
}

    public static boolean isElderly(int dado){
       if (dado>=60) {return true;}
       else {return false;}     
    }
    
    public static boolean maxSize(int dado){
       if (dado>=10) {return true;}
       else {return false;}     
    }
    
   
}