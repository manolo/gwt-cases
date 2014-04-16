package org.gquery.gwtcases.client.cases;

import static com.google.gwt.query.client.GQuery.*;

import java.util.Collection;
import java.util.logging.Level;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.Properties;
import com.google.gwt.user.client.Window;

// http://stackoverflow.com/questions/16080099/calling-gwt-java-function-from-javascript-solved/16081350#16081350
// http://stackoverflow.com/questions/16098288/gwt-passing-java-arrays-to-javascript
public class CaseExportFunction implements EntryPoint {

  public static void handleAnchorClick(JsArrayMixed args) {
    Window.alert("Current row and Column is " + args.getNumber(0) + "  " + args.getNumber(1));
  }

  public static native void exportMyFunction()/*-{
    $wnd.handleAnchorClick_0 = @org.gquery.gwtcases.client.cases.CaseExportFunction::handleAnchorClick(*);
  }-*/;

  @ExportPackage("m")
  @Export("MyClass")
  public static class MyClass implements Exportable {
    public MyClass(String s) {
      // TODO Auto-generated constructor stub
    }
    @Export("$wnd.handleAnchorClick_1")
    public static void handleAnchorClick(double[] args) {
      Window.alert("Current row and Column is " + args[0] + "  " + args[1]);
    }

    @Export("$wnd.handleAnchorClick_3")
    public static void handleAnchorClick(int param1, int param2, int[] a1, int[] a2) {
      System.out.println(param1);
      System.out.println(param2);
      System.out.println(a1[0]);
      System.out.println(a2[0]);

    }
    
    @Export
    public void foo(int[] arr, String a){
      System.out.println("Called with 2 params");
//      logger.log(Level.FINEST, "called with 2 params");
//      foo(arr, a, "otherstring");
    }
    @Export
    public void foo(int[] arr, String a, String b){
      System.out.println("Called with 3 params");
//      logger.log(Level.FINEST, "called with 3 params");
    }
  }

  public void onModuleLoad() {
    exportMyFunction();

    GWT.create(MyClass.class);
    
//    new MyClassExporterImpl();

    Properties wnd = window.cast();

    wnd.setFunction("handleAnchorClick_2", new Function() {
      public void f() {
        // Get the js arguments[] array
        JsArrayMixed args = arguments(0);
        // Get the first element of the arguments[] array
        JsArrayMixed ary = args.getObject(0);
        Window.alert("Current row and Column is " + ary.getNumber(0) + "  " + ary.getNumber(1));
      }
    });
  }
}
