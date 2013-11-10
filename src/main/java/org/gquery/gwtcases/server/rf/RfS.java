package org.gquery.gwtcases.server.rf;

public class RfS {
  public static A busca(String i) {
    return A.findA(i);
  }
  public static A salva(A a) {
    System.out.println("salva " + a + " " + a.getB());
    return a;
  }
}
