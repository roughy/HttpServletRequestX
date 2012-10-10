HttpServletRequestX
===================

Introduction
~~~~~~~~~~~~
Extension for javax.servlet.http.HttpServletRequest. Gives easy access to Http 1.1 request accept and accept-* header. 
The accept header gives some convinience functions to know, what content type the client is able to accept.

Using the javax.servlet.http.HttpServletRequestWrapper to wrap the real HttpServletRequest object.  

Installation
~~~~~~~~~~~~
See maven central
TODO link

Usage
~~~~~
<code>
import de.roughy.util.http.httpServletRequestX.HttpServletRequestX;
import de.roughy.util.http.httpServletRequestX.accept.header.AcceptHeader;

public void handleRequest(javax.servlet.http.HttpServletRequest request) {

    HttpServletRequestX httpServletRequestX = new HttpServletRequestX(request);

    AcceptHeader accept   = httpServletRequestX.getAccept();
    String acceptCharset  = httpServletRequestX.getAcceptCharset();
    String acceptEncoding = httpServletRequestX.getAcceptEncoding();
    String acceptLanguage = httpServletRequestX.getAcceptLanguage();

    if (accept.acceptHtml()) {

        renderHtml();

    } else if (accept.acceptJson()) {

        renderJson();

    } else {

        ... // handle the request otherwise

    }

}
<code>
