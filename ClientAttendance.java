
package helioarai;


public class ClientAttendance <T> {
   
    private Client<T> inicio;
    private Client<T> fim ;
    private int tamanho ;

    

public ClientAttendance() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

public int lenght(){
    return this.tamanho;
}    

public void showQueues(){
    Client<T> temp= this.inicio;
    for (int i =0; i<lenght();i++){
            System.out.println( " idade : " + temp.getAge() + " anos " + "nome " + temp.getName()); 
            temp=temp.getProx();
    }
}

private boolean InserePrimeiro(T valor , T valor1){//
    Client<T> elemento = new Client<T> (valor, valor1);    //   
    this.inicio = elemento ;
    this.fim =elemento ;
    this.tamanho ++;
    return true;
}

  private boolean insereInicio(T valor ,T valor1) {//
    Client <T> elemento = new Client <T> (valor, valor1);         //
    elemento.setProx(this.inicio);
    this.inicio = elemento;
    this.tamanho++;
    return true;
  }

  
  private boolean insereFinal( T valor, T valor1) {
    Client <T> elemento = new Client <T>(valor,  valor1);
    elemento.setProx(null);
    this.fim.setProx(elemento);
    this.fim = elemento;
    this.tamanho++;
    return true;  
  }   
  
    private boolean insereMeio (T valor, T valor1, int pos) {
    Client <T> elemento = new Client <T>(valor, valor1);
    Client aux = this.inicio; //aux le a posição inicial
    Client temp = this.inicio.getProx(); //temp a prox posição;

    if ((pos < 0) || (pos > lenght())) {return false;}
    else {
      for (int i = 1; i < pos; i++) {
        aux = temp;
        temp = temp.getProx();
      }
      aux.setProx(elemento);
      elemento.setProx(temp); //elemento.setProx(aux.getProx())
      this.tamanho++;
      return true;
    }
  }
    
  public boolean addClient(T valor,T valor1, int pos) {
    if ((pos < 0) || (pos > lenght())) {return false;}
    else if ((pos == 0) && (lenght() == 0)) {return InserePrimeiro(valor, valor1);}
    else if ((pos == 0) && (lenght() > 0)) {return insereInicio(valor, valor1);}
    else if (pos == lenght()) {return insereFinal(valor, valor1);}
    else {return insereMeio(valor,valor1, pos);}
  }  
  
  public int numClients (){
      return tamanho;           
  }
  
  public boolean eMaior(int dado){
      if (dado>=60) {return true;}
      else {return false;}     
  }
  
   
  
  public boolean isEmpty(){
      return tamanho==0;      
  }
  
  public  Client<T> getNext(){      
      //showNext();
      if (isEmpty()){
          return null;
      }
      Client <T> temp = inicio;
      inicio= inicio.getProx();
      if (inicio== null){
          fim=null;
      }
      tamanho --;
      temp.setProx(null);
      return temp;
     
  }
  
  public boolean showNext (){
      System.out.println("O proximo cliente a se atendido e o : "+ this.inicio.getName()) ;

      return true;
  }
  

    
  


}
