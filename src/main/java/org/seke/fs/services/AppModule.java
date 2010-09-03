package org.seke.fs.services;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.hibernate.HibernateTransactionAdvisor;
import org.apache.tapestry5.hibernate.HibernateTransactionDecorator;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.MethodAdviceReceiver;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Match;
import org.seke.fs.hibernate.CostumersServiceImpl;
import org.seke.fs.hibernate.ProductsServiceImpl;

/**
 * This module is automatically included as part of the Tapestry IoC Registry, it's a good place to
 * configure and extend Tapestry, or to place your own service definitions.
 */
public class AppModule {

    public static void contributeApplicationDefaults(
            MappedConfiguration<String, String> configuration) {
        configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en");
        configuration.add(SymbolConstants.PRODUCTION_MODE, "false");
        configuration.add(SymbolConstants.APPLICATION_VERSION, "1.0-SNAPSHOT");
        //configuration.add(HibernateSymbols.EARLY_START_UP, "true");
    }

    public static void bind(ServiceBinder binder) {
        binder.bind(ProductsService.class, ProductsServiceImpl.class);
        binder.bind(CostumersService.class, CostumersServiceImpl.class);
    }

    public static void contributeHibernateEntityPackageManager(
            Configuration<String> configuration) {
        configuration.add("org.seke.fs.beans");
    }

    @Match({"*Costumers", "*Products"})
    public static <T> T decorateTransactionally(
            HibernateTransactionDecorator decorator, Class<T> serviceInterface,
            T delegate, String serviceId) {
        return decorator.build(serviceInterface, delegate, serviceId);
    }

    @Match({"*Service"})
    public static void adviseTransactions(
    		HibernateTransactionAdvisor advisor, MethodAdviceReceiver receiver){
        advisor.addTransactionCommitAdvice(receiver);
    };

}
 