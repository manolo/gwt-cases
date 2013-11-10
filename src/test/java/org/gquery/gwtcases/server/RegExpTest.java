package org.gquery.gwtcases.server;

import junit.framework.TestCase;

public class RegExpTest extends TestCase {
  
  public void testReg() {
    String r1 = "(?!.*\\.(html|css|png|jpg)$).+";
    String r2 = ".+(?<!\\.(html|css|png|jpg))";
    String i1 = "/index.html";
    String i2 = "/adf89008.aaa";

    System.out.println(i1.matches(r1));
    System.out.println(i2.matches(r1));
    System.out.println(i1.matches(r2));
    System.out.println(i2.matches(r2));

  }
  
  private void f2(String a, Object...o) {
    System.out.println(o[0].getClass().getName() + " " + o[0].getClass().isArray());
  }

  private void f1(Object...o) {
    System.out.println(o[0].getClass().getName() + " " + o[0].getClass().isArray());
    f2("e", o);
  }
  
  public void testArgs() {
    f1("foo");
  }

}
