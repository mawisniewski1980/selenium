package logs;

import java.net.URI;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Order;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import utilsobjects.OProperties;


@Plugin(name = "CustomConfigurationFactory", category = ConfigurationFactory.CATEGORY)
@Order(0)
public class CustomConfigurationFactory extends ConfigurationFactory {

    private static Configuration createConfiguration(final String name, ConfigurationBuilder<BuiltConfiguration> builder) {
        builder.setConfigurationName(name);
        builder.setStatusLevel(Level.INFO);

        //Configutation for Console
        AppenderComponentBuilder appenderBuilderConsole = builder.newAppender("stdout", "CONSOLE").
                addAttribute("target", ConsoleAppender.Target.SYSTEM_OUT);
        appenderBuilderConsole.add(builder.newLayout("PatternLayout").
                addAttribute("pattern", "%highlight{%d{DEFAULT} %-2p [%t] [%class->%method]}{FATAL=white, ERROR=red, WARN=blue, INFO=black, DEBUG=green, TRACE=blue} %msg%n%throwable"));
        builder.add(appenderBuilderConsole);
        builder.add(builder.newLogger("org.apache.logging.log4j", Level.INFO).
                add(builder.newAppenderRef("stdout")).
                addAttribute("additivity", false));
        builder.add(builder.newRootLogger(Level.INFO).add(builder.newAppenderRef("stdout")));

        /*AppenderComponentBuilder appenderComponentBuilder2 = builder.newAppender("file", "FileAppender").
                addAttribute("file", "asdasd.log");
        appenderComponentBuilder2.add(builder.newLayout("PatternLayout").
                addAttribute("pattern", "%highlight{%d{DEFAULT} %-2p [%t] [%class->%method]}{FATAL=white, ERROR=red, WARN=blue, INFO=black, DEBUG=green, TRACE=blue} %msg%n%throwable"));
        builder.add(appenderComponentBuilder2);
        builder.add(builder.newLogger("org.apache.logging.log4j", Level.INFO).
                add(builder.newAppenderRef("file")).
                addAttribute("additivity", false));
        builder.add(builder.newRootLogger(Level.INFO).add(builder.newAppenderRef("file")));*/

        return builder.build();
    }

    @Override
    public Configuration getConfiguration(
        final LoggerContext loggerContext, final ConfigurationSource source) {
        return getConfiguration(loggerContext, source.toString(), null);
    }

    @Override
    public Configuration getConfiguration(
        final LoggerContext loggerContext, final String name, final URI configLocation) {
        ConfigurationBuilder<BuiltConfiguration> builder = newConfigurationBuilder();
        return createConfiguration(name, builder);
    }

    @Override
    protected String[] getSupportedTypes() {
        return new String[] {"*"}; // IMPORTANT
    }
}
