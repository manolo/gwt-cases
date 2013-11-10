package org.gquery.gwtcases.client.cases.upload;

import gwtupload.client.MultiUploader;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.PopupPanel;


public class CaseGwtUploadIssues implements EntryPoint {
  
  

  public void onModuleLoad() {
    MultiUploader defaultUploader = new MultiUploader();
    defaultUploader.setMaximumFiles(1);
    PopupPanel p = new PopupPanel();
    p.setWidget(defaultUploader);
    p.show();
    
    
    
  }  

}
