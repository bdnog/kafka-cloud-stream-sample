package com.acme.messaging.config;

import com.acme.messaging.sink.MyTopicSink;
import com.acme.messaging.source.MyTopicSource;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for enabling the cloud stream.
 */
@Configuration
@EnableBinding({
    MyTopicSink.class,
    MyTopicSource.class
})
public class StreamConfig {

}
