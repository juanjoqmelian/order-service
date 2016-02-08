package com.dragosolutions.microservices.order;

import com.dragosolutions.microservices.order.config.ApplicationConfiguration;
import com.dragosolutions.microservices.order.config.OrderServiceConfiguration;
import com.dragosolutions.microservices.order.healthcheck.OrderHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class OrderServiceApplication extends Application<ApplicationConfiguration> {

    public static void main(String[] args) {
        try {
            new OrderServiceApplication().run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(Bootstrap<ApplicationConfiguration> bootstrap) {
        // Enable variable substitution with environment variables
//        bootstrap.setConfigurationSourceProvider(
//                new SubstitutingSourceProvider(
//                        bootstrap.getConfigurationSourceProvider(),
//                        new EnvironmentVariableSubstitutor(false)
//                )
//        );

//        bootstrap.addCommand(new RenderCommand());
//        bootstrap.addBundle(new AssetsBundle());
//        bootstrap.addBundle(new MigrationsBundle<ApplicationConfiguration>() {
//            @Override
//            public DataSourceFactory getDataSourceFactory(ApplicationConfiguration configuration) {
//                return configuration.getDataSourceFactory();
//            }
//        });
//        bootstrap.addBundle(new ViewBundle<ApplicationConfiguration>() {
//            @Override
//            public Map<String, Map<String, String>> getViewConfiguration(ApplicationConfiguration configuration) {
//                return configuration.getViewRendererConfiguration();
//            }
//        });
    }

    @Override
    public void run(ApplicationConfiguration applicationConfiguration, Environment environment) throws Exception {

        final OrderServiceConfiguration configuration = applicationConfiguration.getOrder();

        final OrderResource personService = new OrderResource(applicationConfiguration.getEvents());
        environment.jersey().register(personService);


        final OrderHealthCheck healthCheck = new OrderHealthCheck(configuration);
        environment.healthChecks().register("template", healthCheck);
//        environment.jersey().register(healthCheck);
    }
}
