package com.clean.data.mapper.base

import com.clean.data.models.BaseEntity
import com.clean.domain.model.base.BaseDomainModel

interface DataLayerMapper<A : BaseEntity?, B : BaseDomainModel?> {
    fun toDomainModel(e: A): B
    fun toEntity(d: B): A
}
