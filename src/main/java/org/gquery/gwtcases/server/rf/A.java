package org.gquery.gwtcases.server.rf;

import com.google.web.bindery.requestfactory.shared.EntityProxyId;

public class A {
  private static int c = 0;
  private String id = "A" + c++;
  public String getId() {
    return id;
  }
  public void setId(String i) {
    id = i;
  }
  public Integer getVersion() {
    return 1;
  }
  public static A findA(String i) {
    A r = new A();
    r.setId(i);
    return r;
  }
  public EntityProxyId<?> stableId() {
    return null;
  }
  private String name = "no-name";
  public String getName() {
    return name;
  }
  public void setName(String n) {
    name = n;
  }
  public String toString() {
    return "class:" + getClass().getSimpleName() + " id:" + getId() + " name:" + name;
  }
  public B bb;
  public B getB() {
    return bb == null ? (bb =new B()) : bb;
  }
  public void setB(B b) {
    System.out.println("SET B");
    bb = b;
  }
}
