package org.seke.fs.services;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.hibernate.HibernateSymbols;
import org.apache.tapestry5.hibernate.HibernateTransactionAdvisor;
import org.apache.tapestry5.hibernate.HibernateTransactionDecorator;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.MethodAdviceReceiver;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Match;
import org.seke.fs.Costumer;
import org.seke.fs.Order;
import org.seke.fs.OrdersItem;
import org.seke.fs.Product;
import org.seke.fs.beans.CostumerBean;
import org.seke.fs.beans.OrderBean;
import org.seke.fs.beans.OrdersItemBean;
import org.seke.fs.beans.ProductBean;
import org.seke.fs.hibernate.*;

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
        configuration.add(HibernateSymbols.EARLY_START_UP, "true");
    }

    public static void bind(ServiceBinder binder) {
//        binder.bind(ProductsService.class, ProductsServiceImpl.class);
//        binder.bind(CostumersService.class, CostumersServiceImpl.class);
//        binder.bind(OrdersService.class, OrdersServiceImpl.class);
    }

//    public static void contributeHibernateEntityPackageManager(
//            Configuration<String> configuration) {
//        configuration.add("org.seke.fs.beans");
//    }

//    @Match({"*Costumers", "*Products"})
//    public static <T> T decorateTransactionally(
//            HibernateTransactionDecorator decorator, Class<T> serviceInterface,
//            T delegate, String serviceId) {
//        return decorator.build(serviceInterface, delegate, serviceId);
//    }
//
//    @Match({"*Service"})
//    public static void adviseTransactions(
//            HibernateTransactionAdvisor advisor, MethodAdviceReceiver receiver) {
//        advisor.addTransactionCommitAdvice(receiver);
//    }
//
//
//
//    public static Costumer buildCostumer() {
//        return new CostumerBean();
//    }
//
//    public static Order buildOrder(){
//        return new OrderBean();
//    }
//
//    public static OrdersItem buildOrdersItem(){
//        return new OrdersItemBean();
//    }
//
//    public static Product buildProduct(){
//        return new ProductBean();
//    }
}
 