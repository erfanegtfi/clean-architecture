package com.clean.presentation.mapper.base

import com.clean.domain.model.base.BaseDomainModel
import com.clean.presentation.model.base.BasePresentationModel

interface PresentationLayerMapper<A : BaseDomainModel?, B : BasePresentationModel?> {
    fun toPresenterModel(e: A): B
    fun toDomain(d: B): A
}
