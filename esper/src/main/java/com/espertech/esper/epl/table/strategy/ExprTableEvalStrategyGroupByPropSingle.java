/*
 ***************************************************************************************
 *  Copyright (C) 2006 EsperTech, Inc. All rights reserved.                            *
 *  http://www.espertech.com/esper                                                     *
 *  http://www.espertech.com                                                           *
 *  ---------------------------------------------------------------------------------- *
 *  The software in this package is published under the terms of the GPL license       *
 *  a copy of which has been included with this distribution in the license.txt file.  *
 ***************************************************************************************
 */
package com.espertech.esper.epl.table.strategy;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.epl.expression.core.ExprEvaluator;
import com.espertech.esper.epl.expression.core.ExprEvaluatorContext;
import com.espertech.esper.epl.expression.core.ExprEvaluatorEnumerationGivenEvent;

import java.util.Collection;

public class ExprTableEvalStrategyGroupByPropSingle extends ExprTableEvalStrategyGroupByPropBase {

    private final ExprEvaluator groupExpr;

    public ExprTableEvalStrategyGroupByPropSingle(TableAndLockProviderGrouped provider, int propertyIndex, ExprEvaluatorEnumerationGivenEvent optionalEnumEval, ExprEvaluator groupExpr) {
        super(provider, propertyIndex, optionalEnumEval);
        this.groupExpr = groupExpr;
    }

    public Object evaluate(EventBean[] eventsPerStream, boolean isNewData, ExprEvaluatorContext exprEvaluatorContext) {
        Object groupKey = groupExpr.evaluate(eventsPerStream, isNewData, exprEvaluatorContext);
        return evaluateInternal(groupKey, exprEvaluatorContext);
    }

    public Collection<EventBean> evaluateGetROCollectionEvents(EventBean[] eventsPerStream, boolean isNewData, ExprEvaluatorContext context) {
        Object groupKey = groupExpr.evaluate(eventsPerStream, isNewData, context);
        return evaluateGetROCollectionEventsInternal(groupKey, context);
    }

    public EventBean evaluateGetEventBean(EventBean[] eventsPerStream, boolean isNewData, ExprEvaluatorContext context) {
        Object groupKey = groupExpr.evaluate(eventsPerStream, isNewData, context);
        return evaluateGetEventBeanInternal(groupKey, context);
    }

    public Collection evaluateGetROCollectionScalar(EventBean[] eventsPerStream, boolean isNewData, ExprEvaluatorContext context) {
        Object groupKey = groupExpr.evaluate(eventsPerStream, isNewData, context);
        return evaluateGetROCollectionScalarInternal(groupKey, context);
    }
}
