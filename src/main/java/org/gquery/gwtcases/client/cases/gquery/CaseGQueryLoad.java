package org.gquery.gwtcases.client.cases.gquery;

import static com.google.gwt.query.client.GQuery.*;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;

// http://stackoverflow.com/questions/18751561/gwtquery-load-replaces-element
public class CaseGQueryLoad implements EntryPoint {
    
    public void onModuleLoad() {
      SimplePanel sp = new SimplePanel();
      sp.getElement().setId("stuff");
      RootLayoutPanel root = RootLayoutPanel.get();
      root.add(sp);
      $("#stuff").load("hello.html");
    }

}
