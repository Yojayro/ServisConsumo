
package ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetDirec_QNAME = new QName("http://WS/", "getDirec");
    private final static QName _GetDirecResponse_QNAME = new QName("http://WS/", "getDirecResponse");
    private final static QName _GetFicheroAdjunto_QNAME = new QName("http://WS/", "getFicheroAdjunto");
    private final static QName _GetFicheroAdjuntoResponse_QNAME = new QName("http://WS/", "getFicheroAdjuntoResponse");
    private final static QName _Hello_QNAME = new QName("http://WS/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://WS/", "helloResponse");
    private final static QName _GetFicheroAdjuntoResponseReturn_QNAME = new QName("", "return");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDirec }
     * 
     */
    public GetDirec createGetDirec() {
        return new GetDirec();
    }

    /**
     * Create an instance of {@link GetDirecResponse }
     * 
     */
    public GetDirecResponse createGetDirecResponse() {
        return new GetDirecResponse();
    }

    /**
     * Create an instance of {@link GetFicheroAdjunto }
     * 
     */
    public GetFicheroAdjunto createGetFicheroAdjunto() {
        return new GetFicheroAdjunto();
    }

    /**
     * Create an instance of {@link GetFicheroAdjuntoResponse }
     * 
     */
    public GetFicheroAdjuntoResponse createGetFicheroAdjuntoResponse() {
        return new GetFicheroAdjuntoResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDirec }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "getDirec")
    public JAXBElement<GetDirec> createGetDirec(GetDirec value) {
        return new JAXBElement<GetDirec>(_GetDirec_QNAME, GetDirec.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDirecResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "getDirecResponse")
    public JAXBElement<GetDirecResponse> createGetDirecResponse(GetDirecResponse value) {
        return new JAXBElement<GetDirecResponse>(_GetDirecResponse_QNAME, GetDirecResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFicheroAdjunto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "getFicheroAdjunto")
    public JAXBElement<GetFicheroAdjunto> createGetFicheroAdjunto(GetFicheroAdjunto value) {
        return new JAXBElement<GetFicheroAdjunto>(_GetFicheroAdjunto_QNAME, GetFicheroAdjunto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFicheroAdjuntoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "getFicheroAdjuntoResponse")
    public JAXBElement<GetFicheroAdjuntoResponse> createGetFicheroAdjuntoResponse(GetFicheroAdjuntoResponse value) {
        return new JAXBElement<GetFicheroAdjuntoResponse>(_GetFicheroAdjuntoResponse_QNAME, GetFicheroAdjuntoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = GetFicheroAdjuntoResponse.class)
    public JAXBElement<byte[]> createGetFicheroAdjuntoResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_GetFicheroAdjuntoResponseReturn_QNAME, byte[].class, GetFicheroAdjuntoResponse.class, ((byte[]) value));
    }

}
