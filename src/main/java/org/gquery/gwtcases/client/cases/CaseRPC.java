package org.gquery.gwtcases.client.cases;

import org.gquery.gwtcases.client.GreetingService;
import org.gquery.gwtcases.client.GreetingServiceAsync;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportClosure;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;
import org.timepedia.exporter.client.ExporterUtil;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;


// http://stackoverflow.com/questions/20709611/can-java-objects-be-accessed-from-javascript-in-gwt/20787575#20787575
public class CaseRPC implements EntryPoint {
  
  public static abstract class AbstractCallback<T> implements AsyncCallback<T> {
    public void onFailure(Throwable caught) {
      GWT.getUncaughtExceptionHandler().onUncaughtException(caught);
    }

    public abstract void onSuccess(T result);
  }
  
  
    @ExportPackage("foo")
    @Export
    public static class Interop implements Exportable {
      final static GreetingServiceAsync service = GWT.create(GreetingService.class);
  
      public static void greeting(String message, final InteropCallback success, final InteropCallback error) {
        service.greetServer(message, new AsyncCallback<String>() {
          public void onFailure(Throwable caught) {
            error.exec(caught.getMessage());
          }
          public void onSuccess(String result) {
            success.exec(result);
          }
        });
      }
    }
    
    @ExportClosure
    public static interface InteropCallback extends Exportable {
      void exec(String message);
    }
  
    @Override public void onModuleLoad() {
      ExporterUtil.exportAll();

//    GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
//      @Override public void onUncaughtException(Throwable e) {
//        e.printStackTrace();
//        String s = e.getClass().getName() + ": " + e.getMessage();
//        for (StackTraceElement element : e.getStackTrace()) {
//          s += element + "\n";
//        }
//        System.out.println(s);
//      }
//    });
//
//    final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
//    final String textToServer = "foo";
//    greetingService.greetServer(textToServer, new AsyncCallback<String>() {
//      int tries = 0;
//
//      public void onSuccess(String result) {
//          // Do something
//        }
//      public void onFailure(Throwable caught) {
//        if (tries++ < 3) {
//          greetingService.greetServer(textToServer, this);
//        }
//      }
//    });
//
//    // Then, we send the input to the server.
//    greetingService.greetServer(textToServer, new AbstractCallback<String>() {
//      @Override public void onSuccess(String result) {
//        System.out.println("OK " + result);
//      }
//    });
//
//    RequestBuilder b = new RequestBuilder(RequestBuilder.POST, "whatever");
//    try {
//      b.sendRequest("", new RequestCallback() {
//        @Override public void onResponseReceived(Request request, Response response) {
//          }
//
//        @Override public void onError(Request request, Throwable exception) {
//          }
//      });
//    } catch (RequestException e1) {
//      // TODO Auto-generated catch block
//      e1.printStackTrace();
//    }
//
//    com.google.gwt.user.client.Timer t = new com.google.gwt.user.client.Timer() {
//      @Override public void run() {
//        greetingService.greetServer(textToServer, new AbstractCallback<String>() {
//          public void onSuccess(String result) {
//            if (result != null) {
//              Window.alert("Done! Cancelling...");
//              cancel();
//            }
//          }
//        });
//      }
//    };
//    t.scheduleRepeating(5000);

  }
}
