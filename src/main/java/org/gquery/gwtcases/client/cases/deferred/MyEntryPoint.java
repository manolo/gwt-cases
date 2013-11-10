package org.gquery.gwtcases.client.cases.deferred;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Window;

// http://stackoverflow.com/questions/19283162/detect-if-no-javascript-is-build-for-specific-browser-in-gwt/19288044#19288044
public class MyEntryPoint implements EntryPoint {
  
  public static class App {
    public void onLoad() {
      Window.alert("This App is only supported in IE");
    }
  }
  public static class AppIE extends App {
    public void onLoad() {
      Window.alert("This is a supported Browser");
    }
  }

  public void onModuleLoad() {
    App app = GWT.create(App.class);
    app.onLoad();
  }

}
