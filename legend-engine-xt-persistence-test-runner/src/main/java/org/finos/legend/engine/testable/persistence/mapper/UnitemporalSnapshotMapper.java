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

package org.finos.legend.engine.testable.persistence.mapper;

import org.finos.legend.engine.protocol.pure.v1.model.packageableElement.persistence.persister.ingestmode.snapshot.UnitemporalSnapshot;

import java.util.Arrays;

import static org.finos.legend.engine.testable.persistence.mapper.IngestModeMapper.DIGEST_FIELD_DEFAULT;

public class UnitemporalSnapshotMapper
{
    public static org.finos.legend.engine.persistence.components.ingestmode.UnitemporalSnapshot from(UnitemporalSnapshot unitemporalSnapshot)
    {
        return org.finos.legend.engine.persistence.components.ingestmode.UnitemporalSnapshot.builder()
                .digestField(DIGEST_FIELD_DEFAULT)
                .transactionMilestoning(unitemporalSnapshot.transactionMilestoning.accept(MappingVisitors.MAP_TO_COMPONENT_TRANSACTION_MILESTONING))
                .build();
    }
}
