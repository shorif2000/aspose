/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccp;

import com.aspose.diagram.Connection;
import com.aspose.diagram.ConnectionPointPlace;
import com.aspose.diagram.Diagram;
import com.aspose.diagram.Page;
import com.aspose.diagram.SaveFileFormat;
import com.aspose.diagram.Shape;
import com.aspose.diagram.Txt;
import com.aspose.diagram.TypeValue;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;
import com.aspose.diagram.ConnectionPointPlace;
import com.aspose.diagram.ConnectorsTypeValue;
import com.aspose.diagram.Diagram;
import com.aspose.diagram.DiagramSaveOptions;
import com.aspose.diagram.Page;
import com.aspose.diagram.SaveFileFormat;
import com.aspose.diagram.Shape;

/**
 *
 * @author UddinS2
 */
public class fromaspose {

    public static void main(String argv[]) throws Exception {
        String dataDir = "C:\\Users\\Uddins2\\Documents\\aspose\\";
        File fXmlFile = new File(dataDir + "comms_matrix.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        //optional, but recommended
        //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
        doc.getDocumentElement().normalize();

        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("flow");
//             Flow[] flows;
//             flows = new Flow[nList.getLength()];

        // initialize a new drawing
        Diagram diagram = new Diagram();

        // get page by index
        Page page = diagram.getPages().get(0);

        String connectorMaster = "Connector";
        String router = "Router";
        String firewall = "Firewall";
        int pageNumber = 0;
        int xR1 = 1;
        int xR2 = 4;
        int xR3 = 7;
        double y = 1;

        // Set stencil file path
        //String templateFileName = dataDir + "stencil\\Network Connectivity.vss";
        //FileInputStream stream = new FileInputStream(templateFileName);
        // adds master to diagram from source diagram
        Diagram src = new Diagram(dataDir + "Network Connectivity.vdx");
        diagram.addMaster(src, router);
        diagram.addMaster(src, firewall);
        diagram.addMaster(src, connectorMaster);

        for (int temp = 0; temp < nList.getLength() - 1; temp++) {

            Node nNode = nList.item(temp);

            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;
//                     Flow currentflow = new Flow(eElement.getElementsByTagName("src").item(0).getTextContent(), eElement.getElementsByTagName("dst").item(0).getTextContent());
//                     flows[temp] = currentflow;
                //System.out.println("src : " + eElement.getElementsByTagName("src").item(0).getTextContent());
                //System.out.println("dst : " + eElement.getElementsByTagName("dst").item(0).getTextContent());

                // add shapes
                long shape1_ID = diagram.addShape(xR1, y, router, pageNumber);
                long shape2_ID = diagram.addShape(xR2, y, firewall, pageNumber);
                long shape3_ID = diagram.addShape(xR3, y, router, pageNumber);

                // get shapes by ID
                Shape shape1 = page.getShapes().getShape(shape1_ID);
                Shape shape2 = page.getShapes().getShape(shape2_ID);
                Shape shape3 = page.getShapes().getShape(shape3_ID);

                // add two more connection points
                Connection connection1 = new Connection();
                connection1.setIX(0);
                connection1.getX().getUfe().setF("Width*0.33");
//                     connection1.getX().setValue(0.2984);
                connection1.getY().getUfe().setF("Height*0");
//                     connection1.getY().setValue(0);
                Connection connection2 = new Connection();
                connection2.getX().getUfe().setF("Width*0.66");
//                     connection3.getX().setValue(0.5968);
                connection2.getY().getUfe().setF("Height*0");
//                     connection3.getY().setValue(0);
                connection2.setIX(1);
                shape1.getConnections().add(connection1);
                shape1.getConnections().add(connection2);

                Connection connection3 = new Connection();
                connection3.getX().getUfe().setF("Width*0.33");
//                     connection4.getX().setValue(0.2984);
                connection3.getY().getUfe().setF("Height*0");
//                     connection4.getY().setValue(0);
                connection3.setIX(0);
                Connection connection4 = new Connection();
                connection4.getX().getUfe().setF("Width*0.66");
//                     connection3.getX().setValue(0.5968);
                connection4.getY().getUfe().setF("Height*0");
//                     connection3.getY().setValue(0);
                connection4.setIX(1);
                shape2.getConnections().add(connection3);
                shape2.getConnections().add(connection4);
                
                Connection connection5 = new Connection();
                connection5.getX().getUfe().setF("Width*0.33");
//                     connection4.getX().setValue(0.2984);
                connection5.getY().getUfe().setF("Height*0");
//                     connection4.getY().setValue(0);
                connection5.setIX(0);
                shape3.getConnections().add(connection5);

                // add connector shapes
                Shape connector1 = new Shape();
                diagram.addShape(connector1, connectorMaster, 0);
                connector1.setConnectorsType(ConnectorsTypeValue.CURVED_LINES);
                Shape connector2 = new Shape();
                diagram.addShape(connector2, connectorMaster, 0);
                connector2.setConnectorsType(ConnectorsTypeValue.RIGHT_ANGLE);

                //System.out.println(page);
                //ConnectionPointPlace  x = connection2;
               //page.connectShapesViaConnector(shape3, xR3, shape1, xR1, shape2);
                page.connectShapesViaConnector(shape1, ConnectionPointPlace.RIGHT, shape2, ConnectionPointPlace.LEFT, connector1);
                page.connectShapesViaConnector(shape2, ConnectionPointPlace.RIGHT, shape3, ConnectionPointPlace.LEFT, connector2);
                //page.connectShapesViaConnectorIndex(shape1_ID, 1, shape2_ID, 0, connecter1Id);
                //page.connectShapesViaConnectorIndex(shape2_ID, 1, shape3_ID, 0, connecter1Id);

                y++;
                y++;
            }
        }
        
        // save drawing
        DiagramSaveOptions options = new DiagramSaveOptions(SaveFileFormat.VSDX);
        options.setAutoFitPageToDrawingContent(false);
        diagram.save(dataDir + "Drawing3_out.vsdx", options);
    }

}
