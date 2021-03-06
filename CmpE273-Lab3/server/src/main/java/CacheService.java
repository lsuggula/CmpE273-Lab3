import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import api.resources.CacheResource;
import config.CacheServiceConfiguration;
import repository.CacheInterface;
import repository.ChronicleMapCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheService extends Service<CacheServiceConfiguration> {

    private final Logger log = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) throws Exception {
        new CacheService().run(args);
    }

    @Override
    public void initialize(Bootstrap<CacheServiceConfiguration> bootstrap) {
        bootstrap.setName("cache-server");
    }

    @Override
    public void run(CacheServiceConfiguration configuration,
                    Environment environment) throws Exception {
        CacheInterface cache = new ChronicleMapCache();
        environment.addResource(new CacheResource(cache));
        log.info("Loaded resources");

    }
}
