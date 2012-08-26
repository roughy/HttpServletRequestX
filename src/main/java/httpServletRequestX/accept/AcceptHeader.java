package httpServletRequestX.accept;

/**
 * TODO
 * 
 * @author mreinwarth
 */
public interface AcceptHeader {

    public boolean hasHtml();

    public boolean hasJson();

    public AcceptHeader setContent(String content);

}
