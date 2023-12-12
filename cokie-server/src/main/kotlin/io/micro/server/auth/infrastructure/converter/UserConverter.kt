package io.micro.server.auth.infrastructure.converter

import io.micro.server.auth.domain.entity.WXUser
import io.micro.server.auth.infrastructure.po.Authority
import io.micro.server.auth.infrastructure.po.User
import org.mapstruct.BeanMapping
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants.ComponentModel.CDI
import org.mapstruct.ReportingPolicy

/**
 *@author Augenstern
 *@since 2023/11/25
 */
@Mapper(componentModel = CDI, uses = [UserMapper::class])
interface UserConverter {
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    fun wxUserToUser(wxUser: WXUser): User

    fun stringToAuthority(string: MutableSet<String>): MutableSet<Authority>

    @InheritInverseConfiguration
    fun userToWXUser(user: User): WXUser

    @InheritInverseConfiguration
    fun authorityToString(string: MutableSet<Authority>): MutableSet<String>
}