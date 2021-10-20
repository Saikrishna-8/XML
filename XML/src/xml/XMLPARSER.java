package xml;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLPARSER {
	public static void main(String args[])
	{
		DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db=factory.newDocumentBuilder();
			try {
				Document document=db.parse("C:\\Users\\sai\\eclipse-workspace1\\XML\\XMLFILE.xml");
				
				document.getDocumentElement().normalize();
				System.out.println("Root element: " + document.getDocumentElement().getNodeName());  
				
				NodeList studentsList=document.getElementsByTagName("student");
				for(int i=0;i<studentsList.getLength();i++)
				{
					Node student=studentsList.item(i);
					System.out.println("\nNode Name :" + student.getNodeName());  
					if(student.getNodeType()==Node.ELEMENT_NODE)
					{
						Element el=(Element)student;
						System.out.println("\n Student Name :" + el.getAttribute("name"));
						NodeList studetails=el.getChildNodes();
						for(int j=0;j<studetails.getLength();j++)
						{
							Node detail=studetails.item(j);
							if(detail.getNodeType()==Node.ELEMENT_NODE)
							{
								Element ele1=(Element)detail;
								System.out.println("   "+ele1.getTagName()+"    "+ele1.getTextContent() );
								//System.out.println("SAI KRISHNA  "+ele1.getAttribute("value")+ele1.getTagName() );
							//	System.out.println("Checking "+ele1.getTextContent());
							}
						}
					
					}
				}
			} catch (SAXException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
