package XMLDemo;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.util.List;

public class DOM4JDemo {
    public static void main(String[] args) throws Exception{
        //创建XML阅读器
        SAXReader saxReader=new SAXReader();
        //解析XML文件
        Document doc=saxReader.read("D:\\JavaProject\\src\\XMLDemo\\users.xml");
        //获取根节点
        Element root=doc.getRootElement();

        System.out.print("<"+root.getName()+">");
        //获取root节点的子节点的集合
        List<Element> es=root.elements();
        for (Element e:es){//遍历所有的user
            System.out.println("<"+root.getName());
            //获取节点的所有属性
            List<Attribute> attrs=e.attributes();
            for (Attribute a:attrs){
                System.out.println(" "+a.getName()+"=\""+a.getValue()+"\"");
            }
            System.out.println(">");
            for(Element e1:e.elements()){
                System.out.println("<"+e1.getName()+">");
                System.out.println(e1.getText());//输出节点间字符串
                System.out.println("</"+e1.getName()+">");

            }//遍历e的子节点
            System.out.println("</"+root.getName()+">");
        }
        System.out.println("</"+root.getName()+">");
        //获得指定root下指定节点的元素
        Element user1=root.elements().get(1);
//      给user1添加一个子节点
        user1.addElement("tt").addText("test");
//        把加入的子节点写入xml文件

//        Element uu=user1.element("tt");//去除子节点
//        uu.remove(tt);
//        uu.setText();修改子节点字符串
        OutputFormat format=OutputFormat.createCompactFormat();
        format.setEncoding("UTF-8");

//        回写到XML文件
        XMLWriter writer=new XMLWriter(new FileOutputStream("D:\\JavaProject\\src\\XMLDemo\\users.xml"),format);
        writer.write(doc);
        writer.close();


    }
}
