package httpServletRequestX.inject;

import httpServletRequestX.accept.contenttype.AcceptContenttypeComparator;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class GuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AcceptContenttypeComparator.class).in(Singleton.class);
    }
}
