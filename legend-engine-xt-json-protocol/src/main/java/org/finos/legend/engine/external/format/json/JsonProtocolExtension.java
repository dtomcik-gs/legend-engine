//  Copyright 2022 Goldman Sachs
//
//  Licensed under the Apache License, Version 2.0 (the "License");
//  you may not use this file except in compliance with the License.
//  You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//  Unless required by applicable law or agreed to in writing, software
//  distributed under the License is distributed on an "AS IS" BASIS,
//  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  See the License for the specific language governing permissions and
//  limitations under the License.

package org.finos.legend.engine.external.format.json;

import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.factory.Lists;
import org.finos.legend.engine.protocol.pure.v1.extension.ProtocolSubTypeInfo;
import org.finos.legend.engine.protocol.pure.v1.extension.PureProtocolExtension;
import org.finos.legend.engine.protocol.pure.v1.model.executionPlan.nodes.ExecutionNode;
import org.finos.legend.engine.protocol.pure.v1.model.executionPlan.nodes.external.format.json.JsonDeserializeExecutionNode;
import org.finos.legend.engine.protocol.pure.v1.model.executionPlan.nodes.external.format.json.JsonPathReference;
import org.finos.legend.engine.protocol.pure.v1.model.executionPlan.nodes.external.format.json.JsonSerializeExecutionNode;
import org.finos.legend.engine.protocol.pure.v1.model.executionPlan.nodes.externalFormat.PathReference;

import java.util.List;

@Deprecated
public class JsonProtocolExtension implements PureProtocolExtension
{
    @Override
    public List<Function0<List<ProtocolSubTypeInfo<?>>>> getExtraProtocolSubTypeInfoCollectors()
    {
        return Lists.fixedSize.with(() -> Lists.fixedSize.with(
                ProtocolSubTypeInfo.newBuilder(ExecutionNode.class)
                        .withSubtype(JsonSerializeExecutionNode.class, "jsonSerialize")
                        .withSubtype(JsonDeserializeExecutionNode.class, "jsonDeserialize")
                        .build(),
                ProtocolSubTypeInfo.newBuilder(PathReference.class)
                        .withSubtype(JsonPathReference.class, "json")
                        .build()
        ));
    }
}
