package org.gquery.gwtcases.client.cases.upload;

import gwtupload.client.IFileInput.FileInputType;
import gwtupload.client.IUploader;
import gwtupload.client.ModalUploadStatus;
import gwtupload.client.SingleUploaderModal;
import gwtupload.client.Uploader.FormFlowPanel;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.RootPanel;


public class CaseGwtUploadFileUpload implements EntryPoint {
  
  

  public void onModuleLoad() {
    
    
    
    FormPanel formUpload  = new FormFlowPanel();
    
    Button myButton = new Button("MyText"){public void setText(String text) {}};

    IUploader fuFile = new SingleUploaderModal(
        FileInputType.BROWSER_INPUT,
        new ModalUploadStatus(),
        myButton,
        formUpload);
    
    

    RootPanel.get().add(fuFile);

    
    

  }  

}
