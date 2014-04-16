package org.gquery.gwtcases.client.cases.upload;

import static com.google.gwt.query.client.GQuery.*;
import gwtupload.client.BaseUploadStatus;
import gwtupload.client.IFileInput.FileInputType;
import gwtupload.client.IUploadStatus.Status;
import gwtupload.client.IUploader;
import gwtupload.client.IUploader.OnChangeUploaderHandler;
import gwtupload.client.IUploader.OnFinishUploaderHandler;
import gwtupload.client.SingleUploader;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;


// http://stackoverflow.com/questions/20883743/gwtupload-file-upload-handlers

public class CaseGwtUploadCustomButton2 implements EntryPoint {
  
  
  
  public class CustomButton extends Composite implements HasClickHandlers {
    DecoratorPanel widget;

    public CustomButton() {
      Window.alert("aaa");
      widget = new DecoratorPanel();

      widget.setStyleName("aaa");
      widget.setSize("100px", "38px");
      widget.setStylePrimaryName("bbb");
      widget.setTitle("label");

      SimplePanel simplePanel = new SimplePanel();
      Label label = new Label("label");
      label.setStyleName("ccc");
      simplePanel.add(label);

      widget.add(simplePanel);
      initWidget(widget);

    }
    public HandlerRegistration addClickHandler(ClickHandler handler) {
      return addDomHandler(handler, ClickEvent.getType());
    }


  }
  
  public void onModuleLoad() {
//    $(document).empty();
    
    SingleUploader fileUpload;

//    setAction(actionUrl);

//    setEncoding(FormPanel.ENCODING_MULTIPART);
//    setMethod(FormPanel.METHOD_POST);

    CustomButton button = new CustomButton();

    fileUpload = new SingleUploader(FileInputType.CUSTOM.with(button), new BaseUploadStatus() {
      public void setError(String msg) {
        setStatus(Status.ERROR);
        System.out.println("EEEE " + msg);
      }
    });

    fileUpload.setTitle("customFileUpload");

    // deletes the "send/submit" button from upload widget
    fileUpload.setAutoSubmit(true);

    RootPanel.get().add(fileUpload);

    fileUpload.addOnChangeUploadHandler(new OnChangeUploaderHandler() {

        @Override
        public void onChange(IUploader uploader) {

            if (uploader.getStatus() == Status.CHANGED) {
                GWT.log("File input status changed.");
                // TODO ui message.
            }
        }
    });

    fileUpload.addOnFinishUploadHandler(new OnFinishUploaderHandler() {

        @Override
        public void onFinish(IUploader uploader) {

            if (uploader.getStatus() == Status.SUCCESS) {
                GWT.log("File upload successfully.");
//                submit();
            }
        }
    });
    
  }

}
