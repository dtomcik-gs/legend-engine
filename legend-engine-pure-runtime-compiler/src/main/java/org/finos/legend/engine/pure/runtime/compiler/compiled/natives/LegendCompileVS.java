// Copyright 2022 Goldman Sachs
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.finos.legend.engine.pure.runtime.compiler.compiled.natives;

import org.eclipse.collections.api.list.ListIterable;
import org.finos.legend.pure.m3.coreinstance.meta.pure.metamodel.valuespecification.InstanceValue;
import org.finos.legend.pure.m3.execution.ExecutionSupport;
import org.finos.legend.pure.m3.navigation.Instance;
import org.finos.legend.pure.m3.navigation.M3Properties;
import org.finos.legend.pure.m3.navigation.ProcessorSupport;
import org.finos.legend.pure.m4.coreinstance.CoreInstance;
import org.finos.legend.pure.runtime.java.compiled.execution.CompiledExecutionSupport;
import org.finos.legend.pure.runtime.java.compiled.generation.ProcessorContext;
import org.finos.legend.pure.runtime.java.compiled.generation.processors.natives.AbstractNative;
import org.finos.legend.pure.runtime.java.compiled.generation.processors.valuespecification.ValueSpecificationProcessor;

public class LegendCompileVS extends AbstractNative
{
    public LegendCompileVS()
    {
        super("compileVS_String_1__Any_1_");
    }

    @Override
    public String build(CoreInstance topLevelElement, CoreInstance functionExpression, ListIterable<String> transformedParams, ProcessorContext processorContext)
    {
        final ProcessorSupport processorSupport = processorContext.getSupport();
        final ListIterable<? extends CoreInstance> parametersValues = Instance.getValueForMetaPropertyToManyResolved(functionExpression, M3Properties.parametersValues, processorSupport);
        String code = ValueSpecificationProcessor.processValueSpecification(topLevelElement, parametersValues.get(0), processorContext);
        return "org.finos.legend.engine.pure.runtime.compiler.compiled.natives.LegendCompileVS.compileExecVS(" + code + ", es)";
    }

    public static Object compileExecVS(String code, final ExecutionSupport es)
    {
        return ((InstanceValue)org.finos.legend.engine.pure.runtime.compiler.shared.LegendCompile.doCompileVS(code, ((CompiledExecutionSupport)es).getMetadataProvider().getMetadata()))._values().getFirst();
    }
}
