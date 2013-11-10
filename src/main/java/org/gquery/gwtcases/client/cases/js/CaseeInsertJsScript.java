package org.gquery.gwtcases.client.cases.js;

import static com.google.gwt.query.client.GQuery.*;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.plugins.ajax.Ajax;



// 
public class CaseeInsertJsScript implements EntryPoint {

    final static String AT_PUBID = "YOUR-PUBID";
    final static String AT_URL = "https://s7.addthis.com/js/300/addthis_widget.js#domready=1";
    
    public void onModuleLoad() {
      ScriptInjector.fromString(
          "$wnd.addthis_config = $wnd.addthis_config||{};" +
          "$wnd.addthis_config.pubid = 'YOUR-PUBID';"
      ).inject();
      
      $(window).prop("addthis_config", $$("pubid: " + AT_PUBID));
      
      setAddthisId(AT_PUBID);
      
      Ajax.getScript(AT_URL).done(new Function(){public void f() {
        System.out.println("OK");
      }}).fail(new Function(){public void f() {
        System.out.println("FAIL");
      }});
//      ScriptInjector.fromUrl(AT_URL).setCallback(new Callback<Void, Exception>() {
//        @Override public void onSuccess(Void result) {
//          System.out.println("OK");
//        }
//        @Override public void onFailure(Exception reason) {
//          System.out.println("FAIL");
//        }
//      }) .inject();
    }
    
    private static native void setAddthisId(String id) /*-{
      $wnd.addthis_config = $wnd.addthis_config||{};
      $wnd.addthis_config.pubid = id;
    }-*/;
  
}
