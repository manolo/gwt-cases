package org.gquery.gwtcases.client.cases;

import static com.google.gwt.query.client.GQuery.$;
import static com.google.gwt.query.client.GQuery.document;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.query.client.Properties;
import com.google.gwt.text.client.LongParser;
import com.google.gwt.text.client.LongRenderer;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.LongBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ValueBox;

@SuppressWarnings("unused")
public class CaseLongBox implements EntryPoint {
  
  private static native NumberFormat r() /*-{
    return @com.google.gwt.i18n.client.NumberFormat::cachedDecimalFormat;
  }-*/;

    private static native void changeCachedDecimalFormat(NumberFormat f) /*-{
      @com.google.gwt.i18n.client.NumberFormat::cachedDecimalFormat = f;
    }-*/;
  
    public class MyLongBox extends ValueBox<Long> {
      public MyLongBox() {
        super(Document.get().createTextInputElement(), 
              new AbstractRenderer<Long>() {
                public String render(Long l) {
                  return l == null ? "" : l.toString();
                }
              },
              LongParser.instance());
      }
    }
  

  public void onModuleLoad() {
    NumberFormat f = NumberFormat.getFormat("#,##0.0#");
    double d = f.parse("2,123");
    System.out.println(Integer.toString((int)d));

    
    MyLongBox mb = new MyLongBox();
    mb.setValue(1234566l);
    RootPanel.get().add(mb);
    
    LongBox lb = new LongBox();
    lb.setValue(1234566l);
    RootPanel.get().add(lb);
    
    System.out.println(NumberFormat.getDecimalFormat().format(123456));
    changeCachedDecimalFormat(NumberFormat.getFormat("###0"));

    LongBox hb = new LongBox();
    hb.setValue(1234566l);
    RootPanel.get().add(hb);
  }
  
}
