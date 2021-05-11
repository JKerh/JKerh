package XMLDemo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;

public class DOMDemo {
     public static void main(String[] args) throws  Exception{
         /**
          * DOM增删改只是在内存里操作解析xml文件在内存中生成的Document对象
          * 并不会对XML文件有任何影响
          * 如果要把改变写入XML文件中，就需要进行其他操作
          */
        DocumentBuilderFactory bdf=DocumentBuilderFactory.newInstance();//创建解析器工厂对对象
        DocumentBuilder db=bdf.newDocumentBuilder();//创建解析器对象

        File file=new File("D:\\JavaProject\\src\\XMLDemo\\users.xml");
        Document doc=db.parse(file);//把xml解析到内存中，生成Document树

        Element root=doc.getDocumentElement();//获取根节点

//        ============================================================
//          对XML文件实现增删改
        Element newUser=doc.createElement("user");//创建一个新的标签，标签的名字是user
        newUser.setAttribute("id","u_003");

         Element username=doc.createElement("userName");
         username.setTextContent("quest");//给子节点添加新的标签，setTextContent与map集合类似，新增修改都是这个
         newUser.appendChild(username);

         root.appendChild(newUser);//把newUser加入根节点中去
//         root.removeChild(newUser);//移除
//        ============================================================

        NodeList userlist=root.getElementsByTagName("user");//根据标签名称获取当前节点下的子节点
        System.out.println(userlist.getLength());

        Element element=null;
        for (int i = 0; i < userlist.getLength(); i++) {
            element=(Element) userlist.item(i);
            System.out.println(element.getNodeName());

            NodeList node=element.getChildNodes();//获取当下节点所有子节点(包括子节点的子节点)
            //在使用getChildNodes()方法时，如果只是想要获取当前节点的子节点的下一级子节点，就要保证子节点只有一级的子节点
            Element m=null;
            //遍历root下user的节点内容
            for (int j = 0; j < node.getLength(); j++) {
                //DOM在解析xml文档时，会把回车也进行解析，所以要对文档内容进行判断
                if(node.item(j) instanceof Element) {
                    m = (Element) node.item(j);
                    String e=m.getTextContent();
                    m.setTextContent(m.toString());
                    System.out.println("子节点user下的属性" + m.getNodeName() + "-->文本值" + m.getTextContent());
                }
            }
        }
//        以下就是将增删改的过程写入文件中
         TransformerFactory tff=TransformerFactory.newInstance();//创建TransformerFactory的对象
         Transformer tf=tff.newTransformer();//创建Transformer的对象

         DOMSource ds=new DOMSource(doc);//生成doc的数据源

         tf.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
         tf.setOutputProperty(OutputKeys.INDENT,"YES");

         StreamResult sr=new StreamResult(new FileOutputStream(file));

         tf.transform(ds,sr);//把内存中的Document对象写入内存中去
    }
}
