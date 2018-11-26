package com.knack.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.knack.functional.CSVFileProcess;

public class TestClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/SI_config.xml");
//		File file = new File("inputFiles\\input.csv");
//		TestMain tMain=new TestMain();
//		tMain.getDynamicFileInput(file);
//		System.out.println("Started....");
//		
		
		
		 	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		         dbf.setValidating(false);
		         DocumentBuilder db;
				try {
					db = dbf.newDocumentBuilder();
		         Document doc = db.parse(new FileInputStream(new File("inputFiles\\order.xml")));
		         NodeList entries = doc.getElementsByTagName("attribute");
		         System.out.println(":"+entries.getLength());
		         for (int i = 0; i < entries.getLength(); i++) {
		        	 Element node = (Element) entries.item(i);
		        	System.out.println(" : "+ node.getNodeValue());
		        	 listAllAttributes(node);
		        	 
		         }
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	private static void listAllAttributes(Element element) {
		 NodeList list = element.getElementsByTagName("attribute");
         if (list != null && list.getLength() > 0) {
             NodeList subList = list.item(0).getChildNodes();

             if (subList != null && subList.getLength() > 0) {
                 System.out.println( subList.item(0).getNodeValue());;
             }
         }
		
	}

}
