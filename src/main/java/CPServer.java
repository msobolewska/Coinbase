import service.MessagesServiceImpl;
import service.coinbase.CoinbaseWebSocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class CPServer extends Application {
    Logger logger = LoggerFactory.getLogger(CPServer.class);

    @PostConstruct
    public void init() throws Exception {

        logger.info("Starting...");

        CoinbaseWebSocket.init();

        logger.info("Successfully started");
    }

    @Override
    public Set<Class<?>> getClasses(){
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(MessagesServiceImpl.class);
        return classes;
    }
}