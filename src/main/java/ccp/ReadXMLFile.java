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
import com.aspose.diagram.examples.Utils;

/**
 *
 * @author UddinS2
 */
public class ReadXMLFile {

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
            Flow[] flows;
            //flows = new Flow[nList.getLength()];
            
            // initialize a new drawing
            Diagram diagram = new Diagram();
            
            // get page by index
            Page page = diagram.getPages().get(0);
            
           
            String connectorMaster = "Dynamic connector";
            String router = "Router";
            String firewall = "Firewall";
            int pageNumber = 0;
            int xR1 = 1;
            int xR2 = 3;
            int xR3 = 5;
            double y = 1;
           
            // Set stencil file path
            //String templateFileName = dataDir + "stencil\\Network Connectivity.vss";
            //FileInputStream stream = new FileInputStream(templateFileName);
            // adds master to diagram from source diagram
            Diagram src = new Diagram(dataDir + "Example Diagram.vdx");
            diagram.addMaster(src, router);
            diagram.addMaster(src, firewall);
            diagram.addMaster(src, connectorMaster);

            

            String source;
            String destination;
            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;                    
                    source = eElement.getElementsByTagName("src").item(0).getTextContent();
                    destination = eElement.getElementsByTagName("dst").item(0).getTextContent();
                    
                    // add shapes
                    long shape1_ID = diagram.addShape(xR1, y, router, pageNumber);
                    long shape2_ID = diagram.addShape(xR2, y, firewall, pageNumber);
                    long shape3_ID = diagram.addShape(xR3, y, router, pageNumber);
                    
                    // get shapes by ID
                    Shape shape1 = page.getShapes().getShape(shape1_ID);
                    Shape shape2 = page.getShapes().getShape(shape2_ID);
                    Shape shape3 = page.getShapes().getShape(shape3_ID);                    
                    shape1.getText().getValue().add(new Txt(source));
                    shape3.getText().getValue().add(new Txt(destination));
                    
                    // add connector shapes
                    Shape connector1 = new Shape();
                    Shape connector2 = new Shape();
                    //Shape connector3 = new Shape();
                    long connecter1Id = diagram.addShape(connector1, connectorMaster, 0);
                    long connecter2Id = diagram.addShape(connector2, connectorMaster, 0);
                    //long connecter3Id = diagram.addShape(connector3, connectorMaster, 0);
                    // connect shapes by index of conneecting points
                    //System.out.println(page);
                    //System.out.println(shape1.getID());
                    //System.out.println(shape2.getID());
                    //System.out.println(connecter1Id);

                    page.connectShapesViaConnectorIndex(shape1_ID, ConnectionPointPlace.RIGHT, shape2_ID, ConnectionPointPlace.LEFT, connecter1Id);
                    page.connectShapesViaConnectorIndex(shape2_ID, ConnectionPointPlace.RIGHT, shape3_ID, ConnectionPointPlace.LEFT, connecter2Id);
                    //page.connectShapesViaConnectorIndex(shape1.getID(), xR1, shape2.getID(), xR2, connecter1Id);
                    //page.connectShapesViaConnectorIndex(shape1.getID(), 7, shape4.getID(), 3, connecter3Id);
                    //Connection connection1 = new Connection(); 
                    //shape1.Connections.Add(connection1); 
                    y++;y++;
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
