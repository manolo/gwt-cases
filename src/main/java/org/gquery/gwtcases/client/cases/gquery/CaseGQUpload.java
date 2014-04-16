package org.gquery.gwtcases.client.cases.gquery;

import static com.google.gwt.query.client.GQuery.*;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.query.client.*;
import com.google.gwt.query.client.js.JsUtils;
import com.google.gwt.query.client.plugins.ajax.Ajax;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.RootPanel;

public class CaseGQUpload implements EntryPoint {
  
  public void onModuleLoad() {
    final String url = "http://gwtupload.alcala.org/gupld/gwtuploadsample.SingleUploadSample/servlet.gupld";

    final FileUpload fileUpload = new FileUpload();
    RootPanel.get().add(fileUpload);
    
    $(fileUpload)
      // FileUpload does not have a way to set the multiple attribute, we use gQuery    
      .prop("multiple", true)
      // We use gQuery events mechanism 
      .on("change", new Function() {
        public void f() {
          // Use gQuery utils to create a FormData object instead of JSNI
          JavaScriptObject form = JsUtils.runJavascriptFunction(window, "eval", "new FormData()");
          // Get an array with the files selected
          JsArray<JavaScriptObject> files =  $(fileUpload).prop("files");
          // Add each file to the FormData
          for (int i = 0, l = files.length(); i < l; i++) {
            JsUtils.runJavascriptFunction(form, "append", "file-" + i, files.get(i));
          }
          
          // Use gQuery ajax instead of RequestBuilder because it supports FormData and progress
          Ajax.ajax(Ajax.createSettings()
              .setUrl(url)
              .setData((Properties)form))
            // gQuery ajax return a promise 
            .done(new Function() {
              public void f() {
                console.log("Files uploaded, server response is: " + arguments(0));
              }
            })
            .fail(new Function() {
              public void f() {
                console.log("Something went wrong: " + arguments(0));
              }
            })            
            .progress(new Function() {
              public void f() {
                double total = arguments(0);
                double done = arguments(1);
                double percent = arguments(2);
                console.log("Uploaded " + done + "/" + total + " (" + percent + "%)");
              }
            });
        }
    });      
  }
  
}
