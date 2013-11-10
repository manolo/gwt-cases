package org.gquery.gwtcases.client.cases;

import static com.google.gwt.query.client.GQuery.$;
import static com.google.gwt.query.client.GQuery.document;

import com.google.gwt.core.client.Duration;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.query.client.Function;
import com.google.gwt.user.client.Window;

public class StringBuilderPerformance implements EntryPoint {

  double str, sbd, sbf;
  
  public void onModuleLoad() {
    $("div").remove();
    $("<button>run</button>Loops: <input type='text' value=5000 /><div id=r></div>").appendTo(document);
    $("button").click(new Function(){public void f() {
      run(Integer.parseInt($("input").val()), 2000);
    }});
  }
  
  public void run(final int i, final int n) {
    str = sbd = sbf = 0;
    
    Scheduler.get().scheduleFixedDelay(new RepeatingCommand() {
      int c = i;
      public boolean execute() {
        while(c-- > 0) {
          str += string(n);
          sbd += builder(n);
          sbf += buffer(n);
          if (c%20 == 0) return true;
        }
        double max = Math.max(str, Math.max(sbd,sbf));
        $("#r").html(
          "<br/>User agent: " + Window.Navigator.getUserAgent() + 
          "<br/>Total operations: " + (i*n) + "<br/>" +
          format(str, max) + "-> String += <br/>" +
          format(sbd, max) + "-> StringBuilder <br/>" +
          format(sbf, max) + "-> StringBuffer");
        return false;
      }
    }, 0);
  }
  
  public String format(double d, double max) {
    return (long)d + " ms. " + (d == max ? "" : ((int)((max-d)*100/max) + "% faster."));
  }
  
  public double string(int n) {
    double s = Duration.currentTimeMillis();
    String s1 = "";
    for (int i = 0; i < n; i++) {
      s1 += "ALGO1" + "1234567890";
    }
    return Duration.currentTimeMillis() - s;
  }

  public double builder(int n) {
    double s = Duration.currentTimeMillis();
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < n; i++) {
      b.append("ALGO2").append("1234567890");
    }
    return Duration.currentTimeMillis() - s;
  }
  
  public double buffer(int n) {
    double s = Duration.currentTimeMillis();
    StringBuffer b = new StringBuffer();
    for (int i = 0; i < n; i++) {
      b.append("ALGO3").append("1234567890");
    }
    return Duration.currentTimeMillis() - s;
  }
}
