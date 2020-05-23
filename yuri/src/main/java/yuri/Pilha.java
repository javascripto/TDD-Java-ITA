package yuri;

public class Pilha {

  private int quantidade = 0;
  private Object[] elementos;


  Pilha(int maximo) {
    elementos = new Object[maximo];
  }

  public boolean estaVazia() {
    return quantidade == 0;
  }

  public int tamanho() {
    return quantidade;
  }

  public void empilha(Object elemento) {
    if (quantidade == elementos.length) {
      throw new PilhaCheiaException("Não é possível adicionar mais elementos");
    }
    this.elementos[quantidade] = elemento;
    quantidade++;
  }

  public Object topo() {
    return elementos[quantidade - 1];
  }

  public Object desempilha() {
    if (estaVazia()) {
      throw new PilhaVaziaException("Não é possível desempilhar.");
    }
    Object topo = topo();
    quantidade--;
    return topo;
  }
}
