package com.ismachat

import static org.grails.web.mapping.DefaultUrlMappingEvaluator.*


class UrlMappings {

    static mappings = {

        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(view: "/index")
        "500"(view: '/error')
        "404"(view: '/notFound')

        '/register'(controller: 'user', action: 'register', method: "POST")
        '/activate'(controller: 'user', action: 'activate', method: "POST")

        group('/admin') {
            '/role'(resources: 'role', namespace: 'admin', includes: [ACTION_INDEX])

            '/user'(resources: 'user', namespace: 'admin', includes: [ACTION_INDEX, ACTION_SHOW, ACTION_UPDATE, ACTION_SAVE])
            '/user/profile'(controller: 'user', action: 'profile', method: "POST")
            '/user/enableUser'(controller: 'user', action: 'enableUser', method: "PUT")
            '/user/updateImage'(controller: 'user', action: 'updateImage', method: "POST")

        }

        group('/api') {

        }
    }
}
