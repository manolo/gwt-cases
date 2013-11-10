package org.gquery.gwtcases.client.cases.upload;

import gwtupload.client.IUploader;
import gwtupload.client.MultiUploader;
import gwtupload.client.PreloadedImage;
import gwtupload.client.IUploadStatus.Status;
import gwtupload.client.IUploader.UploadedInfo;
import gwtupload.client.PreloadedImage.OnLoadPreloadedImageHandler;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;


public class CaseGwtUploadEditYourMemberView implements EntryPoint {
  
  public void onModuleLoad() {
    
    EditYouthMemberView v = new EditYouthMemberView();
    RootPanel.get().add(v);
  }
  
  
  public static class EditYouthMemberView extends Composite {

    private TextBox textBoxFirstName;
    private TextBox textBoxScoutNumber;
    private ListBox listBoxSection;
    private ListBox listBoxPack;
    private TextBox textBoxSurname;
    private DateBox dateBoxArchived;
    private DateBox dateBoxPackIn;
    private DateBox dateBoxPackOut;
    private DateBox dateBoxDOB;
    // A panel where the thumbnails of upload images will be shown
    //final FlowPanel panelImages = new FlowPanel();
    final HorizontalPanel panelImages = new HorizontalPanel();


    @SuppressWarnings("deprecation")
    public EditYouthMemberView() {       

        final java.util.Date todays_date = new java.util.Date();


        VerticalPanel verticalPanel = new VerticalPanel();
        verticalPanel.setStyleName("gwt-Banner");
        initWidget(verticalPanel);

        HorizontalPanel horizontalPanel = new HorizontalPanel();
        horizontalPanel.setStyleName("gwt-Banner");
        verticalPanel.add(horizontalPanel);
        horizontalPanel.setWidth("246px");

        Label lblHome = new Label("Home");
        lblHome.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
            }
        });
        horizontalPanel.add(lblHome);
        lblHome.setWidth("46px");

        Label lblEditAwards = new Label("Edit Awards");
        lblEditAwards.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
            }
        });
        horizontalPanel.add(lblEditAwards);
        lblEditAwards.setWidth("85px");

        Label lblListAll = new Label("List all Cub Scouts");
        lblListAll.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
            }
        });
        horizontalPanel.add(lblListAll);
        lblListAll.setWidth("130px");

        Label lblAccountUpdate = new Label("Account Update");
        lblAccountUpdate.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
            }
        });
        horizontalPanel.add(lblAccountUpdate);
        lblAccountUpdate.setWidth("104px");

        FlexTable flexTable_1 = new FlexTable();
        verticalPanel.add(flexTable_1);

        Label lblSurname = new Label("Surname");
        lblSurname.setWordWrap(false);
        lblSurname.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
        lblSurname.setStyleName("gwt-Label-Login");
        flexTable_1.setWidget(0, 2, lblSurname);

        Label lblFirstName = new Label("First Name");
        lblFirstName.setWordWrap(false);
        lblFirstName.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
        lblFirstName.setStyleName("gwt-Label-Login");
        flexTable_1.setWidget(0, 3, lblFirstName);

        textBoxSurname = new TextBox();
        flexTable_1.setWidget(1, 1, textBoxSurname);

        textBoxFirstName = new TextBox();
        flexTable_1.setWidget(1, 2, textBoxFirstName);      

        Label lblLookForPhotograph = new Label("Look for photograph:");
        lblLookForPhotograph.setWordWrap(false);
        lblLookForPhotograph.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
        lblLookForPhotograph.setStyleName("gwt-Label-Login");
        flexTable_1.setWidget(2, 1, lblLookForPhotograph);
        flexTable_1.getFlexCellFormatter().setRowSpan(2, 1, 3);

        // Attach the image viewer to the document
        flexTable_1.setWidget(0, 0, panelImages);
        panelImages.setSize("120", "120");
        flexTable_1.getFlexCellFormatter().setRowSpan(0, 0, 4);
        panelImages.clear();

        // Create a new uploader panel and attach it to a document
        final MultiUploader defaultUploader = new MultiUploader();
        flexTable_1.setWidget(3, 1, defaultUploader);
        flexTable_1.getFlexCellFormatter().setRowSpan(3, 1, 3);

        // Add a finish handler which will load the image once the upload finishes
        defaultUploader.addOnFinishUploadHandler(onFinishUploaderHandler);

        FlexTable flexTable = new FlexTable();
        verticalPanel.add(flexTable);

        Label lblDOB = new Label("Date of Birth:");
        lblDOB.setWordWrap(false);
        lblDOB.setStyleName("gwt-Label-Login");
        flexTable.setWidget(0, 0, lblDOB);
        lblDOB.setDirectionEstimator(false);
        lblDOB.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
        lblDOB.setSize("110px", "16px");

        dateBoxDOB = new DateBox();
        dateBoxDOB.setFormat(new DefaultFormat(DateTimeFormat.getFormat("dd-MM-yyyy")));
        flexTable.setWidget(0, 1, dateBoxDOB);
        dateBoxDOB.getDatePicker();

        Label lblSection = new Label("Section:");
        lblSection.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
        lblSection.setStyleName("gwt-Label-Login");
        flexTable.setWidget(0, 2, lblSection);

        listBoxSection = new ListBox();
        listBoxSection.addItem("Cubs");
        flexTable.setWidget(0, 3, listBoxSection);
        listBoxSection.setVisibleItemCount(1);

        Label lblScoutNumber = new Label("Scout Number:");
        lblScoutNumber.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
        lblScoutNumber.setStyleName("gwt-Label-Login");
        flexTable.setWidget(1, 0, lblScoutNumber);
        lblScoutNumber.setDirectionEstimator(false);
        lblScoutNumber.setSize("110px", "16px");

        textBoxScoutNumber = new TextBox();
        flexTable.setWidget(1, 1, textBoxScoutNumber);

        Label lblPack = new Label("Pack:");
        lblPack.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
        lblPack.setStyleName("gwt-Label-Login");
        flexTable.setWidget(1, 2, lblPack);

        listBoxPack = new ListBox();
        listBoxPack.addItem("Explorer");
        listBoxPack.addItem("Pioneer");
        flexTable.setWidget(1, 3, listBoxPack);
        listBoxPack.setVisibleItemCount(1);

        Label lblDateArchived = new Label("Date Archived:");
        lblDateArchived.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
        lblDateArchived.setStyleName("gwt-Label-Login");
        flexTable.setWidget(2, 0, lblDateArchived);
        lblDateArchived.setSize("110px", "16px");

        dateBoxArchived = new DateBox();
        dateBoxArchived.setFormat(new DefaultFormat(DateTimeFormat.getFormat("dd-MM-yyyy")));
        flexTable.setWidget(2, 1, dateBoxArchived);
        dateBoxArchived.getDatePicker();

        Label lblIn_1 = new Label("In:");
        lblIn_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
        lblIn_1.setStyleName("gwt-Label-Login");
        flexTable.setWidget(2, 2, lblIn_1);

        dateBoxPackIn = new DateBox();
        dateBoxPackIn.setFormat(new DefaultFormat(DateTimeFormat.getFullDateFormat()));
        flexTable.setWidget(2, 3, dateBoxPackIn);
        dateBoxPackIn.getDatePicker();

        Label lblNewLabel_3 = new Label("Out:");
        lblNewLabel_3.setStyleName("gwt-Label-Login");
        flexTable.setWidget(2, 4, lblNewLabel_3);

        dateBoxPackOut = new DateBox();
        dateBoxPackOut.setFormat(new DefaultFormat(DateTimeFormat.getFormat("dd-MM-yyyy")));
        dateBoxPackOut.getDatePicker();

        flexTable.setWidget(2, 5, dateBoxPackOut);

        Button btnAdd = new Button("Add");
        btnAdd.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                Integer tracker = 0;
                if (textBoxSurname.getText().length() == 0) {
                    tracker = tracker + 1; 
                }
                if (textBoxFirstName.getText().length() == 0) {
                    tracker = tracker + 2; 
                }
                // if (panelImages.getFilename().length() == 0) {
                //  tracker = tracker + 4; 
                // }
                if (dateBoxDOB.toString().length() == 0) {
                    tracker = tracker + 8; 
                }
                if (dateBoxPackIn.toString().length() == 0) {
                    tracker = tracker + 16; 
                }

                if (tracker == 1) {
                    Window.alert("Please enter a Surname.");
                }
                if (tracker == 2) {
                    Window.alert("Please enter a First Name.");
                }
                if (tracker == 3) {
                    Window.alert("Please enter Surname and First Name");
                }
                if (tracker == 4) {
                    Window.alert("Please select a photograph.");
                }
                if (tracker == 5) {
                    Window.alert("Please enter a Surname and select a photograph.");
                }
                if (tracker == 6) {
                    Window.alert("Please enter a FirstName and select a photograph.");
                }
                if (tracker == 7) {
                    Window.alert("Please enter Surname, First Name and select a photograph");
                }
                if (tracker == 8) {
                    Window.alert("Please enter a DOB");
                }
                if (tracker == 9) {
                    Window.alert("Please enter a Surname and DOB");
                }
                if (tracker == 10) {
                    Window.alert("Please enter a First Name and DOB");
                }
                if (tracker == 11) {
                    Window.alert("Please enter a Surname, First Name and DOB");
                }
                if (tracker == 12) {
                    Window.alert("Please select a photograph and enter a BOB");
                }
                if (tracker == 13) {
                    Window.alert("Please enter a Surname, select a photograph and enter a DOB");
                }
                if (tracker == 14) {
                    Window.alert("Please enter a FirstName, select a photograph and enter a DOB");
                }
                if (tracker == 15) {
                    Window.alert("Please enter Surname, First Name, select a photograph and enter a DOB");
                }
                if (tracker == 16) {
                    Window.alert("Please enter date joined Pack");
                }

                if (tracker == 17) {
                    Window.alert("Please enter a Surname and date joined Pack.");
                }
                if (tracker == 18) {
                    Window.alert("Please enter a First Name and date joined Pack.");
                }
                if (tracker == 19) {
                    Window.alert("Please enter Surname, First Name and date joined Pack");
                }
                if (tracker == 20) {
                    Window.alert("Please select a photograph and enter date joined Pack.");
                }
                if (tracker == 21) {
                    Window.alert("Please enter a Surname, select a photograph and enter date joined Pack.");
                }
                if (tracker == 22) {
                    Window.alert("Please enter a First Name, select a photograph and enter date joined Pack.");
                }
                if (tracker == 23) {
                    Window.alert("Please enter Surname, First Name, select a photograph and enter date joined Pack");
                }
                if (tracker == 24) {
                    Window.alert("Please enter a DOB and date joined Pack");
                }
                if (tracker == 25) {
                    Window.alert("Please enter a Surname, DOB and date joined Pack");
                }
                if (tracker == 26) {
                    Window.alert("Please enter a First Name, DOB and date joined Pack");
                }
                if (tracker == 27) {
                    Window.alert("Please enter a Surname, First Name, DOB and date joined Pack");
                }
                if (tracker == 28) {
                    Window.alert("Please select a photograph, enter a BOB and date joined Pack");
                }
                if (tracker == 29) {
                    Window.alert("Please enter a Surname, select a photograph, enter a DOB and date joined Pack");
                }
                if (tracker == 30) {
                    Window.alert("Please enter a FirstName, select a photograph, enter a DOB and date joined Pack");
                }
                if (tracker == 31) {
                    Window.alert("Please enter Surname, First Name, select a photograph, enter a DOB and date joined Pack");
                }

                //if (tracker == 0) {
                //  AsyncCallback<YthMmbrSectDtls> callback = new CreationHandler<YthMmbrSectDtls>(null);
                //  rpc.createYouthMember(null, textBoxSurname.getText(), textBoxFirstName.getText(), dateBoxDOB.getValue(), 
                //          fileUpload.getFilename(), dateBoxArchived.getValue(), null, listBoxSection.getItemText(listBoxSection.getSelectedIndex()),
                //          listBoxPack.getItemText(listBoxPack.getSelectedIndex()), dateBoxPackIn.getValue(), 
                //          dateBoxPackOut.getValue(), callback);
                //}

            }

        });
        flexTable.setWidget(3, 0, btnAdd);

        Button btnUpdate = new Button("Update");
        btnUpdate.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
            }
        });
        btnUpdate.setText("Update");
        flexTable.setWidget(3, 1, btnUpdate);

        Button btnCancel = new Button("Cancel");
        btnCancel.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
            }
        });
        btnCancel.setText("Cancel");
        flexTable.setWidget(3, 2, btnCancel);

        Button btnClearPage = new Button("Clear Page");
        btnClearPage.setText("Clear Page");
        btnClearPage.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                textBoxSurname.setText("");
                textBoxFirstName.setText("");
                dateBoxDOB.setValue(null);
                dateBoxPackIn.setValue(todays_date);
                dateBoxPackOut.setValue(null);
                textBoxScoutNumber.setText("");
                dateBoxArchived.setValue(null);
            }
        });
        flexTable.setWidget(3, 3, btnClearPage);
        setStyleName("body");
    }

    // Load the image in the document and in the case of success attach it to the viewer
    private IUploader.OnFinishUploaderHandler onFinishUploaderHandler = new IUploader.OnFinishUploaderHandler() {
        public void onFinish(IUploader uploader) {
            if (uploader.getStatus() == Status.SUCCESS) {
              
                new PreloadedImage(uploader.fileUrl(), showImage);

                //The server sends useful information to the client by default
                UploadedInfo info = uploader.getServerInfo();
                System.out.println("File name " + info.name);
                System.out.println("File content-type " + info.ctype);
                System.out.println("File size " + info.size);

                // You can send any customised message and parse it
                System.out.println("Server message " + info.message);
            }
        }
    };

    // Attach an image to the pictures viewer
    private OnLoadPreloadedImageHandler showImage = new OnLoadPreloadedImageHandler() {
        public void onLoad(PreloadedImage image) {
            image.setWidth("75px");
            panelImages.add(image);
        }
    };


    public IUploader.OnFinishUploaderHandler getOnFinishUploaderHandler() {
        return onFinishUploaderHandler;
    }

    public void setOnFinishUploaderHandler(IUploader.OnFinishUploaderHandler onFinishUploaderHandler) {
        this.onFinishUploaderHandler = onFinishUploaderHandler;
    }

    }  

}
