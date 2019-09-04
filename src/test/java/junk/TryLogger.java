package junk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class TryLogger {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    public void bobby () {
        log.info("bob");
    }
}
