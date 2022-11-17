package aula26;

import java.util.ArrayList;

public class Principal2 {
    ArrayList<MaterialEscolar> lista;
    
    public interface Iterator {
        public boolean temProximo();
        public Object proximo();
        public boolean temAnterior();
        public Object anterior();
    }
    
    public class ItemIterator implements Iterator {
	private ArrayList< MaterialEscolar > lista;
	private int pos=0;
	
	public ItemIterator(ArrayList<MaterialEscolar> lista){
            this.lista = lista;
            this.pos = this.lista.size() - 1;
	}
	
	public boolean temAnterior() {
            boolean result=false;
            if ( pos >= 0 )
                    result=true;
            return result;
	}
	public Object anterior() {
            MaterialEscolar item  = this.lista.get(pos);
            pos--;
            return item;
	}	
	
	public boolean temProximo() {
            boolean result=false;
            if ( pos < this.lista.size() )
                    result=true;
            return result;
	}
	
	public Object proximo() {
            Object item  = this.lista.get(pos);
            pos++;
            return item;
	}	
    }
    
    public class MaterialEscolar {
        private String nome;
        public MaterialEscolar(String nome){
            this.nome=nome;
        }
        public String toString(){
            return this.nome;
        }
    }
    
    public void iniciar(){
        lista = new ArrayList<>();
        lista.add(new MaterialEscolar("Lapis"));
        lista.add(new MaterialEscolar("Borracha"));
        
        //TODO3
        Iterator i = new ItemIterator( lista );
        while( i.temAnterior() )
            System.out.println( (MaterialEscolar) i.anterior() );
    }

    public static void main(String[] args) {
        Principal2 p = new Principal2();
        p.iniciar();
    }
}