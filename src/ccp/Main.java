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
import com.aspose.diagram.Diagram;
import com.aspose.diagram.DiagramSaveOptions;
import com.aspose.diagram.Page;
import com.aspose.diagram.SaveFileFormat;
import com.aspose.diagram.Shape;
//import com.aspose.diagram.examples.Utils;

/**
 *
 * @author UddinS2
 */
public class Main {

    public static void main(String argv[]) throws Exception {

        try {
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
            int pageNumber = 0;
            int xR1 = 1;
            int xR2 = 4;
            double y = 1;

            // Set stencil file path
            //String templateFileName = dataDir + "stencil\\Network Connectivity.vss";
            //FileInputStream stream = new FileInputStream(templateFileName);
            // adds master to diagram from source diagram
            Diagram src = new Diagram(dataDir + "Network Connectivity.vdx");
            diagram.addMaster(src, router);
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
                    long shape2_ID = diagram.addShape(xR2, y, router, pageNumber);

                    // get shapes by ID
                    Shape shape1 = page.getShapes().getShape(shape1_ID);
                    Shape shape2 = page.getShapes().getShape(shape2_ID);

                    // add two more connection points
                    Connection connection1 = new Connection();
                    connection1.setIX(0);
                    connection1.getX().getUfe().setF("Width*0.33");
//                     connection1.getX().setValue(0.2984);
                    connection1.getY().getUfe().setF("Height*0");
//                     connection1.getY().setValue(0);
                    Connection connection3 = new Connection();
                    connection3.getX().getUfe().setF("Width*0.66");
//                     connection3.getX().setValue(0.5968);
                    connection3.getY().getUfe().setF("Height*0");
//                     connection3.getY().setValue(0);
                    connection3.setIX(1);
                    shape1.getConnections().add(connection1);
                    shape1.getConnections().add(connection3);

                    Connection connection4 = new Connection();
                    connection4.getX().getUfe().setF("Width*0.33");
//                     connection4.getX().setValue(0.2984);
                    connection4.getY().getUfe().setF("Height*0");
//                     connection4.getY().setValue(0);
                    connection4.setIX(0);
                    shape2.getConnections().add(connection4);

                    // add connector shapes
                    Shape connector1 = new Shape();
                    long connecter1Id = diagram.addShape(connector1, connectorMaster, 0);

                    System.out.println(page);
                    page.connectShapesViaConnectorIndex(shape1_ID, 1, shape2_ID, 0, connecter1Id);

                    y++;
                    y++;
                }
            } //end of for loop
            // save drawing
            DiagramSaveOptions options = new DiagramSaveOptions(SaveFileFormat.VSDX);
            options.setAutoFitPageToDrawingContent(false);
            diagram.save(dataDir + "Drawing2_out.vsdx", options);

            //System.out.println(flows.length);
        } catch (IOException e) {
        } catch (ParserConfigurationException e) {
        } catch (DOMException e) {
        } catch (SAXException e) {
        }

    }
}
