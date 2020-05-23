package yuri;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class PilhaTest {
  private Pilha pilha;

  @Before
  public void inicializaPilha() {
    pilha = new Pilha(10);
  }

  @Test
  public void deveTerPilhaVazia() {
    assertTrue(pilha.estaVazia());
    assertEquals(0, pilha.tamanho());
  }

  @Test
  public void deveEmpilharUmElemento() {
    pilha.empilha("primeiro");
    assertFalse(pilha.estaVazia());
    assertEquals(1, pilha.tamanho());
    assertEquals("primeiro", pilha.topo());
  }

  @Test
  public void deveEmpilharDoisElementos() {
    pilha.empilha("primeiro");
    pilha.empilha("segundo");
    assertEquals(2, pilha.tamanho());
    assertEquals("segundo", pilha.topo());
  }

  @Test
  public void deveEmpilharEDesempilharElementos() {
    pilha.empilha("primeiro");
    pilha.empilha("segundo");
    assertEquals(2, pilha.tamanho());
    assertEquals("segundo", pilha.topo());
    Object desempilhado = pilha.desempilha();
    assertEquals(1, pilha.tamanho());
    assertEquals("primeiro", pilha.topo());
    assertEquals("segundo", desempilhado);
  }

  @Test(expected=PilhaVaziaException.class)
  public void deveLancarErroDePilhaVazia() {
    pilha.desempilha();
  }

  @Test
  public void deveLancarErroDePilhaCheia() {
    for (int i = 0; i < 10; i++) {
      pilha.empilha("elemento " + i);
    }
    try {
      pilha.empilha("boom");
      fail();
    } catch (PilhaCheiaException e) {}
  }

}
