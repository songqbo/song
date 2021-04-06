import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

public class DomParseXml {
    public static void main(String[] args) {
      //1�������ĵ������߹�������
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       //2��ͨ���������������߶���
        try {

            DocumentBuilder db = factory.newDocumentBuilder();
            //ͨ�������������ĵ�����
           Document doc = db.parse(new File("javaXml0923/One.xml"));

            //4�����ĵ������н���������-Node\
            //��ȡ����employe�ڵ㣬���ؽڵ㼯
            NodeList nodeList = doc.getElementsByTagName("employe");

            for (int i = 0; i <nodeList.getLength() ; i++) {

                //ѭ�����ÿ���ڵ�
                Node node = nodeList.item(i);
                //��ȡ�ڵ��id����
                Element ele = (Element) node;
                //�����������������ֵ
                String id = ele.getAttribute("id");
                System.out.println("id="+id);
                //��ȡnode�µ������ӽڵ�
                NodeList cNode = node.getChildNodes();
                System.out.println("����"+cNode.getLength());

                for (int j = 0; j <cNode.getLength(); j++) {
                    Node nodes = cNode.item(j);
                    if(nodes.getNodeName().equals("ename")){
                         String name = nodes.getTextContent();
                         System.out.print(name);
                     }
                    if(nodes.getNodeName().equals("eage")){
                        String age = nodes.getTextContent();
                        System.out.print(age);
                    }
                    if(nodes.getNodeName().equals("eheight")){
                        String height = nodes.getTextContent();
                        System.out.print(height);
                    }
                    if(nodes.getNodeName().equals("esex")){
                        String sex = nodes.getTextContent();
                        System.out.print(sex);
                    }

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
