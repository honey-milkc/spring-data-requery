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

package org.springframework.data.requery.kotlin.domain.stateless

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.springframework.data.requery.kotlin.domain.AbstractDomainTest
import java.time.LocalDateTime
import java.util.*

/**
 * org.springframework.data.requery.kotlin.domain.stateless.StatelessTest
 *
 * @author debop
 */
class StatelessTest : AbstractDomainTest() {

    @Test
    fun `insert and delete stateless`() {

        val uuid = UUID.randomUUID()

        val entry = EntryEntity().apply {
            id = uuid.toString()
            flag1 = true
            flag2 = false
            createdAt = LocalDateTime.now()
        }

        operations.insert(entry)

        val found = operations.findById(Entry::class, entry.id)!!
        assertThat(found.id).isEqualTo(entry.id)
    }
}