package org.gquery.gwtcases.client.rf;

import org.gquery.gwtcases.server.rf.B;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(B.class)
public interface IB extends EntityProxy {
  String getName();
  void setName(String n);
}
