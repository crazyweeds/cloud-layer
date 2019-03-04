package io.cloud.layer.zuul.filters;

import com.netflix.zuul.FilterFileManager;
import com.netflix.zuul.FilterLoader;
import com.netflix.zuul.groovy.GroovyCompiler;
import com.netflix.zuul.groovy.GroovyFileFilter;
import com.netflix.zuul.monitoring.MonitoringHelper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author RippleChan
 * @date 2019-03-03 23:40
 */
@Component
public class GroovyConfig implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        String user = System.getProperty("user.name");
        MonitoringHelper.initMocks();
        FilterLoader.getInstance().setCompiler(new GroovyCompiler());
        FilterFileManager.setFilenameFilter(new GroovyFileFilter());
        FilterFileManager.init(10, "/Users/" + user + "/Documents/develop/code/cloud-layer/cloud-layer-server/zuul-gateway/src/main/java/io/cloud/layer/zuul/filters/");
    }

}
