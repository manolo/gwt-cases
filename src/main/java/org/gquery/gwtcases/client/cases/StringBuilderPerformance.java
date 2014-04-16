package org.gquery.gwtcases.client.cases;

import static com.google.gwt.query.client.GQuery.$;
import static com.google.gwt.query.client.GQuery.document;

import java.math.BigInteger;
import java.util.Random;

import com.google.gwt.core.client.Duration;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.user.client.Window;



// http://stackoverflow.com/questions/1532461/stringbuilder-vs-string-concatenation-in-tostring-in-java
// http://docs.oracle.com/javase/specs/jls/se5.0/html/expressions.html#15.18.1.2
// https://github.com/gwtquery/gwtquery/pull/22#discussion_r3691499
// https://groups.google.com/forum/#!topic/Google-Web-Toolkit/OgzAs6tqJ-U
// https://groups.google.com/forum/#!topic/google-web-toolkit/st48LA5ANDw

/**
 *  
 * @author Manuel Carrasco Moñino
 */
public class StringBuilderPerformance implements EntryPoint {
  
  public void onModuleLoad() {
    int DefaultSyncLoops = GQuery.browser.msie ? GQuery.browser.ie6 ? 30000 : 50000: GQuery.browser.mozilla ? 100000 : 500000;
    $("body").empty();
    $("<h2>GWT String concat/plus vs StringBuilder vs StringBuffer</h2>"
        + "<div>Async loops: <input id='a' type='text' value=5000 /><span> Appends per loop: 2000 </span>"
        + ", Sync loops: <input id='s' type='text' value=" + DefaultSyncLoops + " />"
        + " <button>run</button></div><div id=r></div>").appendTo(document);
    $("button").click(new Function(){public void f() {
      run(Integer.parseInt($("#a").val()), 2000, Integer.parseInt($("#s").val()));
    }});
  }
  
  public void run(final int nLoops, final int nAppends, final int nSyncLoops) {
    final String toAppend = rndString();
    
    Scheduler.get().scheduleFixedDelay(new RepeatingCommand() {
      int c = nLoops;
      double strMs = 0, sbdMs = 0, sbfMs = 0;

      public boolean execute() {
        while(c-- > 0) {
          strMs += runString(nAppends, toAppend);
          sbdMs += runBuilder(nAppends, toAppend);
          sbfMs += runBuffer(nAppends, toAppend);
          if (c%20 == 0) return true;
        }
        double maxMs = Math.max(strMs, Math.max(sbdMs,sbfMs));
        $("#r").html(
          "<br/>User agent: " + Window.Navigator.getUserAgent() + 
          "<br/><br/>Asynchronous: " + nLoops + " loops.<br/>" +
          format(strMs, maxMs, "String append (+=)")  +
          format(sbdMs, maxMs, " StringBuilder") +
          format(sbfMs, maxMs, "StringBuffer") + 
          "<br/>Synchronous: " + nSyncLoops + " loops.<br/>" +
          runSynchronousTest(nSyncLoops, toAppend));
        return false;
      }
    }, 0);
  }
  
  
  //  ... JS obfuscated code for async code
  //  
  //  ... Common functions  
  //  function S(){return (new Date).getTime()}
  //  function cc(){}  
  //  function ac(a,b){a.b+=b}
  //  
  //  ... String concatenation
  //  var on=''
  //  function Hm(a,b){var c,d,e;d=S();e=on;for(c=0;c<a;c++){e+='ALGO1'+b}return S()-d}
  //  
  //  ... StringBuilder
  //  function zl(a){a.b=new cc}
  //  function Bl(){zl(this)}
  //  function Al(a,b){ac(a.b,b);return a}
  //  function Dm(a,b){var c,d,e;e=S();c=new Bl;for(d=0;d<a;d++){Al((ac(c.b,'ALGO2'),c),b)}return S()-e}  
  //  
  //  ... StringBuffer
  //  function wl(){this.b=new cc}
  //  function vl(a,b){ac(a.b,b);return a}
  //  function Cm(a,b){var c,d,e;e=S();c=new wl;for(d=0;d<a;d++){vl((ac(c.b,'ALGO3'),c),b)}return S()-e}
  public double runString(int n, String a) {
    double s = Duration.currentTimeMillis();
    String s1 = "";
    for (int i = 0; i < n; i++) {
      s1 += "ALGO1" + a;
    }
    return Duration.currentTimeMillis() - s;
  }

  public double runBuilder(int n, String a) {
    double s = Duration.currentTimeMillis();
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < n; i++) {
      b.append("ALGO2").append(a);
    }
    return Duration.currentTimeMillis() - s;
  }
  
  public double runBuffer(int n, String a) {
    double s = Duration.currentTimeMillis();
    StringBuffer b = new StringBuffer();
    for (int i = 0; i < n; i++) {
      b.append("ALGO3").append(a);
    }
    return Duration.currentTimeMillis() - s;
  }
  
  public String format(double d, double max, String name) {
    return (long)d + " ms. " + (d == max ? "the slowest." : ((int)((max-d)*100/max) + "% faster.")) + " " + name + "<br/>";
  }
  
  private String rndString() {
    return new BigInteger(130, new Random()).toString(32);
  }
  
  
  //  ... JS obfuscated code for sync code
  //
  //  ... Common functions
  //  function cc(){}
  //  function ac(a,b){a.b+=b}
  //
  //  ... StringBuffer
  //  function vl(a){a.b=new cc}
  //  function yl(){vl(this);ac(this.b,'APPENDSF')}
  //  c=new yl;
  //  for(g=0;g<a;g++){ac(c.b,b)}
  //
  //  ... StringBuilder
  //  function Bl(a){a.b=new cc}
  //  function Fl(){Bl(this);ac(this.b,'APPENDSB')}
  //  r=new Fl;
  //  for(j=0;j<a;j++){ac(r.b,b)}
  //
  //  ... String concat
  //  o='APPENDSC';
  //  for(f=0;f<a;f++){o+=b}
  public String runSynchronousTest(int loops, String toAppend) {

    double bs = Duration.currentTimeMillis();
    StringBuffer b = new StringBuffer("APPENDSF");
    for (int i=0; i<loops; i++) {
      b.append(toAppend);
    }
    double be = Duration.currentTimeMillis() - bs;

    double us = Duration.currentTimeMillis();
    StringBuilder u = new StringBuilder("APPENDSB");
    for (int i=0; i<loops; i++) {
      u.append(toAppend);
    }
    double ue = Duration.currentTimeMillis() - us;
    
    String s = "APPENDSC";
    double ss = Duration.currentTimeMillis();
    for (int i=0; i<loops; i++) {
      s += toAppend;
    }
    double se = Duration.currentTimeMillis() - ss;
    
    double max = Math.max(be, Math.max(ue, se));
    
    return (format(se, max, "  String (+=)") 
        + format(be, max, "  StringBuffer")
        + format(ue, max, "  StringBuilder"));
  }
  

}
