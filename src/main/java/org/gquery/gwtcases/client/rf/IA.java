package org.gquery.gwtcases.client.rf;

import org.gquery.gwtcases.server.rf.A;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(A.class)
public interface IA extends EntityProxy {
  String getName();
  void setName(String n);
  IB getB();
  void setB(IB ib);
}
