package org.gquery.gwtcases.client.cases.js;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;



// 
public class CaseInsertJsQuery implements EntryPoint {

    final static String AT_PUBID = "YOUR-PUBID";
    final static String AT_URL = "https://s7.addthis.com/js/300/addthis_widget.js#domready=1";
    
    public void onModuleLoad() {

    }
    
    public void loadJQueryUI() {
      ScriptInjector.fromUrl("http://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js")
      .setWindow(ScriptInjector.TOP_WINDOW).setCallback(new Callback<Void, Exception>() {
          @Override
          public void onSuccess(Void arg0) {
              GWT.log("Success to load jQuery library");
              ScriptInjector.fromUrl("http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.23/jquery-ui.min.js").setWindow(ScriptInjector.TOP_WINDOW).inject(); 
          }

          @Override
          public void onFailure(Exception arg0) {
              GWT.log("Failed to load jQuery library");
          }
      }).inject();
      
    }
    
  
}
