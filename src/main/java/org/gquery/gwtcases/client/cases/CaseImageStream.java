package org.gquery.gwtcases.client.cases;

import static com.google.gwt.query.client.GQuery.$;
import static com.google.gwt.query.client.GQuery.$$;
import static com.google.gwt.query.client.GQuery.document;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;

// http://stackoverflow.com/questions/16082429/gwt-cyclically-loading-an-image
public class CaseImageStream implements EntryPoint {

  public void onModuleLoad() {
    
    final Image i1 = new Image();
    i1.setWidth("400px");
    
    final Image i2 = new Image();
    i2.setWidth("400px");
    
    AbsolutePanel panel = new AbsolutePanel();
    panel.add(i1, 0, 0);
    panel.add(i2, 0, 0);
    panel.setSize("600px", "400px");
    
    RootPanel.get().add(panel);
    
    final Timer loadNext = new Timer() {
      boolean b;
      int c;
      public void run() {
        String url = "screenshot" + (b? "1" : "2" ) + ".png" + "?" + c++; 
        if (b  = !b) {
          i1.setUrl(url);
        } else {
          i2.setUrl(url);
        }
      }
    };
    
    i1.addLoadHandler(new LoadHandler() {
      public void onLoad(LoadEvent event) {
        i1.getElement().getStyle().setZIndex(1);
        i2.getElement().getStyle().setZIndex(0);
        loadNext.schedule(1000);
      }
    });

    i2.addLoadHandler(new LoadHandler() {
      public void onLoad(LoadEvent event) {
        i1.getElement().getStyle().setZIndex(0);
        i2.getElement().getStyle().setZIndex(1);
        loadNext.schedule(1000);
      }
    });
    
    loadNext.schedule(1000);
    
    final GQuery images = $("<img/><img/>").appendTo(document);
    final Timer timer = new Timer() {
      int c;
      public void run() {
        boolean b = c % 2 == 0 ;
        String url = "screenshot" + (b? "1" : "2" ) + ".png" + "?aa" + c++; 
        images.eq(c%2).attr("src", url);
      }
    };
    
    images.css($$("position: fixed, top: 10px, left: 600px, width: 400px"));
    images.bind("load", new Function(){
      public void f() {
        $(this).css($$("z-index: 1")).siblings("img").css($$("z-index: 0"));
        timer.schedule(1000);
      }
    });
    
    timer.schedule(1000);
    
  }
  
}
