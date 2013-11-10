package org.gquery.gwtcases.client.cases.js;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.query.client.Properties;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.RootPanel;

public class CaseeinterpretCast implements EntryPoint {

    public void onModuleLoad() {
      JsArrayString a = JsonUtils.unsafeEval("['foo', 'bar', 'baz']");
      
      JavaScriptObject j = JsonUtils.safeEval("[\"foo\", \"bar\", \"baz\"]");
      
      

  
      String s[] = toArray(a);
      
      List<String> l = Arrays.asList(s);
      
      Window.alert("" + a);
      Window.alert("" + j);
      Window.alert("" + j.<Properties>cast().toJsonString());
      Window.alert("" + s);
      
      // Create a new iframe
      final Frame f = new Frame();
      f.setUrl("myfile.bin");
      // Set a size of 0px unless you want the file be displayed in it
      // For .html images .pdf, etc you have to configure your servlet
      // to send appropriate headers
      f.setSize("0px", "0px");
      RootPanel.get().add(f);
      // Configure a timer to remove the element from the DOM
      new Timer() {
        public void run() {
          f.removeFromParent();
        }
      }.schedule(10000);
    }
    
    public static String[] toArray(JsArrayString values) {
      if (GWT.isScript()) {
        return reinterpretCast(values);
      } else {
        int length = values.length();
        String[] ret = new String[length];
        for (int i = 0, l = length; i < l; i++) {
          ret[i] = values.get(i);
        }
        return ret;
      }
    }
    
    private static native String[] reinterpretCast(JsArrayString value) /*-{
      return value;
    }-*/;
  
}
