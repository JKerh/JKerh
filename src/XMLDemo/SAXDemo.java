package XMLDemo;

import jdk.internal.org.xml.sax.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXDemo {
    public static void main(String[] args) throws Exception {
        SAXParserFactory spf=SAXParserFactory.newInstance();
        SAXParser sp= spf.newSAXParser();
        //从解析器中得到reader对象
        XMLReader reader= (XMLReader) sp.getXMLReader();
        //        设置内容处理器
        reader.setContentHandler(new SAXTest());
        //设置需要读取文件的路径
        reader.parse("D:\\JavaProject\\src\\XMLDemo\\users.xml");
    }
}
//内容处理器
class SAXTest implements ContentHandler{

    @Override
    public void setDocumentLocator(Locator locator) {

    }

    @Override
//    开始读取文档
    public void startDocument() throws SAXException {
        System.out.println("开始读取文档：");

    }

    @Override
//    结束读取文档
    public void endDocument() throws SAXException {
        System.out.println("结束读取文档：");

    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {

    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {

    }

    @Override
    /**
     * uri xml 文档的命名空间
     * localName 标签的名字
     * qName 带命名空间的标签名字
     * atts 标签的属性集
     */
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {

        System.out.println("<"+qName);//拼接标签开头
        for (int i = 0; i < atts.getLength(); i++) {
            System.out.print(" "+atts.getQName(i)+"=\""+atts.getValue(i)+"\"");//输出标签属性名与属性值
        }
        System.out.println(">");
    }

    @Override
    /**
     * localName 标签的名字
     * qName 带命名空间的标签名字
     * atts 标签的属性集
     */
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("<"+qName+">");//输出标签结尾

    }

    @Override
//    得到标签之间的字符串
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str=new String(ch,start,length);//输出标签之间的字符串

    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {

    }

    @Override
    public void skippedEntity(String name) throws SAXException {

    }
}