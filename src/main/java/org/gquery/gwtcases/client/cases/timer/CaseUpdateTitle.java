package org.gquery.gwtcases.client.cases.timer;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

// http://stackoverflow.com/questions/17701743/how-can-i-change-page-title-periodically-and-switch-the-change-on-off/17705330#comment25831944_17705330
public class CaseUpdateTitle implements EntryPoint {

  public void onModuleLoad() {
    // create just an instance of the timer
    final MyUpdateTitleTimer mytimer = new MyUpdateTitleTimer();
    // To Start the updater
    mytimer.setPrefix("> ");

    new Timer() {
      public void run() {
        // To Stop set the prefix to null
        mytimer.setPrefix(null);
      }
    }.schedule(10000);

    new Timer() {
      public void run() {
        // To Stop set the prefix to null
        mytimer.setPrefix("*");
      }
    }.schedule(20000);

  }

  class MyUpdateTitleTimer extends Timer {
    private String prefix;
    private String title;
    private boolean b;

    public void run() {
      String s = (b = !b) ? prefix + title : title;
      Window.setTitle(s);
    }

    public void setPrefix(String prefix) {
      if (title != null) {
        Window.setTitle(title);
      }
      this.prefix = prefix;
      if (prefix == null) {
        cancel();
      } else {
        title = Window.getTitle();
        scheduleRepeating(300);
      }
    }
  }
}
