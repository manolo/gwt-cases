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
public class CaseGQuerySerializeForm implements EntryPoint {
  
  public void onModuleLoad() {
    String h = "<form id='form' action='javascript:;' method='post' data-field='form'><input class='rounded' name='username' size='20' type='text' data-field='username' value='true'><input class='rounded' name='password' size='20' type='password' data-field='password' value='bar'><button class='submit' type='submit' value='Login' data-field='button'><br></form>";
    GQuery g = $(h).appendTo(document);
    
    Properties data = Properties.create();
    for (Element e : $("form input").elements()) {
      data.set($(e).attr("name"), $(e).val());
    }
    System.out.println(data.toJsonString());
    System.out.println(data.toQueryString());
    Object o = data.get("username");
    System.out.println(o.getClass());
    
    

//    GQuery.post("/my_servlet", data, new Function() {
//      public void f() {
//        String response = arguments(0);
//      };
//    });
//    
//    
//    String payload = "";
//    Element e = DOM.getElementById("form");
//    for (int i = 0, l = e.getChildCount(); i < l; i++) {
//      Element c = e.getChild(i).cast();
//      if (c.getTagName().toLowerCase().matches("input")) {
//        String name = c.<InputElement> cast().getName();
//        String value = c.<InputElement> cast().getValue();
//        payload += name + "=" + value + "&";
//      }
//    }
//    System.out.println(payload);
//
//    RequestBuilder b = new RequestBuilder(RequestBuilder.POST, "/my_servlet");
//    try {
//      b.sendRequest(payload, new RequestCallback() {
//        public void onResponseReceived(Request req, Response resp) {
//           String response = resp.getText();
//        }
//
//        public void onError(Request request, Throwable exception) {
//        }
//      });
//    } catch (RequestException ex) {
//      ex.printStackTrace();
//    }
    
  }
  
}
