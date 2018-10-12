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

package org.springframework.data.requery.kotlin.repository.support

import io.requery.meta.EntityModel

/**
 * org.springframework.data.requery.repository.support.RequeryMetamodel
 *
 * @author debop
 */
class RequeryMetamodel(val entityModel: EntityModel) {

    val managedTypes: Collection<Class<*>> by lazy {
        entityModel.types.mapNotNull { it.classType }
    }

    fun isRequeryManaged(domainClass: Class<out Any>): Boolean {
        return managedTypes.contains(domainClass)
    }

    fun isSingleIdAttribute(domainClass: Class<out Any>,
                            name: String,
                            attributeClass: Class<*>): Boolean {

        val type = entityModel.types.find { it.classType == domainClass }

        if(type != null) {
            val attr = type.singleKeyAttribute
            return attr.classType == attributeClass && attr.name == name
        }
        return false
    }
}