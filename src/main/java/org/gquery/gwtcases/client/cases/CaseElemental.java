package org.gquery.gwtcases.client.cases;

import static elemental.client.Browser.getDocument;
import static elemental.client.Browser.getWindow;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.query.client.builders.JsonBuilder;

import elemental.dom.TimeoutHandler;
import elemental.events.Event;
import elemental.events.EventListener;
import elemental.html.ButtonElement;
import elemental.html.DivElement;
import elemental.xml.XMLHttpRequest;

public class CaseElemental implements EntryPoint {
  
  String json = "{\"testLong\":\"3234345\",\"testDate\":\"2013-04-11T06:09:36.489Z\",\"testString\":\"sathya\",\"testDouble\":\"123.98\",\"testInt\":\"123\"}";

  public void onModuleLoad() {
    final ButtonElement btn = getDocument().createButtonElement();
    btn.setInnerHTML("w00t?");
    btn.getStyle().setColor("red");
    getDocument().getBody().appendChild(btn);

    final DivElement div = getDocument().createDivElement();
    getDocument().getBody().appendChild(div);

    EventListener listener = new EventListener() {
      public void handleEvent(Event evt) {
        final XMLHttpRequest xhr = getWindow().newXMLHttpRequest();
        xhr.setOnload(new EventListener() {
          @Override
          public void handleEvent(Event evt) {
            div.setInnerHTML(xhr.getResponseText());
          }
        });
        xhr.open("GET", "/snippet.html");
        xhr.send();

        getWindow().setTimeout(new TimeoutHandler() {
          public void onTimeoutHandler() {
            getWindow().alert("timeout fired");
          }
        }, 1000);

        btn.removeEventListener(Event.CLICK, this, false);
      }
    };

    btn.addEventListener(Event.CLICK, listener, false);    
  }

  static interface MyBean extends JsonBuilder {
    Long getTestLong();
    Double getTestDouble();
    Integer getTestInt();
    String getTestString();
    String getTestDate();
  }
}
