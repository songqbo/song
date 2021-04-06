import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

public class teachers {

    public static void main(String[] args) {
        //创建工厂对象
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {

            //创建创建者对象
            DocumentBuilder db = factory.newDocumentBuilder();
            //拿到地址
            Document path = db.parse(new File("javaXml0923/teachers.xml"));
            //拿到节点
            NodeList teacher = path.getElementsByTagName("teacher");
            for (int i = 0; i < teacher.getLength(); i++) {
                Node teach = teacher.item(i);
                Element teachers = (Element) teach;

                String ids = teachers.getAttribute("id");
                //获取node下的所有子节点
                NodeList cTeacher = teach.getChildNodes();
                //通过循环拿到子节点
                for (int j = 0; j <cTeacher.getLength(); j++) {
                    Node items = cTeacher.item(j);
                    if (items.getNodeName().equals("nickname")){
                        String textContent = items.getTextContent();
                        System.out.println(textContent);
                    }
                    if (items.getNodeName().equals("name")){
                        String textContent = items.getTextContent();
                        System.out.println(textContent);
                    }
                    if (items.getNodeName().equals("sex")){
                        String textContent = items.getTextContent();
                        System.out.println(textContent);
                    }
                }
                System.out.println("----------------");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
