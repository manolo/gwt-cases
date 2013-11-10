package org.gquery.gwtcases.client.cases;

import static com.google.gwt.query.client.GQuery.*;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.query.client.Properties;
import com.google.gwt.query.client.js.JsUtils;

/**
 * http://stackoverflow.com/questions/16932612/jsni-wrapper-object/16937695#16937695
 */
public class CaseGProperties implements EntryPoint {
  
  private native void export() /*-{
    $wnd.$ = {
       pnotify: function(a) {
         alert(a);
         $wnd.a = a;
       }
    }
  }-*/;

  public void onModuleLoad() {
    export();
    
    String title = "title";
    String text = "title";
    String type = "title";
    
    // Create a JSO and set the properties
    Properties p =  Properties.create();
    p.set("title", title);
    p.set("text", text);
    p.set("type", type);
    
    // Gwt the JSO which has the function we want to call
    JavaScriptObject $ = JsUtils.prop(window, "$");
    
    // Call the JS method and get the returned result
    // ret will be null if the native js function returns void
    Object ret = JsUtils.runJavascriptFunction($, "pnotify", p);
    
    System.out.println(ret);
    
  }
  
}
