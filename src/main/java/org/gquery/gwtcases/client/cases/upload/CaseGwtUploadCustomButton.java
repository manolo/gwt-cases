package org.gquery.gwtcases.client.cases.upload;

import gwtupload.client.BaseUploadStatus;
import gwtupload.client.HasProgress;
import gwtupload.client.IFileInput.FileInputType;
import gwtupload.client.IUploadStatus;
import gwtupload.client.IUploader;
import gwtupload.client.SingleUploader;

import java.util.List;
import java.util.Set;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;


public class CaseGwtUploadCustomButton implements EntryPoint {
  
  public static class MyStatusBar extends BaseUploadStatus {
    // progress bar using HTML5 <progress> tag
    // Note that it does not works in earlier versions to IE10.
    public static class MyProgressBar extends Widget implements HasProgress {
      public MyProgressBar() {
        setElement(Document.get().createElement("progress"));
      }
      public void setProgress(long done, long total) {
        getElement().setAttribute("max", "" + total);
        getElement().setAttribute("value", "" + done);
      }
    }
    
    public MyStatusBar() {
      setProgressWidget(new MyProgressBar());
    }
  }
  
  public static class MyFancyStatusBar extends HTML implements IUploadStatus {
    Status status;
    UploadStatusChangedHandler statusChangedHandler;
    
    // progress works in IE10 but not in earlier. Other browsers support it though.
    Element progress = Document.get().createElement("progress");
    Element text = Document.get().createElement("span");
    
    public MyFancyStatusBar() {
      getElement().appendChild(progress);
      getElement().appendChild(text);
    }
    
    public void setProgress(long done, long total) {
      progress.setAttribute("max", "" + total);
      progress.setAttribute("value", "" + done);
    }
    
    public Widget asWidget() {
      return this;
    }
    public Widget getWidget() {
      return this;
    }

    // If you set a cancel button you have to handle this
    public HandlerRegistration addCancelHandler(UploadCancelHandler handler) {
      return null;
    }
    public Status getStatus() {
      return status;
    }

    // Multiupload widget uses this
    public IUploadStatus newInstance() {
      return new MyFancyStatusBar();
    }

    public void setCancelConfiguration(Set<CancelBehavior> config) {
    }

    // Here you can use your own mechanism to show error messages to the user
    public void setError(String error) {
      Window.alert(error);
    }

    public void setFileNames(List<String> names) {
      text.setInnerText(names.toString());
    }

    public void setI18Constants(UploadStatusConstants strs) {
    }

    public void setStatus(Status status) {
      text.setInnerText(status.toString());
      statusChangedHandler.onStatusChanged(this);
    }

    public void setStatusChangedHandler(UploadStatusChangedHandler handler) {
      statusChangedHandler = handler;
    }
  }
  
  public static class MyFancyLookingButton extends Composite implements HasClickHandlers {
    public MyFancyLookingButton() {
      DecoratorPanel widget = new DecoratorPanel();
      initWidget(widget);
      widget.setWidget(new HTML("Choose ..."));
    }

    public HandlerRegistration addClickHandler(ClickHandler handler) {
      return addDomHandler(handler, ClickEvent.getType());
    }
  }

  public void onModuleLoad() {
    MyFancyLookingButton button = new MyFancyLookingButton();
    RootPanel.get().add(button);
    
    IUploader uploader = new SingleUploader(FileInputType.BUTTON, new MyStatusBar());
    RootPanel.get().add(uploader);
    
    gwtupload.client.Utils.basename(uploader.getFileInput().getName());
    
  }

}
