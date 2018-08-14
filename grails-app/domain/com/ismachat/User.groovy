package com.ismachat

import com.ismachat.constant.Gender
import com.ismachat.constant.Status
import grails.compiler.GrailsCompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@GrailsCompileStatic
@EqualsAndHashCode(includes = 'username')
@ToString(includes = 'username', includeNames = true, includePackage = false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    String username
    String password
    String name
    String remark
    boolean enabled = false
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    //simple object
    String phone
    String about
    Long registered
    List<String> image //public_id and url

    String activationToken

    //entity
    Gender gender
    Status status


    static constraints = {
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
        phone nullable: true, blank: true
        about nullable: true, blank: true
        image nullable: true, blank: true
        gender nullable: true, blank: true
        activationToken nullable: true, blank: true
    }

    static mapping = {
        password column: '`password`'
    }
}
