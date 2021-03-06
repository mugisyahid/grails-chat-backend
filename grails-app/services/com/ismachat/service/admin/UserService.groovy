package com.ismachat.service.admin

import com.ismachat.Role
import com.ismachat.User
import com.ismachat.UserRole
import com.ismachat.command.admin.RegisterCommand
import com.ismachat.constant.Status
import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional
import org.joda.time.LocalDateTime


@Transactional
@GrailsCompileStatic
class UserService {

    KeyGeneratorService keyGeneratorService

    User register(RegisterCommand cmd) {
        User user = new User(name: cmd.name, username: cmd.username, password: cmd.password, remark: cmd.remark)
        user.status = Status.ACTIVE
        user.activationToken = keyGeneratorService.randomAlphaNumeric.nextRandom(24)
        user.registered = new LocalDateTime().toDate().getTime()
        user.save(flush: true, failOnError: true) ?: user
    }

    void setRole(User user, List<String> roles) {
        roles.each {
            Role role = Role.findByAuthority(it)
            UserRole.create(user, role, true)
        }
    }
}