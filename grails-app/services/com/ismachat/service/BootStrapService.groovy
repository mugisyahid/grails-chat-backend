package com.ismachat.service

import com.ismachat.*
import com.ismachat.constant.Status
//import com.ismachat.service.file.ImageService
import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional
import groovy.json.JsonSlurper
import org.joda.time.LocalDateTime

/**
 * Created by zeldris on 15/12/17.
 */

@Transactional
@GrailsCompileStatic
class BootStrapService {

//    ImageService imageService

    void appInit() {
        List<Class> bootStrap = [Role, User]

        bootStrap.each {
            List<Map> data = parseJson("bootstrap/${it.simpleName}.json")
            String method = "init${it.simpleName}"

            if (owner.respondsTo(method)) {
                owner.invokeMethod(method, data)
            }
        }
    }

    void initRole(List<Map> data) {
        for (Map entry : data) {
            Role role = Role.findByAuthority(entry.authority) ?: new Role(entry)

            if (!role.id) {
                role.save() ?: log.error(role.errors as String)
            }
        }
    }
\
    void initUser(List<Map> data) {
        data.each { Map entry ->
            initUser(entry)
        }
    }

    User initUser(Map data) {
        User user = User.findByUsername(data.username) ?: new User(data)
        user.status = Status.ACTIVE
        user.registered = new LocalDateTime().toDate().getTime()
//        String url = imageService.urlFromImageTag((String) data.imageName)
//        user.image = ["", url.substring(url.indexOf('\'') + 1, url.lastIndexOf('\''))] as List

        if (!user.id) {
            if (user.validate()) {
                user.save()
                (data.roles as List<String>).each {
                    Role role = Role.findByAuthority(it)
                    UserRole userRole = new UserRole(user: user, role: role)
                    userRole.save() ?: log.error(userRole.errors as String)
                }
            } else {
                log.error(user.errors as String)
            }
        }

        return user
    }

    private List parseJson(String resource) {
        List jsonData = []
        InputStream stream = null

        try {
            stream = getClass().classLoader.getResourceAsStream(resource)
            jsonData = new JsonSlurper().parse(stream) as List
        } catch (Exception ex) {
            log.error(ex.message)
        } finally {
            stream?.close()
        }

        return jsonData
    }

}


