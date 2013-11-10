package org.gquery.gwtcases.client.cases.gquery;

import static com.google.gwt.query.client.GQuery.*;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;

public class CaseGQueryBrowserFlags implements EntryPoint {
    
    public void onModuleLoad() {
      
      System.out.println(browser);
      if (browser.ie6) {
        Window.alert(">>>>> IE6");
      } else if (browser.safari) {
        Window.alert(">>>>> SAFARI");
      } else if (browser.webkit) {
        Window.alert(">>>>> WEBKIT");
      } else if (browser.mozilla) {
        Window.alert(">>>>> MOZILLA");
      }
      
    }

}
