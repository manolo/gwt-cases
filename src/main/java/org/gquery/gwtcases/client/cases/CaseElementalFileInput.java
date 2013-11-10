package org.gquery.gwtcases.client.cases;

import static com.google.gwt.query.client.GQuery.$;
import static com.google.gwt.query.client.GQuery.document;
import static elemental.client.Browser.getWindow;

import com.google.gwt.core.client.EntryPoint;

import elemental.client.Browser;
import elemental.events.Event;
import elemental.events.EventListener;
import elemental.html.File;
import elemental.html.FileList;
import elemental.html.InputElement;

public class CaseElementalFileInput implements EntryPoint {
  

  public void onModuleLoad() {
    final InputElement input = Browser.getDocument().createInputElement();
    input.setType("file");
    input.setMultiple(true);
    
    $(input).appendTo(document);

    input.addEventListener("change", new EventListener() {
      public void handleEvent(Event evt) {
        FileList list = input.getFiles();
        for (int i = 0; i < list.getLength(); i++) {
          File file = list.item(i);
          getWindow().getConsole().log(file.getName() + " " + file.getSize());
        }
      }
    });   
  }

}
