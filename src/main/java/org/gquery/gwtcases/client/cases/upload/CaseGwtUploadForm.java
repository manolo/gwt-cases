package org.gquery.gwtcases.client.cases.upload;

import gwtupload.client.IUploader;
import gwtupload.client.SingleUploader;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;


public class CaseGwtUploadForm implements EntryPoint {
  
  

  public void onModuleLoad() {
    
    IUploader suploader = new SingleUploader();
    TextBox t1 = new TextBox();
    TextArea t2 = new TextArea();
    
    suploader.add(t1);
    suploader.add(t2);
    suploader.setMultipleSelection(true);
    
    RootPanel.get().add(suploader);
    
  }  

}
