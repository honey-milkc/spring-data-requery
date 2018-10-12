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

package org.springframework.data.requery.provider;

import org.springframework.lang.Nullable;

import javax.persistence.Query;

/**
 * Interface to hide different implementations to extract the original Requery query string from a {@link Query}.
 *
 * @author debop
 * @since 18. 6. 7
 */
public interface QueryExtractor {

    /**
     * Reverse engineers the query string from the {@link Query} object. This requires provider specific API as Requery does
     * not provide access to the underlying query string as soon as one has created a {@link Query} instance of it.
     *
     * @param query
     * @return the query string representing the query or {@literal null} if resolving is not possible.
     */
    @Nullable
    String extractQueryString(Query query);

    /**
     * Returns whether the extractor is able to extract the original query string from a given {@link Query}.
     *
     * @return
     */
    boolean canExtractQuery();
}