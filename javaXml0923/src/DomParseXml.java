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
      //1、创建文档创建者工厂对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       //2、通过工厂创建创建者对象
        try {

            DocumentBuilder db = factory.newDocumentBuilder();
            //通过创建者生成文档对象
           Document doc = db.parse(new File("javaXml0923/One.xml"));

            //4、从文档对象中解析出数据-Node\
            //获取所有employe节点，返回节点集
            NodeList nodeList = doc.getElementsByTagName("employe");

            for (int i = 0; i <nodeList.getLength() ; i++) {

                //循环获得每个节点
                Node node = nodeList.item(i);
                //获取节点的id属性
                Element ele = (Element) node;
                //根据属性名获得属性值
                String id = ele.getAttribute("id");
                System.out.println("id="+id);
                //获取node下的所有子节点
                NodeList cNode = node.getChildNodes();
                System.out.println("长度"+cNode.getLength());

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
