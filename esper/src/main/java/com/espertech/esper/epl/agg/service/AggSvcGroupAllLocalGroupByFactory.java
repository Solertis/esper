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
package com.espertech.esper.epl.agg.service;

import com.espertech.esper.core.context.util.AgentInstanceContext;
import com.espertech.esper.epl.agg.util.AggregationLocalGroupByPlan;
import com.espertech.esper.epl.core.EngineImportService;

/**
 * Implementation for handling aggregation with grouping by group-keys.
 */
public class AggSvcGroupAllLocalGroupByFactory implements AggregationServiceFactory {
    protected final boolean isJoin;
    private final AggregationLocalGroupByPlan localGroupByPlan;

    public AggSvcGroupAllLocalGroupByFactory(boolean join, AggregationLocalGroupByPlan localGroupByPlan) {
        isJoin = join;
        this.localGroupByPlan = localGroupByPlan;
    }

    public AggregationService makeService(AgentInstanceContext agentInstanceContext, EngineImportService engineImportService, boolean isSubquery, Integer subqueryNumber) {
        return new AggSvcGroupAllLocalGroupBy(isJoin, localGroupByPlan);
    }
}
