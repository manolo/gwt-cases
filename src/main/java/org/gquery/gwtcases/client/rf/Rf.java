package org.gquery.gwtcases.client.rf;

import org.gquery.gwtcases.server.rf.RfS;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.RequestFactory;
import com.google.web.bindery.requestfactory.shared.Service;

public class Rf implements EntryPoint {
  
  @Service(RfS.class)
  public static interface AppRq extends RequestContext {
    Request<IA> busca(String id);
    Request<IA> salva(IA a);
  }
  
  public static interface AppRf extends RequestFactory {
    AppRq rq();
  }
  
  public void onModuleLoad() {
    final AppRf rf = GWT.create(AppRf.class);
    rf.initialize(new SimpleEventBus());
    rf.rq().busca("1").with("b").fire(new Receiver<IA>() {
      public void onSuccess(IA ia) {
        System.out.println(ia.getName() + " ");// + ia.getB().getName());
        AppRq rq = rf.rq();
        ia = rq.edit(ia);
        IB ib = ia.getB();
        ib = rq.edit(ib);
        ia.setName("new-name");
        ib.setName("new-name");
        ia.setB(ib);
//        rq.edit(ia.getB()).setName("new-name");
        
        rq.salva(ia).with("b").fire(new Receiver<IA>() {
          public void onSuccess(IA ia) {
            System.out.println(ia.getName() + " " + ia.getB().getName());
          }
        });
      }
    });
  }

}
