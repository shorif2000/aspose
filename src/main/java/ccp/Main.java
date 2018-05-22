/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccp;

import com.aspose.diagram.Connection;
import com.aspose.diagram.ConnectionPointPlace;
import com.aspose.diagram.DateTime;
import com.aspose.diagram.Page;
import com.aspose.diagram.Diagram;
import com.aspose.diagram.FileFormatInfo;
import com.aspose.diagram.FileFormatUtil;
import com.aspose.diagram.Master;
import com.aspose.diagram.SaveFileFormat;
import com.aspose.diagram.Shape;
import com.aspose.diagram.Txt;
import com.aspose.diagram.TypeValue;
import com.aspose.diagram.examples.Shapes.AddingNewShape;
import com.aspose.diagram.examples.Shapes.ConnectVisioSubShapes;
import com.aspose.diagram.examples.Utils;
import com.oracle.xmlns.internal.webservices.jaxws_databinding.ObjectFactory;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author UddinS2
 */
public class Main {

    public static void main(String[] args) throws Exception {
        // For complete examples and data files, please go to https://github.com/aspose-diagram/Aspose.Diagram-for-Java
        // The path to the documents directory.
        //System.out.println(Utils.getDataDir(GetLibraryVersion.class));
        //String dataDir = Utils.getDataDir(GetLibraryVersion.class);
        String dataDir = "C:\\Users\\Uddins2\\Documents\\aspose\\";
/*
        // build path of an existing diagram
        String path = dataDir + "Diagram for Sharif.vdx";
        System.out.println(path);

        // detect file format using the direct file path
        FileFormatInfo info = FileFormatUtil.detectFileFormat(path);

        // get the detected file format
        System.out.println("The spreadsheet format is: " + info.getFileFormatType());

        //Call the diagram constructor to load diagram from a VDX file
        Diagram diagram = new Diagram(path);

        //Display Visio version and document modification time at different stages
        //System.out.println("Visio Instance Version : " + diagram.getVersion());
        //System.out.println("Full Build Number Created : " + diagram.getDocumentProps().getBuildNumberCreated());
        //System.out.println("Full Build Number Edited : " + diagram.getDocumentProps().getBuildNumberEdited());
        //System.out.println("Date Created : " + diagram.getDocumentProps().getTimeCreated());
        //System.out.println("Date Last Edited : " + diagram.getDocumentProps().getTimeEdited());
        //System.out.println("Date Last Printed : " + diagram.getDocumentProps().getTimePrinted());
        //System.out.println("Date Last Saved : " + diagram.getDocumentProps().getTimeSaved());
        //Set some summary information about the diagram
        diagram.getDocumentProps().setCreator("UddinS");
        diagram.getDocumentProps().setCompany("Vodafone");
        diagram.getDocumentProps().setCategory("Network Diagram");
        diagram.getDocumentProps().setManager("Nina");
        diagram.getDocumentProps().setTitle("Voice Discussion");
        diagram.getDocumentProps().setTimeCreated(DateTime.getNow());
        diagram.getDocumentProps().setSubject("Visio Diagram");
        diagram.getDocumentProps().setTemplate("CCP Template");

        //Write the updated file to the disk in VSDX file format
        diagram.save(dataDir + "SetVisioProperties_Out.vsdx", SaveFileFormat.VSDX);

        // Save as PDF file format
        diagram.save(dataDir + "ExportToPDF_Out.pdf", SaveFileFormat.PDF);

        //Save input VSD as VDX
        diagram.save(dataDir + "ExportToXML_Out.vdx", SaveFileFormat.VDX);

        //Save input VSD as VSX
        diagram.save(dataDir + "ExportToXML_Out.vsx", SaveFileFormat.VSX);

        //Save input VSD as VTX
        diagram.save(dataDir + "ExportToXML_Out.vtx", SaveFileFormat.VTX);

        path = dataDir + "Diagram for Sharif.vdx";
        System.out.println(path);
        diagram = new Diagram(path);
        
        for (Master master : (Iterable<Master>) diagram.getMasters())
        {
            //Display information about the masters
            System.out.println("\nMaster ID : " + master.getID());
            System.out.println("Master Name : " + master.getName());
        }
        
        
        File file = new File(dataDir);
        if (!file.exists()){
                file.mkdir();
        }
        // initialize a new Diagram
        diagram = new Diagram();
        
        
        // save in the VSDX format
        System.out.println(dataDir);
        diagram.save(dataDir + "CreateDiagram_Out.vsdx", SaveFileFormat.VSDX);
        
        //dataDir = Utils.getDataDir(AddingNewShape.class);
        path = dataDir + "stencil\\Cisco Systems 2600 (US units).vss"; 
        System.out.println(path);
        // get page by name
        Page page = diagram.getPages().getPage("Page-0");
        
        // Add master with stencil file path and master id
        String masterName = "Switch";
        // Add master with stencil file path and master name
        diagram.addMaster(path, masterName);

        // page indexing starts from 0
        int PageIndex = 1;
        double width = 2, height = 2, pinX = 4.25, pinY = 4.5;
        //Add a new rectangle shape
        long rectangleId = diagram.addShape(pinX, pinY, width, height, masterName, PageIndex);

        // set shape properties 
        Shape rectangle = page.getShapes().getShape(rectangleId);
        rectangle.getXForm().getPinX().setValue(5);
        rectangle.getXForm().getPinY().setValue(5);
        rectangle.setType(TypeValue.SHAPE);
        rectangle.getText().getValue().add(new Txt("Aspose Diagram"));
        rectangle.setTextStyle(diagram.getStyleSheets().get(3));
        rectangle.getLine().getLineColor().setValue("#ff0000");
        rectangle.getLine().getLineWeight().setValue(0.03);
        rectangle.getLine().getRounding().setValue(0.1);
        rectangle.getFill().getFillBkgnd().setValue("#ff00ff");
        rectangle.getFill().getFillForegnd().setValue("#ebf8df");

        diagram.save(dataDir + "AddShape_Out.vsdx", SaveFileFormat.VSDX);
        System.out.println("Shape has been added.");
         
        
        
        
        
        
        
        
        
        
        
        */
        /*
        // initialize a new drawing
        Diagram diagram = new Diagram();
        // get page by index
        Page page = new Page();//diagram.getPages().get(0);
        diagram.getPages().add(page);
       // add masters
        String connectorMaster = "Connector";
        String router = "Router";
        int pageNumber = 0;
        double width  = 2;
        double height = 2;
        double pinX = 4.25;
        double pinY = 9.5;
        diagram.addMaster(dataDir + "stencil\\Network Connectivity.vss", router);
        diagram.addMaster(dataDir + "stencil\\Network Connectivity.vss", connectorMaster);
        System.out.println(dataDir + "stencil\\Network Connectivity.vss");
        // add shapes
        long shape1_ID = diagram.addShape(4.5, 7, router, pageNumber);
        long shape2_ID = diagram.addShape(2.25, 4.5, router, pageNumber);
        long shape3_ID = diagram.addShape(4.5, 4.5, router, pageNumber);
        long shape4_ID = diagram.addShape(6.75, 4.5, router, pageNumber);
        // get shapes by ID
        Shape shape1 = page.getShapes().getShape(shape1_ID);
        Shape shape2 = page.getShapes().getShape(shape2_ID);
        Shape shape3 = page.getShapes().getShape(shape3_ID);
        Shape shape4 = page.getShapes().getShape(shape4_ID);
        // add two more connection points
        Connection connection1 = new Connection();
        connection1.getX().getUfe().setF("Width*0.33");
        connection1.getY().getUfe().setF("Height*0");
        Connection connection3 = new Connection();
        connection3.getX().getUfe().setF("Width*0.66");
        connection3.getY().getUfe().setF("Height*0");
        //shape1.getConnections().add(connection1);
        //shape1.getConnections().add(connection3);

        // add connector shapes
        Shape connector1 = new Shape();
        Shape connector2 = new Shape();
        Shape connector3 = new Shape();
        long connecter1Id = diagram.addShape(connector1, connectorMaster, 0);
        long connecter2Id = diagram.addShape(connector2, connectorMaster, 0);
        long connecter3Id = diagram.addShape(connector3, connectorMaster, 0);
        // connect shapes by index of conneecting points
        //page.connectShapesViaConnectorIndex(shape1.getID(), 6, shape2.getID(), 3, connecter1Id);
        //page.connectShapesViaConnectorIndex(shape1.getID(), 1, shape3.getID(), 3, connecter2Id);
        //page.connectShapesViaConnectorIndex(shape1.getID(), 7, shape4.getID(), 3, connecter3Id);
        // save drawing
        diagram.save(dataDir + "Drawing1_out.vsdx", SaveFileFormat.VSDX);
*/
        
        
        // ExStart:ConnectVisioSubShapes
		// The path to the documents directory.
		dataDir = Utils.getSharedDataDir(ConnectVisioSubShapes.class) + "Protection/";
		// set sub shape ids
		long shapeFromId = 2;
		long shapeToId = 4;

		// load diagram
		Diagram diagram = new Diagram(dataDir + "Drawing1.vsdx");
		// access a particular page
		Page page = diagram.getPages().getPage("Page-3");

		// initialize connector shape
		Shape shape = new Shape();
		shape.getLine().getEndArrow().setValue(4);
		shape.getLine().getLineWeight().setValue(0.01388);

		// add shape
		long connecter1Id = diagram.addShape(shape, "Dynamic connector", page.getID());
		// connect sub-shapes
		page.connectShapesViaConnector(shapeFromId, ConnectionPointPlace.RIGHT, shapeToId, ConnectionPointPlace.LEFT,
				connecter1Id);
		// save Visio drawing
		diagram.save(dataDir + "ConnectVisioSubShapes_Out.vsdx", SaveFileFormat.VSDX);
		// ExEnd:ConnectVisioSubShapes
    }

}
