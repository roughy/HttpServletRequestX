# HttpServletRequestX

## Introduction

Extension for javax.servlet.http.HttpServletRequest. Gives easy access to Http 1.1 request accept and accept-* header.
The accept header gives some convenience functions to know, what content type the client is able to accept. See
[w3.org](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html)

Using the javax.servlet.http.HttpServletRequestWrapper to wrap the real HttpServletRequest object.

## Installation

See [maven central](http://search.maven.org/#search|ga|1|a%3A%22com.github.roughy.http.util%22)

## Usage

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
