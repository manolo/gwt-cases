package org.gquery.gwtcases.client.cases.gquery;

import static com.google.gwt.query.client.GQuery.*;

import java.util.TreeMap;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.plugins.effects.ClipAnimation.Action;
import com.google.gwt.query.client.plugins.effects.ClipAnimation.Corner;
import com.google.gwt.query.client.plugins.effects.ClipAnimation.Direction;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SimpleHtmlSanitizer;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

public class CaseGQuerySatinize implements EntryPoint {
  
  public void onModuleLoad() {
    
    final TextArea ar = new TextArea();
    final HTML h = new HTML();
    Button b = new Button("B1");
    Button b2 = new Button("B2");
    

    
    
    RootPanel.get().add(ar);
    RootPanel.get().add(h);
    RootPanel.get().add(b);
    RootPanel.get().add(b2);
    
    b.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        SafeHtmlBuilder sb = new SafeHtmlBuilder();
        sb.appendHtmlConstant("aaa" + Random.nextInt() + ">>>" + ar.getValue());
        h.setHTML(sb.toSafeHtml());
      }
    });
    
    b2.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        h.setHTML(SimpleHtmlSanitizer.sanitizeHtml(ar.getValue()));
      }
    });
    
  }
  
}
