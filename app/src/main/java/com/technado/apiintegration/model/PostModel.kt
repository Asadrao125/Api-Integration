package com.technado.apiintegration.model

class PostModel {
    var body: String= ""
    var id: Int = 0
    var title: String = ""
    var userId: Int = 0

    constructor(body: String, id: Int, title: String, userId: Int) {
        this.body = body
        this.id = id
        this.title = title
        this.userId = userId
    }
}