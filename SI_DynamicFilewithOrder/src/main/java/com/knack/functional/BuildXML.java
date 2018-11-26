package com.knack.functional;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.messaging.Message;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.knack.target.TargetItems;

public class BuildXML {
	String path = null;
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder;
	StreamResult file = new StreamResult(new File(getPath()));
	DOMSource source;
	Document doc;
	public void processToXML(Message<List<TargetItems>> msg) {
//		path = getPath();
		List<TargetItems> tList = msg.getPayload();
		
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			 doc = dBuilder.newDocument();
			// add elements to Document
			Element rootElement = doc.createElement("target");
			// append root element to document
			doc.appendChild(rootElement);
			for (TargetItems tItems : tList) {
				// append first child element to root element
				rootElement.appendChild(formXML(tItems, doc));
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			// for pretty print
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			 source = new DOMSource(doc);

			// write to console or file
//	            StreamResult console = new StreamResult(System.out);
			

			// write data
//	            transformer.transform(source, console);
			transformer.transform(source, file);
			System.out.println("DONE");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getPath() {
		File file = new File("D:\\WS_Knack\\SI_DynamicFilewithOrder\\inputFiles\\path.properties");
		String[] path = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st = br.readLine();
			System.out.println("path File : "+st);
			path = st.split(":::");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path[1].trim();
	}

	private Node formXML(TargetItems target, Document doc) {
		Map<String, String> tMap = target.getcItems();
		Element targetEntity = doc.createElement("targetItem");
		try {
			for (Map.Entry<String, String> entry : tMap.entrySet()) {
				targetEntity.appendChild(getEmployeeElements(doc, targetEntity, entry.getKey(), entry.getValue()));
				System.out.println(entry.getKey()+" : "+ entry.getValue());
			}
			return targetEntity;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return targetEntity;
	}

	private static Node getEmployeeElements(Document doc, Element element, String name, String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}
}
