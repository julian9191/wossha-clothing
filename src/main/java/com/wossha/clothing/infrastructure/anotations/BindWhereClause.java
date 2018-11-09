package com.wossha.clothing.infrastructure.anotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.skife.jdbi.v2.SQLStatement;
import org.skife.jdbi.v2.sqlobject.Binder;
import org.skife.jdbi.v2.sqlobject.BinderFactory;
import org.skife.jdbi.v2.sqlobject.BindingAnnotation;

import com.wossha.msbase.models.WhereClause;

@BindingAnnotation(BindWhereClause.WhereClauseBinderFactory.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface BindWhereClause {
    class WhereClauseBinderFactory implements BinderFactory {
        public Binder build(Annotation annotation) {
            return new Binder<BindWhereClause, WhereClause>() {
                public void bind(SQLStatement q, BindWhereClause bind, WhereClause clause) {
                    clause.queryValues
                            .keySet()
                            .forEach(s -> q.bind(s, clause.queryValues.get(s)));
                }
            };
        }
    }
}