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

import org.junit.runner.RunWith;
import org.springframework.data.repository.Repository;
import org.springframework.data.requery.core.RequeryOperations;
import org.springframework.data.requery.domain.sample.User;
import org.springframework.data.requery.repository.config.InfrastructureConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.List;

/**
 * org.springframework.data.requery.repository.query.AbstractRequeryQueryTest
 *
 * @author debop
 * @since 18. 6. 14
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { InfrastructureConfig.class })
public abstract class AbstractRequeryQueryTest {

    @Inject RequeryOperations operations;


    interface SampleRepository extends Repository<User, Integer> {

        List<User> findByLastname(String lastname);

        List<User> findByFirstname(String firstname);

        List<User> findAll();
    }
}
