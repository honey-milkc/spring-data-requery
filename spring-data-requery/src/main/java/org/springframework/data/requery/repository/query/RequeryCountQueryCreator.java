/*
 * Copyright 2018 Coupang Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.data.requery.repository.query;

import io.requery.query.LogicalCondition;
import io.requery.query.element.QueryElement;
import io.requery.query.function.Count;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.ReturnedType;
import org.springframework.data.repository.query.parser.PartTree;
import org.springframework.data.requery.core.RequeryOperations;

import static org.springframework.data.requery.utils.RequeryUtils.unwrap;

/**
 * Requery용 Count Query를 생성하는 클래스
 *
 * @author debop
 * @since 18. 6. 21
 */
@Slf4j
public class RequeryCountQueryCreator extends RequeryQueryCreator {

    public RequeryCountQueryCreator(@NotNull final RequeryOperations operations,
                                    @NotNull final ParameterMetadataProvider provider,
                                    @NotNull final ReturnedType returnedType,
                                    @NotNull final PartTree tree) {
        super(operations, provider, returnedType, tree);
    }

    @NotNull
    @Override
    protected QueryElement<?> createQueryElement(@NotNull final ReturnedType type) {
        return unwrap(getOperations().select(Count.count(getDomainClass())));
    }

    @SuppressWarnings("unchecked")
    @NotNull
    @Override
    protected QueryElement<?> complete(@Nullable final LogicalCondition<?, ?> criteria,
                                       @NotNull final Sort sort,
                                       @NotNull final QueryElement<?> root) {

        return unwrap(getOperations()
                          .select(Count.count(getDomainClass()))
                          .where(criteria));
    }
}
