package aula26;

import java.util.ArrayList;

public class Principal {
    
    
    ArrayList<MaterialEscolar> lista;

    public interface Iterator {
        public abstract boolean temProximo();
        public abstract Object proximo();
    }
    
    public class ItemIterator implements Iterator {
        private ArrayList<MaterialEscolar> lista;
        private int pos=0;

        public ItemIterator(ArrayList<MaterialEscolar> lista){
            this.lista = lista;
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
            this.nome = nome;
        }
        public String toString(){
            return this.nome;
        }

    }
    
    public void iniciar(){
        lista = new ArrayList<>();
        MaterialEscolar x;
        x = new MaterialEscolar("Lapis");
        lista.add(x);
        x = new MaterialEscolar("Caneta");
        lista.add(x);
        
        //TODO6
        Iterator i = new ItemIterator(lista);
        while(i.temProximo())
            System.out.println((MaterialEscolar) i.proximo());
        
    }

    public static void main(String[] args) {
        Principal p = new Principal();
        p.iniciar();
    }
}
