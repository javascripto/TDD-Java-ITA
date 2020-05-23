package yuri;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PilhaTest {

  @Test
  public void deveTerPilhaVazia() {
    Pilha p = new Pilha();
    assertTrue(p.estaVazia());
    assertEquals(0, p.tamanho());
  }

  @Test
  public void deveEmpilharUmElemento() {
    Pilha p = new Pilha();
    p.empilha("primeiro");
    assertFalse(p.estaVazia());
    assertEquals(1, p.tamanho());
    assertEquals("primeiro", p.topo());
  }

  @Test
  public void deveEmpilharDoisElementos() {
    Pilha p = new Pilha();
    p.empilha("primeiro");
    p.empilha("segundo");
    assertEquals(2, p.tamanho());
    assertEquals("segundo", p.topo());
  }

  @Test
  public void deveEmpilharEDesempilharElementos() {
    Pilha p = new Pilha();
    p.empilha("primeiro");
    p.empilha("segundo");
    assertEquals(2, p.tamanho());
    assertEquals("segundo", p.topo());
    Object desempilhado = p.desempilha();
    assertEquals(1, p.tamanho());
    assertEquals("primeiro", p.topo());
    assertEquals("segundo", desempilhado);
  }
}