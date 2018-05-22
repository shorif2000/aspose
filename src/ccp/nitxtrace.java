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
public class nitxtrace {

    public static void main(String argv[]) throws Exception {
        String dataDir = "C:\\Users\\Uddins2\\Documents\\aspose\\";
        File fXmlFile = new File(dataDir + "nitx_trace_src10.106.164.0_25dst47.73.107.128_25protoTCPport=3389.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        //optional, but recommended
        //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
        doc.getDocumentElement().normalize();

        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("routing-hop");
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
        System.out.println(nList);
        Long[] shape_ID = new Long[9];
        int i = 0;
        for (int temp = 0; temp < nList.getLength() - 1; temp++) {
            System.out.println(nList.item(temp));
            Node childNode = nList.item(temp).getFirstChild();

            while (childNode.getNextSibling() != null) {
                childNode = childNode.getNextSibling();
                if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element childElement = (Element) childNode;
                    String device_name = childElement.getAttribute("name");
                    String device_type = childElement.getAttribute("type");
                    System.out.println("DEVICE name:" + device_name + " type:" + device_type + " <br/>\n");
System.out.println(i);
                    if (device_type.startsWith("Router")) {
                        shape_ID[i] = diagram.addShape(xR1, y, router, pageNumber);
                    } else if (device_type.startsWith("Firewall")) {
                        shape_ID[i] = diagram.addShape(xR1, y, firewall, pageNumber);
                    }
                    xR1++;
                    xR1++;
                    i++;
                }
                
            }
        }
        System.out.println(shape_ID.length);

        long shape_ID1;
        long shape_ID2;
        Shape shape1;
        Shape shape2;
        Connection[] connection1 = new Connection[8];
        Connection[] connection2 = new Connection[8];
        Connection[] connection3 = new Connection[8];
        Connection[] connection4 = new Connection[8];
        Shape[] connector = new Shape[8];
        for (i = 0; i < (shape_ID.length - 1); i++) {
            System.out.println("shape1: " +i + " : shape2: "+(i+1));
            shape_ID1 = shape_ID[i];
            shape_ID2 = shape_ID[(i + 1)];

            shape1 = page.getShapes().getShape(shape_ID1);
            shape2 = page.getShapes().getShape(shape_ID2);
System.out.println(shape1);
System.out.println(shape2);
            // add two more connection points
            connection1[i] = new Connection();
            connection1[i].setIX(0);
            //connection1.getX().getUfe().setF("Width*0.33");
//                     connection1.getX().setValue(0.2984);
            //connection1.getY().getUfe().setF("Height*0");
//                     connection1.getY().setValue(0);
            connection2[i] = new Connection();
            //connection2.getX().getUfe().setF("Width*0.66");
//                     connection3.getX().setValue(0.5968);
            //connection2.getY().getUfe().setF("Height*0");
//                     connection3.getY().setValue(0);
            connection2[i].setIX(1);
            shape1.getConnections().add(connection1[i]);
            shape1.getConnections().add(connection2[i]);

            connection3[i] = new Connection();
            //connection3.getX().getUfe().setF("Width*0.33");
//                     connection4.getX().setValue(0.2984);
            //connection3.getY().getUfe().setF("Height*0");
//                     connection4.getY().setValue(0);
            connection3[i].setIX(0);
            connection4[i] = new Connection();
            //connection4.getX().getUfe().setF("Width*0.66");
//                     connection3.getX().setValue(0.5968);
            //connection4.getY().getUfe().setF("Height*0");
//                     connection3.getY().setValue(0);
            connection4[i].setIX(1);
            shape2.getConnections().add(connection3[i]);
            shape2.getConnections().add(connection4[i]);

            // add connector shapes
            connector[i] = new Shape();
            diagram.addShape(connector[i], connectorMaster, 0);
            connector[i].setConnectorsType(ConnectorsTypeValue.CURVED_LINES);

            page.connectShapesViaConnector(shape1, ConnectionPointPlace.RIGHT, shape2, ConnectionPointPlace.LEFT, connector[i]);


            y++;
            y++;
        }
        
        // save drawing
        DiagramSaveOptions options = new DiagramSaveOptions(SaveFileFormat.VSDX);
        options.setAutoFitPageToDrawingContent(false);
        diagram.save(dataDir + "Drawing3_out.vsdx", options);
        
        
    }

}
