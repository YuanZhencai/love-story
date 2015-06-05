import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import play.GlobalSettings;

/**
 * Created by Yuan on 2015/6/6.
 */
public class Global  extends GlobalSettings{
    private Injector injector = null;

    public Global() {
        injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
            }
        });
    }

    @Override
    public <A> A getControllerInstance(Class<A> aClass) throws Exception {
        return injector.getInstance(aClass);
    }
}
