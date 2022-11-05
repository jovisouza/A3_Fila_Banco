
package helioarai;

public class Client<T> {
	private T idade;
        private T nome;
	private Client<T> prox;

	public Client(T Age, T Name) {
                this.idade=Age;
                this.nome= Name;
		this.prox = null;
	}

	public T getAge() {
		return this.idade;
	}
        
	public T getName() {     
		return this.nome;
	}                         
        

	public Client<T> getProx() {
		return this.prox;
	}

	public void setAge(T valor) {
		this.idade = valor;
	}
        
        public void setName(T valor1) {
		this.idade = valor1;     
	}                               
        

	public void setProx(Client<T> aux) {
		this.prox = aux;
	}
        
 
        
}