package com.sap.innojam.scouts;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Singleton;
import javax.persistence.EntityManager;

import org.glassfish.hk2.api.PerLookup;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.glassfish.jersey.server.ResourceConfig;
import org.reflections.Reflections;

import com.sap.security.um.service.UserManagementAccessor;
import com.sap.security.um.user.PersistenceException;
import com.sap.security.um.user.UserProvider;

public class Application extends ResourceConfig {

	private String applicationRootPackage;

	public Application() {
		this.applicationRootPackage = this.getClass().getPackage().getName();
		registerEndpoints();
		registerDependecyInjection();
	}

	private void registerEndpoints() {
		// scan whole root package recursively
		packages(true, applicationRootPackage);
	}

	private void registerDependecyInjection() {
		register(new AbstractBinder() {

			@Override
			protected void configure() {
				// EntityManager Factory
				bindFactory(EMFactory.class).to(EntityManager.class).in(
						RequestScoped.class);

				// HCP Service: UserProvider / User
				bind(getUserProvider()).to(UserProvider.class);

				// Classes Annotated with @Singleton, @RequestScoped, @PerLookup
				bindAnnotatedClasses(applicationRootPackage);
			}

			/**
			 * Bind annotated classes with: @Singleton, @RequestScoped, @PerLookup
			 * see:
			 * https://jersey.java.net/documentation/latest/jaxrs-resources.html
			 */
			private void bindAnnotatedClasses(String rootPackage) {
				try {
					Reflections reflections = new Reflections(rootPackage);
					Set<Class<?>> classes = new HashSet<>();
					classes.addAll(reflections
							.getTypesAnnotatedWith(RequestScoped.class));
					classes.addAll(reflections
							.getTypesAnnotatedWith(Singleton.class));
					classes.addAll(reflections
							.getTypesAnnotatedWith(PerLookup.class));

					for (Class<?> cls : classes) {
						Class<? extends Annotation> scope = null;
						if (cls.isAnnotationPresent(Singleton.class))
							scope = Singleton.class;
						else if (cls.isAnnotationPresent(PerLookup.class))
							scope = PerLookup.class;
						else if (cls.isAnnotationPresent(RequestScoped.class))
							scope = RequestScoped.class;
						bind(cls).to(cls).in(scope);
					}
				} catch (SecurityException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private UserProvider getUserProvider() {
		try {
			return UserManagementAccessor.getUserProvider();
		} catch (PersistenceException e) {
			throw new RuntimeException(e);
		}
	}
}
